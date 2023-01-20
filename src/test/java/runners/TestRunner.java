package runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith (Cucumber.class)
@CucumberOptions(
		  plugin= {"pretty","html:Reports/htmlReport.html","json:Reports/jsonReport.json"},
		  features="./src/test/resources/features",
		  glue="step_defination",
		  dryRun=false,  
		  tags="@LoginPageTest", 
		  
		  publish= true
		  )
public class TestRunner {
	

}
