package com.webautomotion.page_factory.object_repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartObjectRepository {

    @FindBy (css = "a.shopping_cart_link")
    public WebElement cartButton;

    public By cartProduct = By.xpath("//div[@data-test='inventory-item-name']");
    
    @FindBy (css = "button.checkout_button")
    public WebElement checkoutButton;

    public CartObjectRepository(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

}

        