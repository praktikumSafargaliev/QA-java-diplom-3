package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecoveryPasswordPage {

    private final WebDriver driver;
    private final String urlRecoveryPasswordPage = "https://stellarburgers.nomoreparties.site/forgot-password";
    private final By enterLink = By.xpath(".//a[text()='Войти']");

    public RecoveryPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открываем страницу")
    public void openUrl() {
        driver.get(urlRecoveryPasswordPage);
    }

    @Step("Кликаем по кнопке 'Войти'")
    public void clickEnterButton() {
        driver.findElement(enterLink).click();
    }
}
