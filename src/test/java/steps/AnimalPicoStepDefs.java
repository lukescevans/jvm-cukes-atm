package steps;

import cucumber.api.java.en.When;
import support.model.AnimalModel;

import java.util.List;

public class AnimalPicoStepDefs {
    List<AnimalModel> animalsList;

    public AnimalPicoStepDefs(AnimalStepDefs animalStepDefs) {
        animalsList = animalStepDefs.animalsList;
        System.out.println("blah");
    }

    @When("^I share the details with Pico$")
    public void I_share_the_details_with_Pico() throws Throwable {
        for (AnimalModel luke : this.animalsList) {
            System.out.println(luke.getName());
        }
    }
}
