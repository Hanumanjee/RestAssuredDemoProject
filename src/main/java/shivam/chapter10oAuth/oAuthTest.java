package shivam.chapter10oAuth;

import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

public class oAuthTest {
    public static void main(String[] args) throws InterruptedException {

        //step 1 the hitting the authorization url

        //-------------selenium---------------------------------------//
//        System.setProperty("webdriver.gecko.driver", "d://geckodriver.exe");
//        WebDriver driver = new FirefoxDriver();
//        System.setProperty("webdriver.chrome.driver","D:\\Download_ChromeDriver\\chromedriver_win32_85\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//       driver.get("https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php&state=shivamhanumanjeerandomstring");
//
//        WebElement email = driver.findElement(By.xpath("//*[@id=\"identifierId\"]"));
//        email.clear();
//        email.sendKeys("shivammacate@gmail.com");
//        WebElement nextBtn = driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/div[2]"));
//        nextBtn.click();
//        Thread.sleep(3001);
//        WebElement pwdInput = driver.findElement(By.xpath("//*[@id=\"password\"]//input"));
//        pwdInput.clear();
//        pwdInput.sendKeys("ShivamHanumanjee$$");
//        WebElement pwdNextBtn = driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button/div[2]"));
//        pwdNextBtn.click();
//        Thread.sleep(4001);
//        String url = driver.getCurrentUrl();
//        System.out.println(url);
//-------------------End Selenium--------------------------//

        //---------------rest assured ---------------------//
        String url = "https://rahulshettyacademy.com/getCourse.php?state=shivamhanumanjeerandomstring&code=4%2F4gHHpBBkaZqOqbKOYAsYZMlkG7a2IDaC12RcddmMr0Tqzly1Sq2YcvtHM7mP9gGLpmzQLdRpuR9LiYO40h3z7wY&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&prompt=consent#";
        String partialcode = url.split("code=")[1];
        String code = partialcode.split("&scope")[0];
        //   System.out.println(code);
        //target attribute value


        String accessTokenResponse = given().urlEncodingEnabled(false)

                .queryParams("code", code)
                .queryParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
                .queryParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
                .queryParams("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
                .queryParams("grant_type", "authorization_code")


             //   .queryParams("state", "shivamhanumanjeerandomstring")
            //    .queryParams("session_state", "ff4a89d1f7011eb34eef8cf02ce4353316d9744b..7eb8")


                .when().log().all().urlEncodingEnabled(true)
                .post("https://www.googleapis.com/oauth2/v4/token").asString();


        JsonPath js = new JsonPath(accessTokenResponse);
        String accessToken = js.getString("access_token");



        String response = given().queryParam("access_token", accessToken)
                .when().log().all()
                .get("https://rahulshettyacademy.com/getCourse.php").asString();
        System.out.println(response);

    }
}
