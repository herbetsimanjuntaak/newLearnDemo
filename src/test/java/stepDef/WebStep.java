package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pages.WebPage;

public class WebStep {

    WebPage webPage;

    public WebStep() {
        this.webPage = new WebPage();
    }

    @Given("open web login page")
    public void openWebLoginPage() {
        webPage.openBrowser();

    }


    @And("user input username {string}")
    public void userInputUsername(String username) {
        webPage.setInput_username(username);
    }

    @And("user input password {string}")
    public void userInputPassword(String password) {
        webPage.setInput_password(password);
    }

    @And("user click login button")
    public void userClickLoginButton() {
        webPage.click_button_login();
    }

    @And("user will see icon cart in homepage")
    public void userWillSeeIconCartInHomepage() {
        webPage.assertHomePage();
    }
}
