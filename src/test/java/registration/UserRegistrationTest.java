package registration;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pom.RegisterPage;
import java.util.concurrent.TimeUnit;

public class UserRegistrationTest {

    private WebDriver driver;
    private RegisterPage objRegisterPage;
    private final String name = System.currentTimeMillis() + "autotest";
    private final String email = System.currentTimeMillis() + "@ya.ru";
    private final String password = System.currentTimeMillis() + "password";
    private final String expectedErrorTextInvalidPassword = "Некорректный пароль";

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        objRegisterPage = new RegisterPage(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    @DisplayName("Регистрация пользователя")
    public void createNewUserTest() {
        objRegisterPage.registrationUser(name, email, password);
        objRegisterPage.checkSuccessRegistration();
    }

    @Test
    @DisplayName("Проверяем ошибку 'Некорректный пароль' для невалидного пароля (< 6 символов)")
    public void checkErrorTextInvalidPasswordTest() {
        objRegisterPage.registrationUser(name, email, "passw");
        Assert.assertEquals(expectedErrorTextInvalidPassword, objRegisterPage.getErrorTextInvalidPassword());
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
