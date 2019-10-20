package com.israt.jahan.testbookreaderapp.ui.bookDetails;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.israt.jahan.testbookreaderapp.ProjectHelper;
import com.israt.jahan.testbookreaderapp.R;
import com.israt.jahan.testbookreaderapp.model.Book;


public class BookDetailsActivity extends AppCompatActivity {

    ImageView bookImage;
    TextView bookTitleTV,authorNameTV, bookTypeTV , summaryId, summaryTV,ratingTV ;
    Button btnRead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final Book book = (Book) getIntent().getSerializableExtra("Data");

         bookImage = findViewById(R.id.bookImage);
         bookTitleTV = findViewById(R.id.bookTitleTV);
         authorNameTV = findViewById(R.id.authorNameTV);
         bookTypeTV= findViewById(R.id.bookTypeTV);
         summaryId = findViewById(R.id.summaryId);
         summaryTV = findViewById(R.id.summaryTV);
         ratingTV = findViewById(R.id.ratingTV);
         btnRead = findViewById(R.id.btnRead);

         bookTitleTV.setText(book.getBookName());
         authorNameTV.setText(book.getBookAuthor());
         bookTypeTV.setText(book.getBookType());
         summaryTV.setText(book.getBookSummary());
         bookImage.setImageBitmap(ProjectHelper.getImage(getApplicationContext(), book.getCoverPath()));

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(BookDetailsActivity.this, ShowBookActivity.class).putExtra("Data", book);
                startActivity(i);
            }
        });

    }


}
