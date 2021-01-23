package shivam.chapter11.pojotestonlocal.serilization;

import io.restassured.parsing.Parser;

import static io.restassured.RestAssured.given;

public class PojoLocationDeserilization {
    public static void main(String[] args) {

   Shivaminfo si =     given().expect().expect().defaultParser(Parser.JSON)
                .when()
                .get("http://localhost:3000/shivaminfo").as(Shivaminfo.class);

        System.out.println(si.getLocation().getLat());
        System.out.println(si.getLocation().getLng());
        System.out.println(si.getAccuracy());

        // get all types values
        System.out.println("---Types Values---------------");

        int typeSize = si.getTypes().size();

        for(int i=0; i<typeSize; i++)
        {
            System.out.println(si.getTypes().get(i));
        }


    }
}
