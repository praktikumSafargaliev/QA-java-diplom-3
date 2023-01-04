package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    private final WebDriver driver;
    private final String urlRegistrationPage = "https://stellarburgers.nomoreparties.site/register";    // URL страницы регистрации
    private final By nameInputField = By.xpath(".//div[label[text()='Имя']]/input");
    private final By emailInputField = By.xpath(".//div[label[text()='Email']]/input");
    private final By passwordInputField = By.xpath(".//div[label[text()='Пароль']]/input");
    private final By registrationButton = By.xpath(".//button[text()='Зарегистрироваться']");
    private final By enterButton = By.xpath(".//button[text()='Войти']");
    private final By invalidPasswordErrorText = By.xpath(".//p[text()='Некорректный пароль']");
    private final By enterLink = By.xpath(".//a[text()='Войти']");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открываем страницу")
    public void openUrl() {
        driver.get(urlRegistrationPage);
    }

    @Step("Вводим имя")
    public void inputName(String name) {
        driver.findElement(nameInputField).sendKeys(name);
    }

    @Step("Вводим email")
    public void inputEmail(String email) {
        driver.findElement(emailInputField).sendKeys(email);
    }

    @Step("Вводим пароль")
    public void inputPassword(String password) {
        driver.findElement(passwordInputField).sendKeys(password);
    }

    @Step("Кликаем по кнопке регистрации")
    public void clickRegistrationButton() {
        driver.findElement(registrationButton).click();
    }

    @Step("Проверяем, что регистрация прошла (отображается кнопка входа)")
    public void checkSuccessRegistration() {
        driver.findElement(enterButton).isDisplayed();
    }

    @Step("Получаем для сравнения текст ошибки при некорректном пароле")
    public String getErrorTextInvalidPassword() {
        return driver.findElement(invalidPasswordErrorText).getText();
    }

    @Step("Кликаем по кнопке 'Войти'")
    public void clickEnterButton() {
        driver.findElement(enterLink).click();
    }

    @Step("Регистрируем нового пользователя")
    public void registrationUser(String name, String email, String password) {
        openUrl();
        inputName(name);
        inputEmail(email);
        inputPassword(password);
        clickRegistrationButton();
    }

}
