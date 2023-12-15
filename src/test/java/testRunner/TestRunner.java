package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features= {"src/test/java/Features/TCLogin.feature"},
        glue="stepDefinitions",
        plugin= {
        		"pretty", "html:reports/myreport.html", 
        		"json:reports/myreport.json"
        		},    //Mandatory to capture failures
        dryRun=true,
        monochrome=true 
      )
public class TestRunner 
{ 
}