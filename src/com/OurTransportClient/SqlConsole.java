package com.OurTransportClient;

import java.sql.*;


public class SqlConsole {

    public SqlConsole() {
        connect();

    }

    private Connection conn;

    private PreparedStatement statement;
    private ResultSet resultSet;

    private void connect() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/holidaymaker?user=root&password=mysql&serverTimezone=UTC");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchByFirstNameAndEmail(String name, String email) {
        try {
            statement = conn.prepareStatement("SELECT * FROM customers WHERE name LIKE ? AND email = ?");
            statement.setString(1, name);
            statement.setString(2, email);
            resultSet = statement.executeQuery();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void search_available_rooms(String start_date, String end_date, String room_size) {
        try {
            statement = conn.prepareStatement("CREATE OR\n" +
                    "REPLACE VIEW room_search AS\n" +
                    "SELECT \n" +
                    " rooms.id, rooms.room_number, rooms.size, rooms.hotel\n" +
                    "FROM \n" +
                    " rooms\n" +
                    "LEFT JOIN \n" +
                    " bokings ON (\n" +
                    " bokings.room_id = rooms.id AND NOT (\n" +
                    " (bokings.date_start < ? AND bokings.date_end < ?) OR\n" +
                    " (bokings.date_start > ? AND bokings.date_end > ?) \n" +
                    ")\n" +
                    ")\n" +
                    "WHERE \n" +
                    " bokings.room_id IS NULL;");
            statement.setString(1, start_date);
            statement.setString(2, start_date);
            statement.setString(3, end_date);
            statement.setString(4, end_date);
            statement.executeUpdate();
            if (!room_size.equals("X")){
                statement = conn.prepareStatement("SELECT \n" +
                        " room_search.id, room_search.room_number, room_search.size, room_search.hotel\n" +
                        "FROM \n" +
                        " room_search\n" +
                        "WHERE room_search.size LIKE ?;");
                statement.setString(1, room_size);
                resultSet = statement.executeQuery();
            }



        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void print_user_search_result() {


        try {

            while (resultSet.next()) {

                String row = "id: " + resultSet.getString("id")

                        + ", name: " + resultSet.getString("name")
                        + ", email: " + resultSet.getString("email");


                System.out.println(row);

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void print_available_rooms_search_result() {


        try {

            while (resultSet.next()) {

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

    public void add_customer(String name, String email, String birth_date, int phone_number){
        try {
            statement = conn.prepareStatement("INSERT INTO customers(name, email, birth_date, phone_number) VALUES('"+name+"', '"+email+"', '"+birth_date+"', '"+phone_number+"')");
            statement.executeUpdate();

        } catch(Exception ex){
            ex.printStackTrace();
        }

    }




}
