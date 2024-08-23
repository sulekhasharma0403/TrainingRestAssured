package Tests;

import Utils.ExcelUtils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.io.File;
import java.util.Map;

public class DeleteBoard extends BaseTest{

    @Test(dependsOnMethods = "Tests.CreateBoard.createBoard")
    public void deleteBoard() {
        RestAssured.baseURI = "https://api.trello.com";

        String filePath = new File("src/test/resources/testData/boards/deleteBoard.xlsx").getAbsolutePath();

        Map<String, String> headersMap = ExcelUtils.getExcelData(filePath, "headers");

        Response response = RestAssured
                .given()
                .headers(headersMap)
                .pathParam("boardId",boardId)
                .queryParam("key",apiKey)
                .queryParam("token",apiToken)
                .when()
                .delete("1/boards/{boardId}")
                .then()
                .extract()
                .response();
        System.out.println(response.prettyPrint());
        System.out.println(response.statusCode());
        response.then().statusCode(200);
    }
}
