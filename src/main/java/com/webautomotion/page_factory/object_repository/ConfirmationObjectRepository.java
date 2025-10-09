package com.webautomotion.page_factory.object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationObjectRepository {

    @FindBy(xpath = "//h2[@data-test='complete-header']")
    public WebElement confirmationMessage;
    
    public ConfirmationObjectRepository (WebDriver driver){
        PageFactory.initElements(driver, this);
    }
}


