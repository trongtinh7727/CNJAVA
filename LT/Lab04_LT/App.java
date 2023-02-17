package com.tinne;

import com.tinne.pojo.Student;
import com.tinne.pojo.StudentPojo;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void print(List<Student> list) {
        System.out.println("\n============ BEGIN ============ ");
        try {
            list.forEach(System.out::println);
        } catch (NullPointerException e) {
            System.out.println("Null");
        }
        System.out.println("============ END ============ \n");
    }

    public static void menu() {
        StudentPojo studentPojo = new StudentPojo();
        int choice = 1;
        do {
            System.out.println("-----------MENU---------------n");
            ;
            System.out.println("1. Hien thi danh sach sinh vien");
            System.out.println("2. Hien thi danh sach sinh vien theo MSSV");
            System.out.println("3. Them sinh vien moi voi MSSV tu dong");
            System.out.println("4. Cap nhat thong tin sinh vien");
            System.out.println("5. Xoa sinh vien");
            System.out.println("6. Thoat");
            Scanner sc = new Scanner(System.in);
            System.out.print("Lua chon cua ban: ");
            choice = sc.nextInt();
            int id, age, check;
            String gender, mssv;
            float avg;
            Student student;
            switch (choice) {
                case 1:
                    List<Student> ds = studentPojo.sellectAll();
                    System.out.println("Danh sach sinh vien:");
                    print(ds);
                    break;
                case 2:
                    System.out.println("Nhap mssv:");
                    mssv = sc.next();
                    System.out.println("Sinh vien la");
                    System.out.println(studentPojo.selectById(mssv));
                    break;
                case 3:
//                    System.out.print("Nhap massv sinh vien: ");
//                    mssv = sc.next();
                    System.out.print("Nhap gioi tinh sinh vien: ");
                    gender = sc.next();
                    System.out.print("Nhap tuoi sinh vien: ");
                    age = sc.nextInt() ;
                    System.out.print("Nhap diem trung binh sinh vien: ");
                    avg = sc.nextFloat();

                    check = studentPojo.insert(new Student(gender,age,avg));
                    if (check == 1) {
                        System.out.println("Thanh cong!");
                    }else {
                        System.out.println("That bai!");
                    }
                    break;
                case 4:
                    System.out.print("Nhap massv sinh vien can cap nhat: ");
                    id = sc.nextInt();
                    System.out.print("Nhap gioi tinh sinh vien: ");
                    gender = sc.next();
                    System.out.print("Nhap tuoi sinh vien: ");
                    age = sc.nextInt() ;
                    System.out.print("Nhap diem trung binh sinh vien: ");
                    avg = sc.nextFloat();

                    check =studentPojo.upate(new Student(id,gender,age,avg) );
                    if (check == 1) {
                        System.out.println("Thanh cong!");
                    }else {
                        System.out.println("That bai!");
                    }
                    break;
                case 5:
                    System.out.print("Nhap MSSV sinh vien can xoa: ");
                    id = sc.nextInt();
                    check = studentPojo.delete(id);
                    if (check == 1) {
                        System.out.println("Thanh cong!");
                    }else {
                        System.out.println("That bai!");
                    }
                    break;
                default:
                    break;
            }
        }
        while (choice != 6);
    }

    public static void main(String[] args) {
        menu();
    }
}
