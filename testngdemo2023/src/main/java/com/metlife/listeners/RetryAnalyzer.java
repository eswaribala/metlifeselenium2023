package com.metlife.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import java.util.ResourceBundle;

public class RetryAnalyzer implements IRetryAnalyzer {
    private int retryCount=0;
    private int maxRetryCount=3;

    private  ResourceBundle resourceBundle;
    public RetryAnalyzer(){
       resourceBundle=ResourceBundle.getBundle("file");
       maxRetryCount=Integer.parseInt(resourceBundle.getString("retrymaxcount"));
    }
    @Override
    public boolean retry(ITestResult iTestResult) {
        if(retryCount<maxRetryCount){
            retryCount++;
            return true;
        }
        return false;
    }
}
