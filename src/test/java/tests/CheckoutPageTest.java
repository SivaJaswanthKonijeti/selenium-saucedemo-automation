package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;

public class CheckoutPageTest extends BaseTest {

    @Test(description = "Verify end-to-end checkout flow")
    public void verifyEndToEndCheckoutFlow() {

        // Page Objects
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        // Step 1: Login
        loginPage.login("standard_user", "secret_sauce");

        Assert.assertTrue(
                productsPage.isProductsPageDisplayed(),
                "Login failed: Products page not displayed"
        );

        // Step 2: Add product to cart
        productsPage.addBackpackToCart();

        Assert.assertEquals(
                productsPage.getCartBadgeCount(),
                1,
                "Cart badge count incorrect after adding product"
        );

        // Step 3: Go to Cart
        productsPage.clickCartIcon();

        Assert.assertTrue(
                cartPage.isCartPageDisplayed(),
                "Cart page not displayed"
        );

        Assert.assertEquals(
                cartPage.getCartItemsCount(),
                1,
                "Cart does not contain expected number of items"
        );

        // Step 4: Checkout
        cartPage.clickCheckout();

        checkoutPage.fillCheckoutDetails(
                "Jash",
                "Automation",
                "500001"
        );

        Assert.assertTrue(
                checkoutPage.isOverviewPageDisplayed(),
                "Checkout overview page not displayed"
        );

        // Step 5: Finish Order
        checkoutPage.clickFinish();

        String confirmationMessage = checkoutPage.getOrderConfirmationMessage();

        Assert.assertEquals(
                confirmationMessage,
                "Thank you for your order!",
                "Order confirmation message not displayed"
        );
    }
}
