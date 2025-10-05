package automotion;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("input.btn_action")).click();
        Thread.sleep(3000);

        System.out.println("2. Add product to chart");
        List<WebElement> listProducts= driver.findElements(By.cssSelector("div.inventory_item"));
        // for(WebElement prod :listProducts){
        //     //System.out.println("Element"+ prod);
        //     System.out.println("Element Test"+ prod.findElement(By.cssSelector("div.inventory_item_name")).getText());
        //     if (prod.findElement(By.cssSelector("div.inventory_item_name")).getText().equalsIgnoreCase("Sauce Labs Backpack")){
        //         prod.findElement(By.cssSelector("button.btn_inventory")).click();   
        //     }

        WebElement product = listProducts.stream().filter(prod->
        prod.findElement(By.cssSelector("div.inventory_item_name")).getText().equalsIgnoreCase("Sauce Labs Backpack")).findFirst().orElse(null);

        product.findElement(By.cssSelector("button.btn_inventory")).click();  

        driver.findElement(By.cssSelector("a.shopping_cart_link")).click();
        Thread.sleep(3000); 

        List<WebElement> chartProducts = driver.findElements(By.xpath("//div[@data-test='inventory-item-name']"));
        Boolean match = chartProducts.stream().anyMatch(prod->prod.getText().equals("Sauce Labs Backpack"));
        Assert.assertTrue(match);
        
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("button.checkout_button")).click();

        driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Nada");
        driver.findElement(By.cssSelector("input[placeholder='Last Name']")).sendKeys("Amanatullah");
        driver.findElement(By.id("postal-code")).sendKeys("132435");
        driver.findElement(By.xpath("//input[@data-test='continue']")).click();

        Thread.sleep(3000);
         List<WebElement> checkoutOverview = driver.findElements(By.xpath("//div[@data-test='inventory-item-name']"));
        Boolean matchOverview = checkoutOverview.stream().anyMatch(prod->prod.getText().equals("Sauce Labs Backpack"));
        Assert.assertTrue(matchOverview);

        driver.findElement((By.name("finish"))).click();
        Thread.sleep(3000);

        Assert.assertEquals("Thank you for your order!",driver.findElement(By.xpath("//h2[@data-test='complete-header']")).getText());



    }

    @AfterMethod
    public void teardown() throws InterruptedException {
        System.out.println("After method in ScenarioE2ETest class");
        Thread.sleep(3000);
        System.out.println("After method in Exploration class");
        driver.quit();
    }

}
