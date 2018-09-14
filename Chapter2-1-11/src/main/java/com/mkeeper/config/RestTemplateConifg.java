package com.mkeeper.config;

import org.apache.http.Header;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.Netty4ClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;

// 必备
@Configuration
@ConfigurationProperties(prefix = "spring.restTemplate")
@ConditionalOnClass(value = {RestTemplate.class, CloseableHttpClient.class})
public class RestTemplateConifg {

    // java配置的优先级低于yml配置；如果yml配置不存在，会采用java配置
    // ####restTemplate的 java配置开始####
    private int maxTotalConnection = 500; //连接池的最大连接数

    private int maxConnectionPerRoute = 100; //同路由的并发数

    private int connectionTimeout = 2 * 1000; //连接超时，默认2s

    private int readTimeout = 30 * 1000; //读取超时，默认30s

    private String charset = "UTF-8";
    // ####restTemplate的 java配置结束####

    public void setMaxTotalConnection(int maxTotalConnection) {
        this.maxTotalConnection = maxTotalConnection;
    }

    public void setMaxConnectionPerRoute(int maxConnectionPerRoute) {
        this.maxConnectionPerRoute = maxConnectionPerRoute;
    }

    public void setConnectionTimeout(int connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    public void setReadTimeout(int readTimeout) {
        this.readTimeout = readTimeout;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    //创建HTTP客户端工厂
    @Bean(name = "clientHttpRequestFactory")
    public ClientHttpRequestFactory clientHttpRequestFactory() {
        return createClientHttpRequestFactory(this.connectionTimeout, this.readTimeout);
    }

    //初始化RestTemplate,并加入spring的Bean工厂，由spring统一管理
    @Bean(name = "restTemplate")
    @ConditionalOnMissingBean(RestTemplate.class)
    public RestTemplate restTemplate(ClientHttpRequestFactory factory) {
        return createRestTemplate(factory);
    }

    //初始化支持异步的RestTemplate,并加入spring的Bean工厂，由spring统一管理
    //如果你用不到异步，则无须创建该对象
    @Bean(name = "asyncRestTemplate")
    @ConditionalOnMissingBean(AsyncRestTemplate.class)
    public AsyncRestTemplate asyncRestTemplate(RestTemplate restTemplate) {
        final Netty4ClientHttpRequestFactory factory = new Netty4ClientHttpRequestFactory();
        factory.setConnectTimeout(this.connectionTimeout);
        factory.setReadTimeout(this.readTimeout);
        return new AsyncRestTemplate(factory, restTemplate);
    }

    private ClientHttpRequestFactory createClientHttpRequestFactory(int connectionTimeout, int readTimeout) {
        //maxTotalConnection 和 maxConnectionPerRoute 必须要配
        if (this.maxTotalConnection <= 0) {
            throw new IllegalArgumentException("invalid maxTotalConnection: " + maxTotalConnection);
        }
        if (this.maxConnectionPerRoute <= 0) {
            throw new IllegalArgumentException("invalid maxConnectionPerRoute: " + maxTotalConnection);
        }

        //全局默认的header头配置
        List<Header> headers = new LinkedList<>();
        headers.add(new BasicHeader("Accept-Encoding", "gzip,deflate"));
        headers.add(new BasicHeader("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6"));

        //禁用自动重试，需要重试时，请自行控制
        HttpRequestRetryHandler retryHandler = new DefaultHttpRequestRetryHandler(0, false);

        //创建真正处理http请求的httpClient实例
        CloseableHttpClient httpClient = HttpClients.custom()
                .setDefaultHeaders(headers)
                .setRetryHandler(retryHandler)
                .build();

        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(
                httpClient);
        factory.setConnectTimeout(connectionTimeout);
        factory.setReadTimeout(readTimeout);
        return factory;
    }

    private RestTemplate createRestTemplate(ClientHttpRequestFactory factory) {
        RestTemplate restTemplate = new RestTemplate(factory);

        //我们采用RestTemplate内部的MessageConverter
        //重新设置StringHttpMessageConverter字符集，解决中文乱码问题
        modifyDefaultCharset(restTemplate);

        //设置错误处理器
        restTemplate.setErrorHandler(new DefaultResponseErrorHandler());

        return restTemplate;
    }

    private void modifyDefaultCharset(RestTemplate restTemplate) {
        List<HttpMessageConverter<?>> converterList = restTemplate.getMessageConverters();
        HttpMessageConverter<?> converterTarget = null;
        for (HttpMessageConverter<?> item : converterList) {
            if (StringHttpMessageConverter.class == item.getClass()) {
                converterTarget = item;
                break;
            }
        }
        if (null != converterTarget) {
            converterList.remove(converterTarget);
        }
        Charset defaultCharset = Charset.forName(charset);
        converterList.add(1, new StringHttpMessageConverter(defaultCharset));
    }

}
