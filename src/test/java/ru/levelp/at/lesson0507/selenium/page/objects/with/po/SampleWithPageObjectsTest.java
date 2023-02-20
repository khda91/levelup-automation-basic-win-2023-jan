package ru.levelp.at.lesson0507.selenium.page.objects.with.po;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.levelp.at.lesson0507.selenium.page.objects.BaseSeleniumTest;

class SampleWithPageObjectsTest extends BaseSeleniumTest {

    private LoginRegistrationPage loginRegistrationPage;
    private IndexPage indexPage;

    private String nameData;
    private String emailData;
    private String passwordData;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        loginRegistrationPage = new LoginRegistrationPage(driver);
        indexPage = new IndexPage(driver);

        nameData = faker.funnyName().name();
        emailData = faker.internet().emailAddress();
        passwordData = faker.internet().password();
    }

    @Test
    void registrationTest() {
        loginRegistrationPage.open();
        loginRegistrationPage.fillNameTextField(nameData);
        loginRegistrationPage.fillEmailTextField(emailData);
        loginRegistrationPage.fillPasswordTextField(passwordData);
        loginRegistrationPage.clickRegisterButton();

        var actualUsername = indexPage.getUserDropdownText();
        assertThat(actualUsername).isEqualToIgnoringCase(nameData);
    }

    @Test
    void negativeRegistrationTest() {
        emailData = faker.internet().domainSuffix();

        loginRegistrationPage.open();
        loginRegistrationPage.fillNameTextField(nameData);
        loginRegistrationPage.fillEmailTextField(emailData);
        loginRegistrationPage.fillPasswordTextField(passwordData);
        loginRegistrationPage.clickRegisterButton();

        String actualErrorMessageText = loginRegistrationPage.getErrorMessageLabelText();
        assertThat(actualErrorMessageText).isEqualToIgnoringCase("register_not_correct_field (email)");
    }
}
