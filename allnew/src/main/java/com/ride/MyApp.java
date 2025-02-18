package com.ride;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyApp {
    
    @Value("${myapp.name}")
    private String appName;

    @Value("${myapp.version}")
    private String version;

    @Value("${myapp.description}")
    private String des;

    public String getAppName() {
        return appName;
    }

    public String getVersion() {
        return version;
    }

    public String getDes() {
        return des;
    }
}
