package com.israt.jahan.testbookreaderapp.ui.bookDetails;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.listener.OnTapListener;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.israt.jahan.testbookreaderapp.ProjectHelper;
import com.israt.jahan.testbookreaderapp.R;
import com.israt.jahan.testbookreaderapp.model.Book;

public class ShowBookActivity extends AppCompatActivity {

    public static String TAG = ShowBookActivity.class.getName();

    PDFView pdfView;
    AppCompatSeekBar page_seek_bar;

    Toolbar showBookToolbar;
    Book book;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_book);

        showBookToolbar = findViewById(R.id.showBookToolbar);
        setSupportActionBar(showBookToolbar);

        initilzationView();

        hiddenToolbar();

    }

    private void initilzationView() {
         book = (Book) getIntent().getSerializableExtra("Data");

        pdfView = findViewById(R.id.pdfView);

        pdfView.fromFile(ProjectHelper.getPDFBook(this, book.getBookPath()))
                .swipeHorizontal(true)
                .onPageChange(new OnPageChangeListener() {
                    @Override
                    public void onPageChanged(int page, int pageCount) {

                        if (page_seek_bar!=null){
                            page_seek_bar.setProgress(page);
                        }

                    }
                })
                .onTap(new OnTapListener() {
                    @Override
                    public boolean onTap(MotionEvent event) {
                        switch (event.getAction()) {
                            case MotionEvent.ACTION_DOWN:

                                //sheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);

                                handleBottonSheetClick();
                                showToolbar();
                                return true;
                            case MotionEvent.ACTION_UP:

                               // sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);

                                Log.e(TAG," ACTION_UP");

                                return true;
                        }

                        return true;
                    }
                })
                .load();
    }

    private void handleBottonSheetClick() {
        Log.e(TAG," ACTION_DOWN");

        final View dialogView = getLayoutInflater().inflate(R.layout.bottom_sheet, null);
        BottomSheetDialog dialog = new BottomSheetDialog(ShowBookActivity.this);
        dialog.setContentView(dialogView);



        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {

                hiddenToolbar();
            }
        });



        dialogView.findViewById(R.id.brightnessLinear).setVisibility(View.GONE);
        dialogView.findViewById(R.id.buttonModeLinear).setVisibility(View.GONE);
        dialogView.findViewById(R.id.pageLinear).setVisibility(View.GONE);


        ImageButton pageButton = dialogView.findViewById(R.id.pageButton);
        pageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogView.findViewById(R.id.buttonModeLinear).setVisibility(View.GONE);
                dialogView.findViewById(R.id.brightnessLinear).setVisibility(View.GONE);
                dialogView.findViewById(R.id.pageLinear).setVisibility(View.VISIBLE);
                pdfView.getPageCount();
                final AppCompatTextView page_seek_barTV= dialogView.findViewById(R.id.page_seek_barTV);
                page_seek_barTV.setText(pdfView.getCurrentPage()+"/"+pdfView.getPageCount());
                page_seek_bar = dialogView.findViewById(R.id.page_seek_bar);
                page_seek_bar.setMax(pdfView.getPageCount());
                page_seek_bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        pdfView.jumpTo(progress);
                        page_seek_barTV.setText(pdfView.getCurrentPage()+"/"+pdfView.getPageCount());

                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });


            }
        });

        ImageButton brightnessButton = dialogView.findViewById(R.id.brightnessButton);
        brightnessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogView.findViewById(R.id.buttonModeLinear).setVisibility(View.GONE);
                dialogView.findViewById(R.id.pageLinear).setVisibility(View.GONE);
                dialogView.findViewById(R.id.brightnessLinear).setVisibility(View.VISIBLE);

                final AppCompatTextView brightness_seek_barTV = dialogView.findViewById(R.id.brightness_seek_barTV);
                AppCompatSeekBar brightness_seek_bar = dialogView.findViewById(R.id.brightness_seek_bar);

                int cBrightness = Settings.System.getInt(getContentResolver(),
                        Settings.System.SCREEN_BRIGHTNESS,0);
                brightness_seek_barTV.setText(cBrightness+"/100");
                brightness_seek_bar.setProgress(cBrightness);

                brightness_seek_bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @RequiresApi(api = Build.VERSION_CODES.M)
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        Context context = getApplicationContext();
                        boolean canWrite = Settings.System.canWrite(context);
                        if (canWrite){
                            int sBrightness = progress*100/100;
                            brightness_seek_barTV.setText(sBrightness+"/100");
                            Settings.System.putInt(getContentResolver(),
                                    Settings.System.SCREEN_BRIGHTNESS_MODE,
                                    Settings.System.SCREEN_BRIGHTNESS_MODE_MANUAL);
                            Settings.System.putInt(context.getContentResolver(),
                                    Settings.System.SCREEN_BRIGHTNESS,sBrightness);

                        }else {

                            Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            context.startActivity(intent);
                        }

                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });


            }
        });

        ImageButton displayButton = dialogView.findViewById(R.id.displayButton);
        displayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogView.findViewById(R.id.buttonModeLinear).setVisibility(View.VISIBLE);
                dialogView.findViewById(R.id.pageLinear).setVisibility(View.GONE);
                dialogView.findViewById(R.id.brightnessLinear).setVisibility(View.GONE);
               final Button nightModeButton = dialogView.findViewById(R.id.nightModeButton);
                nightModeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       pdfView.setNightMode(true);

                    }
                });

                final Button dayModeButton = dialogView.findViewById(R.id.dayModeButton);
                dayModeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        pdfView.setNightMode(false);

                    }
                });

            }
        });

        dialog.show();

    }


    public void hiddenToolbar(){
//        showBookToolbar.animate().translationY(-showBookToolbar.getBottom()).setInterpolator(new AccelerateInterpolator()).start();
        getSupportActionBar().hide();

    }

    public void showToolbar(){
//        showBookToolbar.animate().translationY(0).setInterpolator(new DecelerateInterpolator()).start();
        getSupportActionBar().setTitle(book.getBookName());
        getSupportActionBar().show();

    }

}
