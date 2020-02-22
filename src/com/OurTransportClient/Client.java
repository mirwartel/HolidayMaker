package com.OurTransportClient;

import java.util.Scanner;

public class Client {
    private SqlConsole console = new SqlConsole();

    public Client() {
        printMenu();
        userPickMenuOption();
    }

    private void printMenu() {
        System.out.println("Choose option:");
        System.out.println("  1  Add new costumer");
        System.out.println("  2  Search individuals by country");
        System.out.println("  3  Get mean education level by country");
        System.out.println("  9  Terminate program");
    }

    private void userPickMenuOption() {
        Scanner myInput = new Scanner(System.in);
        String option;
        option = myInput.nextLine();
        switch (option) {
            case "1":
                client_add_customer();
                printMenu();
                userPickMenuOption();

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

            case "9":
                System.out.println("Exiting Program");
                System.exit(0);
                break;

            default:
                System.out.println("Invalid input!");
                userPickMenuOption();
                break;
        }
    }

    public void client_add_customer() {

        Scanner myInput = new Scanner(System.in);
        Customer customer = new Customer();

        while (true) {



        try {


            System.out.println("\nAdding customer:" + customer.toString());
            System.out.println("To confirm, ENTER: 'Y'");
            System.out.println("To return to Main_Menu, ENTER: 'M'");
            System.out.println("To edit customer info, ENTER: 'N'");
            String confirm;
            confirm = myInput.nextLine().toUpperCase();

            switch (confirm) {
                case "Y":
                    console.add_customer("" + customer.getName(), "" + customer.getEmail(), "" + customer.getBirth_date(), customer.getPhone_number());
                    System.out.println("\nCustomer " + customer.getName() + " added!");
                    return;

                case "N":
                    client_add_customer();

                    return;
                case "M":
                    printMenu();
                    userPickMenuOption();

                    break;

                default:
                    System.out.println("invalid input");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }}


}





