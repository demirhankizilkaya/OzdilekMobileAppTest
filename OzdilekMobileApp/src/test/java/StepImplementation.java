import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import java.time.Duration;
import java.util.List;
import java.util.Random;


public class StepImplementation extends BaseTest {

    @Step("<time> saniye kadar bekle")
    public void waitForSeconds(int time) throws InterruptedException {
        Thread.sleep(time * 1000);
        Log4j.log.info(time + "-----Saniye Beklendi-----");


    }

    @Step("id <id> li elemente tıkla")
    public void clickByid(String id) {
        appiumDriver.findElement(By.id(id)).click();
        Log4j.log.info(id + "-----Elementine Tiklandi-----");

    }

    @Step("xpath <xpath> li elemana tıkla")
    public void clickXpathElement(String xpath) {
        appiumDriver.findElement(By.xpath(xpath)).click();
        Log4j.log.info(xpath + "-----Elementine Tiklandi-----");

    }


    @Step("Elementler <xpath> arasından rasgele bir tanesini seç ve tıkla")
    public void clickRandomElement(String xpath) {
        Random random = new Random();
        List<MobileElement> products = appiumDriver.findElements(By.xpath(xpath));
        int index = random.nextInt(products.size());
        products.get(index).click();
        Log4j.log.info(xpath + "-----Random Urun Secildi-----");

    }

    @Step("<id> id'sine <text> textini yaz")
    public void sendKeysById(String id, String text) {
        appiumDriver.findElement(By.id(id)).sendKeys(text);
    }

    @Step("id <id> li elementi bul ve <text> alanını kontrol et")
    public void textAreaControlById(String id, String text) {
        Assert.assertTrue("----------Element text değerine sahip----------"
                , appiumDriver.findElement(By.id(id)).getText().contains(text));
        Log4j.log.info("-----Text Kontrol Edildi-----");

    }

    @Step("xpath <xpath> li elementi bul ve <text> alanını kontrol et")
    public void textAreaControlByXpath(String xpath, String text) {
        Assert.assertTrue("----------Element Text Değerine Sahip Değil----------"
                , appiumDriver.findElement(By.xpath(xpath)).getText().contains(text));
        Log4j.log.info("----Text Kontrol Edildi-----");
    }

    @Step("Sayfayı aşağıya kaydır")
    public void swipeBottom() {

        final int PRESS_TIME = 200; // ms
        PointOption pointOptionStart, pointOptionEnd;
        Dimension dims = appiumDriver.manage().window().getSize();
        pointOptionStart = PointOption.point(dims.width / 2, (int) (dims.height * 0.90));
        pointOptionEnd = PointOption.point(dims.width / 2, (int) (dims.height * 0.10));
        for (int i = 0; i <2 ; i++) {
            new TouchAction(appiumDriver)
                    .press(pointOptionStart)
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                    .moveTo(pointOptionEnd)
                    .release().perform();

            // Diğer bir scroll yöntemi
        /*TouchAction action = new TouchAction(appiumDriver);
        Dimension size = appiumDriver.manage().window().getSize();
        int width = size.width;
        int height = size.height;
        int middleOfX = width / 2;
        int pointOptionStart = (int) (height * .9);
        int endYCoordinate = (int) (height * .0);
        for (int i = 1; i < 3; i++) {
            action.press(PointOption.point(middleOfX, pointOptionStart))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                    .moveTo(PointOption.point(middleOfX, endYCoordinate)).release().perform();*/
            Log4j.log.info("-----Asagıya Scroll Edildi-----");

        }


    }
}
