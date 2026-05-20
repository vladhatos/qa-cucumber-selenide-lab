package com.hapifyme.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import io.cucumber.datatable.DataTable;

// Page Object pentru Search
public class SearchPage {

    private By searchInput = By.cssSelector("#search_text_input");
    private By resultsDropdown = By.className("search_results");
    private By mainColumn = By.className("main_column");
    private final SelenideElement firstResultLink = $(".liveSearchText");

    public void searchFor(String query) {
        $(searchInput).setValue(query);
    }


    public void clickFirstResult() {
        firstResultLink.shouldBe(visible);
        firstResultLink.click();
    }

    public SelenideElement getFirstResultLink() {
        return firstResultLink;
    }



    public void showsNoResultsMessage() {
        $("#main_column").shouldBe(visible);
        $("#main_column").shouldHave(text("can't find anyone"));

    }

    public By getResultsDropdown() {
        return resultsDropdown;
    }

    public void setResultsDropdown(By resultsDropdown) {
        this.resultsDropdown = resultsDropdown;
    }

    public By getMainColumn() {
        return mainColumn;
    }

    public void setMainColumn(By mainColumn) {
        this.mainColumn = mainColumn;
    }
}

