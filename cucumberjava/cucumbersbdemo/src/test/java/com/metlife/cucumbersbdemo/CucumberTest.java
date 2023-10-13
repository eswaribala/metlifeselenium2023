package com.metlife.cucumbersbdemo;

//@Suite
//@IncludeEngines("cucumber")
//@SelectClasspathResource("com/metlife/cucumberspringdemo/cucumber/features")
//@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.metlife.cucumberspringdemo.cucumber.stepDefs")



import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.core.options.Constants.GLUE_PROPERTY_NAME;

@Suite
//@IncludeEngines("cucumber")
@SelectClasspathResource("features")
//@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.metlife.cucumberspringdemo",tags="@InValidPhoneNumber")
public class CucumberTest {
}


