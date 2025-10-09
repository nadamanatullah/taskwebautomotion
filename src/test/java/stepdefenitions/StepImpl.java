package stepdefenitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver.When;
import org.testng.Assert;

import com.webautomotion.page_factory.pages.CartPage;
import com.webautomotion.page_factory.pages.CheckoutInformationPage;
import com.webautomotion.page_factory.pages.CheckoutOverviewPage;
import com.webautomotion.page_factory.pages.ConfirmationPage;
import com.webautomotion.page_factory.pages.DashboardPage;
import com.webautomotion.page_factory.pages.LoginPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class StepImpl {

    WebDriver driver;

    @Given ("User is on the login page")
    public void user_is_on_the_login_page() throws InterruptedException{
        System.out.println("Set Up Web Driver");
        System.setProperty("webdriver.chrome.driver", "D:\\QA\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Thread.sleep(3000);
    }

    @io.cucumber.java.en.When("User logged in with valid credentials")
    public void user_logged_in_with_valid_credentials() throws InterruptedException{
        System.out.println("1. Login ke Aplikasi");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogin("standard_user", "secret_sauce");
        Thread.sleep(3000);
    }
    

    @Then ("User is navigated to the product page")
    public void user_is_navigated_to_the_product_page(){
        throw new io.cucumber.java.PendingException();

    }

    @io.cucumber.java.en.When("User adds a product to the cart")
    public void user_adds_a_product_to_the_cart() throws InterruptedException{
        System.out.println("2. Add product to chart");
        DashboardPage dashboardPage =new DashboardPage(driver);
        dashboardPage.addToChart("Sauce Labs Backpack");
        Thread.sleep(3000);
    }

    @And("User clicks on the cart icon")
    public void user_clicks_on_the_cart_icon() throws InterruptedException{
        CartPage cartPage =new CartPage(driver);
        cartPage.goToCart();
        Thread.sleep(3000);

    }
    //Then User verify the product is added to cart
    @Then ("User verify the product is added to cart")
    public void user_verify_the_product_is_added_to_cart() throws InterruptedException{
        CartPage cartPage =new CartPage(driver);
        Boolean match = cartPage.verifyProductInCart("Sauce Labs Backpack");
        Assert.assertTrue(match);

        Thread.sleep(3000);

    }
    //     When User clicks on the checkout button 
    @io.cucumber.java.en.When("User clicks on the checkout button")
    public void user_clicks_on_the_checkout_button() throws InterruptedException{
         CartPage cartPage =new CartPage(driver);
         cartPage.goToCheckout();

          Thread.sleep(3000);
        
    }
    //     Then User is navigated to the checkout page
    @Then("User is navigated to the checkout page")
    public void user_is_navigated_to_checkout_page(){
          throw new io.cucumber.java.PendingException();


    }
    //     When User fills in the checkout information with valid data
    @io.cucumber.java.en.When("User fills in the checkout information with valid data")
    public void user_fills_in_the_chechkout_information_with_valid_data() throws InterruptedException{
        CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage(driver);
        checkoutInformationPage.doContinue("Nada", "Amanatullah", "132435");
        
        Thread.sleep(3000);
    }
   
    //     Then User verify the selected product in the overview list
    @Then ("User verify the selected product in the overview list")
    public void user_verify_the_selected_product_in_the_overview_list() throws InterruptedException{
         System.out.println("5.Overview Product Checkout");
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        Boolean matchOverview = checkoutOverviewPage.verifyOverviewProduct("Sauce Labs Backpack");
        Assert.assertTrue(matchOverview);

         Thread.sleep(3000);

    }
    //     When User clicks on the finish button 
    @io.cucumber.java.en.When ("User clicks on the finish button")
    public void user_clicks_on_the_finish_button(){
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutOverviewPage.goToFinish();
    }
    
    //     Then User should see the order confirmation page
    @Then ("User should see the order confirmation page")
    public void user_should_see_the_order_confirmation_page() throws InterruptedException{
        System.out.println("6. Order confirmation");
        
        ConfirmationPage confirmationPage = new ConfirmationPage(driver);
        String confirmationOrder = confirmationPage.getConfirmationMessage();
        Assert.assertTrue(confirmationOrder.equalsIgnoreCase("Thank you for your order!"));

        Thread.sleep(3000);
    }
   



}
