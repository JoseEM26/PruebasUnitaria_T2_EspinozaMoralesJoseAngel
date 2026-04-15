package edu.pe.cibertec.screenplay.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class RegistroPage extends PageObject {
    public static final Target FIRSTNAME = Target.the("First Name field")
            .located(By.id("input-firstname"));
    public static final Target LASTNAME = Target.the("Last Name field")
            .located(By.id("input-lastname"));
    public static final Target EMAIL = Target.the("Email field")
            .located(By.id("input-email"));
    public static final Target TELEPHONE = Target.the("Telephone field")
            .located(By.id("input-telephone"));
    public static final Target PASSWORD = Target.the("Password field")
            .located(By.id("input-password"));
    public static final Target CONFIRM_PASSWORD = Target.the("Confirm Password field")
            .located(By.id("input-confirm"));
    public static final Target PRIVACY_POLICY = Target.the("Privacy Policy checkbox")
            .located(By.name("agree"));
    public static final Target CONTINUE_BUTTON = Target.the("Continue button")
            .located(By.cssSelector("input[type='submit']"));
    public static final Target SUCCESS_MESSAGE = Target.the("Success message")
            .located(By.cssSelector("#content h1"));
}
