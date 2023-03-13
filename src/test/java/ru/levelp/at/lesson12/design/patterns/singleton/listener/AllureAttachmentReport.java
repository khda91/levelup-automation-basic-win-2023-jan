package ru.levelp.at.lesson12.design.patterns.singleton.listener;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import ru.levelp.at.lesson11.jenkins.TestContext;

public class AllureAttachmentReport implements TestWatcher {

    @Override
    public void testSuccessful(ExtensionContext context) {
        System.out.println("testSuccessful");
        //        attach();
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        System.out.println("testAborted");
        // attach();
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        System.out.println("testFailed");
        // attach();
    }

    private void attach() {
        final WebDriver driver = (WebDriver) TestContext.getInstance().getObject("driver");
        attachScreenshot(driver);
        attachPageSource(driver);
    }

    @Attachment(type = "image/png", fileExtension = ".png")
    private byte[] attachScreenshot(final WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    private void attachPageSource(final WebDriver driver) {
        var ps = driver.getPageSource();
        Allure.addAttachment("page_source_code", "text/html", ps, ".html");
    }
}
