package edu.pe.cibertec.screenplay.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CarritoPage extends PageObject {
    public static final Target ADD_TO_CART_BTN = Target.the("Add to cart button for #product")
            .locatedBy("//a[text()='{0}']/ancestor::div[@class='product-thumb']//button[contains(@onclick, 'cart.add')]");
            
    public static final Target CART_TOTAL = Target.the("Cart total button")
            .located(By.id("cart-total"));
            
    public static final Target VIEW_CART_LINK = Target.the("Shopping cart link")
            .located(By.cssSelector("a[title='Shopping Cart']"));
            
    public static final Target CART_PRODUCT_NAMES = Target.the("Product names in cart")
            .located(By.cssSelector("div.table-responsive td.text-left a"));
}
