package Tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.log4j.ConsoleAppender;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.HashMap;

public class TrainingRA2024 {
    @Test(enabled = false)
    public void firstPostAPI() {

        RestAssured.baseURI = "https://api.trello.com";

        HashMap<String, String> hm = new HashMap<>();
        hm.put("Content-Type","application/json");
        hm.put("Accept", "*/*");

        HashMap<String, String> queryParamMap = new HashMap<>();
        queryParamMap.put("key", "dd486e53123b2dc7d557ce3167040cf6");
        queryParamMap.put("token", "ATTA07898ac4e95e6b359ac42d39a24124366703106b383b20cd1ab54460fd5b9955F7D3E4FD");
        queryParamMap.put("name", "Trello Board-RestAssured-Automation");
        queryParamMap.put("desc", "My first board from Rest Assured Automation");
        queryParamMap.put("defaultLabels", "true");
        queryParamMap.put("defaultLists", "true");
        queryParamMap.put("prefs_permissionLevel", "private");


        Response response = RestAssured
                .given()
                .headers(hm)
                .queryParams(queryParamMap)
                .log().all()
                .when()
                .body("")
                .post("/1/boards")
                .then()
                .extract()
                .response();

        System.out.println(response.prettyPrint());
        System.out.println(response.getStatusCode());
        System.out.println(response.body());

    }


    @Test(enabled = false)
    public void firstGetAPI() {
        Response response = RestAssured
                .get("https://api.trello.com/1/boards/66bf23518da2a9c89f6dfa8f?key=dd486e53123b2dc7d557ce3167040cf6&token=ATTA07898ac4e95e6b359ac42d39a24124366703106b383b20cd1ab54460fd5b9955F7D3E4FD")
                .then().extract().response();
        System.out.println(response.asString());

    }

    @Test(enabled = true)
    public void secondGetAPI() {
        RestAssured.baseURI = "https://api.trello.com";
        Response response = RestAssured
                .given()
                .pathParam("boardId", "66bf23518da2a9c89f6dfa8f")
                .queryParam("key", "dd486e53123b2dc7d557ce3167040cf6")
                .queryParam("token", "ATTA07898ac4e95e6b359ac42d39a24124366703106b383b20cd1ab54460fd5b9955F7D3E4FD")
                .when()
                .get("1/boards/{boardId}")
                .then()
                .extract()
                .response();
        System.out.println(response.prettyPrint());

    }

    @Test(enabled = false)
    public void thirdGetAPI() {
        RestAssured.baseURI = "https://api.trello.com";

        HashMap<String, String> hm = new HashMap<>();
        hm.put("key", "dd486e53123b2dc7d557ce3167040cf6");
        hm.put("token", "ATTA07898ac4e95e6b359ac42d39a24124366703106b383b20cd1ab54460fd5b9955F7D3E4FD");

        Response response = RestAssured
                .given()
                .pathParam("boardId", "66bf23518da2a9c89f6dfa8f")
                .queryParams(hm)
                .when()
                .get("1/boards/{boardId}")
                .then()
                .extract()
                .response();
        System.out.println(response.prettyPrint());
        response.then().statusCode(200);
    }

    @Test()
    public void firstPutAPI() {
        RestAssured.baseURI = "https://api.trello.com";

        HashMap<String, String> hm = new HashMap<>();
        hm.put("Content-Type","application/json");
        hm.put("Accept", "*/*");

        HashMap<String, String> queryParamMap = new HashMap<>();
        queryParamMap.put("key", "dd486e53123b2dc7d557ce3167040cf6");
        queryParamMap.put("token", "ATTA07898ac4e95e6b359ac42d39a24124366703106b383b20cd1ab54460fd5b9955F7D3E4FD");
        queryParamMap.put("name", "Trello Board-RestAssured-Automation-Put Update");

        Response response = RestAssured
                .given()
                .headers(hm)
                .pathParam("boardId","66c5a4b10169a92b500b7c53")
                .queryParams(queryParamMap)
                .when()
                .body("")
                .put("/1/boards/{boardId}")
                .then()
                .extract()
                .response();

        System.out.println(response.prettyPrint());
        System.out.println(response.getStatusCode());
        System.out.println(response.body());
    }

    @Test(enabled = false)
    public void firstPatchAPI() {

    }
    @Test(enabled = false)
    public void firstDeleteAPI() {
        RestAssured.baseURI = "https://api.trello.com";
        HashMap<String, String> hm = new HashMap<>();
        hm.put("key", "dd486e53123b2dc7d557ce3167040cf6");
        hm.put("token", "ATTA07898ac4e95e6b359ac42d39a24124366703106b383b20cd1ab54460fd5b9955F7D3E4FD");

        Response response = RestAssured
                .given()
                .pathParam("boardId", "66c596e13885c158cf33eb07")
                .queryParams(hm)
                .when()
                .delete("1/boards/{boardId}")
                .then()
                .extract()
                .response();
        System.out.println(response.prettyPrint());
        System.out.println(response.statusCode());
    }
}
