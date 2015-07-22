package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BankStepDefs {


    @Given("I have deposited \\$(\\d+) in my (\\w+) Account")
    public void iHaveDeposited$InMyAccount(int amount, String accountType) {
        // TODO: code goes here
    }

    @When("^I transfer \\$(\\d+) from my Savings Account into my (\\w+) Account$")
    public void I_transfer_$_from_my_Savings_Account_into_my_Checking_Account(int amount, String accountType) throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }
}
