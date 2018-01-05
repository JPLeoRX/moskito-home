package org.moskito.moskito_home.rest.alexa_authorization;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class AlexaResponse {
    private String redirectUrl;
    private String state;
    private String accessToken;
    private String tokenType;
    private LinkedMultiValueMap paramsMap = new LinkedMultiValueMap();

    public AlexaResponse(String redirectUrl, String state, String accessToken, String tokenType) {
        this.redirectUrl = redirectUrl;
        this.state = state;
        this.accessToken = accessToken;
        this.tokenType = tokenType;

        paramsMap.add("state", state);
        paramsMap.add("access_token", accessToken);
        paramsMap.add("token_type", tokenType);
    }

    public String toUrl() {
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .host(redirectUrl).path("/")
                .queryParams(paramsMap).build();

        return uriComponents.toString();
    }

    @Override
    public String toString() {
        return "AlexaResponse{" +
                "redirectUrl='" + redirectUrl + '\'' +
                ", state='" + state + '\'' +
                ", accessToken='" + accessToken + '\'' +
                ", tokenType='" + tokenType + '\'' +
                ", url='" + toUrl() + '\'' +
                '}';
    }
}