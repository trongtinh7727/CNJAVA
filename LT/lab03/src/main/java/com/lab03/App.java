package com.lab03;

import com.lab03.implement.SinhVienDAO;
import com.lab03.modal.SinhVien;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

public class App
{

    public static void print(List<SinhVien> list) {
        System.out.println("\n============ BEGIN ============ ");
        try {
            list.forEach(System.out::println);
        }
        catch (NullPointerException e)
        {
            System.out.println("Null");
        }
        System.out.println("============ END ============ \n");
    }
    public  static void menu(){
        SinhVienDAO sinhVienDAO = new SinhVienDAO();
        int choice = 1;
        do
        {
            System.out.println ("-----------MENU---------------n"); ;
            System.out.println("1. Hien thi danh sach sinh vien");
            System.out.println("2. Hien thi danh sach sinh vien theo MSSV");
            System.out.println("3. Them sinh vien moi voi MSSV tu dong");
            System.out.println("4. Cap nhat thong tin sinh vien");
            System.out.println("5. Xoa sinh vien");
            System.out.println("6. Thoat");
            Scanner sc = new Scanner(System.in);
            System.out.print("Lua chon cua ban: ");
            choice = sc.nextInt();
            int id, age;
            String gender,mssv;
            float avg;
            SinhVien student;
            switch (choice){
                case 1:
                    List<SinhVien> ds =sinhVienDAO.sellectAll();
                    System.out.println("Danh sach sinh vien:");
                    print(ds);
                    break;
                case 2:
                    System.out.println("Nhap mssv:");
                    mssv = sc.next();
                    System.out.println("Sinh vien la");
                    System.out.println(sinhVienDAO.selectById(mssv));
                    break;
                case 3:
                    System.out.print("Nhap massv sinh vien: ");
                    mssv = sc.next();
                    System.out.print("Nhap gioi tinh sinh vien: ");
                    gender = sc.next();
                    System.out.print("Nhap tuoi sinh vien: ");
                    age = sc.nextInt() ;
                    System.out.print("Nhap diem trung binh sinh vien: ");
                    avg = sc.nextFloat();
                    id = sinhVienDAO.insert(new SinhVien(mssv,gender,age,avg));
                    if (id == 1) {
                        System.out.println("Thanh cong!");
                    }else {
                        System.out.println("That bai!");
                    }
                    break;
                case 4:
                    System.out.print("Nhap massv sinh vien can cap nhat: ");
                    mssv = sc.next();
                    System.out.print("Nhap gioi tinh sinh vien: ");
                    gender = sc.next();
                    System.out.print("Nhap tuoi sinh vien: ");
                    age = sc.nextInt() ;
                    System.out.print("Nhap diem trung binh sinh vien: ");
                    avg = sc.nextFloat();
                    id =sinhVienDAO.upate(new SinhVien(mssv,gender,age,avg));
                    if (id == 1) {
                        System.out.println("Thanh cong!");
                    }else {
                        System.out.println("That bai!");
                    }
                    break;
                case 5:
                    System.out.print("Nhap MSSV sinh vien can xoa: ");
                    mssv = sc.next();
                    id = sinhVienDAO.delete(new SinhVien(mssv));
                    if (id == 1) {
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
    public static void main( String[] args )
    {
            menu();
    }
}
