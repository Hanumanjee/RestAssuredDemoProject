package shivam.Chapter12.serialization;

import io.restassured.parsing.Parser;
import shivam.Chapter12.serialization.pojoSerilization.AddPlace;

import static io.restassured.RestAssured.given;

public class PojoAddPlaceTest {
    public static void main(String[] args) {


     AddPlace ap = given().expect().defaultParser(Parser.JSON)
                .when()
                .get("http://localhost:3000/shivamacademy").as(AddPlace.class);


    }
}
