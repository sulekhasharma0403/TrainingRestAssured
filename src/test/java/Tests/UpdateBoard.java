package Tests;

import Utils.ExcelUtils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class UpdateBoard extends BaseTest{

    @Test(dependsOnMethods = "Tests.CreateBoard.createBoard")
    public void updateBoard() {
        RestAssured.baseURI = "https://api.trello.com";

        String filePath = new File("src/test/resources/testData/boards/updateBoard.xlsx").getAbsolutePath();

        Map<String, String> headersMap = ExcelUtils.getExcelData(filePath, "headers");

        Map<String, String> queryParamsMap = ExcelUtils.getExcelData(filePath, "queryParams");

        Response response = RestAssured
                .given()
                .headers(headersMap)
                .pathParam("boardId",boardId)
                .queryParam("key",apiKey)
                .queryParam("token",apiToken)
                .queryParams(queryParamsMap)
                .log().all()
                .when()
                .body("")
                .put("/1/boards/{boardId}")
                .then()
                .extract()
                .response();

        System.out.println(response.prettyPrint());
        System.out.println(response.getStatusCode());
        System.out.println(response.body());
        response.then().statusCode(200);
    }
}
