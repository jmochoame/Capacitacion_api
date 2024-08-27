import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;


public class Proxy {
    @BeforeClass
    public void setUp() {
        RestAssured.useRelaxedHTTPSValidation("SSL");
        RestAssured.proxy("piscis01.bancodebogota.net", 8003);
    }
    @Test
    public void getCustomer() {
        RequestSpecification request = given()
                .baseUri("https://api-clients.labdigitalbdbtvsstg.com")
                .basePath("/customer-management-v3-mngr/V3/enterprise")
                .header("x-api-key", "GX3aQY44BECr0fXF3gIbLlijEQ8Muc")
                .header("X-GovIssueIdentType", "CC")
                .header("X-IdentSerialNum", "1002957689")
                .header("X-Channel", "OPB001")
                .header("X-CompanyId", "001")
                .header("X-Name", "OpenFinance")
                .header("X-RqUID", "13f26ab7-f282-487b-bfaf-a7d0acb04075")
                .header("X-IPAddr", "3.13.132.40");

        Response response = request
                .when()
                .get("/customer/product");

        response.prettyPrint();
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }
}
