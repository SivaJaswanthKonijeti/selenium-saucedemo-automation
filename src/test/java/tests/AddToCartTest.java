package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;

public class AddToCartTest extends BaseTest {

    @Test(description = "Verify product can be added to cart")
    public void verifyAddToCartFlow() {

        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);

        // Step 1: Login
        loginPage.login("standard_user", "secret_sauce");

        // Step 2: Add product to cart
        productsPage.addBackpackToCart();

        // Step 3: Verify cart badge count
        Assert.assertEquals(
                productsPage.getCartBadgeCount(),
                1,
                "Cart badge count is incorrect"
        );

        // Step 4: Go to cart
        productsPage.clickCartIcon();

        // Step 5: Verify item is present in cart
        Assert.assertEquals(
                cartPage.getCartItemsCount(),
                1,
                "Item not added to cart"
        );
    }
}
