package com.webautomotion.page_factory.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.webautomotion.page_factory.object_repository.CartObjectRepository;

public class CartPage {
    CartObjectRepository cartObjectRepository;
    WebDriver driver;


    public CartPage(WebDriver driver){
        this.cartObjectRepository = new CartObjectRepository(driver);
        this.driver = driver;
    }
    public void goToCart(){
        cartObjectRepository.cartButton.click();
    }

    public List<WebElement> getAllProductCart(){
        List<WebElement> cartProduct =  driver.findElements(cartObjectRepository.cartProduct);
        return cartProduct;
    }

    public Boolean verifyProductInCart(String productName){
        Boolean match = getAllProductCart().stream().anyMatch(prod -> prod.getText().equalsIgnoreCase(productName));
        return match;
    }

    public void goToCheckout(){
        cartObjectRepository.checkoutButton.click();
    }

}


 