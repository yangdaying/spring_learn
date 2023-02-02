package com.example.demo.controller;

import com.example.demo.exception.MyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = MyException.class)
    public String getErr(){

        return "";
    }


}
