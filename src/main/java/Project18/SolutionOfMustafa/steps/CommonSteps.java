package steps;


import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.BaseClass;

import java.util.List;

public class CommonSteps extends BaseClass {

    @When("User sends the keys in {string}")
    public void user_sends_the_keys(String page, DataTable dataTable) {
        List<List<String>> AllElementsNameAndValue= dataTable.asLists(String.class);

        for(int i =0 ; i <AllElementsNameAndValue.size() ; i++){

            System.out.println(AllElementsNameAndValue.get(i).get(0));
            System.out.println(AllElementsNameAndValue.get(i).get(1));

            getPage(page).findElementAndSendKeysFunction(AllElementsNameAndValue.get(i).get(0) ,AllElementsNameAndValue.get(i).get(1));

        }
    }


    @And("User clicks on {string}")
    public void userClicksOn(String page, DataTable dataTable) {
        List<String> allElements = dataTable.asList(String.class);

        for (int i = 0; i < allElements.size(); i++) {
            getPage(page).findElementAndClickFunction(allElements.get(i));
        }
    }


    @And("User selects {string} in the drop-down in {string}")
    public void selectInTheDropDownIn(String valueToBeSelected, String page, DataTable dataTable) {
        List<String> allElements = dataTable.asList(String.class);

        for (int i = 0; i < allElements.size(); i++) {
            getPage(page).selectFromDropDownByName(valueToBeSelected, allElements.get(i));
        }
    }


    @And("User randomly selects option in the drop-down in {string}")
    public void userRandomlySelectsOptionInTheDropDownIn(String page, DataTable dataTable) {
        List<String> allElements = dataTable.asList(String.class);

        for (int i = 0; i < allElements.size(); i++) {
            getPage(page).selectFromDropDownByRandomIndex(allElements.get(i));
        }
    }


    @Then("Verify message is {string} in {string}")
    public void verifyMessageIsIn(String expectedMessage, String page, DataTable dataTable) {
        List<String> allElements = dataTable.asList(String.class);

        for (int i = 0; i < allElements.size(); i++) {

            getPage(page).alertByWebElement(allElements.get(i),expectedMessage);
        }

    }}
