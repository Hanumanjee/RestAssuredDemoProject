package shivam.Chapter10_POJO;

public class MessagePOJO {
    private String message;
    private String greet;

    public String getGreet() {
        return greet;
    }

    public void setGreet(String greet) {
        this.greet = greet;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String toString() {
        return this.message.toString();
    }

}
/*
*{"messgge":"Hellow",
* "greet":"Hi"
*  }
* */
//Rest Assured