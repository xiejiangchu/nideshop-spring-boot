package com.xie.config;

import com.alibaba.media.MediaConfiguration;
import com.alibaba.media.client.MediaClient;
import com.alibaba.media.client.impl.DefaultMediaClient;
import com.alibaba.media.upload.UploadPolicy;
import com.alibaba.media.upload.UploadTokenClient;
import com.alibaba.media.upload.impl.DefaultUploadTokenClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Author xie
 * @Date 17/2/23 下午4:38.
 */
@Configuration
@ConfigurationProperties(prefix = "spring.alibaba")
@Component
public class  AlibabaConfig {
    private String appkey;
    private String appsecret;
    private String namespace;

//    @Bean(name = "manageClient")
//    public ManageClient manageClient(@Qualifier("mediaConfiguration") MediaConfiguration configuration) {
//        return new DefaultMediaClient(configuration);
//    }

    @Bean(name = "mediaClient")
    public MediaClient mediaClient(@Qualifier("mediaConfiguration") MediaConfiguration configuration) {
        return new DefaultMediaClient(configuration);
    }

    @Bean(name = "uploadTokenClient")
    public UploadTokenClient uploadTokenClient(@Qualifier("mediaConfiguration") MediaConfiguration configuration) {
        return new DefaultUploadTokenClient(configuration);
    }

    @Bean(name = "uploadPolicy")
    public UploadPolicy uploadPolicy(@Qualifier("mediaConfiguration") MediaConfiguration configuration) {
        UploadPolicy uploadPolicy = new UploadPolicy();
        uploadPolicy.setInsertOnly(UploadPolicy.INSERT_ONLY_NONE);
        uploadPolicy.setExpiration(System.currentTimeMillis() + 3600 * 1000);
        return uploadPolicy;
    }

    @Bean(name = "mediaConfiguration")
    public MediaConfiguration mediaConfiguration(AlibabaConfig alibabaConfig) {
        MediaConfiguration configuration = new MediaConfiguration();
        configuration.setAk(alibabaConfig.getAppkey());
        configuration.setSk(alibabaConfig.getAppsecret());
        configuration.setNamespace(alibabaConfig.getNamespace());
        return configuration;
    }


    public String getAppkey() {
        return appkey;
    }

    public void setAppkey(String appkey) {
        this.appkey = appkey;
    }

    public String getAppsecret() {
        return appsecret;
    }

    public void setAppsecret(String appsecret) {
        this.appsecret = appsecret;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }
}
