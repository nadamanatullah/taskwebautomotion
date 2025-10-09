package com.webautomotion.page_factory.object_repository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardObjectRepository {

    //  List<WebElement> listProducts= driver.findElements(By.cssSelector("div.inventory_item"));
    

    public By listProducts = By.cssSelector("div.inventory_item");
    public By addToCartButton = By.cssSelector("button.btn_inventory");
    public By productName = By.cssSelector("div.inventory_item_name");

    public DashboardObjectRepository (WebDriver driver){
        PageFactory.initElements(driver, this);
    }


}
