package com.hapifyme.pages;

import com.codeborne.selenide.SelenideElement;
import java.time.Duration;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

//Page Object for Navigation bar
public class NavigationBar {

    //Locatori
    private final SelenideElement searchInput = $("#search_text_input");
    private final SelenideElement searchResults = $(".search_results");
    private final SelenideElement homeLink = $("nav a[href='index.php']");
    private final SelenideElement settingsLink = $("nav a[href='settings.php']");
    private final SelenideElement logoutButton = $("#logout_button");

    //Actiuni
    public NavigationBar searchUser(String query) {
        searchInput.shouldBe(visible, Duration.ofSeconds(10));
        searchInput.clear();
        searchInput.setValue(query);
        try { Thread.sleep(1500); } catch (InterruptedException ignored) {}
        return this;
    }


    public void clickHome() {
        homeLink.click();
    }

    public void clickSettings() {
        settingsLink.click();
    }

    public void clickLogout() {
        logoutButton.shouldBe(visible, Duration.ofSeconds(5));
        logoutButton.click();
    }


    public SelenideElement getSearchResults() {
        return searchResults;
    }
}
