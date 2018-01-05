package org.moskito.moskito_home.rest.alexa_authorization;

import java.util.List;

/**
 * Alexa Request POJO
 *
 * This object represents all the data that is passed from Alexa Skill to our login page
 *
 * @author Leo Ertuna
 */
public class AlexaRequest {
    private String state;               // Alexa's internal parameter, pass back unchanged
    private String clientId;            // Alexa Skill's id, configured in developer's console
    private String responseType;        // Response type - "Code" or "Token", we will use token
    private List<String> scope;         // Optional list of scope parameters, we won't use it
    private String redirectUrl;         // Amazon specific redirect URL to which we should redirect from our login page

    // Constructors
    //------------------------------------------------------------------------------------------------------------------
    public AlexaRequest() {

    }

    public AlexaRequest(String state, String clientId, String responseType, List<String> scope, String redirectUrl) {
        this.state = state;
        this.clientId = clientId;
        this.responseType = responseType;
        this.scope = scope;
        this.redirectUrl = redirectUrl;
    }
    //------------------------------------------------------------------------------------------------------------------



    // Getters
    //------------------------------------------------------------------------------------------------------------------
    public String getState() {
        return state;
    }

    public String getClientId() {
        return clientId;
    }

    public String getResponseType() {
        return responseType;
    }

    public List<String> getScope() {
        return scope;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }
    //------------------------------------------------------------------------------------------------------------------



    // Setters
    //------------------------------------------------------------------------------------------------------------------
    public void setState(String state) {
        this.state = state;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }

    public void setScope(List<String> scope) {
        this.scope = scope;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }
    //------------------------------------------------------------------------------------------------------------------

    @Override
    public String toString() {
        return "AlexaRequest{" +
                "state='" + state + '\'' +
                ", clientId='" + clientId + '\'' +
                ", responseType='" + responseType + '\'' +
                ", scope=" + scope +
                ", redirectUrl='" + redirectUrl + '\'' +
                '}';
    }
}
