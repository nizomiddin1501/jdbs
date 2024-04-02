package uz.developers.gson;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Main {
    public static void main(String[] args) {

        String a = "{\"firstname\":\"Nizomiddin\",\"phoneNumber\":\"+998905969167\"}";
        System.out.println(a);

        Gson gson = new Gson();
        User user = gson.fromJson(a, User.class);
        System.out.println(user.getFirstname()+" "+user.getPhoneNumber());

        //

        System.out.println("to json");

        User user1 = new User("Ali","+998971234567");

        Gson gson1 = new Gson();
        String jsonString = gson1.toJson(user1);
        System.out.println(jsonString);


        //







    }
}
