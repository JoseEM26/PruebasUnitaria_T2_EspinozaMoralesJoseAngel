package edu.pe.cibertec.screenplay.tasks;

import edu.pe.cibertec.screenplay.ui.BusquedaPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class BuscarProducto implements Task {
    private final String product;

    public BuscarProducto(String product) {
        this.product = product;
    }

    public static BuscarProducto conNombre(String product) {
        return instrumented(BuscarProducto.class, product);
    }

    @Override
    @Step("{0} searches for product #product")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(product).into(BusquedaPage.SEARCH_INPUT).thenHit(Keys.ENTER)
        );
    }
}
