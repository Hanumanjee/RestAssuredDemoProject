package shivam.chapter11.pojomedical;

import io.restassured.parsing.Parser;

import static io.restassured.RestAssured.given;

public class TestPOJOMedication {
    public static void main(String[] args) {


     GetMedical gm =   given().expect().defaultParser(Parser.JSON)
                .when()
                .get("http://localhost:3000/shivamacademy").as(GetMedical.class);
    }
}
