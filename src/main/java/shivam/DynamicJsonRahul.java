package shivam;

import files.Payload;
import files.ReUsableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class DynamicJsonRahul {
    @Test(dataProvider = "BooksData",priority = 1)
    public void addBook(String isbn, String aisle) throws IOException {

        RestAssured.baseURI = "http://216.10.245.166";
        String resp = given().
                header("Content-Type", "application/json").
                body(Payload.Addbook(isbn, aisle)).
                when().
                post("/Library/Addbook.php").
                then().log().all().assertThat().statusCode(200).
                extract().response().asString();

        JsonPath js = ReUsableMethods.rawToJason(resp);
        String id = js.get("ID");
        System.out.println(id);

        //deleteBook
    }
    @Test(dataProvider = "BooksData", priority = 2)
    public void deleteBook(String isbn, String aisle)
    {
        String id =isbn+aisle;
        RestAssured.baseURI = "http://216.10.245.166";
        String response1=   given().log().all().header("Content-Type", "application/json")
                .body(Payload.DeleteBook(id))
                .when().post("/Library/DeleteBook.php")
                .then().log().all().assertThat().statusCode(200).extract().asString();

    }
    @Test(dataProvider = "BooksData", enabled = false)
    public void testDataProvider(String isbn, String aisle)
    {
        System.out.println(isbn + " " + aisle);
    }

    @DataProvider(name="BooksData")
    public Object[][] getData() {

        // array is collection of elements
        // multidimensional array is collection of arrays
//      Object[][] data={{"dddd","8765"},  {"xxxx","8769"},{"nhgss","3987"}};
//      return data;
        return new Object[][] {{"shivam21","87651"},  {"krishna12","87691"},{"hariom12","39871"}};

    }
}
