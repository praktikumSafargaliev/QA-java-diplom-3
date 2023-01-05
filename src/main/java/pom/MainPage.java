package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private final WebDriver driver;
    private final String urlMainPage = "https://stellarburgers.nomoreparties.site";
    private final By enterButton = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By personalAreaHeaderButton = By.xpath(".//a[@href='/account']");
    private final By bunConstructorButton = By.xpath(".//div[./span[text()='Булки']]");
    private final By sauceConstructorButton = By.xpath(".//div[./span[text()='Соусы']]");
    private final By fillingConstructorButton = By.xpath(".//div[./span[text()='Начинки']]");
    private final By burgerIngredientsSection = By.xpath(".//section[@Class='BurgerIngredients_ingredients__1N8v2']");

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

    @Step("Получаем имя класса у вкладки 'Булки'")
    public String getClassNameBunTab() {
        return driver.findElement(bunConstructorButton).getAttribute("class");
    }

    @Step("Получаем имя класса у вкладки 'Соусы'")
    public String getClassNameSauceTab() {
        return driver.findElement(sauceConstructorButton).getAttribute("class");
    }

    @Step("Получаем имя класса у вкладки 'Начинки'")
    public String getClassNameFillingTab() {
        return driver.findElement(fillingConstructorButton).getAttribute("class");
    }

}
