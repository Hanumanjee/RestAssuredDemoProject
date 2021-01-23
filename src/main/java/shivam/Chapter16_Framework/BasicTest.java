package shivam.Chapter16_Framework;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BasicTest {

    //addPlaceAPI, GetPlaceAPI, updatePlaceAPI, deletePlaceAPI

    String place_id = "";

    @Test(enabled = true, priority = 1)
    public void addPlace() {
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        String resStr = given().queryParam("key", "qaclick123")
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"location\": {\n" +
                        "    \"lat\": -38.383494,\n" +
                        "    \"lng\": 33.427362\n" +
                        "  },\n" +
                        "  \"accuracy\": 50,\n" +
                        "  \"name\": \"Amar Shivam in California\",\n" +
                        "  \"phone_number\": \"(+91) 983 893 3937\",\n" +
                        "  \"address\": \"29, side layout, cohen 09\",\n" +
                        "  \"types\": [\n" +
                        "    \"shoe park\",\n" +
                        "    \"shop\"\n" +
                        "  ],\n" +
                        "  \"website\": \"http://google.com\",\n" +
                        "  \"language\": \"French-IN\"\n" +
                        "}\n")
                .when().post("/maps/api/place/add/json")
                .then().log().all().assertThat().statusCode(200).extract().response().asString();

        JsonPath js = new JsonPath(resStr);

        System.out.println("Body I get from response");
        System.out.println(resStr);
        place_id = js.getString("place_id");
        System.out.println(place_id);

    }

    @Test(enabled = true, priority = 2)
    public void getPlace() {
        //assert name
        System.out.println("Place Id from Add place is: " + place_id);
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        String getStr = given().queryParams("key", "qaclick123")
                .queryParams("place_id", place_id)
                .contentType(ContentType.JSON)
                .when().get("/maps/api/place/get/json")
                .then().assertThat().statusCode(200).extract().response().asString();
        JsonPath js = new JsonPath(getStr);
        System.out.println(js.getString("name"));
        Assert.assertEquals("Amar Shivam in California", js.getString("name"));
    }

    @Test(enabled = true, priority = 3)
    public void updatePlace() {
        // System.out.println("Place Id from Add place is: " + place_id);
        String place_id = "6d6567e78c6c99270f901c4b8b4b9cb9";
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        String putStr = given().queryParams("key", "qaclick123")
                .queryParams("place_id", place_id)
                .body("{\n" +
                        "\"place_id\":\"{\n" +

                        "\"place_id\":\" \"  +place_id+\" \",\n" +

                        "\"address\":\"70 winter walk, USA\",\n" +
                        "\"key\":\"qaclick123\"\n" +
                        "}\n\",\n" +
                        "\"address\":\"70 winter walk, USA\",\n" +
                        "\"key\":\"qaclick123\"\n" +
                        "}\n")
                .when().put("/maps/api/place/update/json")
                .then().log().all().assertThat().statusCode(200).extract().response().asString();

        System.out.println(putStr);

//         JsonPath js = new JsonPath(putStr);
//            System.out.println(js.getString("msg"));

    }

    @Test(priority = 4)
    public void deletePlace() {
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        String delStr = given().queryParams("key", "qaclick123")
                .body("{\n" +
                        "    \"place_id\":\"\"+place_id+\"\"  \n" +
                        "\n" +
                        "}")
                .when().post("/maps/api/place/delete/json")
                .then().assertThat().statusCode(200).extract().response().asString();
    }

}
