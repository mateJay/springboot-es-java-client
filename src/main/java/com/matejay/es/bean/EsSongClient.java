package com.matejay.es.bean;

import com.matejay.es.config.EsConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置es client bean
 */
@Configuration
public class EsSongClient {

    @Bean(initMethod = "init", destroyMethod = "close", name = "songClient")
    public EsClientBean buildEsSongClient(EsConfig esConfig) {
        EsClientBean esClientBean = new EsClientBean();
        esClientBean.setProperties(esConfig.getEsProperties());
        esClientBean.setIndex(esConfig.getSongIndex());
        return esClientBean;
    }
}
