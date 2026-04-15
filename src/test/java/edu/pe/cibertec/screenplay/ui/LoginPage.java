package edu.pe.cibertec.screenplay.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage extends PageObject {
    public static final Target EMAIL = Target.the("Email field")
            .located(By.id("input-email"));
    public static final Target PASSWORD = Target.the("Password field")
            .located(By.id("input-password"));
    public static final Target LOGIN_BUTTON = Target.the("Login button")
            .located(By.cssSelector("input[type='submit']"));
    public static final Target ACCOUNT_HEADER = Target.the("Account header")
            .located(By.cssSelector("#content h2"));
    public static final Target ERROR_MESSAGE = Target.the("Error message")
            .located(By.cssSelector(".alert-danger"));
}
