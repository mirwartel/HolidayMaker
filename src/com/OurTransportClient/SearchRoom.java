package com.OurTransportClient;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.Scanner;


public class SearchRoom {

    private int number_of_guests;
    private String start_date;
    private String end_date;
    private Customer customer;
    private String has_pool = "X";
    private String has_night_entertainment = "X";
    private String has_kids_club = "X";
    private String has_resturant = "X";
    private String room_size = "X";

    public SearchRoom(){
        search_available_rooms();
    }


    private void search_available_rooms(){
        System.out.println("Enter number of guests: ");
        Scanner myInput = new Scanner(System.in);

        try {
            this.number_of_guests = myInput.nextInt();
        }
        catch (InputMismatchException e) {
            System.out.println("invalid input!");
            search_available_rooms();
        }

        set_has_ngt_ent();
        set_has_pool();
        System.out.println("Set start date for booking (YYMMDD): ");
        this.start_date = set_date();
        System.out.println("Set start date for booking (YYMMDD): ");
        this.end_date = set_date();

    }

    public void set_has_ngt_ent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Does booking require a night entertainment? \n for YES, ENTER: 'Y' \n for NO, ENTER: 'N' \n for EITHER, ENTER: 'X'");
        switch (scanner.nextLine().toUpperCase()) {
            case "Y":
                this.has_night_entertainment = "Y";
                break;
            case "N":
                this.has_night_entertainment = "N";
                break;
            case "X":
                this.has_night_entertainment = "X";
                break;
            default:
                System.out.println("invalid input!");

                set_has_ngt_ent();
        }


    }

    public void set_has_pool() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Does booking require a pool? \n for YES, ENTER: 'Y' \n for NO, ENTER: 'N' \n for EITHER, ENTER: 'X'");
        switch (scanner.nextLine().toUpperCase()) {
            case "Y":
                this.has_pool = "Y";
                break;
            case "N":
                this.has_pool = "N";
                break;
            case "X":
                this.has_pool = "X";
                break;
            default:
                System.out.println("invalid input!");

                set_has_pool();
        }
    }

    public String set_date() {
        Scanner scanner = new Scanner(System.in);
        String date;
        date = scanner.nextLine();
        SimpleDateFormat fromUser = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {


            String reformattedStr = myFormat.format(fromUser.parse(date));
            date = reformattedStr;
        } catch (ParseException e) {
            System.out.println("Invalid date format");
            date = set_date();

        }

        return date;

    }


}
