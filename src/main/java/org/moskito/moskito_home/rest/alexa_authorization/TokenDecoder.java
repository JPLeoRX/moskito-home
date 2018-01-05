package org.moskito.moskito_home.rest.alexa_authorization;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;

public class TokenDecoder {
    public static String getIssuer(String token) {
        String issuer = null;

        try {
            DecodedJWT jwt = JWT.decode(token);
            issuer = jwt.getIssuer();
        }

        catch (JWTDecodeException e) {
            e.printStackTrace();
            // Invalid token
        }

        return issuer;
    }
}
