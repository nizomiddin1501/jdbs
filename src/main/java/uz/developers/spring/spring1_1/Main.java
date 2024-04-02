package uz.developers.spring.spring1_1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        DatabaseService databaseService = new DatabaseService();

        int i = -1;

        while (i!=0){
            System.out.println("0 => Exit, 1 => Add User, 2 => Edit User, 3 => Delete User,4 => List Users ");
            i = scanner.nextInt();
            switch (i){
                case 1:
                    System.out.println("Enter firstname");
                    String firstname = scanner.next();
                    System.out.println("Enter lastname");
                    String lastname = scanner.next();
                    System.out.println("Enter username");
                    String username = scanner.next();
                    System.out.println("Enter password");
                    String password = scanner.next();
                    User user = new User(firstname,lastname,username,password);
                    //databaseService.saveUser(user);
                    //databaseService.saveUserPreparedStatement(user);
                    databaseService.saveUserCallableStatement1(user);
                    //databaseService.addUserCallableStatement2(user);
                    break;
                case 2:
                    System.out.println("Enter user's id");
                    int id = scanner.nextInt();
                    System.out.println("Enter editing firstname");
                    firstname = scanner.next();
                    System.out.println("Enter editing lastname");
                    lastname = scanner.next();
                    System.out.println("Enter editing username");
                    username = scanner.next();
                    System.out.println("Enter editing password");
                    password = scanner.next();
                    user = new User(id,firstname,lastname,username,password);
                    //databaseService.editUser(user);
                    databaseService.editUsersPreparedStatement(user);
                    break;
                case 3:
                    System.out.println("Enter user's id");
                     id = scanner.nextInt();
                    //databaseService.deleteUser(id);
                    databaseService.deleteUserPrepareStatement(id);
                    break;
                case 4:
                    //databaseService.getUsers();
                    databaseService.getUsersPreparedStatement();
                    break;
            }

        }








    }
}
