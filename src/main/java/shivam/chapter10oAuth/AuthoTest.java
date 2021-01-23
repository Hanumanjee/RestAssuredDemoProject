package shivam.chapter10oAuth;

import static io.restassured.RestAssured.given;

public class AuthoTest {
    public static void main(String[] args) {

        //Bottom to Top


        // get Access token
//    String accessTokenResponse =    given()
//                .queryParams("code", "4%2F4wHz5m3Hj5zr88nTe9xTvnrHSr-twI9vIzU4AaghHfNQATGvb8W5PHRq_1Izt091fazP205BAf3ugEp4n-VolQc")
//                .queryParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
//                .queryParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
//                .queryParams("grant_type", "authorization_code")
//                .queryParams("state", "verifyfjdss")
//                .queryParams("session_state", "ff4a89d1f7011eb34eef8cf02ce4353316d9744b..7eb8")
//                .queryParams("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
//
//                .when()
//            .post("https://www.googleapis.com/oauth2/v4/token").asString();
//
//        JsonPath js = new JsonPath(accessTokenResponse);
//        String accessToken = js.getString("access_token");
//        System.out.println("ACCESS TOKEN IS: " + accessToken);

        //get ActualRequest
        String accessToken = "ya29.a0AfH6SMBDcdYyjJKlWjqDlNTailGoVyAEaFP1iDCS55AgeP3DdZUyrD9Tpb1qkJq8k9tSTvPmvC60mC9oTm6o9Manmmmgg0e58_9bzXe-HXO-bUymfFBlrDu8YJpPlSEoqtGltI4izkXD1pkqcJ5AY23mViWra9a9t9Q";

     String response =   given()
                .queryParam("access_token", accessToken)
                .when()
                .get("https://rahulshettyacademy.com/getCourse.php").asString();
        System.out.println(response);

    }
}
