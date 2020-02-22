package com.OurTransportClient;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class BirthDate {


    public String input_birth_date() {
        Scanner myInput = new Scanner(System.in);
        System.out.println("Enter date of birth (YYYYMMDD): ");
        String birth_date;
        birth_date = myInput.nextLine();
        SimpleDateFormat fromUser = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {


            String reformattedStr = myFormat.format(fromUser.parse(birth_date));
            birth_date = reformattedStr;
        } catch (ParseException e) {
            System.out.println("Invalid date format");
            birth_date = input_birth_date();

        }

        return birth_date;




    };

}
