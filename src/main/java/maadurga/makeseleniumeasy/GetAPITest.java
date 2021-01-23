package maadurga.makeseleniumeasy;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetAPITest {
    @Test
    public void verifyStatusCode() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        // Response response =

        Response response = given().log().all().contentType(ContentType.JSON)
                .when()
                .get("/booking");
        //  .then().extract().response();

        ValidatableResponse valRes = response.then();
        valRes.statusCode(200);
        valRes.statusLine("HTTP/1.1 200 OK");
    }

    @Test
    public void validateId() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        // Response response =
        given().log().all().contentType(ContentType.JSON)
                .when()
                .get("/booking")
                .then().log().all().assertThat().statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
              //  .body("bookingid.size()",Matchers.hasSize(10))
       .body("bookingid[3]",Matchers.equalTo(10));


    }
}
