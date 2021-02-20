package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utils.BaseClass;

@CucumberOptions(

        features = {"src/test/java/featureFiles/login/Part2.feature"},
        glue = {"steps"},
        dryRun = false,
        plugin = {"pretty", "html:target/report/index.html"}

)

public class TestCampusRunner extends AbstractTestNGCucumberTests {
//        @BeforeClass
//        @Parameters("browser")  // in case of parallel running on different browsers from XML folder, should be un-muted.
        public void beforeMethod(String browser){
            BaseClass.browserName.set(browser);
        }
}
