import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pom.MainPage;

import java.util.concurrent.TimeUnit;

public class ConstructorTest {

    private WebDriver driver;
    private MainPage objMainPage;

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        objMainPage = new MainPage(driver);
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    }

    @Test
    @DisplayName("Проверяем переход к разделу 'Булки'")
    public void moveToBunTabTest() {
        objMainPage.openUrl();
        objMainPage.clickSauceTab();
        objMainPage.clickBunTab();
        objMainPage.checkDisplayBunHeading();
    }

    @Test
    @DisplayName("Проверяем переход к разделу 'Соусы'")
    public void moveToSauceTabTest() {
        objMainPage.openUrl();
        objMainPage.clickSauceTab();
        objMainPage.checkDisplaySauceHeading();
    }

    @Test
    @DisplayName("Проверяем переход к разделу 'Начинки'")
    public void moveToFillingTabTest() {
        objMainPage.openUrl();
        objMainPage.clickFillingTab();
        objMainPage.checkDisplayFillingHeading();
    }

    @After
    public void tearDown() {
        driver.quit();
    }


}
