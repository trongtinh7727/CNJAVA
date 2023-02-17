package com.tinne.pojo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="student")
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String gender;
    private int age;

    public Student(String gender, int age, double avg) {
        this.gender = gender;
        this.age = age;
        this.avg = avg;
    }

    public Student(int id, String gender, int age, double avg) {
        this.id = id;
        this.gender = gender;
        this.age = age;
        this.avg = avg;
    }

    public void copy(Student student) {
        this.gender = student.getGender();
        this.age = student.getAge();
        this.avg = student.getAvg();
    }

    public Student() {
    }

    private double avg;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", avg=" + avg +
                '}';
    }
}

