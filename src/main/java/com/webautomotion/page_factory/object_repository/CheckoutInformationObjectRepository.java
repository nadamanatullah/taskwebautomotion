package com.webautomotion.page_factory.object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutInformationObjectRepository {

    @FindBy(xpath = "//input[@name='firstName']")
    public WebElement firstName;
    
    @FindBy(css ="input[placeholder='Last Name']")
    public WebElement lastName;

    @FindBy(id = "postal-code")
    public WebElement postalCode;

    @FindBy (xpath = "//input[@data-test='continue']")
    public WebElement continueButton;

    public CheckoutInformationObjectRepository (WebDriver driver){
        PageFactory.initElements(driver, this);
    }
// driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Nada");
        // driver.findElement(By.cssSelector("input[placeholder='Last Name']")).sendKeys("Amanatullah");
        // driver.findElement(By.id("postal-code")).sendKeys("132435");
        // driver.findElement(By.xpath("//input[@data-test='continue']")).click();
}
