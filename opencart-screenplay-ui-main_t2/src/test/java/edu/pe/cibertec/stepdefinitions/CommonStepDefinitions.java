package edu.pe.cibertec.stepdefinitions;

import edu.pe.cibertec.screenplay.ui.BusquedaPage;
import edu.pe.cibertec.screenplay.ui.LoginPage;
import edu.pe.cibertec.screenplay.ui.RegistroPage;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.containsString;

public class CommonStepDefinitions {

    @Then("the user should see the message {string}")
    public void theUserShouldSeeTheGeneralMessage(String expectedMessage) {
        Target target;
        if (LoginPage.ERROR_MESSAGE.resolveFor(OnStage.theActorInTheSpotlight()).isVisible()) {
            target = LoginPage.ERROR_MESSAGE;
        } else if (BusquedaPage.NO_RESULTS_MESSAGE.resolveFor(OnStage.theActorInTheSpotlight()).isVisible()) {
            target = BusquedaPage.NO_RESULTS_MESSAGE;
        } else {
            target = RegistroPage.SUCCESS_MESSAGE;
        }

        OnStage.theActorInTheSpotlight().should(
                seeThat(Text.of(target), containsString(expectedMessage))
        );
    }
}
