package com.OurTransportClient;

import java.sql.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Customer {

    String name;
    String email;
    int phone_number;
    String birth_date;

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone_number=" + phone_number +
                ", birth_date='" + birth_date + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public String getBirth_date() {
        return birth_date;
    }

    public Customer(){
        setName();
        setEmail();
        setPhone_number();
        setBirth_date();
    }

    public void setName() {
        Scanner myInput = new Scanner(System.in);
        System.out.println("Enter name: ");
        this.name = myInput.nextLine();

    }

    public void setEmail() {
        Scanner myInput = new Scanner(System.in);
        System.out.println("Enter email: ");
        this.email = myInput.nextLine();
    }

    public void setPhone_number() {
        Scanner myInput = new Scanner(System.in);
        try {
            System.out.println("Enter phone number: ");
            this.phone_number = myInput.nextInt();
        }
        catch (InputMismatchException e) {
            System.out.println("invalid input!");
            setPhone_number();
        }




    }

    public void setBirth_date() {
        this.birth_date = new BirthDate().input_birth_date();
    }
}
