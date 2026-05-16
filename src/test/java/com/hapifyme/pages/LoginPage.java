package com.hapifyme.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

// POM pentru Login Page


public class LoginPage {

    // Locatori privați, pentru encapsulare
    private final By emailInput = By.name("log_email");
    private final By passwordInput = By.name("log_password");
    private final SelenideElement loginButton = $("input[name='login_button']");



    // Actiuni
    public void openPage(String baseUrl) {
        open(baseUrl + "/login_register.php");
    }


    public void login(String email, String password) {
        $(emailInput).clear();
        $(passwordInput).clear();
        $(emailInput).setValue(email);
        $(passwordInput).setValue(password);
        $(loginButton).click();
    }


    public void clickLogin() {
        loginButton.click();
    }



}
