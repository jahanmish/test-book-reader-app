package com.israt.jahan.testbookreaderapp;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MyStorageHelper {

    public static String getjsonfromassetdirectory(Context context, String fileName) {

        String json = null;
        try {
            InputStream is = context.getAssets().open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            return json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return "";

    }

    public  static String getjsonfilefrominternalstorage (Context context){
        Gson gson = new Gson();
        String text = "";
//Make sure to use a try-catch statement to catch any errors
        try {
            //Make your FilePath and File
            String yourFilePath = context.getFilesDir() + "/israt/data/book_reader.json";
            File yourFile = new File(yourFilePath);
            //Make an InputStream with your File in the constructor
            InputStream inputStream = new FileInputStream(yourFile);
            StringBuilder stringBuilder = new StringBuilder();
            //Check to see if your inputStream is null
            //If it isn't use the inputStream to make a InputStreamReader
            //Use that to make a BufferedReader
            //Also create an empty String
            if (inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                //Use a while loop to append the lines from the Buffered reader
                while ((receiveString = bufferedReader.readLine()) != null){
                    stringBuilder.append(receiveString);
                }
                //Close your InputStream and save stringBuilder as a String
                inputStream.close();
                text = stringBuilder.toString();
            }
        } catch (FileNotFoundException e) {
            Log.e("FileNotFoundException", e.getMessage());
            //Log your error with Log.e
        } catch (IOException e) {
            //Log your error with Log.e
            Log.e("FileNotFoundException", e.getMessage());
        }
//Use Gson to recreate your Object from the text String
        return text;
    }
}
