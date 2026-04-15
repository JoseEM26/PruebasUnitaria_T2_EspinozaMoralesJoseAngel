package edu.pe.cibertec.stepdefinitions;

import edu.pe.cibertec.screenplay.questions.ResultadosDeBusqueda;
import edu.pe.cibertec.screenplay.tasks.BuscarProducto;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.Matchers.containsString;

public class BusquedaStepDefinitions {

    @Given("the user is on the OpenCart home page")
    public void theUserIsOnTheOpenCartHomePage() {
        OnStage.theActorCalled("Jose").wasAbleTo(
                Open.url("https://naveenautomationlabs.com/opencart/"));
    }

    @When("the user searches for the product {string}")
    public void theUserSearchesForTheProduct(String productName) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                BuscarProducto.conNombre(productName));
    }

    @Then("the user should see at least one result with the name {string}")
    public void theUserShouldSeeAtLeastOneResultWithTheName(String expectedName) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ResultadosDeBusqueda.nombres(), hasItem(containsString(expectedName))));
    }
}
