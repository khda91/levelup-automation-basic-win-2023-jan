package ru.levelp.at.lesson11.jenkins.listener;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import ru.levelp.at.lesson11.jenkins.TestContext;

public class AllureAttachmentCallback implements AfterTestExecutionCallback {

    @Override
    public void afterTestExecution(ExtensionContext context) throws Exception {
        System.out.println("afterTestExecution");
        if (context.getExecutionException().isPresent()) {
            System.out.println("Делаем скриншот");
            attach();
        }
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
