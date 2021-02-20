package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;

public class DemoPage extends BasePage implements Page {
    private HashMap<String, WebElement> map = new HashMap<>();
    public DemoPage() {
        PageFactory.initElements(driver, this);
        initMap();
    }

    @FindBy(xpath ="//a[text()=\"3. Add a User\"]")
    private WebElement addUserButton;

    @FindBy(xpath ="//a[text()='4. Login']")
    private WebElement LoginButton;

    @FindBy(name = "username")
    private WebElement username;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(css = "input[type=\"button\"]")
    private WebElement saveButton;

    @FindBy(css = "input[value=\"Test Login\"]")
    private WebElement TestLoginButton;

    @FindBy(css = "center>b")
    private WebElement message;





    public void initMap(){
        map.put("addUserButton", addUserButton);
        map.put("username", username);
        map.put("password", password);
        map.put("saveButton", saveButton);
        map.put("TestLoginButton", TestLoginButton);
        map.put("LoginButton", LoginButton);
        map.put("message", message);
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
