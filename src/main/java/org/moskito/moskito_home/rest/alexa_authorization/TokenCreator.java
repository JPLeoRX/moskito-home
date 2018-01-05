package org.moskito.moskito_home.rest.alexa_authorization;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

import java.io.UnsupportedEncodingException;

public class TokenCreator {
    public static String createToken(String secret, String issuer) {
        String token = null;

        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            token = JWT.create().withIssuer(issuer).sign(algorithm);
        }

        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            // UTF-8 encoding not supported
        }

        catch (JWTCreationException e) {
            e.printStackTrace();
            // Invalid Signing configuration / Couldn't convert Claims.
        }

        return token;
    }
}
