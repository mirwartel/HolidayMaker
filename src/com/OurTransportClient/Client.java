package com.OurTransportClient;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Client {
    private SqlConsole console = new SqlConsole();

    public Client() {
        print_main_menu();
        userPickMenuOption();
    }

    private void print_main_menu() {
        System.out.println("Choose option:");
        System.out.println("  1  Add new costumer");
        System.out.println("  2  Search for available rooms");
        System.out.println("  3  Search customer by first name");
        System.out.println("  9  Terminate program");
    }

    private void userPickMenuOption() {
        Scanner myInput = new Scanner(System.in);
        String option;
        option = myInput.nextLine();
        switch (option) {
            case "1":
                client_add_customer();
                print_main_menu();
                userPickMenuOption();

                break;
            case "2":
                System.out.println("You choose 2");
                SearchRoom searchRoom = new SearchRoom();
                System.out.println(searchRoom);
                console.search_available_rooms(searchRoom);
                console.print_available_rooms_search_result();
                print_rooms_menu();
                int room_id = myInput.nextInt();
                console.pick_room_menu(room_id, searchRoom.getStart_date(), searchRoom.getEnd_date(), searchRoom.getNumber_of_guests());
                print_main_menu();
                userPickMenuOption();




                break;

            case "3":
                console.search_customer();

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

    private void client_add_customer() {

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
                        print_main_menu();
                        userPickMenuOption();

                        break;

                    default:
                        System.out.println("invalid input");
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



    private void print_rooms_menu() {
        System.out.println("To return to main menu, ENTER '0':");
        System.out.println("To book room, ENTER room id:");

    }














}





