package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static constants.Constant.URL_RECOVERY_PASSWORD_PAGE;

public class RecoveryPasswordPage {

    private final WebDriver driver;
    private final By enterLink = By.xpath(".//a[text()='Войти']");

    public RecoveryPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открываем страницу")
    public void openUrl() {
        driver.get(URL_RECOVERY_PASSWORD_PAGE);
    }

    @Step("Кликаем по кнопке 'Войти'")
    public void clickEnterButton() {
        driver.findElement(enterLink).click();
    }
}
