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

    private void searchByFirstName(String namn) {
        try {
            statement = conn.prepareStatement("SELECT * FROM larare WHERE namn LIKE ?");
            statement.setString(1, namn);
            resultSet = statement.executeQuery();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void printSearchResults() {


        try {

            while (resultSet.next()) {

                String row = "id: " + resultSet.getString("id")

                        + ", first_name: " + resultSet.getString("namn");

                System.out.println(row);

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void add_customer(String name, String email, String birth_date, int phone_number){
        try {
            statement = conn.prepareStatement("INSERT INTO user(name, email, birth_date, phone_number) VALUES('"+name+"', '"+email+"', '"+birth_date+"', '"+phone_number+"')");
            statement.executeUpdate();

        } catch(Exception ex){
            ex.printStackTrace();
        }

    }


}
