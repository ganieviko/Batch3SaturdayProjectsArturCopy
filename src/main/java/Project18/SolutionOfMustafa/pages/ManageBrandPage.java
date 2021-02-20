package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;

public class ManageBrandPage extends BasePage implements Page {
    private HashMap<String, WebElement> map = new HashMap<>();
    public ManageBrandPage() {
        PageFactory.initElements(driver, this);
        initMap();
    }

    @FindBy(name="company_id")
    public WebElement CompanyIdDropdown;

    @FindBy(name="brand_image")
    public WebElement BrandImageInput;

    @FindBy(name="brand_mission")
    public WebElement BrandMissionInput;

    @FindBy(name="brand_profile_information")
    public WebElement BrandProfileInfoInput;

    @FindBy(name="brand_name")
    public WebElement BrandNameInput;

    @FindBy(name="brand_tagline")
    public WebElement BrandTaglineInput;

    @FindBy(name="brand_website")
    public WebElement BrandWebsiteInput;

    @FindBy(name="public_visibility")
    public WebElement PublicVisibilityDropdown;

    @FindBy(name="submit")
    public WebElement SubmitButton;

    @FindBy(xpath="//a[text()='Edit']")
    public WebElement EditButton;







    @Override
    public void initMap() {
        map.put("SubmitButton", SubmitButton);
        map.put("BrandImageInput", BrandImageInput);
        map.put("BrandMissionInput", BrandMissionInput);
        map.put("BrandProfileInfoInput", BrandProfileInfoInput);
        map.put("BrandNameInput", BrandNameInput);
        map.put("BrandWebsiteInput", BrandWebsiteInput);
        map.put("BrandTaglineInput", BrandTaglineInput);
        map.put("CompanyIdDropdown", CompanyIdDropdown);
        map.put("PublicVisibilityDropdown", PublicVisibilityDropdown);
        map.put("EditButton", EditButton);

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
