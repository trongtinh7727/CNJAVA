package com.tinne;

import com.tinne.implement.ManufactureDAO;
import com.tinne.implement.PhoneDAO;
import com.tinne.pojo.Manufacture;
import com.tinne.pojo.Phone;

import java.util.List;
import java.util.Scanner;


public class Program

{
    public static void menu() {
        PhoneDAO phoneDAO = new PhoneDAO(Phone.class);
        ManufactureDAO manufactureDAO = new ManufactureDAO(Manufacture.class);
        int choice = 1;
        do {
            System.out.println("-----------MENU---------------n");
            System.out.println("------Phone------");
            System.out.println("1. add");
            System.out.println("2. get by id");
            System.out.println("3. get all");
            System.out.println("4. remove");
            System.out.println("5. Top selling");
            System.out.println("6. Sort ");
            System.out.println("7. check if there is a phone priced above 50 million VND.");
            System.out.println("8. the first phone in the list that meets the criteria: has the color 'Pink' and costs over 15 million");
            System.out.println("------Manufacture------");
            System.out.println("9. add");
            System.out.println("10. get by id");
            System.out.println("11. get all");
            System.out.println("12. remove by id");
            System.out.println("13. check whether all manufacturers have more than 100 employees.");
            System.out.println("14. sum of all employees of the manufactures.");
            System.out.println("15. the last manufacturer in the list of manufacturers that meet the criteria: based in the US");
            System.out.println("0. exit");
            Scanner sc = new Scanner(System.in);
            System.out.print("Your choice: ");

            choice = sc.nextInt();
             String pID,mID;
             String name;
             int price;
             String color;
             String country;
             String location;
             int employee;
             int quantity;
              boolean check = true;
              Phone phone;
            Manufacture manufacture;
            switch (choice) {
                case 1:
                    System.out.println("Enter ");
                    System.out.print("id\t:");
                    pID = sc.next();
                    System.out.print("name\t:");
                    name = sc.next();
                    System.out.print("color\t:");
                    color = sc.next();
                    System.out.print("price\t:");
                    price = sc.nextInt();
                    System.out.print("country\t:");
                    country = sc.next();
                    System.out.print("quantity\t:");
                    quantity = sc.nextInt();
                    System.out.print("Manufacture id\t:");
                    mID = sc.next();
                    manufacture = manufactureDAO.get(mID);
                    phone = new Phone(pID,name,price,color,country,quantity,manufacture);
                    System.out.println(phone);
                    phoneDAO.add(phone);
                    System.out.println("done!");
                    break;
                case 2:
                    System.out.println("Enter ");
                    System.out.print("id\t:");
                    pID = sc.next();
                    System.out.println("Result:");
                    System.out.println(phoneDAO.get(pID));
                    System.out.println("done!");
                    break;
                case 3:
                    phoneDAO.print(phoneDAO.getAll());
                    System.out.println("done!");
                    break;
                case 4:
                    System.out.println("Enter ");
                    System.out.print("id\t:");
                    pID = sc.next();
                    phoneDAO.remove(pID);
                    System.out.println("done!");
                    break;
                case 5:
                    System.out.println("Top selling: ");
                    System.out.println(phoneDAO.topSell());
                    System.out.println("done!");
                    break;
                case 6:
                    System.out.println("List of phone sorted: ");
                    System.out.println(phoneDAO.sort());
                    System.out.println("done!");
                    break;
                case 7:
                    System.out.printf("there is a phone priced above 50 million VND: %b\n",phoneDAO.above50Milion());
//                    System.out.println(phoneDAO.above50Milion());
                    System.out.println("done!");
                    break;
                case 8:
                    System.out.println("the first phone in the list that meets the criteria:");
                    System.out.println(phoneDAO.meetCriteria());
                    System.out.println("done!");
                    break;
                case 9:
                    System.out.println("Enter ");
                    System.out.print("id\t:");
                    mID = sc.next();
                    System.out.print("name\t:");
                    name = sc.next();
                    System.out.print("location\t:");
                    location = sc.next();
                    System.out.print("number of employee\t:");
                    employee = sc.nextInt();
                    manufacture = new Manufacture(mID,name,location,employee);
                    manufactureDAO.add(manufacture);
                    System.out.println(manufacture);
                    System.out.println("done!");
                    break;
                case 10:
                    System.out.println("Enter ");
                    System.out.print("id\t:");
                    mID = sc.next();
                    System.out.println("Result:");
                    System.out.println(manufactureDAO.get(mID));
                    System.out.println("done!");
                    break;
                case 11:
                    manufactureDAO.print(manufactureDAO.getAll());
                    System.out.println("done!");
                    break;
                case 12:
                    System.out.println("Enter ");
                    System.out.print("id\t:");
                    mID = sc.next();
                    manufactureDAO.remove(mID);
                    System.out.println("done!");
                    break;
                case 13:
                    System.out.printf("all manufacturers have more than 100 employees: %b\n",manufactureDAO.chkMoreT100());
                    System.out.println("done!");
                    break;
                case 14:
                    System.out.printf("sum of all employees of the manufactures: %d\n",manufactureDAO.countEmployee());
                    System.out.println("done!");
                    break;
                case 15:
                    System.out.println("the last manufacturer in the list of manufacturers that meet the criteria:");
                    System.out.println(manufactureDAO.chkCriteria());
                    System.out.println("done!");
                    break;
                default:
                    break;
            }
        }
        while (choice != 0);
    }

    public static void main( String[] args )
    {
        menu();
    }
}
