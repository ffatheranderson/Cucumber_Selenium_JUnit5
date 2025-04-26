package com.example.runner;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
// value of @SelectPackages annotation should correspond to the name of the package where your *.feature files under "resources" folder. In this particular example : features
@SelectPackages("features")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
// value of @ConfigurationParameter annotation should be equal to the name of the package under the test/java folder which contains the so colled "glue" or in other words "steps" definitions.
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.example")
public class CucumberRunnerTest {

}
