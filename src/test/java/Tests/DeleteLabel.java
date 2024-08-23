package Tests;

import Utils.ExcelUtils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.io.File;
import java.util.Map;


public class DeleteLabel extends BaseTest{

    @Test(dependsOnMethods = "Tests.CreateLabel.createLabel")
    public void updateLabel() {
        RestAssured.baseURI = baseUri;

        String filePath = new File(deleteLabelFilePath).getAbsolutePath();

        Map<String, String> headersMap = ExcelUtils.getExcelData(filePath, "headers");

        Response response = RestAssured
                .given()
                .headers(headersMap)
                .pathParam("labelId", labelId)
                .queryParam("key", apiKey)
                .queryParam("token", apiToken)
                .when()
                .delete("1/labels/{labelId}")
                .then()
                .extract()
                .response();
        System.out.println(response.prettyPrint());
        System.out.println(response.statusCode());
        response.then().statusCode(200);
    }
}
