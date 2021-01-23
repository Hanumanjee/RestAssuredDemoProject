package shivam.chapter11.pojoglossary;

import io.restassured.parsing.Parser;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PogoGlossaryTest {
    @Test
    public void testPojoGlossary(){
        GetGlossary glossary = given().expect().defaultParser(Parser.JSON)
                .when()
                .get("http://localhost:3000/shivamacademy").as(GetGlossary.class);
    }
}
