package ru.levelp.at.lesson0507.selenium.page.objects.type.fluent;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.levelp.at.lesson0507.selenium.page.objects.BaseSeleniumTest;

class SampleFluentTest extends BaseSeleniumTest {

    private LoginRegistrationPage loginRegistrationPage;

    private String nameData;
    private String emailData;
    private String passwordData;

    @Override
    @BeforeEach
    public void setUp() {
        super.setUp();
        loginRegistrationPage = new LoginRegistrationPage(driver);

        nameData = faker.funnyName().name();
        emailData = faker.internet().emailAddress();
        passwordData = faker.internet().password();
    }

    @Test
    void registrationTest() {
        IndexPage indexPage = loginRegistrationPage
            .open()
            .fillNameTextField(nameData)
            .fillEmailTextField(emailData)
            .fillPasswordTextField(passwordData)
            .clickRegisterButton();

        var actualUsername = indexPage.getUserDropdownText();
        assertThat(actualUsername).isEqualToIgnoringCase(nameData);
    }

    @Test
    void registrationWithoutSubPageTest() {
        var actualUsername = loginRegistrationPage
            .open()
            .fillNameTextField(nameData)
            .fillEmailTextField(emailData)
            .fillPasswordTextField(passwordData)
            .successClickRegisterButton()
            .getUserDropdownText();

        assertThat(actualUsername).isEqualToIgnoringCase(nameData);
    }

    @Test
    void negativeRegistrationTest() {
        emailData = faker.internet().domainSuffix();

        String actualErrorMessageText = loginRegistrationPage
            .open()
            .fillNameTextField(nameData)
            .fillEmailTextField(emailData)
            .fillPasswordTextField(passwordData)
            .failClickRegisterButton()
            .getErrorMessageLabelText();

        assertThat(actualErrorMessageText).isEqualToIgnoringCase("register_not_correct_field (email)");
    }
}
