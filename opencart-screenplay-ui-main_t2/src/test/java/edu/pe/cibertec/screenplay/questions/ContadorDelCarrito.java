package edu.pe.cibertec.screenplay.questions;

import edu.pe.cibertec.screenplay.ui.CarritoPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class ContadorDelCarrito implements Question<String> {

    public static ContadorDelCarrito valor() {
        return new ContadorDelCarrito();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(CarritoPage.CART_TOTAL).answeredBy(actor);
    }
}
