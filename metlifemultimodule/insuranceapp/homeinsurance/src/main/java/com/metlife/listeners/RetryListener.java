package com.metlife.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListener implements IRetryAnalyzer {
    private int initialRetryCount=0;
    private final int maxcount=3;
    @Override
    public boolean retry(ITestResult iTestResult) {
        if(initialRetryCount<maxcount){
            initialRetryCount++;
            return true;
        }
        return false;
    }
}
