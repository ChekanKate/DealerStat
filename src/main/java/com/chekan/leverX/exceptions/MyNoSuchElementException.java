package com.chekan.leverX.exceptions;


import javax.persistence.NoResultException;

public class MyNoSuchElementException extends NoResultException {

    public MyNoSuchElementException(String message) {
        super(message);
    }

}
