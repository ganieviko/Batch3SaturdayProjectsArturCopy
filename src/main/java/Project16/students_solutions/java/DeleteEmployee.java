package Project16.students_solutions.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DeleteEmployee {
    WebDriver driver;
    WebDriverWait wait;

    public DeleteEmployee(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }


    /*
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ms-delete-button[class='ng-star-inserted'] button svg"))).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(""))).click();
         */
    public /*static*/ By enterDeleteButton = By.xpath("//table/tbody/tr[1]/td[7]//ms-delete-button/button");
    public /*static*/ By enterYesForDelete = By.cssSelector("app-simple-dialog > mat-dialog-actions > div > div > button:first-child>span:first-child");
    public void delete(){
        Actions action = new Actions(driver);
//        WebElement deleteEmployeeButton =
                wait.until(ExpectedConditions.elementToBeClickable(enterDeleteButton)).click();
//        deleteEmployeeButton;
        WebElement enterYesForDeleteButton =wait.until(ExpectedConditions.elementToBeClickable(enterYesForDelete));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        action.click(enterYesForDeleteButton);
//        enterYesForDeleteButton.click();

//
    }
}
