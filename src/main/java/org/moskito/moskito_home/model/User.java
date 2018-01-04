package org.moskito.moskito_home.model;

/**
 * User POJO
 * @author Leo Ertuna
 */
public class User {
    private String username;
    private String password;
    private String appUrl;

    public User() {

    }

    public User(String username, String password, String appUrl) {
        this.username = username;
        this.password = password;
        this.appUrl = appUrl;
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

    public String getAppUrl() {
        return appUrl;
    }

    public void setAppUrl(String appUrl) {
        this.appUrl = appUrl;
    }
}