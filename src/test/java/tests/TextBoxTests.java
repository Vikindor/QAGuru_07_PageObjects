package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxTests extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void fillFormTest() {
        textBoxPage.openPage()
                .setUserName("Alex")
                .setUserEmail("alex@egorov.com")
                .setCurrentAddress("Some street 1")
                .setPermanentAddress("Another street 1")
                .submit()
                .checkOutput("name", "Alex")
                .checkOutput("email", "alex@egorov.com")
                .checkOutput("currentAddress", "Some street 1")
                .checkOutput("permanentAddress", "Another street 1");
    }

}