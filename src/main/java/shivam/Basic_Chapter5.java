package shivam;

import files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Basic_Chapter5 {
    public static void main(String[] args) {
        // validate if Add Place API is workimg as expected
        //Add place-> Update Place with New Address -> Get Place to validate if New address is present in response

        //given - all input details
        //when - Submit the API -resource,http method
        //Then - validate the response


        RestAssured.baseURI = "https://rahulshettyacademy.com";

        String response = given().log().all().queryParam("key", "qaclick123")
                .header("content-type", "application/json")
                .body(Payload.AddPlace())
                .when()
                .post("/maps/api/place/add/json")
                .then()//.log().all()
                .assertThat().statusCode(200)
                .body("scope", equalTo("APP"))
                .header("Server", "Apache/2.4.18 (Ubuntu)")
                .extract().response().asString();

        System.out.println(response);

        // parse json boby using JsonPath
        JsonPath js = new JsonPath(response); // for parsing json
        String placeId = js.getString("place_id");
        System.out.println("Place Id is: " + placeId);

    }
}
