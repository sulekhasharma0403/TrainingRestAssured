
package Tests;

import Utils.ExcelUtils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class GetLabel_get {
    @Test(enabled = true)
    public void labelGetAPI() {
        RestAssured.baseURI = "https://api.trello.com";

        HashMap<String, String> hm = new HashMap<>();
        hm.put("key", "dd486e53123b2dc7d557ce3167040cf6");
        hm.put("token", "ATTA07898ac4e95e6b359ac42d39a24124366703106b383b20cd1ab54460fd5b9955F7D3E4FD");

        Response response = RestAssured
                .given()
                .pathParam("labelId", "66c88ea73731fdd2bfb5a870")
                .queryParams(hm)
                .when()
                .get("1/labels/{labelId}")
                .then()
                .extract()
                .response();
        System.out.println(response.prettyPrint());
        response.then().statusCode(200);
    }

    @Test(enabled = true)
    public void fourthGetAPI() {
        RestAssured.baseURI = "https://api.trello.com";

        String filePath = new File("src/test/resources/testData/boards/getBoardGET.xlsx").getAbsolutePath();

        Map<String, String> headersMap = ExcelUtils.getExcelData(filePath, "headers");

        Map<String, String> pathParamsMap = ExcelUtils.getExcelData(filePath, "pathParams");

        Map<String, String> queryParamsMap = ExcelUtils.getExcelData(filePath, "queryParams");

        Response response = RestAssured
                .given()
                .headers(headersMap)
                .pathParams(pathParamsMap)
                .queryParams(queryParamsMap)
                .when()
                .get("1/boards/{boardId}")
                .then()
                .extract()
                .response();
        System.out.println(response.prettyPrint());
        response.then().statusCode(200);
    }
}
