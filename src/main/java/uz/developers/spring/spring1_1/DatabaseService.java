package uz.developers.spring.spring1_1;

import java.sql.*;

public class DatabaseService {
    private String url = "jdbc:postgresql://localhost:5432/app_jdbc_example";
    private String dbUser = "postgres";
    private String dbPassword = "1234";

    public void saveUser(User user) {

        try {
            Connection connection = DriverManager.getConnection(url, dbUser, dbPassword);
            Statement statement = connection.createStatement();
            String query = "insert into users(firstname,lastname,username,password) " +
                    "values('" + user.getFirstname() + "','"
                    + user.getLastname() + "','"
                    + user.getUsername() + "','"
                    + user.getPassword() + "');";
            statement.execute(query);
            System.out.println("User is added");
            statement.close();
            connection.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void getUsers() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, dbUser, dbPassword);
            Statement statement = connection.createStatement();
            String query = "select*from users";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstname = resultSet.getString(2);
                String lastname = resultSet.getString(3);
                String username = resultSet.getString(4);
                String password = resultSet.getString("password");
                User user = new User(id, firstname, lastname, username, password);
                System.out.println(user);

            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteUser(int userId) {

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, dbUser, dbPassword);
            Statement statement = connection.createStatement();
            String query = "delete from users where id = " + userId;
            boolean execute = statement.execute(query);
            System.out.println("User is deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


    public void editUser(User user) {
        Connection connection = null;
        try {
             connection = DriverManager.getConnection(url, dbUser, dbPassword);
            Statement statement = connection.createStatement();

            String query = "update users set ";
            if (!user.getFirstname().isEmpty())
                query = query + "firstname ='" + user.getFirstname() + "',";

            if (!user.getLastname().isEmpty())
                query = query + "lastname ='" + user.getLastname() + "',";

            if (!user.getUsername().isEmpty())
                query = query + "username ='" + user.getUsername() + "',";

            if (!user.getPassword().isEmpty())
                query = query + "password ='" + user.getPassword() + "'";

            if (!query.equals("update users set")) {
                if (query.endsWith("',")) {
                    query = query.substring(0, query.length() - 1);
                }
                query = query + "where id = " + user.getId();
                statement.execute(query);
                System.out.println("User is edited");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


    //preparedStatement

    public void saveUserPreparedStatement(User user){
        try {
            Connection connection = DriverManager.getConnection(url,dbUser,dbPassword);
            String query = "insert into users(firstname,lastname,username,password)values(?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,user.getFirstname());
            preparedStatement.setString(2,user.getLastname());
            preparedStatement.setString(3,user.getUsername());
            preparedStatement.setString(4,user.getPassword());
            preparedStatement.executeUpdate();
            System.out.println("User is added by preparedStatement");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void getUsersPreparedStatement(){
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url,dbUser,dbPassword);
            String query = "select * from users";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String firstname = resultSet.getString(2);
                String lastname = resultSet.getString(3);
                String username = resultSet.getString(4);
                String password = resultSet.getString(5);
                User user = new User(id,firstname,lastname,username,password);
                System.out.println(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void editUsersPreparedStatement(User user){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url,dbUser,dbPassword);
            String query = "update users set firstname=?, lastname=?, username=?, password=? where id=? ";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,user.getFirstname());
            preparedStatement.setString(2,user.getLastname());
            preparedStatement.setString(3,user.getUsername());
            preparedStatement.setString(4,user.getPassword());
            preparedStatement.setInt(5,user.getId());
            preparedStatement.executeUpdate();
            System.out.println("User is edited");


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public void deleteUserPrepareStatement(int userId){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url,dbUser,dbPassword);
            String query = "delete from users where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,userId);
            preparedStatement.executeUpdate();
            System.out.println("User is deleted");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    //callableStatement


    public void saveUserCallableStatement1(User user){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url,dbUser,dbPassword);
            String query = "insert into users values(?,?,?,?)";
            CallableStatement callableStatement = connection.prepareCall(query);
            callableStatement.setString(1,user.getFirstname());
            callableStatement.setString(2,user.getLastname());
            callableStatement.setString(3,user.getUsername());
            callableStatement.setString(4,user.getPassword());
            callableStatement.execute();
            System.out.println("User is added");


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    public void addUserCallableStatement2(User user){
//        Connection connection = null;
//        try {
//            connection = DriverManager.getConnection(url,dbUser,dbPassword);
//            String query = "{call insertUsers(?,?,?,?)}";
//            CallableStatement callableStatement = connection.prepareCall(query);
//            callableStatement.setString(1,user.getFirstname());
//            callableStatement.setString(2,user.getLastname());
//            callableStatement.setString(3,user.getUsername());
//            callableStatement.setString(4,user.getPassword());
//            callableStatement.executeUpdate();
//            System.out.println("User is added");
//            callableStatement.close();
//            connection.close();
//
//
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//    }

}
