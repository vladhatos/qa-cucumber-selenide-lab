package com.hapifyme.pages;

import com.codeborne.selenide.SelenideElement;
import java.time.Duration;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

//Page Object for Profile page
public class ProfilePage {

    //Locatori
    private final SelenideElement profileInfo = $(".user_details_left_right");
    private final SelenideElement postsArea = $(".posts_area");


    //Queries
    public boolean isProfilePageLoaded() {
        try {
            profileInfo.shouldBe(visible, Duration.ofSeconds(10));
            return true;
        } catch (Exception e) {
            return false;
        }
    }




    public SelenideElement getPostsArea() {
        return postsArea;
    }
}
