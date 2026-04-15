package edu.pe.cibertec.stepdefinitions;

import edu.pe.cibertec.screenplay.questions.ContadorDelCarrito;
import edu.pe.cibertec.screenplay.tasks.AgregarAlCarrito;
import edu.pe.cibertec.screenplay.ui.CarritoPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.containsText;
import static net.serenitybdd.screenplay.questions.Text.ofEach;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.hasItem;

public class CarritoStepDefinitions {

    @When("the user adds the product {string} to the cart")
    public void theUserAddsTheProductToTheCart(String product) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                AgregarAlCarrito.elProducto(product));
    }

    @Then("the cart should show {string}")
    public void theCartShouldShow(String expectedCount) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(CarritoPage.CART_TOTAL, containsText(expectedCount)).forNoMoreThan(5).seconds());

        OnStage.theActorInTheSpotlight().should(
                seeThat(ContadorDelCarrito.valor(), containsString(expectedCount)));
    }

    @And("navigates to the cart")
    public void navigatesToTheCart() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(CarritoPage.VIEW_CART_LINK));
    }

    @Then("the user should see the product {string} in the cart list")
    public void theUserShouldSeeTheProductInTheCartList(String expectedProduct) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(actor -> ofEach(CarritoPage.CART_PRODUCT_NAMES).answeredBy(actor),
                        hasItem(containsString(expectedProduct))));
    }
}
