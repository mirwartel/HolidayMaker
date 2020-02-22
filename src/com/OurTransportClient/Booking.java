package com.OurTransportClient;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Booking {
    private int number_of_guests;
    private String start_date;
    private String end_date;
    private Customer customer;
    private String has_pool = "X";
    private String has_night_entertainment = "X";
    private String has_kids_club = "X";
    private String has_resturant = "X";
    private String room_size = "X";



    public void setNumber_of_guests(int number_of_guests) {
        this.number_of_guests = number_of_guests;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setHas_pool(String has_pool) {
        this.has_pool = has_pool;
    }

    public void setHas_night_entertainment(String has_night_entertainment) {
        this.has_night_entertainment = has_night_entertainment;
    }

    public void setHas_kids_club(String has_kids_club) {
        this.has_kids_club = has_kids_club;
    }

    public void setHas_resturant(String has_resturant) {
        this.has_resturant = has_resturant;
    }

    public void setRoom_size(String room_size) {
        this.room_size = room_size;
    }

    public Booking() {
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
}