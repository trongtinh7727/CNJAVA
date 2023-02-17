package com.lab03.modal;

public class SinhVien {
    private String mssv;
    private String gender;

    private int age;
    private float avg;

    public SinhVien(String mssv) {
        this.mssv = mssv;
        this.gender = null;
        this.age = -1;
        this.avg = -1;
    }

    public SinhVien() {
        this.mssv = null;
        this.gender = null;
        this.age = -1;
        this.avg = -1;
    }

    public SinhVien(String mssv, String gender, int age, float avg) {
        this.mssv = mssv;
        this.gender = gender;
        this.age = age;
        this.avg = avg;
    }

    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
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

    public float getAvg() {
        return avg;
    }

    public void setAvg(float avg) {
        this.avg = avg;
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                 mssv + "\t" +
                 gender + '\t' +
                 age + '\t' +
                 avg +
                '}';
    }
}
