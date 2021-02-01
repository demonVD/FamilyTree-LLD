package com.familytree.Utility;

import lombok.NonNull;

/**
 * Represent response
 * all apis send this response
 */
public class ReturnResponse {
    private final String response;

    public ReturnResponse(@NonNull final String response) {
        this.response = response;
    }

    public String getResponse() {
        return this.response;
    }
}
