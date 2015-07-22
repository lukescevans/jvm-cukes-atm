//package steps;
//
//import cucumber.api.PendingException;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//
///**
// * Created by luke.evans on 14/07/15.
// */
//public class RentStepDefs {
//    private CarDAO carDatabase;
//
//    @Given("^there are (\\d+) cars available for rental$")
//    public void there_are_cars_available_for_rental(int availableCars) throws Throwable {
//        carDatabase = new InMemoryCarDAO();
//        for (int i = 0; i < availableCars; i++) {
//            Car car = new Car();
//            carDatabase.add(car);
//        }
//    }
//
//    @When("^I rent one$")
//    public void rent_one_car() throws Throwable {
//        Car car = carDatabase.findAvailableCar();
//        car.rent();
//    }
//
//    @Then("^there will only be (\\d+) cars available for rental$")
//    public void there_will_be_less_cars_available_for_rental(int expectedAvailableCars) throws Throwable {
//        int actualAvailableCars = carDatabase.getNumberOfAvailableCars();
//        assertThat(actualAvailableCars, is(expectedAvailableCars));
//    }
//}
