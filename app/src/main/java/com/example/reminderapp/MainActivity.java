package com.example.reminderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ListView listView;
    FloatingActionButton floatingActionButton;

    PopupWindow popupWindow;
    LayoutInflater li;
    FrameLayout frameLayout;

    // class for reminder objects
    class Reminder {
        public String decription = "";
        public int time = 0;

        // constructor
        public Reminder(String d, int t) {
            decription = d;
            time = t;
        }
        public String ConvertReminderToText(){
            String timeStr = Integer.toString(time);
            return (decription+" "+ timeStr);
        }
    }

    Reminder rem1 = new Reminder("Task1",2300);
    String rem1Text = rem1.ConvertReminderToText();

    Reminder rem2 = new Reminder("Task2",1634);
    final String rem2Text = rem2.ConvertReminderToText();

    final ArrayList <String> arrayList = new ArrayList<>();
        arrayList.add(rem1Text);
        arrayList.add(rem2Text);


    private void UpdateArray() {
        arrayList.add("test");
        arrayAdapter.notifyDataSetChanged();
    }




    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);     //activity_main

        listView =  findViewById(R.id.listview);
        floatingActionButton = findViewById(R.id.floating_action_button);


        final ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);
        frameLayout = (FrameLayout) findViewById(R.id.fl);





        floatingActionButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,Pop.class);
                startActivity(intent);

                /* layout inflater example
                li = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                ViewGroup container = (ViewGroup) li.inflate(R.layout.popup_input, null);
                popupWindow = new PopupWindow(container, 600, 800, true);
                popupWindow.showAtLocation(frameLayout, Gravity.CENTER, 250, 500);

                container.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        popupWindow.dismiss();
                        return true;
                    }
                });

                */


                UpdateArray();


            }
        });









    }




}

