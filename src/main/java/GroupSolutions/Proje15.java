package GroupSolutions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Proje15 {
    public static void main(String[] args) {

        // Navigate to https://test.campus.techno.study/
        System.setProperty("webdriver.chrome.driver", MyConstants.DRIVER_PATH);
        WebDriver driver = new ChromeDriver();
        driver.get("https://test.campus.techno.study/");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 20);

        // Dismiss the cookie message by clicking on "Got it!" button
        driver.findElement(By.cssSelector("a[aria-label=\"dismiss cookie message\"]")).click();

        // Login by the credentials (username = "daulet2030@gmail.com" and password = "TechnoStudy123@")
        driver.findElement(By.cssSelector("input[data-placeholder=\"Username\"]")).sendKeys("daulet2030@gmail.com");
        driver.findElement(By.cssSelector("input[data-placeholder=\"Password\"]")).sendKeys("TechnoStudy123@");
        driver.findElement(By.cssSelector("button[aria-label=\"LOGIN\"]")).click();


        // Click on Setup in the left menu
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".group-items > :nth-child(1)")));
        driver.findElement(By.cssSelector(".group-items > :nth-child(1)")).click();


        // Click on School Setup
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(" .group-items > :nth-child(1)>div>:nth-child(2) >a>span")));
        driver.findElement(By.cssSelector(".group-items > :nth-child(1)>div>:nth-child(2) >a>span")).click();


        // Click on Departments
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text() = 'Departments']")));
        driver.findElement(By.xpath("//*[text() = 'Departments']")).click();


        // Click on "+" button to add a school department
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("ms-add-button svg")));
        driver.findElement(By.cssSelector("ms-add-button svg")).click();


        // On the pop-up window, type "High School" for the name of the department and "HS-1" for the code.
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[placeholder='GENERAL.FIELD.NAME']>input")));
        driver.findElement(By.cssSelector("[placeholder='GENERAL.FIELD.NAME']>input")).sendKeys("High School");
        driver.findElement(By.cssSelector("[placeholder='GENERAL.FIELD.CODE'] > input")).sendKeys("HS-1");


        // Click on "Section" tab
        driver.findElement(By.cssSelector(" #mat-tab-label-0-1>div")).click();


        // Click on "+" button to ad a new section.
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("school-department-section svg[data-icon=\"plus\"]")));
        driver.findElement(By.cssSelector("school-department-section svg[data-icon=\"plus\"]")).click();


        // Type "Junior Classes" for the name of the section and "Juniors" for the short name and click on "Add" button to create the section.
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("mat-form-field:nth-child(1) input")));
        driver.findElement(By.cssSelector("mat-form-field:nth-child(1) input")).sendKeys("Junior Classes");
        driver.findElement(By.cssSelector("mat-form-field:nth-child(2) input")).sendKeys("Juniors");
        driver.findElement(By.cssSelector("ms-button>button")).click();


        // Create another section with the name "Senior Classes" and the short name "Seniors" similarly.
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("school-department-section svg[data-icon=\"plus\"]")));
        driver.findElement(By.cssSelector("school-department-section svg[data-icon=\"plus\"]")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("mat-form-field:nth-child(1) input")));
        driver.findElement(By.cssSelector("mat-form-field:nth-child(1) input")).sendKeys("Senior Classes");
        driver.findElement(By.cssSelector("mat-form-field:nth-child(2) input")).sendKeys("Seniors");
        driver.findElement(By.cssSelector("ms-button>button")).click();


        // Click on "Save" for creating the school department.
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text() = 'Save']")));
        driver.findElement(By.xpath("//*[text() = 'Save']")).click();


        // Verify if the department with the name "High School" created. It should write "School Department successfully created." on the console.
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("toast-container"),"School Department successfully created"));
        String output=driver.findElement(By.id("toast-container")).getText();
        if (output.equals("School Department successfully created")){
            System.out.println("New department created");
        }else {
            System.out.println("New departmet dont created ");
        }

        // Click on "+" button to add a school department AGAIN
        driver.findElement(By.cssSelector("ms-add-button svg")).click();

        // On the pop-up window, type "High School" for the name of the department and "HS-1" for the code AGAIN
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("[placeholder='GENERAL.FIELD.NAME']>input")).sendKeys("High School");
        driver.findElement(By.cssSelector("[placeholder='GENERAL.FIELD.CODE'] > input")).sendKeys("HS-1");

        // Click on "Save" for TRYING to create a school department with the same name.
        driver.findElement(By.xpath("//*[text() = 'Save']")).click();

        // Verify that a dialog box occurs with a message "There is already Department with "High School" name!". It should write the message of the dialog box on the console.
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("toast-container"),"There is already Department with \"High School\" name!"));
        String nameoutput=driver.findElement(By.id("toast-container")).getText();
        if (nameoutput.contains("There is already Department with \"High School\" name!")){
            System.out.println("There is already Department with \"High School\" name!");
        }else {
            System.out.println("New departmet created successfully");
        }


        // Click on "x" to dismiss the pop-up window.
        driver.findElement(By.cssSelector("mat-toolbar-row >:nth-child(4)")).click();


        // Click on edit button (or the row) of the "High School" department to edit it.
        driver.findElement(By.cssSelector("tbody>tr:nth-child(1) ms-edit-button")).click();


        // Edit the school department name as "High School Classes" and department code as "HSC-1" and click on "Save"
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[placeholder='GENERAL.FIELD.NAME']>input")));
        driver.findElement(By.cssSelector("[placeholder='GENERAL.FIELD.NAME']>input")).clear();
        driver.findElement(By.cssSelector("[placeholder='GENERAL.FIELD.NAME']>input")).sendKeys("High School Classes");
        driver.findElement(By.cssSelector("[placeholder='GENERAL.FIELD.CODE'] > input")).clear();
        driver.findElement(By.cssSelector("[placeholder='GENERAL.FIELD.CODE'] > input")).sendKeys("HSC-1");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text() = 'Save']")));
        driver.findElement(By.xpath("//*[text() = 'Save']")).click();

        // Verify if the department name was edited as "High School Classes" and department code was edited as "HSC-1"
        // It should write "School Department name successfully edited." on the console.
        // And it should write "School Department code successfully edited." on the console.

        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("toast-container"),"School Department successfully updated"));
        String error=driver.findElement(By.id("toast-container")).getText();
        if (error.contains("School Department successfully updated")){
            System.out.println("New department updated");
        }else {
            System.out.println("New departmet did not updated ");
        }

        // Click on corresponding trash icon
        driver.findElement(By.cssSelector("tbody>tr:nth-child(1) ms-delete-button")).click();

        // Click on "Yes" for deleting the school department.
        driver.findElement(By.xpath("//*[text()=' Yes ']")).click();

        // Verify the department is deleted. (it should not be present in the table anymore)
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("toast-container"),"School Department successfully deleted"));
        String delete=driver.findElement(By.id("toast-container")).getText();
        if (delete.contains("School Department successfully deleted")){
            System.out.println("New department deleted");
        }else {
            System.out.println("New departmet did not deleted ");
        }


        // Close the browser
        driver.quit();

    }
}
