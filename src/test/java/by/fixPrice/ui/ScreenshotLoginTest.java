package by.fixPrice.ui;

import by.fixPrice.driver.Driver;
import by.fixPrice.pages.HomePage;
import by.fixPrice.pages.LoginPage;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.fail;

public class ScreenshotLoginTest {

    @BeforeEach
    public void startUpScreenshotTests() {
        HomePage homePage = new HomePage();
        homePage.openPage();
        homePage.acceptCookies();
        LoginPage loginPage = new LoginPage();
        loginPage.openLoginForm();
        loginPage.clickLoginFormToggleByEmail();
    }
    @Test
    public void compareModalElementScreenshot() throws IOException {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        WebElement modalElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='modal']")));

        Screenshot actualScreenshot = new AShot()
                .coordsProvider(new WebDriverCoordsProvider())
                .takeScreenshot(Driver.getDriver(), modalElement);

        File expectedFile = new File("src/test/resources/screenshots/expected/modal.png");

        if (!expectedFile.exists()) {
            expectedFile.getParentFile().mkdirs();
            ImageIO.write(actualScreenshot.getImage(), "png", expectedFile);
            System.out.println("Создан новый эталонный скриншот: " + expectedFile.getAbsolutePath());
        } else {
            BufferedImage expectedImage = ImageIO.read(expectedFile);
            ImageDiff diff = new ImageDiffer().makeDiff(expectedImage, actualScreenshot.getImage());

            if (diff.hasDiff()) {
                byte[] actualBytes = toByteArray(actualScreenshot.getImage());
                byte[] expectedBytes = Files.readAllBytes(expectedFile.toPath());
                byte[] diffBytes = toByteArray(diff.getMarkedImage());

                saveScreenshotToAllure("Фактический результат", actualBytes);
                saveScreenshotToAllure("Ожидаемый результат (Эталон)", expectedBytes);
                saveScreenshotToAllure("Различия (Diff)", diffBytes);

                File diffFile = new File("src/test/resources/screenshots/diff/modal_diff.png");
                diffFile.getParentFile().mkdirs();
                ImageIO.write(diff.getMarkedImage(), "png", diffFile);

                fail("Скриншоты отличаются! Проверьте вкладку Attachments в Allure.");
            }
        }
    }

    @Attachment(value = "{name}", type = "image/png")
    private byte[] saveScreenshotToAllure(String name, byte[] image) {
        return image;
    }

    private byte[] toByteArray(BufferedImage image) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "png", baos);
        return baos.toByteArray();
    }

    @AfterEach
    public void tearDown() {
        Driver.quitDriver();
    }
}
