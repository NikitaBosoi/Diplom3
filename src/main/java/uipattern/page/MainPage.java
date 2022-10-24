package uipattern.page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private static WebDriver driver;

    //локатор кнопки Личный кабинет
    private By personalAccount = By.xpath("//p[contains(text(),'Личный Кабинет')]");

    //локатор кнопки Войти
    private By inputAccountOrder = By.cssSelector(".button_button__33qZ0.button_button_type_primary__1O7Bx.button_button_size_large__G21Vg");
    private By makeBurger = By.cssSelector(".text.text_type_main-large.mb-5.mt-10");

    //локаторы Конструктор
    private By bun = By.xpath(".//span[contains(text(),'Булки')]");
    private By sauce = By.xpath(".//span[contains(text(),'Соусы')]");
    private By filling = By.xpath(".//span[contains(text(),'Начинки')]");
    private By section = By.xpath("//*[@id='root']/div/main/section[1]/div[1]/div");

    public By getInputAccountOrder() {
        return inputAccountOrder;
    }

    public By getMakeBurger() {
        return makeBurger;
    }

    public By getSection() {
        return section;
    }

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //Методы
    // метод открытия страницы
    @Step
    public void openMainPage() {
        driver.get("https://stellarburgers.nomoreparties.site/");
    }

    // метод клика по кнопке Личный кабинет
    @Step
    public void clickPersonalAccount() {
        driver.findElement(personalAccount).click();
    }

    // метод клика по "Войти в аккаунт"
    @Step
    public void clickLoginAccount() {
        driver.findElement(inputAccountOrder).click();
    }

    //Конструктор
    // метод клика по "Соусы"
    @Step
    public void clickSauce() {
        driver.findElement(sauce).click();
    }

    // метод клика по "Начинки"
    @Step
    public void clickFilling() {
        driver.findElement(filling).click();
    }

    // метод клика по "Булки"
    @Step
    public void clickBun() {
        driver.findElement(bun).click();
    }

    // метод получения текста элемента
    @Step
    public String getActualText(By by) {
        return driver.findElement(by).getText();
    }

    @Step
    public String getElementClassName(By by, int index) {
        return driver.findElements(by).get(index).getAttribute("class");
    }
}
