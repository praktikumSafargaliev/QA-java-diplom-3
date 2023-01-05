package PersonalArea;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pom.*;

import java.util.concurrent.TimeUnit;

public class PersonalAreaTest {

    private WebDriver driver;
    private MainPage objMainPage;
    private ProfilePage objProfilePage;
    private LoginPage objLoginPage;
    private RegisterPage objRegisterPage;

    private final String name = System.currentTimeMillis() + "autotest";
    private final String email = System.currentTimeMillis() + "@ya.ru";
    private final String password = System.currentTimeMillis() + "password";

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        objMainPage = new MainPage(driver);
        objProfilePage = new ProfilePage(driver);
        objRegisterPage = new RegisterPage(driver);
        objLoginPage = new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        objRegisterPage.registrationUser(name, email, password);
    }

    @Test
    @DisplayName("Переход в личный кабинет")
    public void moveToPersonalAreaTest() {
        objLoginPage.openUrl();
        objLoginPage.userAuthorisation(email, password);
        objMainPage.clickPersonalAreaButton();
        Assert.assertEquals(name, objProfilePage.getNameFieldValueAttribute());
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на кнопку 'Конструктор'")
    public void moveToConstructorFromPersonalAreaConstructorButtonTest() {
        objLoginPage.openUrl();
        objLoginPage.userAuthorisation(email, password);
        objMainPage.clickPersonalAreaButton();
        objProfilePage.clickConstructorButton();
        objMainPage.checkDisplayConstructor();
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор по клику на логотип Stellar Burgers")
    public void moveToConstructorFromPersonalAreaLogoTest() {
        objLoginPage.openUrl();
        objLoginPage.userAuthorisation(email, password);
        objMainPage.clickPersonalAreaButton();
        objProfilePage.clickLogo();
        objMainPage.checkDisplayConstructor();
    }

    @Test
    @DisplayName("Выход из аккаунта по кнопке 'Выйти'")
    public void logoutUserTest() {
        objLoginPage.openUrl();
        objLoginPage.userAuthorisation(email, password);
        objMainPage.clickPersonalAreaButton();
        objProfilePage.clickExitButton();
        objProfilePage.checkSuccessLogout();
    }


    @After
    public void tearDown() {
        driver.quit();
    }

}
