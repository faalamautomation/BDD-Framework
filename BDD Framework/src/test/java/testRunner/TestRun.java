package testRunner;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		          features= {".//Features/Login.feature",".//Features/Notes.feature"},
		          glue={"stepDefinitions","hooks"},
		          dryRun=true,
		          monochrome=true,
		          plugin= {"pretty", "html:target/CucumberReports/CucumberReport.html"}
                )

public class TestRun {

	
	
	
}
