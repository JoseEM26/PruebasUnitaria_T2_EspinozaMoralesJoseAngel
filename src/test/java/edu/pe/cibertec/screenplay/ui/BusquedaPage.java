package edu.pe.cibertec.screenplay.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class BusquedaPage extends PageObject {
    public static final Target SEARCH_INPUT = Target.the("Search input box")
            .located(By.name("search"));
    public static final Target SEARCH_BUTTON = Target.the("Search button")
            .located(By.cssSelector("#search button"));
    public static final Target PRODUCT_RESULTS = Target.the("Product results list")
            .located(By.cssSelector(".product-layout h4 a"));
    public static final Target NO_RESULTS_MESSAGE = Target.the("No results message")
            .located(By.xpath("//p[contains(text(), 'There is no product that matches the search criteria.')]"));
}
