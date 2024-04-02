package uz.developers.spring.spring1_1.version3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        DatabaseService databaseService = new DatabaseService();
        System.out.println("1 dan 3 gacha son kiritin");
        int number = scanner.nextInt();

        switch (number){
            case 1:
                databaseService.getPC();
                break;
            case 2:
                databaseService.getLaptop();
                break;
            case 3:
                databaseService.getPrinter();
                break;
        }






















    }
}
