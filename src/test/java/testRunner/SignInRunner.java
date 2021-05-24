package testRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions
        (
                features=".//Feature/SignIn.feature",
                glue="stepDefinitions",
                dryRun=false,
                monochrome=true,
                plugin= {"pretty", "html:test-output.html"}
                //plugin= {"pretty", "html:target/cucumber-html-report.html"}
        )


public class SignInRunner {
}
