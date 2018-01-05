package org.moskito.moskito_home.rest.alexa_authorization;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;

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
