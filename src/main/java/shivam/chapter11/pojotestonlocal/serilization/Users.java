package shivam.chapter11.pojotestonlocal.serilization;

import java.util.List;

public class Users {

    private List<Student> student;
    private List<Parent> parent ;


    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }

    public List<Parent> getParent() {
        return parent;
    }

    public void setParent(List<Parent> parent) {
        this.parent = parent;
    }
}
