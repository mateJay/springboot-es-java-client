package com.matejay.es.config;

import com.matejay.es.constant.PropertyKeyConst;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
@ConfigurationProperties(prefix = "spring.es")
public class EsConfig {
    private String hostName;
    private String port;
    private String songIndex;

    public Properties getEsProperties() {
        Properties properties = new Properties();
        properties.setProperty(PropertyKeyConst.HOST_NAME, hostName);
        properties.setProperty(PropertyKeyConst.PORT, port);

        return properties;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getSongIndex() {
        return songIndex;
    }

    public void setSongIndex(String songIndex) {
        this.songIndex = songIndex;
    }
}
