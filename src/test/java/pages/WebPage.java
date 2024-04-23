package pages;

import org.openqa.selenium.By;

import static helper.Utility.driver;

public class WebPage {
    By input_username = By.id("user-name");
    By input_password = By.id("password");
    By login_button = By.id("login-button");
    By icon_cart = By.xpath("//a[@class='shopping_cart_link']");


    public void openBrowser(){
        driver.get("https://www.saucedemo.com/"); //untuk web yang kita mau test
    }

    public void setInput_username(String username){ //berdasarkan feature filenya/ web feature
        driver.findElement(input_username).sendKeys(username); // jadi ini tuh dari selector baris 8
    }

    public void setInput_password(String password){ //berdasarkan feature filenya/ web feature
        driver.findElement(input_password).sendKeys(password); // jadi ini tuh dari selector baris 9 dan key parameter dari feature
    }

    public void click_button_login(){
        driver.findElement(login_button).click(); // jadi ini tuh dari selector baris 10
    }

    public void assertHomePage(){
        driver.findElement(icon_cart).isDisplayed(); // jadi ini tuh dari selector baris 11 yang di inspect
    }
}
