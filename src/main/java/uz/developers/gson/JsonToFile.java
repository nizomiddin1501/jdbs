package uz.developers.gson;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileOutputStream;

public class JsonToFile {

    public static void main(String[] args) {

        System.out.println("to json");

        User user1 = new User("Ali","+998971234567");

        Gson gson1 = new Gson();
        String jsonString = gson1.toJson(user1);
        System.out.println(jsonString);

        File file = new File("gson.txt");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(jsonString.getBytes());
            fileOutputStream.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


























    }
}
