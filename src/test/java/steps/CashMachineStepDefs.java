package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import support.AtmHelper;
import support.model.AtmModel;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CashMachineStepDefs {
    int withdrawalAmount;
    AtmModel atmModel;
    AtmHelper atmHelper = new AtmHelper();

    @When("^I request \\$(\\d+)$")
    public void I_request_$(int withdrawalAmount) throws Throwable {
        //Set amount requested
        this.withdrawalAmount = withdrawalAmount;

        //set the balance on the atm model
        this.atmModel = atmHelper.makeWithdrawal(this.atmModel, withdrawalAmount);
    }

    @Then("^\\$(\\d+) should be dispensed$")
    public void $_should_be_dispensed(int cashDispensed) throws Throwable {
        assertThat("Amount dispensed is incorrect", cashDispensed, is(this.withdrawalAmount));
    }

    @Given("^I have \\$(\\d+) in my account$")
    public void I_have_$_in_my_account(int bankBalance) throws Throwable {
        this.atmModel.setBalance(bankBalance);
    }

    @And("^the Balance should be (-*[\\$]\\d+)$")
    public void the_Balance_should_be_$(String accountBalance) throws Throwable {
        //Strip $ char
        accountBalance = accountBalance.replace("$", "");
        assertThat("Balance is incorrect", atmModel.getBalance(), is(Integer.valueOf(accountBalance)));
    }

    @Given("^I have deposited \\$(\\d+) in my Account$")
    public void I_have_deposited_$_in_my_Account(int depositedAmount) throws Throwable {
        //Create instance of ATM model
        this.atmModel = new AtmModel(depositedAmount);
        System.out.println("Account balance: " + atmModel.getBalance());
    }

    @Then("^the balance of my Account should be \\$(\\d+)$")
    public void the_balance_of_my_Account_should_be_$(int expectedBalance) throws Throwable {
        int atmBalance = this.atmModel.getBalance();
        assertThat("Balance is incorrect", atmBalance, is(expectedBalance));
    }

    @Given("^I deposit \\$(\\d+) in my Account$")
    public void I_have_deposit_$_in_my_Account(int depositAmount) throws Throwable {
        if (atmModel == null) {
            this.atmModel = new AtmModel(depositAmount);
        }

        //Deposit
        this.atmModel = this.atmHelper.makeDeposit(this.atmModel, depositAmount);
    }

    @And("^the last transaction should be \"([^\"]*)\"$")
    public void the_last_transaction_should_be(String transactionType) throws Throwable {
        final int size = this.atmModel.thm.size();

        assertThat("Last transaction type incorrect", transactionType.toLowerCase(), is(atmModel.thm.get(size - 1).getTransType().toString().toLowerCase()));
    }

    @Then("^a \"([^\"]*)\" transaction should be created$")
    public void a_transaction_should_be_created(String transactionType) throws Throwable {
        if (transactionType.equalsIgnoreCase("balance enquiry")) {
            transactionType = "balance_enquiry";
        }

        //Get total number of txns from the atm model
        final int size = this.atmModel.thm.size();

        assertThat("Transaction type is incorrect", transactionType.toLowerCase(), is(atmModel.thm.get(size - 1).getTransType().toString().toLowerCase()));
    }

    @When("^I request my Balance$")
    public void I_request_my_Balance() throws Throwable {
        this.atmHelper.balanceEnquiry(this.atmModel);
    }

    @Given("^I enter my Pin correctly$")
    public void I_enter_my_Pin_correctly() throws Throwable {
        String pin = this.atmHelper.getRandomPin(6);
        this.atmModel.setPin(Integer.valueOf(pin));
        this.atmModel.setPinAttemptsLeft(3);
        this.atmModel.setCardBlocked(false);
    }

    @And("^I should have \"([^\"]*)\" Pin attempts remaining$")
    public void I_should_have_Pin_attempts_remaining(int pinAttemptsLeft) throws Throwable {
        assertThat("Pin attempts incorrect", this.atmModel.getPinAttemptsLeft(), is(pinAttemptsLeft));
    }

    @Given("^I enter my Pin incorrectly \"([^\"]*)\" times$")
    public void I_enter_my_Pin_incorrectly_times(int pinAttempts) throws Throwable {
        this.atmModel.setPinAttemptsLeft(3 - pinAttempts);
    }

    @And("^my card should be blocked$")
    public void my_card_should_be_blocked() throws Throwable {
        if (this.atmModel.getPinAttemptsLeft() == 0) {
            this.atmModel.setCardBlocked(true);
        }
        else {this.atmModel.setCardBlocked(false);}

        assertThat("Pin is not blocked", this.atmModel.getCardBlocked(), is(true));
    }

    @And("^my card should not be blocked$")
    public void my_card_should_not_be_blocked() throws Throwable {
        if (this.atmModel.getPinAttemptsLeft() <= 0) {
            this.atmModel.setCardBlocked(true);
        }
        else {this.atmModel.setCardBlocked(false);}

        assertThat("Pin is blocked", this.atmModel.getCardBlocked(), is(false));
    }

    @Then("^the request should not be fulfilled$")
    public void the_request_should_not_be_fulfilled() throws Throwable {
        // Express the Regexp above with the code you wish you had
        assertThat(this.atmModel.getCardBlocked(), is(true));
    }

    @Given("^the balance of my Account is \\$(\\d+)$")
    public void the_balance_of_my_Account_is(int depositAmount) throws Throwable {
        if (atmModel == null) {
            this.atmModel = new AtmModel(depositAmount);
        }
    }
}