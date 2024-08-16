import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class TrainingRA2024{
    @Test(enabled = false)
    public void firstPostAPI(){

        }


    @Test(enabled = false)
    public void firstGetAPI(){
        Response response = RestAssured
                .get("https://api.trello.com/1/boards/66bf23518da2a9c89f6dfa8f?key=dd486e53123b2dc7d557ce3167040cf6&token=ATTA07898ac4e95e6b359ac42d39a24124366703106b383b20cd1ab54460fd5b9955F7D3E4FD")
                .then().extract().response();
        System.out.println(response.asString());

    }

    @Test
    public void secondGetAPI(){
        RestAssured.baseURI = "https://api.trello.com";
        Response response = RestAssured
                .given()
                .pathParam("boardId","66bf23518da2a9c89f6dfa8f")
                .queryParam("key","dd486e53123b2dc7d557ce3167040cf6")
                .queryParam("token","ATTA07898ac4e95e6b359ac42d39a24124366703106b383b20cd1ab54460fd5b9955F7D3E4FD")
                .when()
                .get("1/boards/{boardId}")
                .then()
                .extract()
                .response();
        System.out.println(response.asString());

    }

    @Test(enabled = false)
    public void firstPutAPI(){

    }

    @Test(enabled = false)
    public void firstPatchAPI(){

    }
}
