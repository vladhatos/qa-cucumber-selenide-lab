package com.hapifyme.pages;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.datatable.DataTable; // Make sure to import this
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


//Page Object for Settings
public class SettingsPage {

    //Locatori
    private final SelenideElement firstNameInput = $("input[name='first_name']");
    private final SelenideElement lastNameInput = $("input[name='last_name']");
    private final SelenideElement emailInput = $("input[name='email']");
    private final SelenideElement updateButton = $("input[name='update_details']");
    private final SelenideElement mainColumn = $(".main_column");


    //Actiuni
    public void openSettings(String baseUrl) {
        open(baseUrl + "/settings.php");

    }

    public void updateDetails(DataTable dataTable) {

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);


        String firstName = data.get(0).get("first_name");
        String lastName = data.get(0).get("last_name");

        $(By.name("first_name")).setValue(firstName);
        $(By.name("last_name")).setValue(lastName);

        $(By.name("update_details")).click();
    }

    public SelenideElement getFirstNameInput() {
        return firstNameInput;
    }

    public SelenideElement getLastNameInput() {
        return lastNameInput;
    }

    public SelenideElement getEmailInput() {
        return emailInput;
    }



    public void clickUpdateDetails() {
        updateButton.shouldBe(visible, Duration.ofSeconds(5));
        updateButton.click();
    }

    //Queries
    public boolean isSettingsPageLoaded() {
        try {
            firstNameInput.shouldBe(visible, Duration.ofSeconds(10));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getFirstNameValue() { return firstNameInput.getValue();
    }

    public String getLastNameValue() { return lastNameInput.getValue();
    }

    public String getEmailValue() { return emailInput.getValue();
    }

    public SelenideElement getMainColumn() { return mainColumn;
    }
}
