import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Microcreditos {
    @BeforeMethod
    public void setup() {
        RestAssured.useRelaxedHTTPSValidation("SSL");
    }
    @Test
            public void Microcredito (){
        RequestSpecification request = given()
                .baseUri("http://10.86.154.122:4563")
                .basePath("/disbursement-management/V1/Product/microcredit/parameters")
                .header("X-Channel","PPE")
                .header("X-IPAddr","1.1.1.1")
                .header("X-Name","microfinanzas")
                .header("X-NetworkOwner","PPE")
                .header("X-RqUid","0EAD5196-3746-47C6-8BED-8B0D768A4D8A")
                .header("X-TerminalId","IN01")
                .header("x-api-key","YcAx#9ghY!WOR^M5b5yRrcxXzHh2Lu")
                .formParam("DaneCode","13006007")
                .formParam("Year","2024")
                .formParam("CreditAmount","28000000");

        Response response = request
                .when()
                .get();

        response.prettyPrint();
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);

    }


}
