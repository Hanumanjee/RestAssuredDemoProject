package shivam.chapter11.jsonpath;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class ShimvamInstructorJson {
    public static void main(String[] args) {

        RestAssured.baseURI="http://localhost:3000";

     String response =   given()
                .when().get("/shivaminfo")
                .then().log().all().assertThat().statusCode(200).extract().response().asString();

    }
}
