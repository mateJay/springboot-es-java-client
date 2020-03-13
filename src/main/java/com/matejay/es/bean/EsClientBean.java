package com.matejay.es.bean;

import com.matejay.es.constant.PropertyKeyConst;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Properties;

public class EsClientBean {
    private Properties properties;
    private RestHighLevelClient esClient;

    private Logger logger = LoggerFactory.getLogger(EsClient.class);

    /**
     * 初始化es client
     */
    public void init() {
        if (this.properties == null) {
            throw new RuntimeException("properties is null");
        } else {
            String hostName = properties.getProperty(PropertyKeyConst.HOST_NAME);
            String port = properties.getProperty(PropertyKeyConst.PORT);
            esClient = new RestHighLevelClient(RestClient.builder(new HttpHost(hostName, Integer.parseInt(port), "http")));
        }
        logger.info("init es client success");
    }

    /**
     * 关闭es client
     */
    public void close() {
        if (esClient != null) {
            try {
                esClient.close();
                logger.info("close es client success");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public RestHighLevelClient getEsClient() {
        return esClient;
    }

    public void setEsClient(RestHighLevelClient esClient) {
        this.esClient = esClient;
    }
}
