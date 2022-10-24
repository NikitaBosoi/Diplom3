package uipattern.page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {

    private static WebDriver driver;



    //Личный кабинет
    private By userAccount = By.cssSelector(".Account_text__fZAIn.text.text_type_main-default");
    private By constructor = By.xpath("//p[contains(text(),'Конструктор')]");
    private By logo = By.xpath(".//*[@id='root']/div/header/nav/div");
    private By logout = By.cssSelector(".Account_button__14Yp3.text.text_type_main-medium.text_color_inactive");

    public By getLogout(){
        return logout;
    }

    public By getUserAccount() {
        return userAccount;
    }

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    //метод кликает по кнопке Констуктор
    @Step
    public void clickConstructor() {
        driver.findElement(constructor).click();
    }

    //метод кликает по кнопке Логотипа
    @Step
    public void clickLogo() {
        driver.findElement(logo).click();
    }

    //метод кликает по кнопке Выход
    @Step
    public void clickLogout() {
        driver.findElement(logout).click();
    }

    // метод получения текста элемента
    @Step
    public String getActualText(By by) {
        return driver.findElement(by).getText();
    }
}
