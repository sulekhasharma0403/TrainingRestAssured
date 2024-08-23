package Tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.util.HashMap;


public class DeleteLabels_Del {

    @Test(enabled = true)
    public void labelDeleteAPI() {
        RestAssured.baseURI = "https://api.trello.com";
        HashMap<String, String> hm = new HashMap<>();
        hm.put("key", "dd486e53123b2dc7d557ce3167040cf6");
        hm.put("token", "ATTA07898ac4e95e6b359ac42d39a24124366703106b383b20cd1ab54460fd5b9955F7D3E4FD");

        Response response = RestAssured
                .given()
                .pathParam("labelID", "66c88ea73731fdd2bfb5a870")
                .queryParams(hm)
                .when()
                .delete("1/labels/{labelID}")
                .then()
                .extract()
                .response();
        System.out.println(response.prettyPrint());
        System.out.println(response.statusCode());
    }
}
