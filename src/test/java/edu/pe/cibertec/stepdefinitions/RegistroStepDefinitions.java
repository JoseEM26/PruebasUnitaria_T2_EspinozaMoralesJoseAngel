package edu.pe.cibertec.stepdefinitions;

import edu.pe.cibertec.screenplay.tasks.RegistrarseComo;
import edu.pe.cibertec.screenplay.ui.RegistroPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.annotations.Managed;
import org.openqa.selenium.WebDriver;

public class RegistroStepDefinitions {

    @Managed
    WebDriver driver;


    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("the user navigates to the register page")
    public void theUserNavigatesToTheRegisterPage() {
        OnStage.theActorCalled("Jose").wasAbleTo(
                Open.url("https://naveenautomationlabs.com/opencart/index.php?route=account/register")
        );
    }

    @When("the user fills the form with first name {string}, last name {string}, email {string}, phone {string} and password {string}")
    public void theUserFillsTheFormWithFirstNameLastNameEmailPhoneAndPassword(String firstName, String lastName, String email, String phone, String password) {
        String dynamicEmail = email.replace("@", System.currentTimeMillis() + "@");
        Serenity.setSessionVariable("dynamicEmail").to(dynamicEmail);
        
        OnStage.theActorInTheSpotlight().attemptsTo(
                RegistrarseComo.conDatos(firstName, lastName, dynamicEmail, phone, password)
        );
    }

    @And("accepts the privacy policy")
    public void acceptsThePrivacyPolicy() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(RegistroPage.PRIVACY_POLICY)
        );
    }

    @And("clicks on continue")
    public void clicksOnContinue() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(RegistroPage.CONTINUE_BUTTON)
        );
    }

}
