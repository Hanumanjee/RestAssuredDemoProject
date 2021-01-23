package shivam.Chapter6;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNestedJson {
    JsonPath js = new JsonPath(files.Payload.CoursePrice());

    @Test //1. Print No of courses returned by API
    public void getNumberOfCourses() {

        int courseNum = js.getInt("courses.size()");
        System.out.println("Size of courses: " + courseNum);
        Assert.assertEquals(courseNum, 6);

    }

    @Test
    public void printPurchaseAmount() {
        int purchaseAmt = js.getInt("dashboard.purchaseAmount");
        System.out.println("Purchase Amount is: " + purchaseAmt);
    }

    @Test
    public void printTitleOfFirstCourse() {
        String title = js.getString("courses[0].title");
        System.out.println("Title of First course: " + title);
    }

    @Test
    public void printAllCourseAndPrice() {
        int courseNum = js.getInt("courses.size()");
        for (int i = 0; i < courseNum; i++) {
            String course = (js.getString("courses[" + i + "].title"));
            int price = (js.getInt("courses[" + i + "].price"));

            System.out.println("Course: " + course + " Price: " + price);
        }
    }

    @Test
    public void numberOfCopySoldForRPA() {
        int copyNum = 0;
        int courseNum = js.getInt("courses.size()");
        for (int i = 0; i < courseNum; i++) {
            String course = js.get("courses[" + i + "].title");
            if (course.equalsIgnoreCase("RPA")) {
                copyNum = js.getInt("courses[" + i + "].copies");
            }
        }
        System.out.println("Number of copies: " + copyNum);

    }
    @Test
    public void verifyPurchaseAmount(){
        int purchaseAmt = js.getInt("dashboard.purchaseAmount");
        int courseNum = js.getInt("courses.size()");
        int totalSum=0;
        for (int i = 0; i < courseNum; i++) {
             totalSum += js.getInt("courses["+i+"].price")  * js.getInt("courses["+i+"].copies");
        }
        System.out.println(purchaseAmt);
        System.out.println(totalSum);
        Assert.assertEquals(totalSum,purchaseAmt);
    }
}
