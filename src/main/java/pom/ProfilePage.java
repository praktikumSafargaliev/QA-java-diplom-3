package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {

    private final WebDriver driver;
    private final String urlProfilePage = "https://stellarburgers.nomoreparties.site/account/profile";
    private final By nameInputField = By.xpath(".//div[label[text()='Имя']]/input");
    private final By exitButton = By.xpath(".//button[text()='Выход']");
    private final By constructorHeaderButton = By.xpath(".//a[p[text()='Конструктор']]");
    private final By logoHeaderButton = By.xpath(".//div/a[@href='/']");
    private final By enterButton = By.xpath(".//button[text()='Войти']");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Кликаем по кнопке 'Конструктор'")
    public void clickConstructorButton() {
        driver.findElement(constructorHeaderButton).click();
    }

    @Step("Кликаем по логотипу Stellar Burgers")
    public void clickLogo() {
        driver.findElement(logoHeaderButton).click();
    }

    @Step("Кликаем по кнопке 'Выйти'")
    public void clickExitButton() {
        driver.findElement(exitButton).click();
    }

    @Step("Получаем значение поля 'Имя'")
    public String getNameFieldValueAttribute() {
        return driver.findElement(nameInputField).getAttribute("value");
    }

    @Step("Проверяем успешный выход из аккаунта")
    public void checkSuccessLogout() {
        driver.findElement(enterButton).isDisplayed();
    }


}
