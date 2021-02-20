package Project16.students_solutions;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class Proje16_byTurkana {

    WebDriver driver;
    WebDriverWait wait;
    String created="Employee successfully created";
    String updated="Employee successfully updated";
    String invalid = "×\n" +
            "Error!\n" +
            "Invalid Employee Info!";
    String suchdocument = "×\n" +
            "Error!\n" +
            "Jonathan Clay already has such document number or PIN";
    String deleted="Employee successfully deleted";
    String photoupload="Photo successfully uploaded";
    Robot robot=new Robot();


    public Proje16_byTurkana() throws AWTException {
    }

//  Note-1: Use TestNG for your tests
//  Note-2: Do not forget to delete whatever you have created manually if needed in order to keep the data clean for other testers please.

    //  Open a browser and navigate to


    @Test
    public void login() {
        System.setProperty("webdriver.chrome.driver", "resources/webdrivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://test.campus.techno.study/");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 5);

        //  Dismiss the cookie message by clicking on "Got it!" button
        driver.findElement(Selectors.cookie).click();

        //  Login by the credentials (username = "daulet2030@gmail.com" and password = "TechnoStudy123@")
        driver.findElement(Selectors.username).sendKeys("daulet2030@gmail.com");
        driver.findElement(Selectors.password).sendKeys("TechnoStudy123@");
        driver.findElement(Selectors.loginbutton).click();
    }

    //  Navigate to HumanResources > Employees through the left menu
    @Test(dependsOnMethods = "login")
    public void navigate() {
        waitFor(ExpectedConditions.visibilityOfElementLocated(Selectors.humanresmenu), "Human Resources not visible");
        driver.findElement(Selectors.humanresmenu).click();

        waitFor(ExpectedConditions.visibilityOfElementLocated(Selectors.employeemenu), "Employees menu not visible");
        driver.findElement(Selectors.employeemenu).click();

    }


    //  Test 1: Verify that an employee can be created with a minimum (First Name, Last Name, Employee ID, Document Type and Document Number) data --> (passes)
    @Test(dependsOnMethods = "navigate")
    public void test1() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.firstplus));
        driver.findElement(Selectors.firstplus).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.firstname));
        driver.findElement(Selectors.firstname).sendKeys("Turkana");
        driver.findElement(Selectors.lastname).sendKeys("Mammadova");
        driver.findElement(Selectors.employeeID).sendKeys("3003222");

        driver.findElement(Selectors.doctype).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.docelement1));
        driver.findElement(Selectors.docelement1).click();
        driver.findElement(Selectors.docnumber).sendKeys("3211");
        driver.findElement(Selectors.save).click();

        wait.until(ExpectedConditions.textToBePresentInElementLocated(Selectors.popup,created));
        String actual=driver.findElement(Selectors.popup).getText();
        Assert.assertEquals(actual,created);
        wait.until(ExpectedConditions.invisibilityOfElementWithText(Selectors.popup,created));

    }

    //  Test 2: Verify that an existing employee can be deleted
    @Test(dependsOnMethods = "test1")
    public void test2() {
        driver.findElement(Selectors.delete).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(Selectors.submit));
        driver.findElement(Selectors.submit).click();

        wait.until(ExpectedConditions.textToBePresentInElementLocated(Selectors.popup,deleted));

        String actual=driver.findElement(Selectors.popup).getText();
        Assert.assertEquals(actual,deleted);
        wait.until(ExpectedConditions.invisibilityOfElementWithText(Selectors.popup,deleted));
    }

    //  Test 3: Verify that the first name of an existing employee can be updated --> (passes)
    @Test(dependsOnMethods = "test2")
    public void test3() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.firstname));
        driver.findElement(Selectors.firstname).sendKeys("Jhon");
        driver.findElement(Selectors.lastname).sendKeys("Cornelius");
        driver.findElement(Selectors.employeeID).sendKeys("3045672");
        driver.findElement(Selectors.doctype).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.docelement1));
        driver.findElement(Selectors.docelement1).click();
        driver.findElement(Selectors.docnumber).sendKeys("1111");
        driver.findElement(Selectors.save).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(Selectors.popup,created));
        wait.until(ExpectedConditions.invisibilityOfElementWithText(Selectors.popup,created));

        driver.findElement(Selectors.firstname).clear();
        driver.findElement(Selectors.firstname).sendKeys("Alvina");
        driver.findElement(Selectors.save).click();

        wait.until(ExpectedConditions.textToBePresentInElementLocated(Selectors.popup,updated));
        String actual=driver.findElement(Selectors.popup).getText();
        Assert.assertEquals(actual,updated);
        wait.until(ExpectedConditions.invisibilityOfElementWithText(Selectors.popup,updated));

    }

    //  Test 4: Verify that the last name of an existing employee can be updated --> (passes)
    @Test(dependsOnMethods = "test3")
    public void test4() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.lastname));
        driver.findElement(Selectors.lastname).clear();
        driver.findElement(Selectors.lastname).sendKeys("Nasibova");
        driver.findElement(Selectors.save).click();

        wait.until(ExpectedConditions.textToBePresentInElementLocated(Selectors.popup,updated));
        String actual=driver.findElement(Selectors.popup).getText();
        Assert.assertEquals(actual,updated);
        wait.until(ExpectedConditions.invisibilityOfElementWithText(Selectors.popup,updated));

    }
    //  Test 5: Verify that the document number of an existing employee can be updated --> (passes)
    @Test(dependsOnMethods = "test4")
    public void test5() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.docnumber));
        driver.findElement(Selectors.docnumber).clear();
        driver.findElement(Selectors.docnumber).sendKeys("6897");
        driver.findElement(Selectors.save).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(Selectors.popup,updated));
        String actual=driver.findElement(Selectors.popup).getText();
        Assert.assertEquals(actual,updated);
        wait.until(ExpectedConditions.invisibilityOfElementWithText(Selectors.popup,updated));

    }
    //  Test 6: Verify that (any other data you decided) of an existing employee can be updated --> (passes)
    @Test(dependsOnMethods = "test5")
    public void test6()  {

        driver.findElement(Selectors.employeeID).clear();
        driver.findElement(Selectors.employeeID).sendKeys("3002333");
        driver.findElement(Selectors.save).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(Selectors.popup,updated));
        String actual=driver.findElement(Selectors.popup).getText();
        Assert.assertEquals(actual,updated);
        wait.until(ExpectedConditions.invisibilityOfElementWithText(Selectors.popup,updated));

        driver.findElement(Selectors.delete).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.submit));
        driver.findElement(Selectors.submit).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(Selectors.popup,deleted));
        wait.until(ExpectedConditions.invisibilityOfElementWithText(Selectors.popup,deleted));



    }
    //  Test 7: Verify that an employee with different names but the same Employee ID cannot be created --> (fails!)
    @Test(dependsOnMethods = "test6")
    public void test7()  {

        wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.firstname));
        driver.findElement(Selectors.firstname).sendKeys("Elvin");
        driver.findElement(Selectors.lastname).sendKeys("Mammadov");
        driver.findElement(Selectors.employeeID).sendKeys("123456789"); //this id is belong to the another teacher

        driver.findElement(Selectors.doctype).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.docelement1));
        driver.findElement(Selectors.docelement1).click();
        driver.findElement(Selectors.docnumber).sendKeys("3211");
        driver.findElement(Selectors.save).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(Selectors.popup,created));
        String actual=driver.findElement(Selectors.popup).getText();
        Assert.assertEquals(actual,suchdocument);


    }

    //  Test 8: Verify that an employee with different names but the same Document Number cannot be created --> (passes)
    @Test(dependsOnMethods = "test6")
    public void test8()  {
        wait.until(ExpectedConditions.invisibilityOfElementWithText(Selectors.popup,created));
        driver.findElement(Selectors.delete).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.submit));
        driver.findElement(Selectors.submit).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(Selectors.popup,deleted));
        wait.until(ExpectedConditions.invisibilityOfElementWithText(Selectors.popup,deleted));


        wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.firstname));
        driver.findElement(Selectors.firstname).sendKeys("Jane");
        driver.findElement(Selectors.lastname).sendKeys("Mithchel");
        driver.findElement(Selectors.employeeID).sendKeys("6946435");

        driver.findElement(Selectors.doctype).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.docelement1));
        driver.findElement(Selectors.docelement1).click();
        driver.findElement(Selectors.docnumber).sendKeys("012345678910");  //this document number is belong to the another teacher
        driver.findElement(Selectors.save).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(Selectors.popup,suchdocument));

        String actual=driver.findElement(Selectors.popup).getText();
        Assert.assertEquals(actual,suchdocument);
        wait.until(ExpectedConditions.invisibilityOfElementWithText(Selectors.popup,suchdocument));

    }
    //  Test 9: Verify that an employee with the same First Name and Last Name can be created --> (passes)

    @Test(dependsOnMethods = "test8")
    public void test9()  {

        wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.firstname));
        driver.findElement(Selectors.firstname).clear();
        driver.findElement(Selectors.firstname).sendKeys("Жанар");
        driver.findElement(Selectors.lastname).clear();
        driver.findElement(Selectors.lastname).sendKeys("Бельгибаева");
        driver.findElement(Selectors.employeeID).clear();
        driver.findElement(Selectors.employeeID).sendKeys("6549889");

        driver.findElement(Selectors.doctype).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.docelement2));
        driver.findElement(Selectors.docelement2).click();
        driver.findElement(Selectors.docnumber).clear();
        driver.findElement(Selectors.docnumber).sendKeys("4567");
        driver.findElement(Selectors.save).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(Selectors.popup,created));
        String actual=driver.findElement(Selectors.popup).getText();
        Assert.assertEquals(actual,created);
        wait.until(ExpectedConditions.invisibilityOfElementWithText(Selectors.popup,created));

        driver.findElement(Selectors.delete).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.submit));
        driver.findElement(Selectors.submit).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(Selectors.popup,deleted));
        wait.until(ExpectedConditions.invisibilityOfElementWithText(Selectors.popup,deleted));

    }


    //  Use a data provider to do the Tests 10-15
    @DataProvider(name = "NameFirstnameIdProvider")
    public Object[][] dataProvider1() {
        Object[][] testData = {
                {"","Aliyev","3003222","10001"},
                {"Ece","","3003111","3003"},
                {"Deniz","Ozturk"," ","20002"},

        };
        return testData;
    }

    //  Test 10: Verify that an employee without entering a first name cannot be created --> (passes)
    //  Test 11: Verify that an employee without entering a last name cannot be created --> (passes)
    @Test(dataProvider = "NameFirstnameIdProvider",dependsOnMethods = "test9")
    public void test10_11_12(String DPfastname,String DPlastname,String DPemployeeID, String DPdocumentID) {

        driver.findElement(Selectors.firstname).clear();
        driver.findElement(Selectors.firstname).sendKeys(DPfastname);

        driver.findElement(Selectors.lastname).clear();
        driver.findElement(Selectors.lastname).sendKeys(DPlastname);

        wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.employeeID));
        driver.findElement(Selectors.employeeID).clear();
        driver.findElement(Selectors.employeeID).sendKeys(DPemployeeID);

        driver.findElement(Selectors.doctype).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.docelement1));
        driver.findElement(Selectors.docelement1).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.docnumber));
        driver.findElement(Selectors.docnumber).clear();
        driver.findElement(Selectors.docnumber).sendKeys(DPdocumentID);
        driver.findElement(Selectors.save).click();

        wait.until(ExpectedConditions.textToBePresentInElementLocated(Selectors.popup,invalid));
        String actual=driver.findElement(Selectors.popup).getText();
        wait.until(ExpectedConditions.invisibilityOfElementWithText(Selectors.popup,invalid));
        Assert.assertEquals(actual,invalid);


    }

//  Test 13: Verify that an employee cannot be created if you enter just numerical values for the First Name --> (fails!!!)
//  Test 14: Verify that an employee cannot be created if you enter just special characters like @,!,#, ,%,^,... for the name --> (fails!!!)

    @DataProvider(name = "DifferentValuesforName")
    public Object[][] dataProvider4() {
        return new String[][]{
                {"4565","Alimov","1001222","50003"},
                {"_-_-/","Omerli","1001333","50004"},
                {"Leo","Jolie","abcd","9008"},
        };
    }
    @Test(dataProvider = "DifferentValuesforName",dependsOnMethods = "test10_11_12")
    public void test13_14_15(String DPfname,String DPlastname,String DPemployeeID,String DPdocumentID)  {

        driver.findElement(Selectors.secondplus).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.firstname));
        driver.findElement(Selectors.firstname).clear();
        driver.findElement(Selectors.firstname).sendKeys(DPfname);
        driver.findElement(Selectors.lastname).clear();
        driver.findElement(Selectors.lastname).sendKeys(DPlastname);

        wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.employeeID));
        driver.findElement(Selectors.employeeID).clear();
        driver.findElement((Selectors.employeeID)).sendKeys(DPemployeeID);

        driver.findElement(Selectors.doctype).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.docelement1));
        driver.findElement(Selectors.docelement1).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.docnumber));
        driver.findElement(Selectors.docnumber).clear();
        driver.findElement(Selectors.docnumber).sendKeys(DPdocumentID);
        driver.findElement(Selectors.save).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(Selectors.popup,created));

        String actual = driver.findElement((Selectors.popup)).getText();
        wait.until(ExpectedConditions.invisibilityOfElementWithText(Selectors.popup,created));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.delete));
        driver.findElement(Selectors.delete).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.submit));
        driver.findElement(Selectors.submit).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(Selectors.popup,deleted));
        wait.until(ExpectedConditions.invisibilityOfElementWithText(Selectors.popup,deleted));

        Assert.assertEquals(actual, invalid);

    }

    //  Test 16: Verify that a photo can be uploaded while creating a new employee --> (fails!)
    @Test(dependsOnMethods = "test10_11_12")
    public void test16() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.firstname));
        driver.findElement(Selectors.firstname).sendKeys("Turkana");
        driver.findElement(Selectors.lastname).sendKeys("Mammadova");
        driver.findElement(Selectors.employeeID).sendKeys("3003222");

        driver.findElement(Selectors.doctype).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.docelement1));
        driver.findElement(Selectors.docelement1).click();
        driver.findElement(Selectors.docnumber).sendKeys("3331");
        waitFor(ExpectedConditions.elementToBeClickable(Selectors.photo), "The photo can be uploaded for an existing employee");

    }
    //  Test 17: Verify that a photo can be uploaded for an existing employee --> (passes)
    @Test(dependsOnMethods = "test10_11_12")
    public void test17() throws InterruptedException {

        driver.findElement(Selectors.save).click();
        String path = "C:\\Users\\ememm\\OneDrive\\Рабочий стол\\Turkana M\\materiallar\\idontknow\\ramazan\\yejhjhssss.jpg";
        StringSelection stringSelection = new StringSelection(path);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection,null);
        wait.until(ExpectedConditions.elementToBeClickable(Selectors.photo));
        driver.findElement(Selectors.photo).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.uploadsecond));
        driver.findElement(Selectors.uploadsecond).click();
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.uploadthird));
        driver.findElement(Selectors.uploadthird).click();
        Thread.sleep(1000);
        driver.findElement(Selectors.uploadthird).click();

        wait.until(ExpectedConditions.textToBePresentInElementLocated(Selectors.popup,photoupload));
        String actual = driver.findElement(Selectors.popup).getText();
        wait.until(ExpectedConditions.invisibilityOfElementWithText(Selectors.popup,photoupload));
        Assert.assertEquals(actual, photoupload);

        wait.until(ExpectedConditions.elementToBeClickable(Selectors.closephoto));
        driver.findElement(Selectors.closephoto).click();
        wait.until(ExpectedConditions.elementToBeClickable(Selectors.save));
        driver.findElement(Selectors.save).click();
        wait.until(ExpectedConditions.invisibilityOfElementWithText(Selectors.popup, updated));


    }
    //  Test 18:Verify that the photo of an existing employee can be changed --> (passes)
    @Test(dependsOnMethods = "test17")
    public void test18() throws InterruptedException {
        String path = "C:\\Users\\ememm\\OneDrive\\Рабочий стол\\Turkana M\\materiallar\\idontknow\\ramazan\\664621.jpg";
        StringSelection stringSelection = new StringSelection(path);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection,null);
        wait.until(ExpectedConditions.elementToBeClickable(Selectors.photo));
        driver.findElement(Selectors.photo).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.uploadsecond));
        driver.findElement(Selectors.uploadsecond).click();
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.uploadthird));
        driver.findElement(Selectors.uploadthird).click();

        wait.until(ExpectedConditions.textToBePresentInElementLocated(Selectors.popup, photoupload));
        String actual = driver.findElement(Selectors.popup).getText();
        wait.until(ExpectedConditions.invisibilityOfElementWithText(Selectors.popup, photoupload));
        Assert.assertEquals(actual, photoupload);

    }
    //  Test 19: Verify that the photo of an existing employee can be deleted --> (passes)
//  Close the browser
    @Test(dependsOnMethods = "test18")
    public void test19()  {

        wait.until(ExpectedConditions.elementToBeClickable(Selectors.closephoto));
        driver.findElement(Selectors.closephoto).click();
        wait.until(ExpectedConditions.elementToBeClickable(Selectors.save));
        driver.findElement(Selectors.save).click();
        wait.until(ExpectedConditions.invisibilityOfElementWithText(Selectors.popup,updated));

        wait.until(ExpectedConditions.elementToBeClickable(Selectors.photo));
        driver.findElement(Selectors.photo).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.deletephoto));
        driver.findElement(Selectors.deletephoto).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.submit));
        driver.findElement(Selectors.submit).click();
        wait.until(ExpectedConditions.elementToBeClickable(Selectors.closephoto));
        driver.findElement(Selectors.closephoto).click();

        wait.until(ExpectedConditions.elementToBeClickable(Selectors.save));
        driver.findElement(Selectors.save).click();

        wait.until(ExpectedConditions.textToBePresentInElementLocated(Selectors.popup, updated));
        String actual=driver.findElement(Selectors.popup).getText();
        Assert.assertEquals(actual,updated);
        wait.until(ExpectedConditions.invisibilityOfElementWithText(Selectors.popup,updated));

        wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.delete));
        driver.findElement(Selectors.delete).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Selectors.submit));
        driver.findElement(Selectors.submit).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(Selectors.popup,deleted));
        driver.quit();
    }


    private <T> void waitFor(ExpectedCondition<T> condition) {
        waitFor(condition, condition.toString());
    }

    private <T> void waitFor(ExpectedCondition<T> condition, String errorMessage) {
        try {
            wait.until(condition);
        } catch (TimeoutException e) {
            Assert.fail(errorMessage);
        }
    }

}
