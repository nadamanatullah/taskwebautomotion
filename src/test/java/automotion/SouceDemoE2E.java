package automotion;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v139.storage.model.AttributionReportingVerboseDebugReportSent;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.webautomotion.page_factory.object_repository.CheckoutOverviewObjectRepository;
import com.webautomotion.page_factory.object_repository.DashboardObjectRepository;
import com.webautomotion.page_factory.pages.CartPage;
import com.webautomotion.page_factory.pages.CheckoutInformationPage;
import com.webautomotion.page_factory.pages.CheckoutOverviewPage;
import com.webautomotion.page_factory.pages.ConfirmationPage;
import com.webautomotion.page_factory.pages.DashboardPage;
import com.webautomotion.page_factory.pages.LoginPage;

public class SouceDemoE2E {
    public WebDriver driver;


    @BeforeMethod
    public void setUp() throws InterruptedException{
        System.out.println("Set Up Web Driver");
        System.setProperty("webdriver.chrome.driver", "D:\\QA\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Thread.sleep(3000);
    }

    @Test
    public void scenarioCheckout() throws InterruptedException{
        System.out.println("Scenario Check Out E2E Sauce Demo");

        System.out.println("1. Login ke Aplikasi");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogin("standard_user", "secret_sauce");
        // driver.findElement(By.id("user-name")).sendKeys("standard_user");
        // driver.findElement(By.id("password")).sendKeys("secret_sauce");
        // driver.findElement(By.cssSelector("input.btn_action")).click();
        Thread.sleep(3000);

        System.out.println("2. Add product to chart");
        DashboardPage dashboardPage =new DashboardPage(driver);
        dashboardPage.addToChart("Sauce Labs Backpack");
        // List<WebElement> listProducts= driver.findElements(By.cssSelector("div.inventory_item"));
        // WebElement product = listProducts.stream().filter(prod->
        // prod.findElement(By.cssSelector("div.inventory_item_name")).getText().equalsIgnoreCase("Sauce Labs Backpack")).findFirst().orElse(null);
        // product.findElement(By.cssSelector("button.btn_inventory")).click();  
        Thread.sleep(3000); 

        System.out.println("3. Verify Product to Check Out");
        CartPage cartPage =new CartPage(driver);
        cartPage.goToCart();
        Thread.sleep(3000);

        Boolean match = cartPage.verifyProductInCart("Sauce Labs Backpack");
        Assert.assertTrue(match);

        Thread.sleep(3000);
        cartPage.goToCheckout();

        // driver.findElement(By.cssSelector("a.shopping_cart_link")).click();
        // List<WebElement> chartProducts = driver.findElements(By.xpath("//div[@data-test='inventory-item-name']"));
        // Boolean match = chartProducts.stream().anyMatch(prod->prod.getText().equals("Sauce Labs Backpack"));
        // Assert.assertTrue(match);
         
        // driver.findElement(By.cssSelector("button.checkout_button")).click();

        System.out.println("4. Checkout Information");
        Thread.sleep(3000);
        CheckoutInformationPage checkoutInformationPage = new CheckoutInformationPage(driver);
        checkoutInformationPage.doContinue("Nada", "Amanatullah", "132435");
        


        // driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Nada");
        // driver.findElement(By.cssSelector("input[placeholder='Last Name']")).sendKeys("Amanatullah");
        // driver.findElement(By.id("postal-code")).sendKeys("132435");
        // driver.findElement(By.xpath("//input[@data-test='continue']")).click();

        Thread.sleep(3000);
        
        System.out.println("5.Overview Product Checkout");
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        Boolean matchOverview = checkoutOverviewPage.verifyOverviewProduct("Sauce Labs Backpack");
        Assert.assertTrue(matchOverview);
        
        Thread.sleep(3000);
        checkoutOverviewPage.goToFinish();

        // List<WebElement> checkoutOverview = driver.findElements(By.xpath("//div[@data-test='inventory-item-name']"));
        // Boolean matchOverview = checkoutOverview.stream().anyMatch(prod->prod.getText().equals("Sauce Labs Backpack"));
        // Assert.assertTrue(matchOverview);
        // driver.findElement((By.name("finish"))).click();
       

        System.out.println("6. Order confirmation");
        Thread.sleep(3000);
        ConfirmationPage confirmationPage = new ConfirmationPage(driver);
        String confirmationOrder = confirmationPage.getConfirmationMessage();
        Assert.assertTrue(confirmationOrder.equalsIgnoreCase("Thank you for your order!"));

        //Assert.assertEquals("Thank you for your order!",driver.findElement(By.xpath("//h2[@data-test='complete-header']")).getText());

    }

    @AfterMethod
    public void teardown() throws InterruptedException {
        System.out.println("After method in ScenarioE2ETest class");
        Thread.sleep(3000);
        System.out.println("After method in Exploration class");
        driver.quit();
    }

}
