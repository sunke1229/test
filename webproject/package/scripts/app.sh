#!/bin/bash
#-------------------------------------------------------------------------------------------------------------
#该脚本的使用方式为-->[sh app.sh start|stop|status|restart]
#注意对此文件做任何修改都无法影响到测试和生产环境，在系统部署环境时会还原，仅限于用户在本地部署使用。
#-------------------------------------------------------------------------------------------------------------
if [ ! -n "$JAVA_HOME" ]; then
	export JAVA_HOME="/usr/java/default"
fi
#
#-------------------------------------------------------------------------------------------------------------
#       系统运行参数   运行环境: JDK_1.8+
#-------------------------------------------------------------------------------------------------------------
# 公共参数，不要修改
APP_BIN=$(cd "$(dirname "$0")"; pwd)
APP_HOME=$(cd "$(dirname "$0")"/..; pwd)
SHELL_FILE_NAME=${0##*/}
CLASSPATH=$APP_HOME/config
#这个是固定的,一定是spring-boot的类
APP_MAIN=org.springframework.boot.loader.WarLauncher
# 这个是PaaS在部署你的app时，会从服务器中读取系统环境变量APP_ID，代表你的APP_ID，不用修改，如果本地运行这脚本可能需要修改
# 打包后的Flat war文件
WAR_FILE=${APP_HOME}/$APP_ID-exec.war

NOHUPLOG=/dev/null
#NOHUPLOG=nohup.out


#-------------------------------------------------------------------------------------------------------------
#   程序开始
#-------------------------------------------------------------------------------------------------------------

PID=0

getPID(){
    javaps=`$JAVA_HOME/bin/jps -l | grep "${WAR_FILE}"`
    if [ -n "$javaps" ]; then
        PID=`echo $javaps | awk '{print $1}'`
    else
        PID=0
    fi
}

# Docker 容器下的运行方式
docker() {
    getPID
    if [ $PID -ne 0 ]; then
        echo "================================================================================================================"
        echo "$APP_ID already started(PID=$PID)"
        echo "================================================================================================================"
    else
        # 内存大小 由系统环境变量 APP_JAVA_OPTS 配置。
        JAVA_OPTS="-server -Dfile.encoding=UTF-8 $APP_JAVA_OPTS"
#        JAVA_OPTS="$JAVA_OPTS -XX:ParallelGCThreads=8 -XX:+UseConcMarkSweepGC -XX:MaxGCPauseMillis=850"
#        JAVA_OPTS="$JAVA_OPTS -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+PrintGCTimeStamps -Xloggc:gc_bkjava.log"
#        JAVA_OPTS="$JAVA_OPTS -Djava.security.egd=file:/dev/./urandom"

        $JAVA_HOME/bin/java $JAVA_OPTS -classpath $CLASSPATH -jar $WAR_FILE > $NOHUPLOG 2>&1 &
    fi
}

startup(){
    getPID
    echo "================================================================================================================"
    if [ $PID -ne 0 ]; then
        echo "$APP_ID already started(PID=$PID)"
        echo "================================================================================================================"
    else
        echo -n "Starting $APP_ID"

        # 内存配置
        JAVA_OPTS="$JAVA_OPTS -Xms1g -Xmx1g"
        JAVA_OPTS="$JAVA_OPTS -XX:ParallelGCThreads=8 -XX:+UseConcMarkSweepGC -XX:MaxGCPauseMillis=850"
        JAVA_OPTS="$JAVA_OPTS -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+PrintGCTimeStamps -Xloggc:gc_bkjava.log"
        JAVA_OPTS="$JAVA_OPTS -Djava.security.egd=file:/dev/./urandom"
        JAVA_OPTS="$JAVA_OPTS -server -Dfile.encoding=UTF-8"

        nohup $JAVA_HOME/bin/java $JAVA_OPTS -classpath $CLASSPATH -jar $WAR_FILE > $NOHUPLOG 2>&1 &

        for i in $(seq 5)
        do
        sleep 0.8
        echo -e ".\c"
        done
        getPID
        if [ $PID -ne 0 ]; then
            echo "(PID=$PID)...[Success]"
            echo "================================================================================================================"
        else
            echo "[Failed]"
            echo "================================================================================================================"
            exit 1
        fi
    fi
}


shutdown(){
    kill_signal=$1
    getPID
    echo "================================================================================================================"
    if [ $PID -ne 0 ]; then
        echo -n "Stopping $APP_ID(PID=$PID)..."
        kill ${kill_signal} $PID
        if [ $? -ne 0 ]; then
            echo "[Failed]"
            echo "================================================================================================================"
            exit 1
            #break
        fi
        for i in $(seq 50)
        do
            sleep 0.9
            getPID
            if [ $PID -eq 0 ]; then
                break
            fi
            echo -e ".\c"
        done

        getPID
        if [ $PID -eq 0 ]; then
            echo "[Success]"
            echo "================================================================================================================"
        else
            echo "[Failed]"
            echo "================================================================================================================"
            exit 1
        fi
    else
        echo "$APP_ID is not running"
        echo "================================================================================================================"
    fi
}


getServerStatus(){
    getPID
    echo "================================================================================================================"
    if [ $PID -ne 0 ]; then
        echo "$APP_ID is running(PID=$PID)"
        echo "================================================================================================================"
    else
        echo "$APP_ID is not running"
        echo "================================================================================================================"
    fi
}

restart(){
    shutdown $1
    sleep 1
    startup
}

case "$1" in
docker)
    docker
    ;;
restart)
    restart
    ;;
start)
    startup
    ;;
stop)
    shutdown
    ;;
status)
    getServerStatus
    ;;
forceStop)
    shutdown "-9"
    ;;
forceRestart)
    restart "-9"
    ;;
*)
 echo $"Usage: $SHELL_FILE_NAME {start|stop|status|restart}"
esac