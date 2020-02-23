package com.OurTransportClient;

import java.lang.invoke.SwitchPoint;
import java.sql.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class SqlConsole {

    public SqlConsole() {
        connect();

    }

    private Connection conn;

    private PreparedStatement statement;
    private ResultSet resultSet;
    private int selected_user;
    private ArrayList<Integer> available_rooms = new ArrayList<>();




    private void connect() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/holidaymaker?user=root&password=mysql&serverTimezone=UTC");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void searchByFirstNameAndEmail(String name, String email) {

        try {
            statement = conn.prepareStatement("SELECT * FROM customers WHERE name LIKE ? AND email = ?");
            statement.setString(1, name);
            statement.setString(2, email);
            resultSet = statement.executeQuery();



        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void search_customer() {
        String name;
        String email;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Searching for customer");
        System.out.println("Enter customer name:");
        name = scanner.nextLine();
        System.out.println("Enter email name:");
        email = scanner.nextLine();
        searchByFirstNameAndEmail(name, email);
        print_user_search_result();
    }
    public ResultSet getResultSet() {
        return resultSet;
    }

    public void search_available_rooms(SearchRoom room) {

        try {
            statement = conn.prepareStatement("CREATE OR\n" +
                    "REPLACE VIEW room_search AS\n" +
                    "SELECT \n" +
                    " rooms.id, rooms.room_number, rooms.size, rooms.hotel\n" +
                    "FROM \n" +
                    " rooms \n" +
                    "LEFT JOIN \n" +
                    " bokings ON (\n" +
                    " bokings.room_id = rooms.id AND NOT (\n" +
                    " (bokings.date_start < ? AND bokings.date_end < ?) OR\n" +
                    " (bokings.date_start > ? AND bokings.date_end > ?) \n" +
                    ")\n" +
                    ")\n" +
                    "WHERE \n" +
                    " bokings.room_id IS NULL AND rooms.size = ? ;");
            statement.setString(5, room.getRoom_size());
            statement.setString(1, room.getStart_date());
            statement.setString(2, room.getStart_date());
            statement.setString(3, room.getEnd_date());
            statement.setString(4, room.getEnd_date());
            statement.executeUpdate();

            statement = conn.prepareStatement( "\nSELECT \n" +
                    " room_search.id, room_search.room_number, room_search.size, room_search.hotel\n" +
                            "FROM \n" +
                            " room_search\n" +
                            "LEFT JOIN hotels ON(hotels.name = room_search.hotel)\n" +
                            "WHERE hotels.pool = ? AND hotels.kids_club = ? AND hotels.night_entertainment = ? AND hotels.resturant = ?;");
            statement.setString(1, room.getHas_pool());
            statement.setString(2, room.getHas_kids_club());
            statement.setString(3, room.getHas_night_entertainment());
            statement.setString(4, room.getHas_restaurant());
            resultSet = statement.executeQuery();
;

           /*if (!room_size.equals("X")){
                statement = conn.prepareStatement( "\nSELECT \n" +
                        " room_search.id, room_search.room_number, room_search.size, room_search.hotel\n" +
                        "FROM \n" +
                        " room_search\n" +
                        "WHERE room_search.size = ?;");
                statement.setString(1, room_size);
                resultSet = statement.executeQuery();
            }


            if (!has_pool.equals("X")){
                statement = conn.prepareStatement( "\nSELECT \n" +
                        " room_search.id, room_search.room_number, room_search.size, room_search.hotel\n" +
                        "FROM \n" +
                        " room_search\n" +
                        "LEFT JOIN hotels ON(hotels.name = room_search.hotel)\n" +
                        "WHERE hotels.pool = ?;");
                statement.setString(1, has_pool);
                resultSet = statement.executeQuery();
            }

            if (!has_kids_club.equals("X")){
                statement = conn.prepareStatement( "\nSELECT \n" +
                        " room_search.id, room_search.room_number, room_search.size, room_search.hotel\n" +
                        "FROM \n" +
                        " room_search\n" +
                        "LEFT JOIN hotels ON(hotels.name = room_search.hotel)\n" +
                        "WHERE hotels.kids_club = ?;");
                statement.setString(1, has_kids_club);
                resultSet = statement.executeQuery();

            }

            if (!has_ngt_ent.equals("X")){
                statement = conn.prepareStatement( "\nSELECT \n" +
                        " room_search.id, room_search.room_number, room_search.size, room_search.hotel\n" +
                        "FROM \n" +
                        " room_search\n" +
                        "LEFT JOIN hotels ON(hotels.name = room_search.hotel)\n" +
                        "WHERE hotels.night_entertainment = ?;");
                statement.setString(1, has_ngt_ent);
                resultSet = statement.executeQuery();
            }

            if (!has_restaurant.equals("X")){
                statement = conn.prepareStatement( "\nSELECT \n" +
                        " room_search.id, room_search.room_number, room_search.size, room_search.hotel\n" +
                        "FROM \n" +
                        " room_search\n" +
                        "LEFT JOIN hotels ON(hotels.name = room_search.hotel)\n" +
                        "WHERE hotels.resturant = ?;");
                statement.setString(1, has_restaurant);
                resultSet = statement.executeQuery();
            }*/


        } catch (Exception e) {
            e.printStackTrace();
        }}

        public void print_user_search_result () {


            try {

                while (resultSet.next()) {
                    selected_user = resultSet.getInt("id");

                    String row = "id: " + resultSet.getString("id")

                            + ", name: " + resultSet.getString("name")
                            + ", email: " + resultSet.getString("email");


                    System.out.println(row);

                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    public ArrayList<Integer> getAvailable_rooms() {
        return available_rooms;
    }

    public void print_available_rooms_search_result () {


            try {

                while (resultSet.next()) {

                    available_rooms.add(resultSet.getInt("id"));


                    String row = "Room id: " + resultSet.getString("id")
                            + "\nRoom number: " + resultSet.getString("room_number")
                            + "\nRoom size: " + resultSet.getString("size")
                            + "\nHotel: " + resultSet.getString("hotel");


                    System.out.println(row);

                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        private void get_hotel_name_by_room_id(int room_id){


        try {
            statement = conn.prepareStatement( "\nSELECT \n" +
                    " rooms.hotel, rooms.room_number\n" +
                    "FROM \n" +
                    " rooms\n" +
                    "WHERE rooms.id = ?;");
                    statement.setInt(1, room_id);
            resultSet = statement.executeQuery();
            resultSet.next();


        }


         catch (Exception e) {
                e.printStackTrace();
            }

        };

   public void add_customer (String name, String email, String birth_date,int phone_number){
            try {
                statement = conn.prepareStatement("INSERT INTO customers(name, email, birth_date, phone_number) VALUES('" + name + "', '" + email + "', '" + birth_date + "', '" + phone_number + "')");
                statement.executeUpdate();

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }



    public void pick_room_menu(int room_id,  String date_start, String date_end, int people) {
        search_customer();
        get_hotel_name_by_room_id(room_id);

        while (true) {try {


            try {
                statement = conn.prepareStatement("INSERT INTO bokings(date_start, date_end, hotel, room_id, room_number, customer_id, people) VALUES('" + date_start + "', '" + date_end + "', '" + resultSet.getString("hotel") + "', '" + room_id + "', '"  + resultSet.getString("room_number") + "', '" + selected_user +"', '"  + people + "')");
                statement.executeUpdate();
                break;

            } catch (Exception ex) {
                ex.printStackTrace();
                break;
            }


        }catch (InputMismatchException e){
            System.out.println("invalid input");

        }
        ;}



    }


    public void remove_booking()

    {

        try {
            statement = conn.prepareStatement("SELECT * FROM bokings");
            resultSet = statement.executeQuery();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        try {

            while (resultSet.next()) {

                String row = "Booking id: " + resultSet.getString("id")
                        + " Date Start: " + resultSet.getString("date_start") + "Date end: " + resultSet.getString("date_end")
                        + " Hotel: " + resultSet.getString("hotel")
                        + " Room number: " + resultSet.getString("room_number")
                        + " Number of guests: " + resultSet.getString("hotel")
                        + " Customerid: " + resultSet.getString("customer_id");


                System.out.println(row);

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        System.out.println("Enter 0 to return to main menu. Enter room id to remove booking: ");

        Scanner scanner = new Scanner(System.in);
       while (true)
       {try {
           int user_input = scanner.nextInt();
           if (user_input == 0){
                   break;

           }
           else {
               try {
                   statement = conn.prepareStatement("DELETE FROM bokings  WHERE id = ? ");
                   statement.setInt(1, user_input);
                   statement.executeUpdate();

                   System.out.println("booking deleted.");



               } catch (Exception e) {
                   e.printStackTrace();
               }

           }
           break;
       }
       catch (InputMismatchException e){
           System.out.println("invalid input!");
       }}




    }

}
