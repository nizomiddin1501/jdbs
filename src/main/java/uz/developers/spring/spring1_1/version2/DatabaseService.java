package uz.developers.spring.spring1_1.version2;

import java.sql.*;

public class DatabaseService {

    private String url = "jdbc:postgresql://localhost:5432/computer_db";
    private String dbUser = "postgres";
    private String dbPassword = "1234";



    public void outputDates(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url,dbUser,dbPassword);
            String query = "select model,price from Laptop order by price asc";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String model = resultSet.getString(1);
                int price = resultSet.getInt(2);
                Laptop laptop = new Laptop(model,price);
                System.out.println(laptop);
            }
            preparedStatement.close();
            System.out.println("///////////////");
            String query1 = "select model,price from PC order by price asc";
            PreparedStatement preparedStatement1 = connection.prepareStatement(query1);
            ResultSet resultSet1 = preparedStatement1.executeQuery();
            while (resultSet1.next()) {
                String model = resultSet1.getString(1);
                int price = resultSet1.getInt(2);
                PC pc = new PC(model,price);
                System.out.println(pc);
            }
            preparedStatement1.close();
            System.out.println("///////////////");
            String query2 = "select model,price from Printer order by price asc";
            PreparedStatement preparedStatement2 = connection.prepareStatement(query2);
            ResultSet resultSet2 = preparedStatement2.executeQuery();
            while (resultSet2.next()) {
                String model = resultSet2.getString(1);
                int price = resultSet2.getInt(2);
                Printer printer = new Printer(model,price);
                System.out.println(printer);
            }
            preparedStatement2.close();
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }





}
