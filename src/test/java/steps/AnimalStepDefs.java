package steps;

import cucumber.api.java.en.Given;
import support.model.AnimalModel;

import java.util.List;

public class AnimalStepDefs {
    List<AnimalModel> animalsList;

    @Given("^I have some animals")
    public void I_have_some_animals(List<AnimalModel> animals) throws Throwable {
        System.out.println("asdf");

        animalsList = animals;

        for (AnimalModel a : animalsList) {
            System.out.println(a.getName() + "|" + a.getType());
        }

        System.out.println("done");
    }
}
