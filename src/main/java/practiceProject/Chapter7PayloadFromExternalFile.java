package practiceProject;

import files.Payload;
import files.ReUsableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Chapter7PayloadFromExternalFile {
    public static void main(String[] args) throws IOException {
// TODO Auto-generated method stub
// validate if Add Place API is workimg as expected
        //Add place-> Update Place with New Address -> Get Place to validate if New address is present in response

        //given - all input details
        //when - Submit the API -resource,http method
        //Then - validate the response
        //content of the Json file to String how to do that -> content of the file can convert to Byte -> Byte data convert to String

        RestAssured.baseURI = "https://rahulshettyacademy.com";
        String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")


              //  .body(new String(Files.readAllBytes(Paths.get("D:\\1.1.SHIVAMHANUMANJEE_INTERVIEW_2019\\REST_ASSURED_UDEMY_COURSE\\Chapter7_HandlingDynamicPayloadWithParameterization\\addPlace.json"))))
.body(Payload.GenerateStringFromResource("D:\\\\1.1.SHIVAMHANUMANJEE_INTERVIEW_2019\\\\REST_ASSURED_UDEMY_COURSE\\\\Chapter7_HandlingDynamicPayloadWithParameterization\\\\addPlace.json"))

                .when().post("maps/api/place/add/json")
                .then().assertThat().statusCode(200).body("scope", equalTo("APP"))
                .header("server", "Apache/2.4.18 (Ubuntu)").extract().response().asString();

        System.out.println(response);
        JsonPath js = new JsonPath(response); //for parsing Json
        String placeId = js.getString("place_id");

        System.out.println(placeId);

        //Update Place
        String newAddress = "Summer Walk, Africa updated by Shivam";

        given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
                .body("{\r\n" +
                        "\"place_id\":\"" + placeId + "\",\r\n" +
                        "\"address\":\"" + newAddress + "\",\r\n" +
                        "\"key\":\"qaclick123\"\r\n" +
                        "}").
                when().put("maps/api/place/update/json")
                .then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));

        //Get Place

        String getPlaceResponse = given().log().all().queryParam("key", "qaclick123")
                .queryParam("place_id", placeId)
                .when().get("maps/api/place/get/json")
                .then().assertThat().log().all().statusCode(200).extract().response().asString();

        JsonPath js1;
        js1 = ReUsableMethods.rawToJason(getPlaceResponse);
        String actualAddress = js1.getString("address");
        System.out.println("The updated address is: " + actualAddress);

        Assert.assertEquals(actualAddress, newAddress);
        //Cucumber Junit, Testng

    }
}
