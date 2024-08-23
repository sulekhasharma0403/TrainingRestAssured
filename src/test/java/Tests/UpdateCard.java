package Tests;

import Utils.ExcelUtils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.io.File;
import java.util.Map;

public class UpdateCard extends BaseTest{

    @Test(dependsOnMethods = "Tests.CreateCard.createCard")
    public void updateCard() {
        RestAssured.baseURI = baseUri;

        String filePath = new File(updateCardFilePath).getAbsolutePath();

        Map<String, String> headersMap = ExcelUtils.getExcelData(filePath, "headers");

        Map<String, String> queryParamsMap = ExcelUtils.getExcelData(filePath, "queryParams");

        Response response = RestAssured
                .given()
                .headers(headersMap)
                .pathParam("cardId", cardId)
                .queryParam("key", apiKey)
                .queryParam("token", apiToken)
                .queryParams(queryParamsMap)
                .when()
                .body("")
                .put("/1/cards/{cardId}")
                .then()
                .extract()
                .response();

        System.out.println(response.prettyPrint());
        System.out.println(response.getStatusCode());
        System.out.println(response.body());

        response.then().statusCode(200);
    }

}