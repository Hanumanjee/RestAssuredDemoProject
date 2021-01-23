package maadurga;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AddDeleteUpdateAPI {
    @Test
    public void addCoursePayload() {
        RestAssured.baseURI = "http://localhost:3000";
        Response response = given().contentType(ContentType.JSON)
                .when()
                .get("/courses")
                .then().assertThat().statusCode(200).extract().response();

        String resStr = response.asString();
        //  System.out.println(resStr);
        JsonPath js = new JsonPath(resStr);

    }
}