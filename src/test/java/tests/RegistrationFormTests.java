package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationFormTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void minimalRegistrationTest() {
        registrationPage.openPage()
                .setFirstName("Test")
                .setLastName("Testov")
                .setGender("Other")
                .setNumber("1234567890")
                .submit()
                .checkSubmitResult("Student Name", "Test Testov")
                .checkSubmitResult("Gender", "Other")
                .checkSubmitResult("Mobile", "1234567890");
    }

    @Test
    void fullRegistrationTest() {
        registrationPage.openPage()
                .setFirstName("Test")
                .setLastName("Testov")
                .setEmail("testov@test.test")
                .setGender("Other")
                .setNumber("1234567890")
                .setDateOfBirth("16", "April", "1975")
                .setSubject("English").setSubject("Computer")
                .setHobbies("Reading").setHobbies("Music")
                .setPicture("file_example_JPG_100kB.jpg")
                .setAddress("Test Street, 123")
                .setState("Uttar Pradesh")
                .setCity("Merrut")
                .submit()
                .checkSubmitResult("Student Name", "Test Testov")
                .checkSubmitResult("Student Email", "testov@test.test")
                .checkSubmitResult("Gender", "Other")
                .checkSubmitResult("Mobile", "1234567890")
                .checkSubmitResult("Date of Birth", "16 April,1975")
                .checkSubmitResult("Subjects", "English, Computer Science")
                .checkSubmitResult("Hobbies", "Reading, Music")
                .checkSubmitResult("Picture", "file_example_JPG_100kB.jpg")
                .checkSubmitResult("Address", "Test Street, 123")
                .checkSubmitResult("State and City", "Uttar Pradesh Merrut");
    }

    @Test
    void emptySubmitTest() {
        registrationPage.openPage().submit().checkValidation();
    }

}