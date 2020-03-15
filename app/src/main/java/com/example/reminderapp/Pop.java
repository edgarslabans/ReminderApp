package com.example.reminderapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Pop extends Activity {

    EditText descriptionTextbox;
    EditText timeTextbox;
    Button submitButtonPopUp;



    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.popup_input);

        descriptionTextbox = findViewById(R.id.descriptionTextbox_id);
        timeTextbox = findViewById(R.id.timeTextbox);
        submitButtonPopUp = findViewById(R.id.submitButtonPopUp_id);


        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*0.8), (int)(height*0.8));




        submitButtonPopUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainActivity.arrayList.add("test");
                MainActivity.arrayAdapter.notifyDataSetChanged();

            }

    }


}
