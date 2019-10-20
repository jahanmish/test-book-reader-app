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
import com.israt.jahan.testbookreaderapp.model.BookDatum;


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


        final BookDatum bookDatum = (BookDatum) getIntent().getSerializableExtra("Data");

         bookImage =(ImageView) findViewById(R.id.bookImage);
         bookTitleTV = (TextView) findViewById(R.id.bookTitleTV);
         authorNameTV = (TextView) findViewById(R.id.authorNameTV);
         bookTypeTV= (TextView) findViewById(R.id.bookTypeTV);
         summaryId = (TextView) findViewById(R.id.summaryId);
         summaryTV = (TextView) findViewById(R.id.summaryTV);
         ratingTV = (TextView) findViewById(R.id.ratingTV);
         btnRead = (Button) findViewById(R.id.btnRead);

         bookTitleTV.setText(bookDatum.getBookName());
         authorNameTV.setText(bookDatum.getBookAuthor());
         bookTypeTV.setText(bookDatum.getBookType());
         bookImage.setImageBitmap(ProjectHelper.getImage(getApplicationContext(), bookDatum.getCoverPath()));

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(BookDetailsActivity.this, ShowBookActivity.class).putExtra("Data",bookDatum);
                startActivity(i);
            }
        });

    }


}
