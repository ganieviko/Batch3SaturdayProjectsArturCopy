package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.bouncycastle.jcajce.provider.symmetric.ARC4;
import org.testng.Assert;
import pages.BasePage;
import utils.BaseClass;

import java.util.List;

public class TestCaseAssertions extends BaseClass {


    @Then("Verify alert is {string}")
    public void verifyAlertIs(String result) {
        BasePage basePage = new BasePage();
        basePage.AssertionByUsingAlert(result);
    }
}

