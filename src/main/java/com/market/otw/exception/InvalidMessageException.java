package com.market.otw.exception;

public class InvalidMessageException extends OwtException{

    public InvalidMessageException( String errMsg) {
        super( errMsg);
    }

    @Override
    public int getStatusCode() {
        return 400;
    }
}
