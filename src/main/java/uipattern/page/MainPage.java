package uipattern.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private static WebDriver driver;

    //локатор кнопки Личный кабинет
    public By personalAccount = By.xpath(".//*[@id='root']/div/header/nav/a/p");

    //локатор кнопки Войти
    public By inputAccountOrder = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']");
    public By makeBurger = By.xpath(".//*[@id='root']/div/main/section[1]/h1");

    //локаторы Конструктор
    public By bun = By.xpath(".//*[@id='root']/div/main/section[1]/div[1]/div[1]");
    public By sauce = By.xpath(".//*[@id='root']/div/main/section[1]/div[1]/div[2]");
    public By filling = By.xpath(".//*[@id='root']/div/main/section[1]/div[1]/div[3]");
    public By section = By.xpath("//*[@id='root']/div/main/section[1]/div[1]/div");

    public MainPage(WebDriver driver) {
        this.driver = driver;
//        waitForLoad = new WaitForLoad(driver);
    }

    //Методы
    // метод открытия страницы
    public void openMainPage() {
        driver.get("https://stellarburgers.nomoreparties.site/");
    }

    // метод клика по кнопке Личный кабинет
    public void clickPersonalAccount() {
        driver.findElement(personalAccount).click();
    }

    // метод клика по "Войти в аккаунт"
    public void clickLoginAccount() {
        driver.findElement(inputAccountOrder).click();
    }

    //Конструктор
    // метод клика по "Соусы"
    public void clickSauce() {
        driver.findElement(sauce).click();
    }

    // метод клика по "Начинки"
    public void clickFilling() {
        driver.findElement(filling).click();
    }

    // метод клика по "Булки"
    public void clickBun() {
        driver.findElement(bun).click();
    }

    // метод получения текста элемента
    public String getActualText(By by) {
        return driver.findElement(by).getText();
    }

    public String getElementClassName(By by, int index) {
        return driver.findElements(by).get(index).getAttribute("class");
    }
}
