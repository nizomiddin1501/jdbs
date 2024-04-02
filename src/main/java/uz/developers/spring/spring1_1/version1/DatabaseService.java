package uz.developers.spring.spring1_1.version1;

import java.sql.*;

public class DatabaseService {

    private String url = "jdbc:postgresql://localhost:5432/computer_db";
    private String dbUser = "postgres";
    private String dbPassword = "1234";




    public void getProduct(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url,dbUser,dbPassword);
            String query = "select*from product";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
//                int id = resultSet.getInt(1);
                String maker = resultSet.getString(1);
                String model = resultSet.getString(2);
                String price = resultSet.getString(3);
                Product product = new Product(maker,model,price);
                System.out.println(product);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
