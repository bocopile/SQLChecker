package com.example.sqlchecker.consts;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {

    FORBIDDEN(403, "ERR-403", "FORBIDDEN"),
    NOT_FOUND(404 , "ERR-404", "NOT FOUND"),
    INTERVAL_ERROR(500, "ERR-500", "INTER SERVER ERROR");

    public int resultCode;
    public String errorCode;
    public String message;

}
