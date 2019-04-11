/*
 *  Copyright (c) 2017.  Tencent 蓝鲸智云(BlueKing)
 */

package com.tencent.examples.common.aop;

import com.google.common.base.Throwables;
import com.tencent.bk.utils.json.JsonUtil;
import com.tencent.examples.common.Consts;
import com.tencent.examples.common.exception.BusinessException;
import com.tencent.examples.helper.RespHelper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class ServiceAopAspect {

    private static final Logger LOG = LoggerFactory.getLogger(ServiceAopAspect.class);

    @Pointcut("@annotation(com.tencent.examples.common.aop.annotation.ServiceAop)")
    public void serviceAopPointcut() {

    }

    @Around("serviceAopPointcut()")
    public Object aroundAdvice(ProceedingJoinPoint jp) {

        String serviceName = jp.getTarget().getClass().getName();

        String methodName = jp.getSignature().getName();

        Object[] args = jp.getArgs();

        StopWatch timeWatch = new StopWatch();

        boolean ok = true;
        Object resp = null;
        try {
            timeWatch.start();
            resp = jp.proceed();
        } catch (Throwable t) {

            ok = false;
            int code = Consts.SYS_UNKNOW_ERR;
            if (t instanceof BusinessException) {
                code = ((BusinessException) t).getCode();
            }
            LOG.error("service={}| method={}| args={}| exception:{}", serviceName, methodName, JsonUtil.skipLogFields(args), Throwables.getStackTraceAsString(t));
            resp = RespHelper.fail(code, t.getMessage());

        } finally {

            timeWatch.stop();

            if (LOG.isDebugEnabled()) {
                LOG.debug("service={}| method={}| useTime={}| args={}| resp={}",
                        serviceName, methodName, timeWatch.getTotalTimeMillis(), JsonUtil.skipLogFields(args), resp != null ? JsonUtil.skipLogFields(resp) : resp);
            } else if (ok) {
                LOG.info("service={}| method={}| useTime={}| ", serviceName, methodName, timeWatch.getTotalTimeMillis());
            }

        }

        return resp;
    }
}
