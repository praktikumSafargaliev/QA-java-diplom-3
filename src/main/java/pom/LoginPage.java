package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final WebDriver driver;
    private final String urlLoginPage = "https://stellarburgers.nomoreparties.site/login";
    private final By enterButton = By.xpath(".//button[text()='Войти']");
    private final By emailInputField = By.xpath(".//div[label[text()='Email']]/input");
    private final By passwordInputField = By.xpath(".//div[label[text()='Пароль']]/input");
    private final By mainPageBurgerIngredientsSection = By.xpath(".//section[@Class='BurgerIngredients_ingredients__1N8v2']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открываем страницу")
    public void openUrl() {
        driver.get(urlLoginPage);
    }

    @Step("Вводим имя")
    public void inputEmail(String email) {
        driver.findElement(emailInputField).sendKeys(email);
    }

    @Step("Вводим пароль")
    public void inputPassword(String password) {
        driver.findElement(passwordInputField).sendKeys(password);
    }

    @Step("Кликаем кнопку 'Войти'")
    public void clickEnterButton() {
        driver.findElement(enterButton).click();
    }

    @Step("Авторизация пользователя")
    public void userAuthorisation(String email, String password) {
        inputEmail(email);
        inputPassword(password);
        clickEnterButton();
    }

    @Step("Проверяем успешную авторизацию")
    public void checkSuccessAuthorisation() {
        driver.findElement(mainPageBurgerIngredientsSection).isDisplayed();
    }
}
