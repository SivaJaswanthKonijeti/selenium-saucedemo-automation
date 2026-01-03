package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DemoWait;

import java.time.Duration;

public class ProductsPage {
    private final WebDriverWait wait;

    // ---------- Locators ----------
    private final By pageTitle = By.className("title");
    private final By inventoryItems = By.className("inventory_item");
    private final By cartIcon = By.className("shopping_cart_link");
    private final By addToCartBackpackBtn = By.id("add-to-cart-sauce-labs-backpack");
    private final By cartBadge = By.className("shopping_cart_badge");

    public ProductsPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // ---------- Page Validations ----------
    public String getPageTitle() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(pageTitle)
        ).getText();
    }

    public boolean isProductsPageDisplayed() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(pageTitle)
        ).isDisplayed();
    }


    // ---------- Page Actions ----------
    public int getProductsCount() {
        return wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(inventoryItems)
        ).size();
    }

    public void clickCartIcon() {
        wait.until(
                ExpectedConditions.elementToBeClickable(cartIcon)
        ).click();
        DemoWait.pause(2);
    }

    public void addBackpackToCart() {
        wait.until(
                ExpectedConditions.elementToBeClickable(addToCartBackpackBtn)
        ).click();
        DemoWait.pause(2);
    }

    public int getCartBadgeCount() {
        return Integer.parseInt(
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(cartBadge)
                ).getText()
        );}
}
