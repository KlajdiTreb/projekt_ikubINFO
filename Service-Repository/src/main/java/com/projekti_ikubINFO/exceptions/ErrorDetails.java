package com.projekti_ikubINFO.exceptions;

import java.util.Date;

public class ErrorDetails {
    private String message;
    private String details;
    private Date time;

    public ErrorDetails(Date time, String message, String details) {
        super();
        this.time = time;
        this.message = message;
        this.details = details;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

    public Date getTime() {
        return time;
    }

}