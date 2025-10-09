package com.webautomotion.page_factory.object_repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOverviewObjectRepository {

    public By overviewProduct = By.xpath("//div[@data-test='inventory-item-name']");

    @FindBy (name ="finish")
    public WebElement finishButton;

    public CheckoutOverviewObjectRepository(WebDriver driver){
        PageFactory.initElements(driver, this);

    }

}

