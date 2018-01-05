package org.moskito.moskito_home.rest.alexa_authorization;

import org.junit.Assert;
import org.junit.Test;

public class TokenManagerTest {
    @Test
    public void test() {
        test("admin");
        test("leo");
        test("ajdosjdfa");
        test("null");
        test("kekeekkeke");
    }

    private void test(String username) {
        String usernameOriginal = username;
        TokenManager tm = new TokenManager(usernameOriginal);
        String token = tm.getAccessToken();
        String usernameDecoded = TokenDecoder.getIssuer(token);
        Assert.assertEquals(usernameOriginal, usernameDecoded);

        System.out.println(usernameOriginal + "          " + token);
    }
}