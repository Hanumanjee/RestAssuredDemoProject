package shivam.chapter11.pojo;

import io.restassured.parsing.Parser;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class PojoMainTest {
    public static void main(String[] args) {

String[] courseTitles ={"Selenium Webdriver Java", "Cypress", "Protector"};


        GetCourse gc = given().expect().defaultParser(Parser.JSON)
                .when()
                .get("http://localhost:3000/shivamacademy").as(GetCourse.class);

//        System.out.println(gc.getInstructor());
//        System.out.println(gc.getLinkedIn());
//        String title=     gc.getCourses().getWebAutomation().get(0).getCourseTitle();
//        System.out.println(title);

        int webAutoSize = gc.getCourses().getWebAutomation().size();
        //   System.out.println(webAutoSize);


// get all course titles from webAutomation
        for (int i = 0; i < webAutoSize; i++) {
            String csTitle = gc.getCourses().getWebAutomation().get(i).getCourseTitle();
          //  System.out.println("Course Name: " + csTitle);
        }
        System.out.println("------------------------");
// get the price of SoapUI Webservices testing
List<String> actualList = new ArrayList<>();

        for (int i = 0; i < webAutoSize; i++) {
            actualList.add(gc.getCourses().getWebAutomation().get(i).getCourseTitle());
            //   System.out.println(csTitle);
        }

       //convert Array to arrayList
        List<String> expectedList = Arrays.asList(courseTitles);

        System.out.println(expectedList);
        System.out.println(actualList);
        Assert.assertEquals(expectedList, actualList);


      //--------------get price-----------------//

        List<Api> listApi = gc.getCourses().getApi();

        for (int i = 0; i < listApi.size(); i++) {
            if (listApi.get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing")) {
             //   System.out.println("Price of the course is: " + listApi.get(i).getPrice());
            }
        }
    }
}
