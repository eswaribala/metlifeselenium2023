package com.metlife.cucumberspringdemo.cucumber;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

@Suite
//@IncludeEngines("cucumber")
@SelectClasspathResource("com/metlife/cucumberspringdemo/cucumber/features")
//@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.metlife.cucumberspringdemo.cucumber.stepDefs")
public class CucumberTest {
}
