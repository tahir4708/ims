package com.ita.if103java.ims.exception.dao;

import com.ita.if103java.ims.exception.BaseRuntimeException;

public class CRUDException extends BaseRuntimeException {

    public CRUDException(String message) {
        super(message);
    }

    public CRUDException() {
    }

    public CRUDException(String message, Throwable cause) {
        super(message, cause);
    }

    public CRUDException(Throwable cause) {
        super(cause);
    }

}
