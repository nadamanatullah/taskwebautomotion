package automotion;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.Iterator;
//import javax.swing.text.html.HTMLDocument.Iterator;

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

import com.google.j2objc.annotations.Property;

public class RahulShettyAcademy {
    WebDriver driver;
    WebDriverWait wait;  
    
    @BeforeMethod
    public void setUp(){

        System.out.println("Set Up Web Driver");
        System.setProperty("webdriver.chrome.driver", "D:\\QA\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        wait = new WebDriverWait(driver, Duration.ofMillis(4000));
        
    }

    @Test (priority = 1)
    public void inputForm()throws InterruptedException{
        Thread.sleep(4000);
        System.out.println("Input Form Rahul Shetty Accademy");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("name")));

        driver.findElement(By.name("name")).sendKeys("Nada Amanatullah");
        driver.findElement(By.name("email")).sendKeys("nadamanatullah2@gmail.com");
        driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys("AfterOffice");
        driver.findElement(By.id("exampleCheck1")).click();
        driver.findElement(By.id("exampleFormControlSelect1")).click();
        List<WebElement> listOptions =driver.findElements(By.id("exampleFormControlSelect1"));
        for (WebElement option : listOptions){
            System.out.println(option.getText());
            if (option.getText().equals("Female"));
            option.click();
            break;
        }
        driver.findElement(By.id("inlineRadio1")).click();
        driver.findElement(By.name("bday")).sendKeys("11-06-2000");
        //driver.findElement(By.xpath("//input[@type='date']")).click();

        Thread.sleep(4000);
        driver.findElement(By.cssSelector("input.btn-success")).click();


    }
    @Test (priority = 2)
    public void handleWindows() throws InterruptedException{
         Thread.sleep(4000);
        System.out.println("Handle Windows Rahul Shetty Accademy");

        driver.findElement(By.xpath("//a[@class='blinkingText']")).click();

        Thread.sleep(2000);
        
        Set<String> windows = driver.getWindowHandles();
        System.out.println("ini adalah windows" + windows);//[parentId, childId]

        Iterator<String> iterator = windows.iterator();
        String parentId = iterator.next();
        String childId = iterator.next();

        Thread.sleep(2000);

        driver.switchTo().window(childId);
        Assert.assertEquals("Welcome to the Career-Focused Software Testing Meetup",driver.findElement(By.xpath("//p[@class='hero_heading']")).getText());
        driver.switchTo().window(parentId);
    }

    @AfterMethod
    public void tearDown()throws InterruptedException{
        System.out.println("After Method");
        Thread.sleep(4000);
        if(driver != null){
            driver.quit();
        }
    }

}
