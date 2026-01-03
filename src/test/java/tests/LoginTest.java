package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

public class LoginTest extends BaseTest {

    @Test(priority = 1, description = "Verify login with valid credentials")
    public void validLoginTest() {

        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);

        loginPage.login("standard_user", "secret_sauce");

        Assert.assertTrue(
                productsPage.isProductsPageDisplayed(),
                "Login failed: Products page not displayed"
        );
    }

    @Test(priority = 2, description = "Verify locked out user login")
    public void lockedOutUserTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("locked_out_user", "secret_sauce");

        Assert.assertTrue(
                loginPage.getErrorMessage().toLowerCase().contains("locked out"),
                "Locked out user error message not displayed"
        );
    }

    @Test(priority = 3, description = "Verify login with invalid credentials")
    public void invalidCredentialsTest() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("invalid_user", "invalid_pass");

        Assert.assertTrue(
                loginPage.getErrorMessage().toLowerCase().contains("do not match"),
                "Invalid credentials error message not displayed"
        );
    }
}
