package Project16.students_solutions;
import org.openqa.selenium.By;

public class Selectors {
    public static By cookie = By.cssSelector("a[aria-label=\"dismiss cookie message\"]");
    public static By username = By.cssSelector("input[data-placeholder=\"Username\"]");
    public static By password = By.cssSelector("input[data-placeholder=\"Password\"]");
    public static By loginbutton = By.cssSelector("button[aria-label=\"LOGIN\"]");
    public static By firstname = By.cssSelector("ms-text-field[formcontrolname='firstName']>input");
    public static By lastname = By.cssSelector("ms-text-field[formcontrolname=\"lastName\"]>input");
    public static By employeeID =By.cssSelector("input[formcontrolname=\"employeeId\"]");
    public static By doctype =By.cssSelector("mat-card >div:nth-child(2)>:nth-child(1)");
    public static By docelement1 =By.cssSelector("mat-option:nth-child(1)");
    public static By docelement2 =By.cssSelector("mat-option:nth-child(2)");
    public static By docelement3 =By.cssSelector("mat-option:nth-child(3)");
    public static By docnumber =By.cssSelector("input[formcontrolname=\"documentNumber\"]");
    public static By save =By.cssSelector("ms-save-button > button");
    public static By contract =By.xpath("//*[text()='Contracts']");
    public static By contractplus =By.cssSelector("ms-table-toolbar  svg[data-icon=\"plus\"]");
    public static By popup =By.id("toast-container");

    public static By photo =By.cssSelector(" div > div > div:nth-child(2) > button:nth-child(2)");
    public static By uploadsecond =By.cssSelector("svg[data-icon=\"upload\"]");
    public static By uploadthird =By.cssSelector(" mat-file-upload-queue button:nth-child(1)");
    public static By closephoto =By.cssSelector("mat-dialog-actions > div:nth-child(2) > button");
    public static By deletephoto =By.cssSelector("mat-dialog-actions > div:nth-child(1) > button");

    public static By submit =By.cssSelector("button[type='submit']");
    public static By delete =By.cssSelector("ms-delete-button > button");
    public static By secondplus =By.cssSelector("ms-button[icon=\"plus\"]>button");
    public static By firstplus =By.cssSelector("ms-table-toolbar ms-add-button");
    public static By employeemenu =By.cssSelector(".group-items > :nth-child(5)>div>:nth-child(2) >a>span");
    public static By humanresmenu =By.cssSelector(".group-items > :nth-child(5)");

}
