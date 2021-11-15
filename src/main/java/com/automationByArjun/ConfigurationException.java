package com.automationByArjun;

public class ConfigurationException extends RuntimeException {

    String exceptionMessage;
    String cause;
    public ConfigurationException(String message){
        this.cause = message;
    }

    public String toString(){
     exceptionMessage = "error on configuration file. please check the file for any invalid input";
        exceptionMessage += " exception occurred due to "+ this.cause;
        return  exceptionMessage;
    }
}
