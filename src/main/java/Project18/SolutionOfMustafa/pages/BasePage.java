package pages;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.BaseClass;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage() {
        this.driver = BaseClass.setUp();
        wait = new WebDriverWait(driver,15);
    }

    // Getting webElement from the Map. To be used in the PageObjectClasses
    public WebElement getWebElement(HashMap<String, WebElement> map, String mapKey){
        if(!map.containsKey(mapKey)){
            throw new RuntimeException("Element not found " + mapKey);
        }
        return map.get(mapKey);
    }

    //    Click on element method
    protected void clickFunction(WebElement element){
        waitUntilClickable(element);
        scrollToElement(element);
        element.click();

    }

    //    Send keys function
    protected void sendKeysFunction(WebElement element , String value){

        try{
            waitUntilVisible(element);
            scrollToElement(element);
            element.clear();
            element.sendKeys(value);
        }catch (IllegalArgumentException e){
            System.out.println("Element can not be empty");
        }


    }

    //    Waiting until element become visible
    protected void waitUntilVisible(WebElement elementToWait){

        wait.until(ExpectedConditions.visibilityOf(elementToWait));

    }


    //    WaitForClickable
    protected void waitUntilClickable(WebElement elmentToWait){

//        wait until clickable is working as if the element is not visible
        wait.until(ExpectedConditions.elementToBeClickable(elmentToWait));
    }

    //  Verify element is contains specific text
    protected void ElementContainsText(WebElement element , String myText){

        waitUntilVisible(element);
        Assert.assertTrue(element.getText().contains(myText));
    }

    // Thread sleep waiter method
    public void waiting(int howLong){
        try {
            Thread.sleep(howLong);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Scroll to Webelement method
    protected void scrollToElement(WebElement elementToScroll){
//        JavascriptExecutor js = ((JavascriptExecutor) driver);
//        js.executeScript("arguments[0].scrollIntoView();", elementToScroll);

        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true);", elementToScroll);

    }

    //Hover over and click method
    protected void moveToElementAndClick(WebElement element){
        Actions actions = new Actions(BaseClass.setUp());
        scrollToElement(element);
        actions.moveToElement(element).click().perform();
    }

    // Uploading file method using Robot class
    public void uploadFile(String pathToFile){

        Robot robot = null;
        try {
            robot = new Robot();

        StringSelection stringSelection = new StringSelection(pathToFile);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection,null);
        waiting(500);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        waiting(500);
        robot.keyPress(KeyEvent.VK_ENTER);

        } catch (AWTException e) {
            e.printStackTrace();
        }
    }


    public void selectDropDown(WebElement element) {
        Select select = new Select(element);
        int selectionSize = select.getOptions().size();
        System.out.println("selectionSize = " + selectionSize);
        Random random = new Random();
        int randomIndex = random.nextInt(selectionSize);
        System.out.println("randomIndex = " + randomIndex);
        select.selectByIndex(randomIndex);
        waiting(2000);
    }

    public void selectDropDown(String name, WebElement element) {
        waitUntilVisible(element);
        Select select = new Select(element);
        select.selectByVisibleText(name);

    }

    public void AssertionByUsingAlert(String result) {
        String Alertext="";

        try {
            Alertext = driver.switchTo().alert().getText();
            driver.switchTo().alert().accept();
        }  catch(Exception e){
            System.out.println(e.getMessage());
        }

        Assert.assertEquals(result,Alertext);
    }

    public void AssertionByWebElement(WebElement element, String expectedMessage) {

        String ActualMessage = "";

        try {
            waitUntilVisible(element);
            ActualMessage= element.getText();
        }catch (Exception e){
          ActualMessage = "Keys to send should be a not null";
        }

        System.out.println(ActualMessage + "-Actual Message");
        System.out.println(expectedMessage + "-Expected Message");
        Assert.assertTrue(ActualMessage.contains(expectedMessage));
    }
}



