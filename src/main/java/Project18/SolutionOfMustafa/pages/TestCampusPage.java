package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;

public class TestCampusPage extends BasePage implements Page {
    private HashMap<String, WebElement> map = new HashMap<>();
    public TestCampusPage() {
        PageFactory.initElements(driver, this);
        initMap();
    }
    @FindBy(css = "input[formcontrolname = 'username']")
    private WebElement username;

    @FindBy(css = "input[formcontrolname = 'password']")
    private WebElement password;

    @FindBy(xpath = "//span[text()=' LOGIN ']")
    private WebElement LoginButton;

    @FindBy(xpath = "//h3[text()='  Dashboard ']")
    private WebElement Dashboard;

    @FindBy(id = "toast-container")
    private WebElement ErrorElement;

    public void initMap(){

        map.put("username",username);
        map.put("password",password);
        map.put("LoginButton",LoginButton);
        map.put("Dashboard",Dashboard);
        map.put("ErrorElement",ErrorElement);

    }


    // ===========================All methods to be listed here ======================
    @Override
    public void findElementAndClickFunction(String element)
    {
        clickFunction(getWebElement(map, element));
    }

    @Override
    public void findElementAndSendKeysFunction(String element, String text)
    {
        sendKeysFunction(getWebElement(map,element), text);
    }

    @Override
    public void selectFromDropDownByRandomIndex(String element)
    {
        selectDropDown(getWebElement(map,element));

    }

    @Override
    public void selectFromDropDownByName(String nameToSelect, String element)
    {
        selectDropDown(nameToSelect, getWebElement(map,element));
    }

    @Override
    public void alertByWebElement(String webElement, String expectedText) {
        AssertionByWebElement(getWebElement(map,webElement),expectedText);
    }

}
