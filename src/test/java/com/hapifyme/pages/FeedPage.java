package com.hapifyme.pages;

import com.codeborne.selenide.SelenideElement;
import java.time.Duration;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

//Page Object for Feed page
public class FeedPage {

    //Locators
    private final SelenideElement postTextArea  = $("#post_text");
    private final SelenideElement postButton    = $("#post_button");
    private final SelenideElement postsArea     = $(".posts_area");
    private final SelenideElement userDetails   = $(".user_details_left_right");

    //Actions
    public FeedPage openFeed(String baseUrl) {
        open(baseUrl + "/index.php");
        return this;
    }

    public FeedPage writePost(String text) {
        postTextArea.shouldBe(visible);
        postTextArea.clear();
        postTextArea.setValue(text);
        return this;
    }

    public void clickPost() {
        postButton.click();
    }

    //Assertions / Queries
    public boolean isFeedPageLoaded() {
        try {
            postTextArea.shouldBe(visible, Duration.ofSeconds(10));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isPostVisible(String postText) {
        //AJAX
        postsArea.shouldBe(visible, Duration.ofSeconds(10));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ignored) {}
        return postsArea.getText().contains(postText);
    }


    public SelenideElement getUserDetails() {
        return userDetails;
    }
}
