package shivam;

import files.Payload;
import files.ReUsableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DynamicJson {
   // String id = "";

    @Test(priority = 1)
    public void addBook() {
        // add book
        RestAssured.baseURI = "http://216.10.245.166";

        String response = given().log().all().header("Content-Type", "application/json")
                .body(Payload.Addbook("abcd23", "124345"))
                .when().post("/Library/Addbook.php")
                .then().log().all().assertThat().statusCode(200)
                .extract().response().asString();

        JsonPath js = ReUsableMethods.rawToJason(response);
     String   id = js.get("ID");
        System.out.println(id);


        // delete book
        RestAssured.baseURI = "http://216.10.245.166";
     String response1=   given().log().all().header("Content-Type", "application/json")
                .body("{\n" +
                        " \n" +
                        "\"ID\" : \""+id+"\"\n" +
                        " \n" +
                        "} ")
                .when().post("/Library/DeleteBook.php")
                .then().log().all().assertThat().statusCode(200).extract().asString();

         }

    @Test(enabled = false)
    public void deleteBookByGetID() {
        RestAssured.baseURI = "http://216.10.245.166";
        String response1=   given().log().all().header("Content-Type", "application/json")
                .body("{\n" +
                        " \n" +
                        "\"ID\" : \"\"+id+\"\"\n" +
                        " \n" +
                        "} ")
                .when().post("/Library/DeleteBook.php")
                .then().log().all().assertThat().statusCode(200).extract().asString();

        JsonPath js1 = ReUsableMethods.rawToJason(response1);
        System.out.println(js1.getString("msg"));
    }


}
