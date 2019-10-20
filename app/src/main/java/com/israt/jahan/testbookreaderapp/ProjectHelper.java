package com.israt.jahan.testbookreaderapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.File;

public class ProjectHelper {

    public static Bitmap getImage(Context context, String imagePath){
        String yourFilePath = context.getFilesDir() + "/israt"+imagePath;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        return BitmapFactory.decodeFile(yourFilePath, options);
    }
    public static File getPDFBook(Context context, String filePath){
        String yourFilePath = context.getFilesDir() + "/israt"+filePath;
        return new File(yourFilePath);
    }


}
