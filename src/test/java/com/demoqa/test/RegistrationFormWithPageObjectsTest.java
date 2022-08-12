package com.demoqa.test;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class RegistrationFormWithPageObjectsTest {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1500x800";
    }

    @Test
    void fillFormTest () {
        registrationFormPage.openPage()
                .setFirstName("Olga")
                .setLastName("Alexandrova")
                .setEmail("Olga@ya.ru")
                .setGender("Female")
                .setNumber("8916111111")
                .setBirthDate("30", "June", "2008")
                .setSubjects("History")
                .setHobby("Sports")
                .setHobby("Reading")
                .setHobby("Music")
                .uploadFile("src/test/resources/file.txt")
                .setCurrentAddress("Moscow")
                .setState("NCR")
                .setCity("Delhi")
                .pressSubmit();

        registrationFormPage.checkResultsTableVisible()
                .checkResults("Student Name", "Olga Alexandrova")
                .checkResults("Student Email", "Olga@ya.ru")
                .checkResults("Gender", "Female")
                .checkResults("Mobile", "8916111111")
                .checkResults("Date of Birth", "30 June,2008")
                .checkResults("Subjects", "History")
                .checkResults("Hobbies", "Sports, Reading, Music")
                .checkResults("Picture", "file.txt")
                .checkResults("Address", "Moscow")
                .checkResults("State and City", "NCR Delhi");
    }
}