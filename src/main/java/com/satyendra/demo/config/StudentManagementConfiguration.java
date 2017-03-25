package com.satyendra.demo.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

public class StudentManagementConfiguration extends Configuration {

    @JsonProperty("mySQLConfiguration")
    private MySQLConfiguration mySQLConfiguration;

    public MySQLConfiguration getMySQLConfiguration() {
        return mySQLConfiguration;
    }

    public void setMySQLConfiguration(MySQLConfiguration mySQLConfiguration) {
        this.mySQLConfiguration = mySQLConfiguration;
    }
}
