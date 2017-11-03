package com.example.sagar.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Home extends AppCompatActivity {

    Button btn1;
    EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btn1 = (Button) findViewById(R.id.main_page);
        et1 = (EditText) findViewById(R.id.name);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, FirstActivity.class);
                String message = String.valueOf(et1.getText());
                if(message.isEmpty()) {
                    Toast.makeText(getApplicationContext() , "Enter Your Name Please" , Toast.LENGTH_SHORT).show();
                }
                else
                {
                    intent.putExtra("keyName",message);
                    startActivity(intent);
                    finish();
                }

            }
        });

    }
}
