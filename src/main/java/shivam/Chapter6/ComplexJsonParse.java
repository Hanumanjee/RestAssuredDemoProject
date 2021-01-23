package shivam.Chapter6;

import files.Payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {
    public static void main(String[] args) {
        JsonPath js = new JsonPath(Payload.CoursePrice());
       /*1. Print No of courses returned by API
        2.Print Purchase Amount
        3. Print Title of the first course
        4. Print All course titles and their respective Prices
        5. Print number of copies sold by RPA Course
        6. Verify if Sum of all Course prices matches with Purchase Amount
        */
       //1. Print No of courses returned by API
       int count =  js.getInt("courses.size()");
        System.out.println("No of courses returned by API : " + count);
        // Print dashboard
        int dashboardNum = js.getInt("dashboard.size()");
        System.out.println("Number of Dashboard is : " + dashboardNum);

        //  2.Print Purchase Amount
        int purchaseAmount = js.getInt("dashboard.purchaseAmount");
        System.out.println("Purchase Amount is: " + purchaseAmount);

        //3. Print Title of the first course
        System.out.println("Title of first course is: " + js.get("courses[0].title"));

        //4. Print All course titles and their respective Prices

        for(int i=0; i<count; i++)
        {
            String curseTitle = js.get("courses["+i+"].title");
            int price = js.getInt("courses["+i+"].price");
            System.out.println("Course name is: " + curseTitle + " And Course price is: " + price);
        }

        //  5. Print number of copies sold by RPA Course
        System.out.println();
        System.out.println("-----------Number of Copies----------------");
        System.out.println();
        for(int i =0; i<count; i++)
        {

            String curseTitle = js.get("courses["+i+"].title");
            if(curseTitle.equals("Maths"))
            {
                int copies = js.getInt("courses["+i+"].copies");
                System.out.println("Course name is: " + curseTitle + " And Number of copies: " + copies);
                break;
            }


        }
        // 6. Verify if Sum of all Course prices matches with Purchase Amount

        System.out.println();
        System.out.println("-----------Total Sum----------------");
        System.out.println();

        int courseSum=0;

        for(int i=0; i<count; i++)
        {
            int price = js.getInt("courses["+i+"].price") * js.getInt("courses["+i+"].copies");
            courseSum +=price;

        }
        System.out.println(courseSum);

    }
}
