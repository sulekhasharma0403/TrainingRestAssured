package Tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

public class CreateCardOnBoard {
    @Test
    public void createCardAPI() {

        RestAssured.baseURI = "https://api.trello.com";

        HashMap<String, String> queryParamMap = new HashMap<>();
        queryParamMap.put("key", "dd486e53123b2dc7d557ce3167040cf6");
        queryParamMap.put("token", "ATTA07898ac4e95e6b359ac42d39a24124366703106b383b20cd1ab54460fd5b9955F7D3E4FD");
        queryParamMap.put("name", "Card2");
        queryParamMap.put("idList", "66c891f235a40d86c5604a29");

        Response response = RestAssured
                .given()
                .queryParams(queryParamMap)
                .log().all()
                .when()
                .body("")
                .post("/1/cards")
                .then()
                .extract()
                .response();

        System.out.println(response.prettyPrint());
        System.out.println(response.getStatusCode());
        System.out.println(response.body());

    }
}
