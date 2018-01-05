package org.moskito.moskito_home.rest.alexa_authorization;

public class TokenManager {
    private String username;
    private String accessToken;

    public TokenManager(String username) {
        this.username = username;
        this.accessToken = TokenCreator.createToken("alexa-skill-secret", username);
    }

    public String getUsername() {
        return username;
    }

    public String getAccessToken() {
        return accessToken;
    }

}