package Authorisation;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pom.LoginPage;
import pom.MainPage;
import pom.RecoveryPasswordPage;
import pom.RegisterPage;

import java.util.concurrent.TimeUnit;

public class AuthorisationTest {

    private WebDriver driver;
    private MainPage objMainPage;
    private LoginPage objLoginPage;
    private RegisterPage objRegisterPage;
    private RecoveryPasswordPage objRecoveryPasswordPage;

    private final String name = System.currentTimeMillis() + "autotest";
    private final String email = System.currentTimeMillis() + "@ya.ru";
    private final String password = System.currentTimeMillis() + "password";

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        objMainPage = new MainPage(driver);
        objRegisterPage = new RegisterPage(driver);
        objLoginPage = new LoginPage(driver);
        objRecoveryPasswordPage = new RecoveryPasswordPage(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        objRegisterPage.registrationUser(name, email, password);
    }

    @Test
    @DisplayName("Авторизация пользователя по кнопке 'Войти в аккаунт' на главной странице")
    public void userAuthorisationFromMainPageEnterButtonTest() {
        objMainPage.openUrl();
        objMainPage.clickEnterButton();
        objLoginPage.userAuthorisation(email, password);
        objLoginPage.checkSuccessAuthorisation();
    }

    @Test
    @DisplayName("Авторизация пользователя через кнопку 'Личный кабинет'")
    public void userAuthorisationFromMainPageHeaderButtonTest() {
        objMainPage.openUrl();
        objMainPage.clickPersonalAreaButton();
        objLoginPage.userAuthorisation(email, password);
        objLoginPage.checkSuccessAuthorisation();
    }

    @Test
    @DisplayName("Авторизация пользователя через кнопку 'Войти' в форме регистрации")
    public void userAuthorisationFromRegisterPageEnterButtonTest() {
        objRegisterPage.openUrl();
        objRegisterPage.clickEnterButton();
        objLoginPage.userAuthorisation(email, password);
        objLoginPage.checkSuccessAuthorisation();
    }

    @Test
    @DisplayName("Авторизация пользователя через кнопку 'Войти' в форме восстановления пароля")
    public void userAuthorisationFromRecoveryPageEnterButtonTest() {
        objRecoveryPasswordPage.openUrl();
        objRecoveryPasswordPage.clickEnterButton();
        objLoginPage.userAuthorisation(email, password);
        objLoginPage.checkSuccessAuthorisation();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
