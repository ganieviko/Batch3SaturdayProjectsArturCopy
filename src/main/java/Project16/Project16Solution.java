package Project16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Project16Solution {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "resources/webdrivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 5);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // Navigate to https://test.campus.techno.study/
        driver.get("https://test.campus.techno.study");

        // Dismiss the cookie message by clicking on "Got it!" button
        driver.findElement(By.cssSelector("a[aria-label=\"dismiss cookie message\"]")).click();

        // Login by the credentials (username = "daulet2030@gmail.com" and password = "TechnoStudy123@")
        String username = "daulet2030@gmail.com";
        String password = "TechnoStudy123@";
        driver.findElement(By.cssSelector("input[formcontrolname=\"username\"]")).sendKeys(username);
        driver.findElement(By.cssSelector("input[formcontrolname=\"password\"]")).sendKeys(password);
        driver.findElement(By.cssSelector("button[aria-label=\"LOGIN\"]")).click();

        //  Navigate to HumanResources > Employees through the left menu
        driver.findElement(By.cssSelector("div.group-items>fuse-nav-vertical-collapsable:nth-child(5)")).click();
        driver.findElement(By.cssSelector("fuse-nav-vertical-collapsable:nth-child(5)>div.children>fuse-nav-vertical-item:nth-child(2)")).click();

    }

    //  Test 1: Verify that an employee can be created with a minimum (First Name, Last Name, Employee ID, Document Type and Document Number) data --> (passes)
    @Test
    public void test1() {
        driver.findElement(By.cssSelector("ms-add-button[tooltip=\"EMPLOYEE.TITLE.ADD\"]")).click();


    }


//  Test 2: Verify that an existing employee can be deleted
//  Test 3: Verify that the first name of an existing employee can be updated --> (passes)
//  Test 4: Verify that the last name of an existing employee can be updated --> (passes)
//  Test 5: Verify that the document number of an existing employee can be updated --> (passes)
//  Test 6: Verify that (any other data you decided) of an existing employee can be updated --> (passes)
//  Test 7: Verify that an employee with different names but the same Employee ID cannot be created --> (fails!)
//  Test 8: Verify that an employee with different names but the same Document Number cannot be created --> (passes)
//  Test 9: Verify that an employee with the same First Name and Last Name can be created --> (passes)

//  Use a data provider to do the Tests 10-15
//  Test 10: Verify that an employee without entering a first name cannot be created --> (passes)
//  Test 11: Verify that an employee without entering a last name cannot be created --> (passes)
//  Test 12: Verify that an employee without entering an Employee ID cannot be created --> (passes)
//  Test 13: Verify that an employee cannot be created if you enter just numerical values for the First Name --> (fails!!!)
//  Test 14: Verify that an employee cannot be created if you enter just special characters like @,!,#, ,%,^,... for the name --> (fails!!!)
//  Test 15: Add your own test data for the data provider for a negative testing of creating an employee (feel free to add more than one case)

//  Test 16: Verify that a photo can be uploaded while creating a new employee --> (fails!)
//  Test 17: Verify that a photo can be uploaded for an existing employee --> (passes)
//  Test 18:Verify that the photo of an existing employee can be changed --> (passes)
//  Test 19: Verify that the photo of an existing employee can be deleted --> (passes)

//  Write at least three different test cases for the search options of your own!
//  Close the browser
}
