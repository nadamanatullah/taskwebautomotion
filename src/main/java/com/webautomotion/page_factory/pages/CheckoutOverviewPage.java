package com.webautomotion.page_factory.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.webautomotion.page_factory.object_repository.CartObjectRepository;
import com.webautomotion.page_factory.object_repository.CheckoutOverviewObjectRepository;

public class CheckoutOverviewPage {
    CheckoutOverviewObjectRepository checkoutOverviewObjectRepository;
    WebDriver driver;

    public CheckoutOverviewPage(WebDriver driver){
        this.checkoutOverviewObjectRepository = new CheckoutOverviewObjectRepository(driver);
        this.driver= driver;
    }

    public List<WebElement> getProductCheckout(){
        List<WebElement> overviewProduct = driver.findElements(checkoutOverviewObjectRepository.overviewProduct);
        return overviewProduct;
    }

    public Boolean verifyOverviewProduct(String productName){
        Boolean match = getProductCheckout().stream().anyMatch(prod -> prod.getText().equalsIgnoreCase(productName));
        return match;
    }

    public void goToFinish(){
        checkoutOverviewObjectRepository.finishButton.click();
    }
//  public CartPage(WebDriver driver){
//         this.cartObjectRepository = new CartObjectRepository(driver);
//         this.driver = driver;
//     }
}


