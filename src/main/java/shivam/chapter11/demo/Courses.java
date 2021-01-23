package shivam.chapter11.demo;

import java.util.List;

public class Courses {
    public Courses(){

    }
    private List<WebAutomation> webAutomations;
    private List<Api> apis;
    private List<Mobile> mobiles;

    public List<WebAutomation> getWebAutomations() {
        return webAutomations;
    }

    public List<Api> getApis() {
        return apis;
    }

    public List<Mobile> getMobiles() {
        return mobiles;
    }

    public void setWebAutomations(List<WebAutomation> webAutomations) {
        this.webAutomations = webAutomations;
    }

    public void setApis(List<Api> apis) {
        this.apis = apis;
    }

    public void setMobiles(List<Mobile> mobiles) {
        this.mobiles = mobiles;
    }
}
