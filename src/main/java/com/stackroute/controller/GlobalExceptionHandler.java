package com.stackroute.controller;

import com.stackroute.exception.AlreadyUpdatedException;
import com.stackroute.exception.TrackAlreadyExistException;
import com.stackroute.exception.TrackNotFoundException;
import lombok.extern.log4j.Log4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice

public class GlobalExceptionHandler
{
    @ResponseStatus(value= HttpStatus.CONFLICT,reason="Track Already exists")
    @ExceptionHandler(TrackAlreadyExistException.class)
    public void handleTrackAlreadyExistException(TrackAlreadyExistException e)
    {
        System.out.println("Track Already Exists"+e);

    }


    @ResponseStatus(value= HttpStatus.NOT_FOUND,reason="Track Not Found")
    @ExceptionHandler(TrackNotFoundException.class)
    public void handleTrackNotExistException(TrackNotFoundException e)
    {
        System.out.println("Track doesn't exists"+e);

    }


    @ResponseStatus(value= HttpStatus.CONFLICT,reason="Updation already exists")
    @ExceptionHandler(AlreadyUpdatedException.class)
    public void handleEmptyFieldException(AlreadyUpdatedException e)
    {
        System.out.println("Updation alraedy done for this id"+e);

    }
}
