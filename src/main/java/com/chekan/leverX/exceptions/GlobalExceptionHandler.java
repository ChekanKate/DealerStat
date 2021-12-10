package com.chekan.leverX.exceptions;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.hibernate5.HibernateOptimisticLockingFailureException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.NoResultException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<IncorrectData> handleException(MyNoSuchElementException exception) {
        IncorrectData data = new IncorrectData();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<IncorrectData> handleException(NumberFormatException exception) {
        IncorrectData data = new IncorrectData();
        data.setInfo("Wrong format of data");

        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<IncorrectData> handleException(HibernateOptimisticLockingFailureException exception) {
        IncorrectData data = new IncorrectData();
        data.setInfo("This item does not exist.");

        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<IncorrectData> handleException(NoResultException exception) {
        IncorrectData data = new IncorrectData();
        data.setInfo("This item does not exist.");

        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<IncorrectData> handleException(ConstraintViolationException exception) {
        IncorrectData data = new IncorrectData();
        data.setInfo("This item does not exist.");

        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<IncorrectData> handleException(IndexOutOfBoundsException exception) {
        IncorrectData data = new IncorrectData();
        data.setInfo("This item does not exist.");

        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }


}
