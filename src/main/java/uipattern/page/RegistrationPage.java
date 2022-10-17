package uipattern.page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RegistrationPage {

    private static WebDriver driver;
    private static WaitForLoad waitForLoad;

    //локатор кнопки Личный кабинет
    public By personalAccount = By.xpath(".//*[@id='root']/div/header/nav/a/p");

    //локатор перенаправления на форму Зарегистрироваться
    private By registr = By.xpath(".//*[@id='root']/div/main/div/div/p[1]/a");

    //входные данные для регистрации
    private By inputs = By.xpath(".//input[@class='text input__textfield text_type_main-default']");

    //локатор кнопки Зарегистрироваться
    public By registrationLogin = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");

    public By inputError = By.xpath(".//*[@id='root']/div/main/div/form/fieldset[3]/div/p");

    //авторизация с разных форм
    public By inputFromRegistr = By.xpath(".//*[@id='root']/div/main/div/div/p/a");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        waitForLoad = new WaitForLoad(driver);
    }


    // метод клика по кнопке Личный кабинет
    public void clickPersonalAccount() {
        driver.findElement(personalAccount).click();
    }

    // метод клика по "Зарегистрироваться"
    public void clickRegistr() {
        driver.findElement(registr).click();
    }

    //метод кликает по кнопке Войти с формы регистрации
    public void clickInputFromRegistr() {
        driver.findElement(inputFromRegistr).click();
    }

    //метод заполняет поле ввода Имя, Email, Пароль
    public void setInputsPersonalInfo(String name, String email, String password) {
        List<WebElement> listInputs = driver.findElements(inputs);
        listInputs.get(0).sendKeys(name);
        listInputs.get(1).sendKeys(email);
        listInputs.get(2).sendKeys(password);
    }

    //метод кликает по кнопке Зарегистрироваться
    public void clickRegistrationLoginButton() {
        driver.findElement(registrationLogin).click();
    }

    //Объединенный метод Регистрации пользователя
    @Step("User registration")
    public void registrationUser(String name, String email, String password) throws InterruptedException {
        waitForLoad.waitForLoadXpath(personalAccount);
        clickPersonalAccount();
        clickRegistr();
        setInputsPersonalInfo(name, email, password);
        clickRegistrationLoginButton();
        Thread.sleep(1000);
    }

    // метод получения текста элемента
    public String getActualText(By by) {
        return driver.findElement(by).getText();
    }

}
