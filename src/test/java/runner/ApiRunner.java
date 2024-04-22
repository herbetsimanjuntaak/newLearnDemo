package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        glue = {"stepDef"}, //tempat menaro step kita
        features = {"src/test/java/features"}, //path dimana feature diletakkan
        tags = "@api" //nge run yang ada tag api nya yang ada di feature
)
public class ApiRunner {
}
