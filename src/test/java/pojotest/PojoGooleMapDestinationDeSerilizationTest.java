package pojotest;

import io.restassured.parsing.Parser;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class PojoGooleMapDestinationDeSerilizationTest {
    public static void main(String[] args) {





    ShivamInfo si=    given().header("Content-Type","application/json").expect().defaultParser(Parser.JSON)
                .when()
                .get("http://localhost:3000/shivaminfo")
            .then().log().all().extract().as(ShivamInfo.class);


            List<String> listdAddress = new ArrayList<>();
        listdAddress =si.getDestination_addresses();

        for(String s : listdAddress)
        {
            System.out.println("Destination Address: " + s);
        }

        List<String> listOAddress = new ArrayList<>();
        listOAddress =si.getOrigin_addresses();


        System.out.println("-----------------------------------");
        for(String s : listOAddress)
        {
            System.out.println("Original Address: " + s);
        }
    }
}
