package shivam.chapter11.demo;

public class GetCourses {

    public GetCourses(){

    }
    private String name;
    private String url;
    private String services;
    private String experties;
    private String linkedIn;

  //  private List<Courses> courses;



    public String getUrl() {
        return url;
    }

    public String getServices() {
        return services;
    }

    public String getExperties() {
        return experties;
    }

    public String getLinkedIn() {
        return linkedIn;
    }

//   // public List<Courses> getCourses() {
//        return courses;
//    }



    public void setUrl(String url) {
        this.url = url;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public void setExperties(String experties) {
        this.experties = experties;
    }

    public void setLinkedIn(String linkedIn) {
        this.linkedIn = linkedIn;
    }

//    public void setCourses(List<Courses> courses) {
//        this.courses = courses;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
