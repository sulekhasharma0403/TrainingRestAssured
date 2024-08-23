package Tests;

import Utils.ExcelUtils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.io.File;
import java.util.Map;

public class CreateList extends BaseTest {
    @Test(dependsOnMethods = "Tests.CreateBoard.createBoard")
    public void createList() {


        RestAssured.baseURI = baseUri;

        String filePath = new File(createListFilePath).getAbsolutePath();

        Map<String, String> headersMap = ExcelUtils.getExcelData(filePath, "headers");

        Map<String, String> queryParamsMap = ExcelUtils.getExcelData(filePath, "queryParams");

        Response response = RestAssured
                .given()
                .headers(headersMap)
                .queryParam("key", apiKey)
                .queryParam("token", apiToken)
                .queryParam("idBoard", boardId)
                .queryParams(queryParamsMap)
                .log().all()
                .when()
                .body("")
                .post("/1/lists")
                .then()
                .extract()
                .response();

        System.out.println(response.prettyPrint());
        System.out.println(response.getStatusCode());
        System.out.println(response.body());
        response.then().statusCode(200);

        listId = response.path("id");

    }
}
