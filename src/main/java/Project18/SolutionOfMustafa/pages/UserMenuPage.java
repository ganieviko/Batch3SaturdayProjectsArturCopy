package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class UserMenuPage extends BasePage implements Page {
    private HashMap<String, WebElement> map = new HashMap<>();
    public UserMenuPage() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "ul.sidebar-menu > li")
    public List<WebElement> menuBar;

    @Override
    public void initMap() {
    // no need to put any values to the map, since we are working with only one list of web-element.
    }



    // ===========================All methods to be listed here ======================
    //this method can be used only to handle for list of web-elements click function;
    @Override
    public void findElementAndClickFunction(String element) {
        //Getting the webElement for the menuBar List by String element parameter
        WebElement webElement = menuBar.stream().filter(a -> a.getText().contains(element)).findFirst().orElse(null);
        if(webElement==null){
            throw new RuntimeException("Element not found " + element);
        }
        clickFunction(webElement);
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

}
