package com.coldmorning.online.education.auth.util.response;

import org.springframework.http.HttpStatus;

public class ResultHttpStatus {
    public static final HttpStatus status200 = HttpStatus.OK;
    public static final HttpStatus status201 = HttpStatus.CREATED;
    public static final HttpStatus status400 = HttpStatus.BAD_REQUEST;
    public static final HttpStatus status401 = HttpStatus.UNAUTHORIZED;
    public static final HttpStatus status422 = HttpStatus.UNPROCESSABLE_ENTITY;
    public static final HttpStatus status500 = HttpStatus.INTERNAL_SERVER_ERROR;
}
