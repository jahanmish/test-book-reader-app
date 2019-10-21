package com.israt.jahan.testbookreaderapp.database;

import android.content.Context;

import androidx.room.Room;

public class DatabaseClient {

    private Context context;
    private static DatabaseClient databaseClient;
    private MyDatabase myDatabase;

    private DatabaseClient(Context context){
        this.context=context;
        myDatabase= Room.databaseBuilder(context,MyDatabase.class,"BookReader")
                .allowMainThreadQueries().build();
    }

    public static DatabaseClient getInstance(Context context){
        if (databaseClient== null){
            databaseClient=new DatabaseClient(context) ;
        }
        return databaseClient;
    }

    public MyDatabase getMyDatabase(){
        return myDatabase;
    }

}
