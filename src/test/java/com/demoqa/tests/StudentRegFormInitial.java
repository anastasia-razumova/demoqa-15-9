package com.demoqa.tests;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;


public class StudentRegFormInitial extends TestBase{

    @Test
    void simpleTest() {
        step("Open registration form",() -> {
            open("/automation-practice-form");
            executeJavaScript("$('footer').remove()");
            executeJavaScript("$('#fixedban').remove()");
        });
        step("Fill in registration form",() -> {
                    $("#firstName").setValue("Ivan");
                    $("#lastName").setValue("Ivanov");
                    $("#userEmail").setValue("ivani@gmail.com");
                    $("#genterWrapper").$(byText("Male")).click();
                    $("#userNumber").setValue("1234567890");
                    $("#dateOfBirthInput").click();
                    $(".react-datepicker__year-select").selectOption("1980");
                    $(".react-datepicker__month-select").selectOption("June");
                    $(".react-datepicker__day--015").click();
                    $("#subjectsInput").setValue("English").pressTab();
                    $("#hobbiesWrapper").$(byText("Sports")).click();
                    $("#uploadPicture").uploadFile(new File("src/test/resources/3.png"));
                    $("#currentAddress").setValue("Address123");
                    $(byText("Select State")).click();
                    $(byText("NCR")).click();
                    $(byText("Select City")).click();
                    $(byText("Delhi")).click();
                    $("#submit").click();
        });
        step("Check submitted form",() -> {
            $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
            $(".table-responsive").shouldHave(text("Ivan Ivanov"));
            $(".table-responsive").shouldHave(text("ivani@gmail.com"));
            $(".table-responsive").shouldHave(text("Male"));
            $(".table-responsive").shouldHave(text("1234567890"));
            $(".table-responsive").shouldHave(text("15 June,1980"));
            $(".table-responsive").shouldHave(text("English"));
            $(".table-responsive").shouldHave(text("Sports"));
            $(".table-responsive").shouldHave(text("Address123"));
            $(".table-responsive").shouldHave(text("NCR Delhi"));

        });



    }
}

