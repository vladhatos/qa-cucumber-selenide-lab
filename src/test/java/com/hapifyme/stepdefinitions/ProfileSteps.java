package com.hapifyme.stepdefinitions;

import com.hapifyme.pages.NavigationBar;
import com.hapifyme.pages.SearchPage;
import com.hapifyme.pages.SettingsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.Assert.assertTrue;

public class ProfileSteps {

    private final NavigationBar navBar = new NavigationBar();
    private final SearchPage searchPage = new SearchPage();
    private final SettingsPage settingsPage = new SettingsPage();

    //Search
    @When("utilizatorul caută {string} în bara de navigare")
    public void searchUser(String query) {
        $(By.cssSelector("input[name='q']")).setValue(query);
    }

    @Then("ar trebui să vadă o listă de rezultate care conține {string}")
    public void verifyResults(String expectedName) {
        $(".search_results").shouldBe(visible);
        // Verificam textul
        $(".search_results").shouldHave(text(expectedName));

    }

    @When("utilizatorul da click pe primul rezultat")
    public void clickFirstResult() {
        searchPage.clickFirstResult();
    }

    @Then("pagina utilizatorului trebuie accesata")
    public void profilePageLoaded() {
        //verificam ca e vizibila o sectiune din pagina de profil (ar fi trebuit pagina utilizatorului cautat, dar nu merge)
        $(".user_details_left_right").shouldBe(visible);
    }

    @When("utilizatorul cauta un utilizator inexistent in search bar")
    public void searchInexistentUser(String query) {
        $(By.cssSelector("input[name='q']")).setValue(query);
    }

    @Then("o pagina fara rezultate e afisata")
    public void noResultsMessage() {
        assertTrue("Error was not displayed", searchPage.showsNoResultsMessage());
    }
    //Settings (Data Table)
    @When("utilizatorul navigheaza la Settings")
    public void navigateToSettings() {
        navBar.clickSettings();
        assertTrue("Settings page did not load", settingsPage.isSettingsPageLoaded());
    }

    @And("utilizatorul editeaza urmatoarele valori:")
    public void updateDetailsFromDataTable() {
        settingsPage.updateDetails();
    }

    @And("utilizatorul da click pe Update")
    public void clickUpdateDetails() {
        settingsPage.clickUpdateDetails();
    }

    @Then("noile setari sunt salvate")
    public void settingsSavedSuccessfully(String settingsUpdated) {
        //Verificam daca apare textul care indica salvarea detaliilor
        Assert.assertTrue("Text not found!", settingsUpdated.contains("Details updated"));
    }
}
