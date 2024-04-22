package pages;

import helper.Endpoint;
import helper.Models;
import helper.Utility;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.File;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ApiPage {

    //logic semuanya dilakukan disini dan helper. tidak boleh di step , karena PMO

    String setUpUrl, globalId;

    Response res;

    public void prepareUrlFor(String url) {
        switch (url) {
            case "GET_LIST_USERS":
                setUpUrl = Endpoint.GET_LIST_USERS;
                break;
            case "CREATE_NEW_USERS":
                setUpUrl = Endpoint.CREATE_NEW_USERS;
                break;
            case "DELETE_USERS":
                setUpUrl = Endpoint.DELETE_USERS;
                break;
            case "POST_USERS":
                setUpUrl = Endpoint.POST_USERS;
                break;
            case "PATCH_USERS":
                setUpUrl = Endpoint.PATCH_USERS;
                break;
            case "PUT_USERS":
                setUpUrl = Endpoint.PUT_USERS;
                break;
            default:
                System.out.println("input valid url :)");
        }
    }

    public void hitGetAPIGetListUser() {
        res = Models.getListUsers(setUpUrl);
        System.out.println(res.getBody().asString()); //untuk nge print bodynya
    }

    public void validationStatusCodeIsEquals(int statusCode) {
        //res sudah diambil dari retrun dari getListUsers di baris 43
        assertThat(res.statusCode()).isEqualTo(statusCode);
    }

    public void validationResponseBodyGetListUsers() {
        //karena tipenya list kita buat dlu listnya terus di dpat dari responnya
        List<Object> id = res.jsonPath().getList("id");
        List<Object> name = res.jsonPath().getList("name");
        List<Object> email = res.jsonPath().getList("email");
        List<Object> gender = res.jsonPath().getList("gender");
        List<Object> status = res.jsonPath().getList("status");


        assertThat(id.get(0)).isNotNull();
        assertThat(name.get(0)).isNotNull();
        assertThat(email.get(0)).isNotNull();
        assertThat(gender.get(0)).isIn("female","male"); //maksudnya adalah ini harus female atau male kalau tidak dia akan error
        assertThat(status.get(0)).isIn("active","inactive");
    }

    public void validationResponseJsonWithJSONSchema(String fileName) {
        File JSONFile = Utility.getJSONSchemaFile(fileName); //dari utility
        res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JSONFile));
    }

    public void hitAPICreateNewUser() {
        res = Models.postCreatNewUser(setUpUrl);
        System.out.println(res.getBody().asString()); //untuk nge print bodynya
    }
    public void validationResponseBodyCreateUsers() {
        JsonPath jsonPathEvaluator = res.jsonPath(); //dari response kita ambil json nya
        Integer id = jsonPathEvaluator.get("id"); //makanya integer id ngambil id
        String name = jsonPathEvaluator.get("name"); //name ngambil name ditampung sebagai string
        String email = jsonPathEvaluator.get("email");
        String gender = jsonPathEvaluator.get("gender");
        String status = jsonPathEvaluator.get("status");

        assertThat(id).isNotNull(); //kemudian di assert/dibandingkan dia null atau tidak
        assertThat(name).isNotNull();
        assertThat(email).isNotNull();
        assertThat(gender).isIn("female","male");
        assertThat(status).isIn("active","inactive"); //harus diantara kedua ini

        globalId = Integer.toString(id);

    }

    public void hitGetAPIDeleteNewUser() {
        res = Models.hitGetAPIDeleteNewUser(setUpUrl,globalId);

    }

    public void deleteUser(){ //gimana ya kalo dia mencari sendiri id nya
        res = Models.deletetingUser(setUpUrl,globalId);

    }

    public void hitGetAPIUpdateNewUser() {
        res = Models.hitGetAPIUpadateNewUser(setUpUrl,globalId);

    }

    public void validationResponseBodyUpdateUsers() {
        JsonPath jsonPathEvaluator = res.jsonPath(); //dari response kita ambil json nya
        Integer id = jsonPathEvaluator.get("id"); //makanya integer id ngambil id
        String name = jsonPathEvaluator.get("name"); //name ngambil name ditampung sebagai string
        String email = jsonPathEvaluator.get("email");
        String gender = jsonPathEvaluator.get("gender");
        String status = jsonPathEvaluator.get("status");

        assertThat(id).isNotNull(); //kemudian di assert/dibandingkan dia null atau tidak
        assertThat(name).isNotNull();
        assertThat(email).isNotNull();
        assertThat(gender).isIn("female","male");
        assertThat(status).isIn("active","inactive"); //harus diantara kedua ini

    }


}
