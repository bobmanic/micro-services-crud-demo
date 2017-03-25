package com.satyendra.demo.config;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Satyendra on 25/03/17.
 */
public class MySQLConfiguration {

    @JsonProperty("url")
    private String url;

    @JsonProperty("port")
    private String port;

    @JsonProperty("database")
    private String database;

    @JsonProperty("username")
    private String username;

    @JsonProperty("password")
    private String password;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        StringBuilder sb = new StringBuilder("jdbc:mysql://");
        sb.append(this.url).append(":").append(this.port).append("/").append(this.database);
        return sb.toString();
    }
}
