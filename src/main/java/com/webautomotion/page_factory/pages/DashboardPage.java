package com.webautomotion.page_factory.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.webautomotion.page_factory.object_repository.DashboardObjectRepository;

public class DashboardPage {
    private DashboardObjectRepository dashboardObjectRepository;
    private WebDriver driver;
    
    public DashboardPage(WebDriver driver){
        this.dashboardObjectRepository = new DashboardObjectRepository(driver);
        this.driver = driver;
        
    }

    public WebElement getProductByName(String productName){
        List<WebElement> products= driver.findElements(dashboardObjectRepository.listProducts);
        WebElement product = products.stream().filter(prod->
        prod.findElement(dashboardObjectRepository.productName).getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
        return product;
    }

    public void addToChart(String productName){
        WebElement product = getProductByName(productName);
        product.findElement(dashboardObjectRepository.addToCartButton).click();
         
    }

    
        
  
        
}


