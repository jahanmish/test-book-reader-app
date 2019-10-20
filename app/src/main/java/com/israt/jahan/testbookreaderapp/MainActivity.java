package com.israt.jahan.testbookreaderapp;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.israt.jahan.testbookreaderapp.model.BookData;
import com.israt.jahan.testbookreaderapp.model.Book;
import com.israt.jahan.testbookreaderapp.ui.adapter.RecyclerViewClickListener;
import com.israt.jahan.testbookreaderapp.ui.bookDetails.BookDetailsActivity;
import com.wshunli.assets.CopyAssets;

public class MainActivity extends AppCompatActivity implements RecyclerViewClickListener {

    private AppBarConfiguration mAppBarConfiguration;
    private static final String TAG = "MainActivity";
    private static final int MY_PERMISSION_REQUEST_STORAGE = 1;
    private static final String BOOK_READER = "Book Reader";
    private static final String IS_COPY = "Is Copy";

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        sharedPreferences= getSharedPreferences(BOOK_READER, MODE_PRIVATE);

        if(sharedPreferences.getBoolean(IS_COPY,true)){
            copyAsset();
        }
        if (ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)){
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{(Manifest.permission.WRITE_EXTERNAL_STORAGE)},
                        MY_PERMISSION_REQUEST_STORAGE);
            }else{
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{(Manifest.permission.WRITE_EXTERNAL_STORAGE)},
                        MY_PERMISSION_REQUEST_STORAGE);
                 }
        }

        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        String getjsonfilefrominternalstorage = MyStorageHelper.getjsonfilefrominternalstorage(getApplicationContext());
        BookData bookData = new Gson().fromJson(getjsonfilefrominternalstorage, BookData.class);

        RecyclerView my_recycler_view = (RecyclerView) findViewById(R.id.my_recycler_view);
        my_recycler_view.setHasFixedSize(true);
        RecyclerViewDataAdapter adapter = new RecyclerViewDataAdapter(this, bookData, this);
        my_recycler_view.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        my_recycler_view.setAdapter(adapter);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case MY_PERMISSION_REQUEST_STORAGE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ContextCompat.checkSelfPermission(MainActivity.this,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                        //do nothing
                        }
                    } else {
                    Toast.makeText(this, "No Permission Granted!", Toast.LENGTH_SHORT).show();
                }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Type Here To Search");
        return super.onCreateOptionsMenu(menu);
    }

    public void copyAsset(){
        try {

            String internalDirectory = getFilesDir().getAbsolutePath()
                    + "/israt";

            CopyAssets.with(MainActivity.this)
                    .from("data")
                    .to(internalDirectory)
                    .copy();
            CopyAssets.with(MainActivity.this)
                    .from("data/cover/bangla")
                    .to(internalDirectory)
                    .copy();
            CopyAssets.with(MainActivity.this)
                    .from("data/cover/english")
                    .to(internalDirectory)
                    .copy();
            CopyAssets.with(MainActivity.this)
                    .from("data/pdf/bangla")
                    .to(internalDirectory)
                    .copy();
            CopyAssets.with(MainActivity.this)
                    .from("data/pdf/english")
                    .to(internalDirectory)
                    .copy();

            sharedPreferences.edit().putBoolean(IS_COPY,false).apply();

        }catch (Exception e){

            sharedPreferences.edit().putBoolean(IS_COPY,true).apply();
            e.printStackTrace();
         }

    }

    @Override
    public void onClick(Book bookItem) {

        Intent intent = new Intent(this, BookDetailsActivity.class).putExtra("Data",bookItem);
        startActivity(intent);

    }
}
