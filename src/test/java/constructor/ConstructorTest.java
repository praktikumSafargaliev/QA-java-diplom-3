package constructor;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pom.MainPage;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.containsString;

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
    @DisplayName("Проверяем, что вкладка 'Булки' активна после нажатия")
    public void moveToBunTabTest() {
        objMainPage.openUrl();
        objMainPage.clickSauceTab();
        objMainPage.clickBunTab();
        Assert.assertThat(objMainPage.getClassNameBunTab(), containsString("current"));
    }

    @Test
    @DisplayName("Проверяем, что вкладка 'Соусы' активна после нажатия")
    public void moveToSauceTabTest() {
        objMainPage.openUrl();
        objMainPage.clickSauceTab();
        Assert.assertThat(objMainPage.getClassNameSauceTab(), containsString("current"));
    }

    @Test
    @DisplayName("Проверяем, что вкладка 'Начинки' активна после нажатия")
    public void moveToFillingTabTest() {
        objMainPage.openUrl();
        objMainPage.clickFillingTab();
        Assert.assertThat(objMainPage.getClassNameFillingTab(), containsString("current"));
    }

    @After
    public void tearDown() {
        driver.quit();
    }


}
