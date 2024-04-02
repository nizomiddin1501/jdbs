package uz.developers.spring.spring1_1.version3;

import uz.developers.spring.spring1_1.version2.Printer;

import java.sql.*;

public class DatabaseService {

    private String url = "jdbc:postgresql://localhost:5432/computer_db";
    private String dbUser = "postgres";
    private String dbPassword = "1234";


    Connection connection = null;

    public void getPC() {
        try {
            connection = DriverManager.getConnection(url, dbUser, dbPassword);
            String query = "select model,price from PC";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String model = resultSet.getString(1);
                int price = resultSet.getInt(2);
                PC pc = new PC(model, price);
                System.out.println(pc);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void getLaptop() {
        try {
            connection = DriverManager.getConnection(url, dbUser, dbPassword);
            String query = "select model,price from Laptop";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String model = resultSet.getString(1);
                int price = resultSet.getInt(2);
                Laptop laptop = new Laptop(model, price);
                System.out.println(laptop);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void getPrinter() {
        try {
            connection = DriverManager.getConnection(url, dbUser, dbPassword);
            String query = "select model,price from Printer";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String model = resultSet.getString(1);
                int price = resultSet.getInt(2);
                Printer printer = new Printer(model, price);
                System.out.println(printer);
            }
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
