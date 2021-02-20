package pages;

public interface Page {


    void findElementAndSendKeysFunction(String element, String text) ;

    void findElementAndClickFunction(String element);

    void initMap();

    void selectFromDropDownByRandomIndex(String element);

    void selectFromDropDownByName(String nameToSelect, String element);

    void alertByWebElement(String webElement, String expectedText);

}
