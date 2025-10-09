package com.webautomotion.page_factory.pages;

import org.openqa.selenium.WebDriver;

import com.webautomotion.page_factory.object_repository.CheckoutInformationObjectRepository;

public class CheckoutInformationPage {
    private CheckoutInformationObjectRepository checkoutInformationObjectRepository;

    public CheckoutInformationPage (WebDriver driver){
        this.checkoutInformationObjectRepository = new CheckoutInformationObjectRepository(driver);
    }
    
    public void doContinue(String firstname, String lastname, String postalcode){
        checkoutInformationObjectRepository.firstName.sendKeys(firstname);
        checkoutInformationObjectRepository.lastName.sendKeys(lastname);
        checkoutInformationObjectRepository.postalCode.sendKeys(postalcode);
        checkoutInformationObjectRepository.continueButton.click();
    }
    
}



