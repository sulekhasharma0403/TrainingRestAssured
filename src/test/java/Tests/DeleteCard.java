package Tests;

import Utils.ExcelUtils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.io.File;
import java.util.Map;


public class DeleteCard extends BaseTest {

    @Test(dependsOnMethods = "Tests.CreateCard.createCard")
    public void deleteCard() {
        RestAssured.baseURI = baseUri;

        String filePath = new File(deleteCardFilePath).getAbsolutePath();

        Map<String, String> headersMap = ExcelUtils.getExcelData(filePath, "headers");

        Response response = RestAssured
                .given()
                .headers(headersMap)
                .pathParam("cardId", cardId)
                .queryParam("key", apiKey)
                .queryParam("token", apiToken)
                .when()
                .delete("1/cards/{cardId}")
                .then()
                .extract()
                .response();
        System.out.println(response.prettyPrint());
        System.out.println(response.statusCode());
        response.then().statusCode(200);
    }
}
