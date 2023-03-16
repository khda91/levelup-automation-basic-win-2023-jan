package ru.levelp.at.lesson13.bdd;

import io.cucumber.junit.platform.engine.Cucumber;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

//@Suite
////@IncludeEngines("cucumber")
// @SelectClasspathResource("ru/levelp/at/lesson13/bdd")
//@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "ru.levelp.at.lesson13.bdd")
@Cucumber
public class RunCucumberTest {
}
