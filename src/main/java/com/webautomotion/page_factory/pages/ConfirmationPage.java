package com.webautomotion.page_factory.pages;

import org.openqa.selenium.WebDriver;

import com.webautomotion.page_factory.object_repository.ConfirmationObjectRepository;

public class ConfirmationPage {
    ConfirmationObjectRepository confirmationObjectRepository;

    public ConfirmationPage(WebDriver driver){
        this.confirmationObjectRepository = new ConfirmationObjectRepository(driver);
    }

    public String getConfirmationMessage(){
        return confirmationObjectRepository.confirmationMessage.getText();
    }
}
