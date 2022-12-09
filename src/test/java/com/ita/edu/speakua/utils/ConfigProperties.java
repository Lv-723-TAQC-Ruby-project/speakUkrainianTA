package com.ita.edu.speakua.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {
    private final Properties properties;

    public ConfigProperties() {
        properties = new Properties();
        try {
            FileInputStream file = new FileInputStream("src/test/resources/config.properties");
            properties.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  String getLastName() {return properties.getProperty("lastName");}
    public  String getFirstName() {return properties.getProperty("firstName");}
    public  String getPhone() {return properties.getProperty("phone");}
    public  String getEmail() {return properties.getProperty("email");}
    public  String getPassword() {return properties.getProperty("password");}
    public  String getConfirm() {return properties.getProperty("confirm");}
    public String getAdminEmail() {
        return properties.getProperty("admin_email");
    }
    public String getAdminPassword() {
        return properties.getProperty("admin_password");
    }
    public String getBaseWebUrl() {
        return properties.getProperty("base_web_url");
    }

}
