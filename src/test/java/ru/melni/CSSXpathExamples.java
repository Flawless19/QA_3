package ru.melni;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.id;

public class CSSXpathExamples {
    @BeforeAll
    static void beforeAll() {
    Configuration.browserSize = "1400x800";
    Configuration.baseUrl = "https://demoqa.com";
    Configuration.pageLoadStrategy = "eager";
    Configuration.holdBrowserOpen = true;
    Configuration.timeout = 5000; // default 4000
    }
    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Alena");
        $("#lastName").setValue("Melnichenko");
        $("#userEmail").setValue("melnichenko2001@gmail.com");
        $("#genterWrapper").$(byText("Female")).click();
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__year-select").selectOption("2001");
        $(".react-datepicker__day--014").click();
        $("#userNumber").setValue("9999999999");
        $("#subjectsInput").setValue("Math").pressEnter(); //currentAddress-wrapper
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("pik.png");
        $("#currentAddress").setValue("myAddress");
        $("#state").scrollIntoView(true);
        $("#stateCity-wrapper").find(byText("Select State")).click();
        $(byText("Uttar Pradesh")).click();
        $("#stateCity-wrapper").find(byText("Select City")).click();
        $(byText("Lucknow")).click();
        $("#stateCity-wrapper").scrollIntoView(true);
        $("#submit").click();


        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(By.tagName("tbody")).shouldHave(text("Alena"));
        $(By.tagName("tbody")).shouldHave(text("Melnichenko"));
        $(By.tagName("tbody")).shouldHave(text("melnichenko2001@gmail.com"));
        $(By.tagName("tbody")).shouldHave(text("Female"));
        $(By.tagName("tbody")).shouldHave(text("9999999999"));
        $(By.tagName("tbody")).shouldHave(text("14 March,2001"));
        $(By.tagName("tbody")).shouldHave(text("Maths"));
        $(By.tagName("tbody")).shouldHave(text("Music"));
        $(By.tagName("tbody")).shouldHave(text("pik.png"));
        $(By.tagName("tbody")).shouldHave(text("myAddress"));
        $(By.tagName("tbody")).shouldHave(text("Uttar Pradesh Lucknow"));
    }
}

