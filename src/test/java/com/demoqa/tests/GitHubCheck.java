package com.demoqa.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class GitHubCheck {

    @Test
    void checkSoftAssertions() {
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $(".wiki-more-pages-link").$("button").click();
        $("[data-filterable-for='wiki-pages-filter']").shouldHave(text("SoftAssertions"));
        $("a[href$='SoftAssertions']").click();
        $("#wiki-body").shouldHave(text("Using JUnit5 extend test class"));

    }
}
