package Tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

public class UpdateCards_Put {

    @Test(enabled = true)
    public void updateLabelPutAPI() {
        RestAssured.baseURI = "https://api.trello.com";

        HashMap<String, String> queryParamMap = new HashMap<>();
        queryParamMap.put("key", "dd486e53123b2dc7d557ce3167040cf6");
        queryParamMap.put("token", "ATTA07898ac4e95e6b359ac42d39a24124366703106b383b20cd1ab54460fd5b9955F7D3E4FD");

        Response response = RestAssured
                .given()
                .pathParam("cardId", "66c89dc9a94f2e8d72901834")
                .queryParams(queryParamMap)
                .when()
                .body("")
                .put("/1/cards/{cardId}")
                .then()
                .extract()
                .response();

        System.out.println(response.prettyPrint());
        System.out.println(response.getStatusCode());
        System.out.println(response.body());
    }

}