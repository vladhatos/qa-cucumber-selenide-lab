package com.hapifyme.stepdefinitions;

import com.hapifyme.pages.FeedPage;
import com.hapifyme.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertTrue;

public class PostSteps {

    private final LoginPage loginPage = new LoginPage();
    private final FeedPage feedPage = new FeedPage();

    //Background
    @Given("utilizatorul s-a logat cu emailul {string} si parola {string}")
    public void loginWithCredentials(String email, String password) {
        loginPage.openPage("https://apps.qualiadept.eu/hapifyme.php");
        loginPage.login(email, password);
        loginPage.clickLogin();
        assertTrue("Login failed – feed page not loaded", feedPage.isFeedPageLoaded());
    }

    //When
    @When("utilizatorul scrie {string} in input field")
    public void writeInPostBox() {
        String message = "TEST: Creare postare automata.";
        feedPage.writePost(message);
    }

    @When("utilizatorul apasa pe butonul de Post")
    public void clickPostButton() {
        feedPage.clickPost();
    }

    //Then
    @Then("postarea noua trebuie sa apara in feed")
    public void postShouldAppear(String postText) {
        assertTrue("Post not found in feed: " + postText,
                feedPage.isPostVisible(postText));
    }


}
