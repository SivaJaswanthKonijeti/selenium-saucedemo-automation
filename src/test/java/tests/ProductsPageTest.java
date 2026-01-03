package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

public class ProductsPageTest extends BaseTest {

    @Test(priority = 1, description = "Verify Products page is displayed after login")
    public void verifyProductsPageIsDisplayed() {

        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);

        loginPage.login("standard_user", "secret_sauce");

        Assert.assertTrue(
                productsPage.isProductsPageDisplayed(),
                "Products page is not displayed after login"
        );
    }

    @Test(priority = 2, description = "Verify products count is greater than zero")
    public void verifyProductsCount() {

        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);

        loginPage.login("standard_user", "secret_sauce");

        int productCount = productsPage.getProductsCount();

        Assert.assertTrue(
                productCount > 0,
                "Products list is empty"
        );
    }

    @Test(priority = 3, description = "Verify cart icon navigation")
    public void verifyCartIconNavigation() {

        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);

        loginPage.login("standard_user", "secret_sauce");

        productsPage.clickCartIcon();

        // Minimal validation (URL check is OK for navigation test)
        Assert.assertTrue(
                driver.getCurrentUrl().contains("cart"),
                "Cart page not opened after clicking cart icon"
        );
    }
}
