package com.liuliu.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResponseCode {
    SUCCESS(200,"Success"),
    REQUEST_BAD(400,"Bad Request"),
    NOTFOUND(404,"Not Found"),
    FORBIDDEN(403,"Forbidden"),
    SERVER_ERROR(500,"Server Internal Error"),
    UNAUTHORZED(401,"UNAUTHORIZED"),
    CUSTOM_ERROR(700,"Custom error")
    ;
    private final int code;
    private final String desc;
}
