package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import pages.ProjectSpecificMethods;

@CucumberOptions(features = "src/test/java/feature",
		         glue = "stepDefinition",
                 monochrome =true,
		         publish = true)

public class RunCucumberTests extends ProjectSpecificMethods {

}
