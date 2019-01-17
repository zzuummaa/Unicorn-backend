package ru.zuma.rest.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import java.util.HashMap;
import java.util.Map;

public class User {

    private String androidId;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonGetter(value = "android_id")
    public String getAndroidId() {
        return androidId;
    }

    public void setAndroidId(String androidId) {
        this.androidId = androidId;
    }

    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "User{" +
                "androidId='" + androidId + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
