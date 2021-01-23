package shivam.Chapter10_POJO;


import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class MessageTest {
  @Test
          public void test() {
      MessagePOJO m = new MessagePOJO();
      m.setMessage("Hello");
      m.setGreet("Hi");

      //Rest Assured
      given()
              .body(m)
              .when()
              .post("/message");
  }

}
