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
    private String name;
    private String email;
    private String password;
    private final String expectedErrorTextInvalidPassword = "Некорректный пароль";

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        objRegisterPage = new RegisterPage(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        name = System.currentTimeMillis() + "autotest";
        email = System.currentTimeMillis() + "@ya.ru";
        password = System.currentTimeMillis() + "password";
    }

    @Test
    @DisplayName("Регистрация пользователя")
    public void createNewUserTest() {
        objRegisterPage.openUrl();
        objRegisterPage.inputName(name);
        objRegisterPage.inputEmail(email);
        objRegisterPage.inputPassword(password);
        objRegisterPage.clickRegistrationButton();
        objRegisterPage.checkSuccessRegistration();
    }

    @Test
    @DisplayName("Проверяем ошибку 'Некорректный пароль' для невалидного пароля (< 6 символов)")
    public void checkErrorTextInvalidPasswordTest() {
        objRegisterPage.openUrl();
        objRegisterPage.inputName(name);
        objRegisterPage.inputEmail(email);
        objRegisterPage.inputPassword("passw");
        objRegisterPage.clickRegistrationButton();
        Assert.assertEquals(expectedErrorTextInvalidPassword, objRegisterPage.getErrorTextInvalidPassword());
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
