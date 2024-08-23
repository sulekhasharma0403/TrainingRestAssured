
package Tests;

import Utils.ExcelUtils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.io.File;
import java.util.Map;

public class GetLabel extends BaseTest{
    @Test(dependsOnMethods = "Tests.CreateLabel.createLabel")
    public void getLabel() {
        RestAssured.baseURI = baseUri;

        String filePath = new File(getLabelFilePath).getAbsolutePath();

        Map<String, String> headersMap = ExcelUtils.getExcelData(filePath, "headers");

        Response response = RestAssured
                .given()
                .headers(headersMap)
                .pathParam("labelId", labelId)
                .queryParam("key", apiKey)
                .queryParam("token", apiToken)
                .when()
                .get("1/labels/{labelId}")
                .then()
                .extract()
                .response();
        System.out.println(response.prettyPrint());
        response.then().statusCode(200);
    }

}
