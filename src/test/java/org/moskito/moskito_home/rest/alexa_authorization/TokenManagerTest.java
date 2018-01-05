package org.moskito.moskito_home.rest.alexa_authorization;

import org.junit.Assert;
import org.junit.Test;

public class TokenManagerTest {
    @Test
    public void test() {
        String usernameOriginal = "admin";
        TokenManager tm = new TokenManager(usernameOriginal);
        String token = tm.getAccessToken();
        System.out.println(token);

        String usernameDecoded = TokenDecoder.getIssuer(token);
        System.out.println(usernameDecoded);

        Assert.assertEquals(usernameOriginal, usernameDecoded);
    }

}