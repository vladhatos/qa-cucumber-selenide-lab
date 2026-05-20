package com.hapifyme.hooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import static com.codeborne.selenide.Selenide.screenshot;


public class Hooks {


    @Before
    public void setUp(Scenario scenario) {
        // Configurare globală Selenide
        Configuration.baseUrl = "https://apps.qualiadept.eu/hapifyme.php";
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10_000;
        Configuration.pageLoadTimeout = 30_000;
        Configuration.screenshots = true;
        Configuration.reportsFolder = "target/screenshots";

        System.out.println("Start scenariu: " + scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario) {
        // Facem screenshot doar dacă testul a eșuat
        if (scenario.isFailed()) {
            String screenshotName = scenario.getName().replace(" ", "_");
            screenshot(screenshotName); // Funcție Selenide
            System.out.println("!!! Scenariu Eșuat. Screenshot salvat.");
        }

        // Închidem browserul pentru a avea un mediu curat la următorul test
        Selenide.closeWebDriver();
        System.out.println("Stop scenariu: " + scenario.getName());
    }
}
