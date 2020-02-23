package com.OurTransportClient;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.Scanner;


public class SearchRoom {

    private int number_of_guests;
    private String start_date;
    private String end_date;
    private String has_pool = "X";
    private String has_night_entertainment = "X";
    private String has_kids_club = "X";
    private String has_restaurant = "X";
    private String room_size = "X";

    public SearchRoom() {
        search_available_rooms();
    }


    public int getNumber_of_guests() {
        return number_of_guests;
    }

    public String getHas_pool() {
        return has_pool;
    }

    public String getHas_night_entertainment() {
        return has_night_entertainment;
    }

    public String getHas_kids_club() {
        return has_kids_club;
    }

    public String getHas_restaurant() {
        return has_restaurant;
    }

    public String getRoom_size() {
        return room_size;
    }

    public String getStart_date() {
        return start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void search_available_rooms() {
        System.out.println("Enter number of guests: ");
        Scanner myInput = new Scanner(System.in);

        try {
            this.number_of_guests = myInput.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("invalid input!");
            search_available_rooms();
        }
        System.out.println("Set start date for booking (YYYYMMDD): ");
        this.start_date = set_date();
        System.out.println("Set end date for booking (YYYYMMDD): ");
        this.end_date = set_date();

        set_room_size();

        set_has_ngt_ent();
        set_has_pool();
        set_has_kids_club();
        set_has_restaurant();






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

    public void set_has_kids_club() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Does booking require a kids club? \n for YES, ENTER: 'Y' \n for NO, ENTER: 'N' \n for EITHER, ENTER: 'X'");
        switch (scanner.nextLine().toUpperCase()) {
            case "Y":
                this.has_kids_club = "Y";
                break;
            case "N":
                this.has_kids_club = "N";
                break;
            case "X":
                this.has_kids_club = "X";
                break;
            default:
                System.out.println("invalid input!");

                set_has_kids_club();
        }
    }

    public void set_has_restaurant() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Does booking require a restaurant at the hotel? \n for YES, ENTER: 'Y' \n for NO, ENTER: 'N' \n for EITHER, ENTER: 'X'");
        switch (scanner.nextLine().toUpperCase()) {
            case "Y":
                this.has_restaurant = "Y";
                break;
            case "N":
                this.has_restaurant = "N";
                break;
            case "X":
                this.has_restaurant = "X";
                break;
            default:
                System.out.println("invalid input!");

                set_has_restaurant();
        }
    }

    public void set_room_size() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Does booking require a specific room size? \n for LARGE, ENTER: 'L' \n for MEDIUM, ENTER: 'M'  \n for SMALL, ENTER: 'S' \n for EITHER, ENTER: 'X'");
        switch (scanner.nextLine().toUpperCase()) {
            case "L":
                this.room_size = "L";
                break;
            case "M":
                this.room_size = "M";
                break;
            case "S":
                this.room_size = "S";
                break;
            case "X":
                this.room_size = "X";
                break;
            default:
                System.out.println("invalid input!");

                set_has_restaurant();
        }
    }


    public String set_date() {
        Scanner scanner = new Scanner(System.in);
        String date;
        date = scanner.nextLine();
        SimpleDateFormat fromUser = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {


            date = myFormat.format(fromUser.parse(date));
        } catch (ParseException e) {
            System.out.println("Invalid date format");
            date = set_date();

        }

        return date;

    }


    @Override
    public String toString() {
        return "SearchRoom{" +
                "number_of_guests=" + number_of_guests +
                ", start_date='" + start_date + '\'' +
                ", end_date='" + end_date + '\'' +
                ", has_pool='" + has_pool + '\'' +
                ", has_night_entertainment='" + has_night_entertainment + '\'' +
                ", has_kids_club='" + has_kids_club + '\'' +
                ", has_restaurant='" + has_restaurant + '\'' +
                ", room_size='" + room_size + '\'' +
                '}';
    }
}
