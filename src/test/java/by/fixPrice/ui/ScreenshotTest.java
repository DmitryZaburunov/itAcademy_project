package by.fixPrice.ui;

import by.fixPrice.driver.Driver;
import by.fixPrice.pages.HomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.fail;

public class ScreenshotTest {

    @BeforeEach
    public void startUpScreenshotTests() {
        HomePage homePage = new HomePage();
        homePage.openPage();
        homePage.acceptCookies();
        homePage.openLoginForm();
    }

    @Test
    public void compareModalElementScreenshot() throws IOException {
        Screenshot actualScreenshot = new AShot().takeScreenshot(Driver.getDriver(),

                Driver.getDriver().findElement(By.xpath("//div[@id='modal']")));

        File expectedFile = new File("src/test/resources/screenshots/expected/modal.png");
        if (!expectedFile.exists()) {
            expectedFile.getParentFile().mkdirs();
            ImageIO.write(actualScreenshot.getImage(), "png", expectedFile);
        } else {
            ImageDiff diff = new ImageDiffer().makeDiff(ImageIO.read(expectedFile), actualScreenshot.getImage());
            if (diff.hasDiff()) {
                File diffFile = new File("src/test/resources/screenshots/diff/modal_diff.png");
                diffFile.getParentFile().mkdirs();
                ImageIO.write(diff.getMarkedImage(), "png", diffFile);
                fail("Скриншоты отличаются: " + diffFile.getAbsolutePath());
            }
        }
    }

    @AfterEach
    public void tearDown() {
        Driver.quitDriver();
    }
}
