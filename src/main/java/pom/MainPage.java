package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private final WebDriver driver;
    private final String urlMainPage = "https://stellarburgers.nomoreparties.site";
    private final By enterButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By personalAreaHeaderButton = By.xpath(".//a[@href='/account']");
    private final By bunConstructorButton = By.xpath(".//span[text()='Булки']");
    private final By sauceConstructorButton = By.xpath(".//span[text()='Соусы']");
    private final By fillingConstructorButton = By.xpath(".//span[text()='Начинки']");
    private final By burgerIngredientsSection = By.xpath(".//section[@Class='BurgerIngredients_ingredients__1N8v2']");
    private final By bunTabHeading = By.xpath(".//h2[text()='Булки']");
    private final By sauceTabHeading = By.xpath(".//h2[text()='Соусы']");
    private final By fillingTabHeading = By.xpath(".//h2[text()='Начинки']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открываем страницу")
    public void openUrl() {
        driver.get(urlMainPage);
    }

    @Step("Кликаем кнопку 'Войти в аккаунт'")
    public void clickEnterButton() {
        driver.findElement(enterButton).click();
    }

    @Step("Кликаем кнопку 'Личный кабинет'")
    public void clickPersonalAreaButton() {
        driver.findElement(personalAreaHeaderButton).click();
    }

    @Step("Проверяем, что отображается конструктор ингредиентов")
    public void checkDisplayConstructor() {
        driver.findElement(burgerIngredientsSection).isDisplayed();
    }

    @Step("Клик на вкладку 'Булки'")
    public void clickBunTab() {
        driver.findElement(bunConstructorButton).click();
    }

    @Step("Клик на вкладку 'Соусы'")
    public void clickSauceTab() {
        driver.findElement(sauceConstructorButton).click();
    }

    @Step("Клик на вкладку 'Начинки'")
    public void clickFillingTab() {
        driver.findElement(fillingConstructorButton).click();
    }

    @Step("Проверяем, что отображается заголовок 'Булки'")
    public void checkDisplayBunHeading() {
        driver.findElement(bunTabHeading).isDisplayed();
    }

    @Step("Проверяем, что отображается заголовок 'Соусы'")
    public void checkDisplaySauceHeading() {
        driver.findElement(sauceTabHeading).isDisplayed();
    }

    @Step("Проверяем, что отображается заголовок 'Начинки'")
    public void checkDisplayFillingHeading() {
        driver.findElement(fillingTabHeading).isDisplayed();
    }

}
