package org.moskito.moskito_home.rest.alexa_authorization;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * Alexa Response POJO
 *
 * This object represents the data we need to provide for the Alexa Skill
 *
 * @author Leo Ertuna
 */
public class AlexaResponse {
    private String redirectUrl;             // Amazon specific redirect URL to which we should redirect from our login page
    private String state;                   // Alexa's internal parameter, pass from request
    private String accessToken;             // Our generated access token
    private String tokenType;               // Token type should be "Bearer"

    // Constructors
    //------------------------------------------------------------------------------------------------------------------
    public AlexaResponse(String redirectUrl, String state, String accessToken, String tokenType) {
        this.redirectUrl = redirectUrl;
        this.state = state;
        this.accessToken = accessToken;
        this.tokenType = tokenType;
    }
    //------------------------------------------------------------------------------------------------------------------

    // Combine the base redirect url wih all the parameters
    public String toUrl() {
        String url = redirectUrl + "#";
        url += "state=" + state;
        url += "&access_token=" + accessToken;
        url += "&token_type=" + tokenType;
        return url;
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