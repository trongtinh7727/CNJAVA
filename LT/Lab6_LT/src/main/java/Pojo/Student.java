package Pojo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="student")
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String course;
    private int fee;

    public Student(String name, String course, int fee) {
        this.name = name;
        this.course = course;
        this.fee = fee;
    }

    public Student() {
    }

    public Student(int id, String name, String course, int fee) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.fee = fee;
    }
    public void copy(Student student) {
        this.name = student.name;
        this.course = student.course;
        this.fee = student.fee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }
}

