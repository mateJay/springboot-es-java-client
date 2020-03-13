package com.matejay.es.bean;

import com.matejay.es.config.EsConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置es client bean
 */
@Configuration
public class EsClient {

    @Autowired
    private EsConfig esConfig;

    @Bean(initMethod = "init", destroyMethod = "close")
    public EsClientBean buildEsClient() {
        EsClientBean esClientBean = new EsClientBean();
        esClientBean.setProperties(esConfig.getEsProperties());
        return esClientBean;
    }
}
