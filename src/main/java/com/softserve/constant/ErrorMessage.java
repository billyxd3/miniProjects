package com.softserve.constant;

public enum ErrorMessage {
    FAIL_TO_CREATE_CONNECTION("FAIL TO CREATE CONNECTION TO DATABASE"),
    FAIL_TO_READ_DATABASE_PROPERTIES("FAIL TO READ DATABASE PROPERTIES FROM FILE"),
    FAIL_TO_CLOSE_CONNECTION("FAIL TO CREATE CONNECTION TO DATABASE");


    String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}