package uz.developers.gson;

import com.google.gson.Gson;

import java.io.*;

public class JsonToFileRead {
    public static void main(String[] args) {

        File file = new File("gson.txt");
        try {
            FileInputStream inputStream = new FileInputStream(file);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String row;
            StringBuilder stringBuilder = new StringBuilder();
            while ((row = bufferedReader.readLine()) != null) {
                stringBuilder.append(row);
            }
            inputStream.close();


            String jsonString = stringBuilder.toString();
            Gson gson = new Gson();
            User user = gson.fromJson(jsonString, User.class);
            System.out.println(user.getFirstname() + "  " + user.getPhoneNumber());


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
