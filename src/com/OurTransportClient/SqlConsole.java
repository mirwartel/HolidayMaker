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

    public void search_available_rooms() {
        try {
            statement = conn.prepareStatement("SELECT * FROM rooms WHERE hotel and number NOT in bookings");

            resultSet = statement.executeQuery();


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

    public void add_customer(String name, String email, String birth_date, int phone_number){
        try {
            statement = conn.prepareStatement("INSERT INTO customers(name, email, birth_date, phone_number) VALUES('"+name+"', '"+email+"', '"+birth_date+"', '"+phone_number+"')");
            statement.executeUpdate();

        } catch(Exception ex){
            ex.printStackTrace();
        }

    }




}
