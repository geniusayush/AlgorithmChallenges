package com.demo;

/**
 * Created by ayush on 16/02/17.
 */
public class LoggerException extends Exception {

    public LoggerException(String s) {
        super(s);
    }

    public LoggerException(Exception e) {
        super(e);
    }
}

