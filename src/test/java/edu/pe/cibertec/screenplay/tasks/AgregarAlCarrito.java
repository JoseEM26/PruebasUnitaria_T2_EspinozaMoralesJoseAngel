package edu.pe.cibertec.screenplay.tasks;

import edu.pe.cibertec.screenplay.ui.CarritoPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class AgregarAlCarrito implements Task {
    private final String product;

    public AgregarAlCarrito(String product) {
        this.product = product;
    }

    public static AgregarAlCarrito elProducto(String product) {
        return instrumented(AgregarAlCarrito.class, product);
    }

    @Override
    @Step("{0} adds #product to the cart")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                BuscarProducto.conNombre(product),
                Click.on(CarritoPage.ADD_TO_CART_BTN.of(product))
        );
    }
}
