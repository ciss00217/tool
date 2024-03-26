package com.fcb.reset.tool.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "app.reset-batch-script")
public class ResetBatchScriptConfigurationProperties {
    private String startTime;
    private Map<String, String> map;
    public Map<String, String> getMap() {
        return map;
    }
    public void setMap(Map<String, String> map) {
        this.map = map;
    }
}

