package shivam.Chapter12.serialization.pojoSerilization;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class SerializeTest {
    public static void main(String[] args) {
       // RestAssured.baseURI = "";

        AddPlace addPlace = new AddPlace();
        Location location = new Location();

        location.setLat(-38.383494);
        location.setLng(33.427362);

        addPlace.setAccuracy(50);
        addPlace.setName("Shivam Hose");
        addPlace.setPhone_number("(+91) 1111111111");
        addPlace.setAddress("32, Shivam, cohen 09");
        addPlace.setWebsite("http://google.com");
        addPlace.setLanguage("Bengali-IN");


        addPlace.setLocation(location);


        List<String> list = new ArrayList<>();
        list.add("shoe park");
        list.add("shop");
        addPlace.setTypes(list);


        String res = given()

                .body(addPlace)
                .when()
                .post("http://localhost:3000/shivaminfo")
                .then().assertThat().statusCode(201).extract().response().asString();
        System.out.println(res);

    }

}
