package com.tinne;

import com.tinne.implement.ManufactureDAO;
import com.tinne.implement.PhoneDAO;
import com.tinne.pojo.Manufacture;
import com.tinne.pojo.Phone;

import java.util.List;
import java.util.Scanner;


public class Program

{
    public static void print(List<Phone> list) {
        System.out.println("\n============ BEGIN ============ ");
        try {
            list.forEach(System.out::println);
        } catch (NullPointerException e) {
            System.out.println("Null");
        }
        System.out.println("============ END ============ \n");
    }

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
            System.out.println("4. remove by id");
            System.out.println("5. remove");
            System.out.println("6. Top selling");
            System.out.println("7. Sort ");
            System.out.println("8. check if there is a phone priced above 50 million VND.");
            System.out.println("9. the first phone in the list that meets the criteria: has the color 'Pink' and costs over 15 million");
            System.out.println("------Manufacture------");
            System.out.println("10. add");
            System.out.println("11. get by id");
            System.out.println("12. get all");
            System.out.println("13. remove by id");
            System.out.println("14. remove");
            System.out.println("15. check whether all manufacturers have more than 100 employees.");
            System.out.println("16. sum of all employees of the manufactures.");
            System.out.println("17. the last manufacturer in the list of manufacturers that meet the criteria: based in the US");
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
                    Manufacture manufacture = manufactureDAO.get(mID);
                    phone = new Phone(pID,name,price,color,country,quantity,manufacture);
                    System.out.println(phone);
                    phoneDAO.add(phone);
                    break;
                case 2:
                    System.out.println("Enter ");
                    System.out.print("id\t:");
                    pID = sc.next();
                    System.out.println("Result:");
                    System.out.println(phoneDAO.get(pID));
                    break;
                case 3:
                    print(phoneDAO.getAll());
                    break;
                case 4:
                    System.out.println("Enter ");
                    System.out.print("id\t:");
                    pID = sc.next();
                    phoneDAO.remove(pID);
                    break;
                case 6:
                    System.out.println("Top selling: ");
                    System.out.println(phoneDAO.topSell());

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
