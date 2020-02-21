package com.OurTransportClient;
import java.util.Scanner;

public class Client {
    private SqlConsole console = new SqlConsole();

    public Client(){
        printMenu();
        userPickMenuOption();
    }

    private void printMenu(){
        System.out.println("Choose option:");
        System.out.println("  1  Add new costumer");
        System.out.println("  2  Search individuals by country");
        System.out.println("  3  Get mean education level by country");
    }

    private void userPickMenuOption(){
        Scanner myInput = new Scanner(System.in);
        String option;
        option = myInput.nextLine();
        switch(option){
            case "1":
                client_add_user();

                break;
            case "2":
                System.out.println("You choose 2");
                break;
            case "3":
                System.out.println("You choose 3 - to get mean education level by country");
                System.out.println("  What country?");
                String country;
                country = myInput.nextLine();
                System.out.println("You choose " + country);
                break;
        }
    }

    private void client_add_user(){
        Scanner myInput = new Scanner(System.in);
        System.out.println("Enter name: ");
        String name;
        name = myInput.nextLine();
        System.out.println("Enter email: ");
        String email;
        email = myInput.nextLine();
        System.out.println("Enter date of birth (YYYY-MM-DD): ");
        String birth_date;
        birth_date = myInput.nextLine();
        System.out.println("Enter phone number: ");
        int phone_number;
        phone_number = myInput.nextInt();
        System.out.println("Adding user: \n NAME: "+name+ "\n EMAIL: " +email+ "\n DATE OF BIRTH:" +birth_date+ "\n PHONE NUMBER: "+phone_number+ "\n \n TO CONFIRM, ENTER 'Y':");
        String confirm;
        confirm = myInput.nextLine();
        System.out.println(confirm);
        try {
            if (confirm.equals("Y")){console.add_customer(""+name,""+email,""+birth_date, phone_number);
                System.out.println("Customer " +name+ " added!");}
            else {
                System.out.println("invalid input");
                System.out.println(confirm);
            }
        }catch (Exception e){e.printStackTrace();}



    }


}
