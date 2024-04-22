package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.ApiPage;

public class ApiStep {

    ApiPage apiPage;

    public ApiStep() {
        this.apiPage = new ApiPage();
    }

    @Given("prepare url for {string}")
    public void prepareUrlFor(String url) {
        apiPage.prepareUrlFor(url);
    }

    @And("hit get API get list user")
    public void hitGetAPIGetListUser() {
        apiPage.hitGetAPIGetListUser();
    }

    @Then("validation status code is equals {int}")
    public void validationStatusCodeIsEquals(int statusCode) {
        System.out.println(statusCode);
        apiPage.validationStatusCodeIsEquals(statusCode);
    }

    @Then("validation response body get list users")
    public void validationResponseBodyGetListUsers() {
        apiPage.validationResponseBodyGetListUsers();
    }

    @Then("validation response json with JSONSchema {string}")
    public void validationResponseJsonWithJSONSchema(String fileName) {
        apiPage.validationResponseJsonWithJSONSchema(fileName);
    }

    @And("hit get API post create new user")
    public void hitGetAPIPostCreateNewUser() {
        apiPage.hitAPICreateNewUser();
    }

    @Then("validation response body create users")
    public void validationResponseBodyCreateUsers() {
        apiPage.validationResponseBodyCreateUsers();

    }


    @And("hit get API delete new user")
    public void hitGetAPIDeleteNewUser() {
        apiPage.hitGetAPIDeleteNewUser();

    }

    @And("hit get API delete user")
    public void hitGetAPIDeleteUser() {
        apiPage.deleteUser();
    }

    @And("hit get API update new user")
    public void hitGetAPIUpdateNewUser() {
        apiPage.hitGetAPIUpdateNewUser();
    }

    @Then("validation response body update users")
    public void validationResponseBodyUpdateUsers() {
        apiPage.validationResponseBodyUpdateUsers();

    }
}
