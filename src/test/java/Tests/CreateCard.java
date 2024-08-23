package Tests;

import Utils.ExcelUtils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.io.File;
import java.util.Map;

public class CreateCard extends BaseTest {
    @Test(dependsOnMethods = "Tests.CreateList.createList")
    public void createCard() {

        RestAssured.baseURI = baseUri;

        String filePath = new File(createCardFilePath).getAbsolutePath();

        Map<String, String> headersMap = ExcelUtils.getExcelData(filePath, "headers");

        Map<String, String> queryParamsMap = ExcelUtils.getExcelData(filePath, "queryParams");

        Response response = RestAssured
                .given()
                .headers(headersMap)
                .queryParam("key", apiKey)
                .queryParam("token", apiToken)
                .queryParam("idList", listId)
                .queryParams(queryParamsMap)
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
        response.then().statusCode(200);

        cardId = response.path("id");

    }
}
