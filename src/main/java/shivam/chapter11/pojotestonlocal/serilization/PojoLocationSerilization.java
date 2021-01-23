package shivam.chapter11.pojotestonlocal.serilization;

import io.restassured.RestAssured;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class PojoLocationSerilization {
    public static void main(String[] args) {
        Shivaminfo shivaminfo = new Shivaminfo();
        Location location = new Location();

        location.setLat(-33.333);
        location.setLng(55.55555);

        shivaminfo.setLocation(location);


        // adding types values
        List<String> typeList = new ArrayList<>();
        typeList.add("AAA");
        typeList.add("BBB");
        typeList.add("CCCDD");
        typeList.add("VVVV");

        //---Student records------//
        Student student = new Student();
        student.setName("intellijstudent");
        student.setGrade("intellijgrade");
        student.setAge(12);

        // adding another student record//
        Student student1 = new Student();
        student1.setName("student1");
        student1.setGrade("grade1");
        student1.setAge(8);

        List<Student> studentList = new ArrayList<>();
        studentList.add(student);
        studentList.add(student1);


        //adding Parent values
        Parent parent= new Parent();
        parent.setName("intellijname");
        parent.setRelation("intellijfather");
        parent.setAge(444);
        parent.setOccupation("intellijOccupation");

        //another parent record
        Parent parent1 = new Parent();
        parent1.setName("nameparent1");
        parent1.setRelation("father1");
        parent1.setAge(45);
        parent1.setOccupation("parent1Occupation");

        List<Parent> parentList = new ArrayList <>();
        parentList.add(parent);
        parentList.add(parent1);

        //adding Labs values

        Labs labs = new Labs();
        labs.setLocation("intellijlocation");
        labs.setName("intellijname");
        labs.setTime("intellijTime");

        List<Labs> labsList = new ArrayList<>();
        labsList.add(labs);

            // adding users values
        Users users = new Users();
        users.setParent(parentList);
        users.setStudent(studentList);

        List<Users> userList = new ArrayList<>();

        userList.add(users);


        //---------------//

        shivaminfo.setAccuracy(60);
        shivaminfo.setName("Shivam");
        shivaminfo.setPhone_number("222-222-2222");
        shivaminfo.setAddress("Hari hey Shivam");
        shivaminfo.setWebsite("www.shivamwebsite.org");
        shivaminfo.setLanguage("Bangla");
        shivaminfo.setTypes(typeList);
        shivaminfo.setLabs(labsList);

       shivaminfo.setUsers(userList);





        RestAssured.baseURI = "http://localhost:3000";

        String  response= given()
                .header("Content-Type","application/json")
                .when()
                .body(shivaminfo)
                .post("/shivaminfo")
                .then().assertThat().statusCode(201).extract().response().asString();

        System.out.println(response);


    }

}
