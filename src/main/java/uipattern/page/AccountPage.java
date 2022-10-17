package uipattern.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {

    private static WebDriver driver;

    //Личный кабинет
    public By userAccount = By.xpath(".//*[@id='root']/div/main/div/nav/p");
    public By constructor = By.xpath(".//*[@id='root']/div/header/nav/ul/li[1]/a/p");
    public By logo = By.xpath(".//*[@id='root']/div/header/nav/div");
    public By logout = By.xpath(".//*[@id='root']/div/main/div/nav/ul/li[3]/button");

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    //метод кликает по кнопке Констуктор
    public void clickConstructor() {
        driver.findElement(constructor).click();
    }

    //метод кликает по кнопке Логотипа
    public void clickLogo() {
        driver.findElement(logo).click();
    }

    //метод кликает по кнопке Выход
    public void clickLogout() {
        driver.findElement(logout).click();
    }

    // метод получения текста элемента
    public String getActualText(By by) {
        return driver.findElement(by).getText();
    }
}
