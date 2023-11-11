package com.javaproject.region.service.exception;

public class RegionNotFoundException extends RuntimeException{
    public RegionNotFoundException(String message){
        super(message);
    }

}
