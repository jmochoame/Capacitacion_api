import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import static io.restassured.RestAssured.given;
public class CreateObjects {

    @BeforeClass
    public void setUp() {
        RestAssured.useRelaxedHTTPSValidation("SSL");
        RestAssured.proxy("piscis01.bancodebogota.net", 8003);
    }

    @Test
    public void CreateObjects (){

        File postBody = new File("src/main/resources/createObject.json");
        RequestSpecification request = given()
                .baseUri("https://api.restful-api.dev")
                .basePath("/objects")
                .header("Content-Type","application/json")
                .body(postBody);

        Response response = request
                .when()
                .post();
        response.prettyPrint();
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200);
    }
}