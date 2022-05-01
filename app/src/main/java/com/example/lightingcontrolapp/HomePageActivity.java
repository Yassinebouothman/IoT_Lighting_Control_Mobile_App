package com.example.lightingcontrolapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HomePageActivity extends AppCompatActivity {

    Button on_button;
    Button off_button;
    ConstraintLayout layout;
    ImageView lamp_on;
    ImageView lamp_off;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        on_button = (Button) findViewById(R.id.on_button);
        off_button = (Button) findViewById(R.id.off_button);
        layout = findViewById(R.id.linear_layout);
        lamp_on = findViewById(R.id.lamp_on);
        lamp_off = findViewById(R.id.lamp_off);



        lamp_off.setVisibility(View.VISIBLE);
        lamp_on.setVisibility(View.GONE);
        on_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout.setBackgroundColor(Color.WHITE);
                lamp_on.setVisibility(View.VISIBLE);
                lamp_off.setVisibility(View.GONE);
                FirebaseDatabase database = FirebaseDatabase.getInstance("https://lighting-control-app-default-rtdb.europe-west1.firebasedatabase.app/");
                DatabaseReference myRef = database.getReference("LED_STATUS");
                myRef.setValue("ON");

            }
        });
        off_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout.setBackgroundColor(Color.BLACK);
                lamp_off.setVisibility(View.VISIBLE);
                lamp_on.setVisibility(View.GONE);
                FirebaseDatabase database = FirebaseDatabase.getInstance("https://lighting-control-app-default-rtdb.europe-west1.firebasedatabase.app/");
                DatabaseReference myRef = database.getReference("LED_STATUS");
                myRef.setValue("OFF");
            }

        });

    }
}
