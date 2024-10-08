package Tests;

import Utils.ExcelUtils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Map;

public class CreateBoard extends BaseTest {

    @Test(enabled = true)
    public void createBoard() {

        RestAssured.baseURI = baseUri;

        String filePath = new File(createBoardFilePath).getAbsolutePath();

        Map<String, String> headersMap = ExcelUtils.getExcelData(filePath, "headers");

        Map<String, String> queryParamsMap = ExcelUtils.getExcelData(filePath, "queryParams");

        Response response = RestAssured
                .given()
                .headers(headersMap)
                .queryParam("key", apiKey)
                .queryParam("token", apiToken)
                .queryParams(queryParamsMap)
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
        response.then().statusCode(200);

        boardId = response.path("id");

    }
}
