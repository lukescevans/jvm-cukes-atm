package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import support.Belly;

public class EatCukesStepDefs {
    Belly belly;
    private int cukesEaten, duration;

    @Given("^I have (\\d+) cukes in my belly$")
    public void I_have_cukes_in_my_belly(int cukes) throws Throwable {
        belly = new Belly();
        belly.eat(cukes);
        this.cukesEaten = cukes;
    }

    @When("^I wait (\\d+) (hour|hours)$")
    public void I_wait_hour(int hours) throws Throwable {
        belly = new Belly();
        belly.waitSomeTime(hours);

        duration = hours;
    }

    @Then("^my belly should growl$")
    public void my_belly_should_growl() throws Throwable {
        System.out.println("Grrrrr, I just ate " + cukesEaten + " CUKES in " + this.duration + " HOURS");
    }
}
