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
                //tags = {"@sanity","@regression"}, //AND
                plugin= {"pretty", "html:test-output.html"}
                //tags = {"@sanity,@Regression"} //OR


        )
class SignInRunner {
}
