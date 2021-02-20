package steps;


import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import utils.BaseClass;

public class LoginSteps extends BaseClass {
    WebDriver driver;

    @Given("User navigates to the  {string}")
    public void userNavigatesToThe(String website) {
        driver = BaseClass.setUp();
        driver.get(website);
        driver.manage().window().maximize();
    }
}
