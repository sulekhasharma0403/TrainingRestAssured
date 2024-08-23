package Tests;

import Utils.ExcelUtils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class UpdateLabel_Put {

    @Test(enabled = true)
    public void updateLabelPutAPI() {
        RestAssured.baseURI = "https://api.trello.com";

        HashMap<String, String> queryParamMap = new HashMap<>();
        queryParamMap.put("key", "dd486e53123b2dc7d557ce3167040cf6");
        queryParamMap.put("token", "ATTA07898ac4e95e6b359ac42d39a24124366703106b383b20cd1ab54460fd5b9955F7D3E4FD");

        Response response = RestAssured
                .given()
                .pathParam("labelId", "66c88ea73731fdd2bfb5a870")
                .queryParams(queryParamMap)
                .when()
                .body("")
                .put("/1/labels/{labelId}")
                .then()
                .extract()
                .response();

        System.out.println(response.prettyPrint());
        System.out.println(response.getStatusCode());
        System.out.println(response.body());
    }

}