package steps;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Optional;
import utils.BaseClass;

public class Hooks {
    WebDriver driver;
    @Before
    public void start(){
        driver = BaseClass.setUp();
    }

    @After
    public void quit(Scenario scenario){
            if(scenario.isFailed()){
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", scenario.getName());
            }
        //BaseClass.tearDown();
    }
}
