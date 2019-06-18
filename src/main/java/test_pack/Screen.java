package test_pack;


import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.cropper.indent.BlurFilter;
import ru.yandex.qatools.ashot.cropper.indent.IndentCropper;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;

public class Screen {
    private WebDriver driver;
    private String path;

    Screen(WebDriver driver, String path) {
        this.driver = driver;
        this.path = path;
    }

    @Attachment(value = "{0}", type = "image/png")
    public byte[] saveAllureScreenshotError(String name) {
        return ((TakesScreenshot) (new Augmenter().augment(driver)))
                .getScreenshotAs(OutputType.BYTES);
    }

    public byte[] saveAllureScreenshot(String name) {
        return pageScreenAshot(name);
    }

    byte[] pageScreenAshot(String name) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] bytes = null;
        File to = new File(path + "\\" + name + ".png");
        try {
            Screenshot screenshot = new AShot().imageCropper(new IndentCropper(1000).addIndentFilter(new BlurFilter()))
                    .takeScreenshot(driver);
            BufferedImage img = screenshot.getImage();
            ImageIO.write(img, "png", to);
            ImageIO.write(img, "png", baos);
            baos.flush();
            bytes = baos.toByteArray();
            baos.close();
        } catch (Exception e) {
        }
        return bytes;
    }
}