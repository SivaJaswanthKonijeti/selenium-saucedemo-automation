package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;

public class CartPageTest extends BaseTest {

    @Test(priority = 1, description = "Verify cart page is displayed")
    public void verifyCartPageIsDisplayed() {

        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);

        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickCartIcon();

        Assert.assertTrue(
                cartPage.isCartPageDisplayed(),
                "Cart page is not displayed"
        );
    }

    @Test(priority = 2, description = "Verify cart is empty initially")
    public void verifyCartIsEmpty() {

        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);

        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickCartIcon();

        Assert.assertEquals(
                cartPage.getCartItemsCount(),
                0,
                "Cart is not empty initially"
        );
    }

    @Test(priority = 3, description = "Verify continue shopping button navigation")
    public void verifyContinueShoppingNavigation() {

        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        CartPage cartPage = new CartPage(driver);

        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickCartIcon();
        cartPage.clickContinueShopping();

        Assert.assertTrue(
                productsPage.isProductsPageDisplayed(),
                "Did not navigate back to Products page"
        );
    }
}
