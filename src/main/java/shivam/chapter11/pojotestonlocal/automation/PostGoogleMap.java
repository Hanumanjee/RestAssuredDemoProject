package shivam.chapter11.pojotestonlocal.automation;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class PostGoogleMap {
    public static void main(String[] args) {


        RestAssured.baseURI = "http://localhost:3000";

     String  response= given()
                .header("Content-Type","application/json")
                .when()
             .body("{\n" +
                     "    \"location\": {\n" +
                     "        \"lat\": -33.3333,\n" +
                     "        \"lng\": 44.444\n" +
                     "    }\n" +
                     "}")
                .post("/shivaminfo")
                .then().assertThat().statusCode(201).extract().response().asString();

        System.out.println(response);

    }
}
