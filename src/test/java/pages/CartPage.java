package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DemoWait;

import java.time.Duration;
import java.util.List;

public class CartPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // ---------- Locators ----------
    private final By cartTitle = By.className("title");
    private final By cartItems = By.className("cart_item");
    private final By continueShoppingBtn = By.id("continue-shopping");
    private final By checkoutBtn = By.id("checkout");

    // ---------- Constructor ----------
    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ---------- Page Validations ----------
    public boolean isCartPageDisplayed() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(cartTitle)
        ).getText().equals("Your Cart");
    }

    // ---------- Page Actions ----------
    public int getCartItemsCount() {
        List<?> items = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(cartItems)
        );
        return items.size();
    }

    public void clickContinueShopping() {
        wait.until(
                ExpectedConditions.elementToBeClickable(continueShoppingBtn)
        ).click();
        DemoWait.pause(2);
    }

    public void clickCheckout() {
        wait.until(
                ExpectedConditions.elementToBeClickable(checkoutBtn)
        ).click();
        DemoWait.pause(3);
    }
}