package shivam.chapter10oAuth;

public class oAuthPractice {
    public static void main(String[] args) {
        String url = "https://rahulshettyacademy.com/getCourse.php?state=shivamhanumanjeerandomstring&code=4%2F4gHHpBBkaZqOqbKOYAsYZMlkG7a2IDaC12RcddmMr0Tqzly1Sq2YcvtHM7mP9gGLpmzQLdRpuR9LiYO40h3z7wY&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&prompt=consent#";
        String partialcode = url.split("code=")[1];
        String firstPart = url.split("code=")[0];
        System.out.println(firstPart);
        System.out.println(partialcode);
        String code = partialcode.split("&scope=")[0];
        System.out.println(code);
    }
}
