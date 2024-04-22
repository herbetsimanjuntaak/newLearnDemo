package helper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import static helper.Utility.generateRandomEmail;

public class Models {
    //semua hit akan dijalankan dari sini
    //komunikasi dengan restassured untuk hit apapun yang ingin dilakukan

    private static RequestSpecification request;

    public static void setUpHeaders() { //code ini hanya untuk cleen code aja , supaya kita disetiap hit tidak capek buat headers nya
        request = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization", "Bearer 2259048ef8b50ff36a730b1d6dcd5962cd3c9aa5210a7b4ca68b92c36d8abfc9");
    }

    public static Response getListUsers(String endpoint) {
        System.out.println("Endpoint yang dilempar : " + endpoint); // ini di dpat dari api page bari 15
        setUpHeaders();
        return request.when().get(endpoint);
    }

    public static Response postCreatNewUser(String endpoint) {
        String name = "Herbet Simanjuntak";
        String gender = "male";
        String email = generateRandomEmail(); //karena email tidak boleh sama/ email yang udah dipakai tidak boleh dipakai lagi  maka buat function dlu di class utility
        String status = "active";
        JSONObject payload = new JSONObject();
        payload.put("name", name);
        payload.put("gender", gender);
        payload.put("email", email);
        payload.put("status", status);
        setUpHeaders();
        return request.body(payload.toString()).when().post(endpoint);

        //pertanyaan herbet disini bukannya otomatis ya untuk buat create user ?
        //kenpa kita sendiri yang isi user
    }

    public static Response hitGetAPIDeleteNewUser(String endpoint, String user_id) {
        setUpHeaders();
        String finalEndpoint = endpoint+"/"+user_id;
        return request.when().delete(finalEndpoint);

    }

    public static Response deletetingUser(String endpoint,String user_id){
        setUpHeaders();
        String finalEndpoint = endpoint+"/"+user_id;
        return request.when().delete(finalEndpoint);
    }

    public static Response hitGetAPIUpadateNewUser(String endpoint, String user_id) {
        setUpHeaders();
        String name = "Herbet EDIT";
        String gender = "male";
        String email = generateRandomEmail(); //karena email tidak boleh sama/ email yang udah dipakai tidak boleh dipakai lagi  maka buat function dlu di class utility
        String status = "active";
        JSONObject payload = new JSONObject();
        payload.put("name", name);
        payload.put("gender", gender);
        payload.put("email", email);
        payload.put("status", status);
        String finalEndpoint = endpoint+"/"+user_id;
        return request.body(payload.toString()).when().patch(finalEndpoint);

    }
}
