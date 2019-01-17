package ru.zuma;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="app")
public class AppProperties {

    private String imageServerURL;

    public String getImageServerURL() {
        return imageServerURL;
    }

    public void setImageServerURL(String imageServerURL) {
        this.imageServerURL = imageServerURL;
    }
}
