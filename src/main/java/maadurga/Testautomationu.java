package maadurga;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Testautomationu {
    @Test
    public void testData(){
        given()
                .when()
                .get("http://api.zippopotam.us/us/90210")
                .then().assertThat()
                .body("places[0].'place name'",equalTo("Beverly Hills"));

    }
}
