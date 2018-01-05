package org.moskito.moskito_home.rest.responses;

public class JsonTokenVerificationResponse {
    private boolean valid;

    public JsonTokenVerificationResponse(boolean valid) {
        this.valid = valid;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
}