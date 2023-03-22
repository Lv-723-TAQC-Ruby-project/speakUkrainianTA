package com.ita.edu.speakua.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {
    private final Properties properties;

    public ConfigProperties() {
        properties = new Properties();
        try {
            FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config.properties");
            properties.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public String getJDBCTeachUAURL() { return properties.getProperty("JDBCTeachUAURL");  }
    public String getJDBCTeachUAUser() { return properties.getProperty("JDBCTeachUAUser");  }
    public String JDBCTeachUAPassword() { return properties.getProperty("JDBCTeachUAPassword");  }

    public String getAdminEmail() {
        return properties.getProperty("admin_email");
    }
    public String getAdminPassword() {
        return properties.getProperty("admin_password");
    }
    public String getBaseWebUrl() {
        return properties.getProperty("base_web_url");
    }
    public String getUserEmail() {
        return properties.getProperty("user_email");
    }
    public String getUserPassword() {
        return properties.getProperty("user_password");
    }
    public String getUserSoyecEmail() {
        return properties.getProperty("user_soyec_email");
    }
    public String getUserSoyecPassword() {
        return properties.getProperty("user_soyec_password");
    }

}
