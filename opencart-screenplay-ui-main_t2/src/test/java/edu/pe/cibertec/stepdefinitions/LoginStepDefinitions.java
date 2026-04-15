package edu.pe.cibertec.stepdefinitions;

import edu.pe.cibertec.screenplay.tasks.IniciarSesionComo;
import edu.pe.cibertec.screenplay.ui.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.questions.Text;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.containsString;

public class LoginStepDefinitions {

    @Given("the user navigates to the login page")
    public void theUserNavigatesToTheLoginPage() {
        OnStage.theActorCalled("Jose").wasAbleTo(
                Open.url("https://naveenautomationlabs.com/opencart/index.php?route=account/login")
        );
    }

    @When("the user enters email {string} and password {string}")
    public void theUserEntersEmailAndPassword(String email, String password) {
        String finalEmail = Serenity.sessionVariableCalled("dynamicEmail");
        if (finalEmail == null) finalEmail = email; // Fallback to provided email if no dynamic email in session

        OnStage.theActorInTheSpotlight().attemptsTo(
                IniciarSesionComo.conCredenciales(finalEmail, password)
        );
    }

    @And("clicks on the login button")
    public void clicksOnTheLoginButton() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(LoginPage.LOGIN_BUTTON)
        );
    }

    @Then("the user should see the name {string} in the page header")
    public void theUserShouldSeeTheNameInThePageHeader(String expectedName) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(Text.of(LoginPage.ACCOUNT_HEADER), containsString("My Account"))
        );
    }

}
