package pojotest;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class PojoGooleMapDestinationSerilizationTest {

    public static void main(String[] args) {
        ShivamInfo shivamInfo = new ShivamInfo();
        Distance distance = new Distance();
        Duration duration = new Duration();
        Elements elements = new Elements();
        Rows rows = new Rows();

        // diclare lists

        List<String> listDistanceAddress = new ArrayList<>();
        List<String> listOriginalAddress = new ArrayList<>();
        List<Elements> listElements = new ArrayList<>();
        List<Rows> listRows = new ArrayList<>();


        listDistanceAddress.add("Washington, DC, USA");
        listDistanceAddress.add("Kolkata, WB, India");
        listDistanceAddress.add("Varanasi, UP, India");
        shivamInfo.setDestination_addresses(listDistanceAddress);

        listOriginalAddress.add("Kolkata, WB, India");
        listOriginalAddress.add("Varanasi, UP, India");
        shivamInfo.setOrigin_addresses(listOriginalAddress);

        shivamInfo.setStatus("Very Good");

        listRows.add(rows);
        shivamInfo.setRows(listRows);

        listElements.add(elements);

        rows.setElements(listElements);

        elements.setStatus("Elements OK");


        distance.setText("my text");
        distance.setValue(1234);
        duration.setText("duration text");
        duration.setValue(4321);

        elements.setDistance(distance);
        elements.setDuration(duration);

        given().given().header("Content-Type", "application/json")
                .body(shivamInfo)
                .when()
                .post("http://localhost:3000/shivaminfo")
                .then().log().all().extract().as(ShivamInfo.class);

    }
}
