package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BaseClass;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.HashMap;

public class ManageCompanyPage extends BasePage implements Page {
    private HashMap<String, WebElement> map = new HashMap<>();
    public ManageCompanyPage() {
        PageFactory.initElements(driver, this);
        initMap();
    }

    @FindBy(name = "company_name")
    public WebElement CompanyName;

    @FindBy(name = "company_tagline")
    public WebElement CompanyTagline;

    @FindBy(name = "company_website")
    public WebElement CompanyWebsite;

    @FindBy(name = "company_profile_information")
    public WebElement CompanyProfileInformation;

    @FindBy(name = "company_image")
    public WebElement CompanyImage;

    @FindBy(name = "company_mission")
    public WebElement CompanyMission;

    @FindBy(name = "company_registration_no")
    public WebElement CompanyRegistrationNo;

    @FindBy(name = "public_visibility")
    public WebElement VisibilityDropDown;

    @FindBy(name = "submit")
    public WebElement SaveButton;

    @FindBy(xpath = "//input[@type='search']")
    public WebElement SearchInputField;

    @FindBy(linkText = "Delete")
    public WebElement DeleteButton;

    @FindBy(linkText = "Details")
    public WebElement DetailsButton;

    @Override
    public void initMap() {
        map.put("CompanyImage", CompanyImage);
        map.put("SaveButton", SaveButton);
        map.put("DeleteButton", DeleteButton);
        map.put("DetailsButton", DetailsButton);
        map.put("CompanyName", CompanyName);
        map.put("CompanyTagline", CompanyTagline);
        map.put("CompanyWebsite", CompanyWebsite);
        map.put("CompanyProfileInformation", CompanyProfileInformation);
        map.put("CompanyMission", CompanyMission);
        map.put("CompanyRegistrationNo", CompanyRegistrationNo);
        map.put("SearchInputField", SearchInputField);
        map.put("VisibilityDropDown", VisibilityDropDown);
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

}
