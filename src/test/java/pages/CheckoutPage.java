package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DemoWait;

import java.time.Duration;

public class CheckoutPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // ---------- Locators ----------
    private final By firstNameField = By.id("first-name");
    private final By lastNameField  = By.id("last-name");
    private final By postalCodeField = By.id("postal-code");
    private final By continueBtn = By.id("continue");

    private final By overviewTitle = By.className("title");
    private final By finishBtn = By.id("finish");

    private final By successMessage = By.className("complete-header");

    // ---------- Constructor ----------
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ---------- Step 1: Enter Checkout Information ----------
    public void enterFirstName(String firstName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField))
                .sendKeys(firstName);
        DemoWait.pause(1);
    }

    public void enterLastName(String lastName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField))
                .sendKeys(lastName);
        DemoWait.pause(1);
    }

    public void enterPostalCode(String postalCode) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(postalCodeField))
                .sendKeys(postalCode);
        DemoWait.pause(1);
    }

    public void clickContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(continueBtn)).click();
        DemoWait.pause(2);
    }

    // ---------- Business Method ----------
    public void fillCheckoutDetails(String firstName, String lastName, String postalCode) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterPostalCode(postalCode);
        clickContinue();
    }

    // ---------- Step 2: Overview Page ----------
    public boolean isOverviewPageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(overviewTitle))
                .getText().equals("Checkout: Overview");
    }

    public void clickFinish() {
        wait.until(ExpectedConditions.elementToBeClickable(finishBtn)).click();
        DemoWait.pause(2);
    }

    // ---------- Step 3: Confirmation ----------
    public String getOrderConfirmationMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage))
                .getText();
    }
}
