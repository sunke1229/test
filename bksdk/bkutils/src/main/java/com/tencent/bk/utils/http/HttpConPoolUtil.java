package com.tencent.bk.utils.http;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeUnit;

/**
 * HTTP请求工具,包装了HTTPClient连接池，默认最大并发100条连接，向每个地址最多只能同时并发10条
 *
 * @author syp
 * @version 1.0
 * @created 2015年1月21日 下午9:31:34
 */
public class HttpConPoolUtil {

    private static final Logger log = LoggerFactory.getLogger(HttpConPoolUtil.class);

    private static final String charset = "UTF-8";

    private final static CloseableHttpClient httpClient;

    static {
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create()
                .setDefaultConnectionConfig(
                        ConnectionConfig.custom()
                                .setBufferSize(102400)
                                .setCharset(Charset.forName(charset))
                                .build())
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectionRequestTimeout(15000)
                        .setConnectTimeout(15000)
                        .setSocketTimeout(15000).build())
                .setConnectionTimeToLive(180, TimeUnit.SECONDS)
                .disableAutomaticRetries()
                .disableAuthCaching()
                .disableCookieManagement()
                .setMaxConnPerRoute(500)
                .setMaxConnTotal(1000);

        CloseableHttpClient tmp;
        try {
            tmp = httpClientBuilder
                    .setSSLSocketFactory(new SSLConnectionSocketFactory(SSLContexts.custom()
                            .loadTrustMaterial(null, new TrustSelfSignedStrategy())
                            .build()
                    ))
                    .build();
        } catch (NoSuchAlgorithmException | KeyManagementException | KeyStoreException e) {
            log.error("", e);
            tmp = httpClientBuilder.build();
        }
        httpClient = tmp;
    }

    /**
     * 提交POST请求，并返回数据，用encoding参数解析
     *
     * @param url         提交的地址
     * @param content     提交的内容字符串
     * @param contentType 默认传null则为"application/x-www-form-urlencoded"
     * @return
     */
    public static String post(String url, String content, String contentType) throws Exception {
        return post(url, charset, content, contentType);
    }

    /**
     * 提交POST请求，并返回数据，用encoding参数解析
     *
     * @param url         提交的地址
     * @param charset     字符集，用于解析返回的字符串
     * @param content     提交的内容字符串
     * @param contentType 默认传null则为"application/x-www-form-urlencoded"
     * @return 返回字符串
     */
    public static String post(String url, String charset, String content, String contentType) throws Exception {
        byte[] resp = post(url, content.getBytes(charset), contentType);
        if (null == resp)
            return null;
        return new String(resp, charset);
    }

    /**
     * 提交POST请求，并返回数据（默认采用encoding常量指定的字符集解析）
     *
     * @param url     提交的地址
     * @param content 提交的内容字符串
     * @return 返回字符串
     */
    public static String post(String url, String content) throws Exception {
        return post(url, charset, content, "application/x-www-form-urlencoded");
    }

    /**
     * 支持自定义头的POST请求
     *
     * @param url     提交的地址
     * @param content 提交的内容字符串
     * @param headers 自定义请求头
     * @return
     */
    public static String post(String url, String content, Header... headers) throws Exception {
        return post(url, charset, content, headers);
    }

    /**
     * 支持自定义头的POST请求
     *
     * @param url     提交的地址
     * @param charset 字符集，用于解析返回的字符串
     * @param content 提交的内容字符串
     * @param headers 自定义请求头
     * @return
     */
    public static String post(String url, String charset, String content, Header... headers) throws Exception {
        byte[] resp = post(url, new ByteArrayEntity(content.getBytes(charset)), headers);
        if (null == resp)
            return null;
        return new String(resp, charset);
    }

    /**
     * 提交POST请求，并返回字节数组
     *
     * @param url         提交的地址
     * @param content     提交的内容字节数据
     * @param contentType 默认传null则为"application/x-www-form-urlencoded"
     * @return 返回字节数组
     */
    public static byte[] post(String url, byte[] content, String contentType) throws Exception {
        return post(url, new ByteArrayEntity(content), contentType);
    }

    /**
     * 提交POST请求，并返回字节数组
     *
     * @param url           提交的地址
     * @param requestEntity 封装好的请求实体
     * @param contentType   默认传null则为"application/x-www-form-urlencoded"
     * @return 返回字节数组
     */
    public static byte[] post(String url, HttpEntity requestEntity, String contentType) throws Exception {
        return post(url, requestEntity, new BasicHeader("Content-Type",
                contentType == null ? "application/x-www-form-urlencoded" : contentType));
    }

    public static byte[] post(String url, HttpEntity requestEntity, Header... headers) throws Exception {
        HttpPost post = new HttpPost(url);
        // 设置为长连接，服务端判断有此参数就不关闭连接。
        post.setHeader("Connection", "Keep-Alive");
        post.setHeaders(headers);
        post.setEntity(requestEntity);
        CloseableHttpResponse httpResponse = httpClient.execute(post);
        HttpEntity entity = httpResponse.getEntity();
        return EntityUtils.toByteArray(entity);
    }

    /**
     * GET请求，并返回字符串
     *
     * @param url 提交的地址
     * @return
     */
    public static String get(String url) throws IOException {
        return get(url, null);
    }

    public static String get(String url, Header[] header) throws IOException {
        HttpGet get = new HttpGet(url);
        // 设置为长连接，服务端判断有此参数就不关闭连接。
        get.setHeader("Connection", "Keep-Alive");
        if (header != null && header.length > 0)
            get.setHeaders(header);
        HttpEntity entity = httpClient.execute(get).getEntity();
        return EntityUtils.toString(entity, charset);
    }
}
