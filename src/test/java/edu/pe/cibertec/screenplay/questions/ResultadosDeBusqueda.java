package edu.pe.cibertec.screenplay.questions;

import edu.pe.cibertec.screenplay.ui.BusquedaPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import java.util.Collection;

public class ResultadosDeBusqueda implements Question<Collection<String>> {

    public static ResultadosDeBusqueda nombres() {
        return new ResultadosDeBusqueda();
    }

    @Override
    public Collection<String> answeredBy(net.serenitybdd.screenplay.Actor actor) {
        return Text.ofEach(BusquedaPage.PRODUCT_RESULTS).answeredBy(actor);
    }
}
