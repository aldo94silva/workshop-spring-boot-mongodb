package com.aldosilva.workshopmongo.exeptions;

import java.io.Serial;

public class NotFoundExeption extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private final int errorCode = 400;

    public NotFoundExeption(String msg) {
        super(msg);
    }

    public  int getErrorCode(){
        return errorCode;
    }
}
