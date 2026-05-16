package com.hapifyme.stepdefinitions;

import com.hapifyme.pages.FeedPage;
import com.hapifyme.pages.LoginPage;
import com.hapifyme.pages.NavigationBar;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import java.util.Objects;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.title;
import static org.junit.Assert.assertTrue;


public class LoginSteps {

    LoginPage loginPage = new LoginPage();
    FeedPage feedPage;
    NavigationBar navBar = new NavigationBar();


    public LoginSteps() {
        feedPage = new FeedPage();
    }

    //Given
    @Given("utilizatorul deschide pagina de login")
    public void theUserIsOnTheLoginPage() {
        loginPage.openPage("(https://apps.qualiadept.eu/hapifyme.php)");

    }

    //When
    @When("utilizatorul introduce emailul {string} si parola {string}")
    public void theUserEntersCredentials(String email, String password) {
        $(By.name("log_email")).setValue(email);
        $(By.name("log_password")).setValue(password);
    }

    @And("utilizatorul apasă butonul de login")
    public void theUserClicksLogin() {
        loginPage.clickLogin();
    }

    @And("utilizatorul apasă butonul de logout")
    public void theUserClicksLogout() {
        navBar.clickLogout();
    }

    //Then

    @Then("titlul paginii ar trebui sa contina {string}")
    public void pageTitleContains(String expectedTitle) {
        assertTrue("Title mismatch", Objects.requireNonNull(title()).contains(expectedTitle));
    }

    @Then("utilizatorul ar trebui să vadă un mesaj de eroare")
    public void errorMessageDisplayed() {
        $("#log_inv").shouldBe(visible);
    }



    @Then("utilizatorul ar trebui să fie redirecționat către homepage")
    public void verifyHomepage() {
        // Verificam un element care există doar în index.php (dupa login)
        // De exemplu, div-ul cu clasa .posts_area sau .user_details
        $(".posts_area").shouldBe(visible);

    }

    @Then("utilizatorul ajunge pe login page")
    public void verifyLoginpage() {
        // Verificam un element care există doar în login page
        $("#login_header").shouldBe(visible);
    }

}

