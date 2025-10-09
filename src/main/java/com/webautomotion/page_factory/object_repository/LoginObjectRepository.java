package com.webautomotion.page_factory.object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginObjectRepository {
    // driver.findElement(By.id("user-name")).sendKeys("standard_user");
    //     driver.findElement(By.id("password")).sendKeys("secret_sauce");
    //     driver.findElement(By.cssSelector("input.btn_action")).click();
    @FindBy(id ="user-name")
    public WebElement userName;

    @FindBy(id ="password")
    public WebElement password;

    @FindBy(css ="input.btn_action")
    public WebElement btnLogin;
    
    public LoginObjectRepository (WebDriver driver){
        PageFactory.initElements(driver, this);
    }

}
