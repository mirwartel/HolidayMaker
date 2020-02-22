package com.OurTransportClient;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    public void client_add_user(){
        Scanner myInput = new Scanner(System.in);
        System.out.println("Enter name: ");
        String name;
        name = myInput.nextLine();
        System.out.println("Enter email: ");
        String email;
        email = myInput.nextLine();

        String birth_date;
        birth_date = new BirthDate().input_birth_date();

        System.out.println("Enter phone number: ");
        int phone_number;
        phone_number = myInput.nextInt();

        while (true){try {

            System.out.println("\nAdding user: \n NAME: "+name+ "\n EMAIL: " +email+ "\n DATE OF BIRTH: " +birth_date+ "\n PHONE NUMBER: "+phone_number+ "\n \n TO CONFIRM, ENTER 'Y'\n TO RE-ENTER INFO, ENTER 'N'\n TO RETURN TO MAIN-MENU, ENTER 'M':");
            String confirm;
            confirm = myInput.nextLine().toUpperCase();

            switch (confirm) {
                case "Y":
                    console.add_customer("" + name, "" + email, "" + birth_date, phone_number);
                    System.out.println("\nCustomer " + name + " added!");
                    return;

                case "N":
                    client_add_user();

                    break;
                case "M":
                    printMenu();
                    userPickMenuOption();

                    break;
                default:
                    System.out.println("invalid input");
                    break;
            }
        }catch (Exception e){e.printStackTrace();}}



    }




}
