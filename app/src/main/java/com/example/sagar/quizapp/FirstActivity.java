package com.example.sagar.quizapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class FirstActivity extends AppCompatActivity {

    TextView question, title, score_ans;
    RadioGroup rg1;
    RadioButton rb1, rb2, rb3, rb4;
    Button next_que;

    String value = "";
    String correctAnswer = "";
    int totalCorrect = 0, totalAttend = 0;

    int number[] = {1,2,3,4,5,6,7,8,9,10};
    int index[] = {1,3,5,7,9,2,4,6,8,0};
    int cnt = 0;

    ArrayList<Integer> no = new ArrayList<>();
    int randomNumber=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        this.rb1 = (RadioButton) findViewById(R.id.rb1);
        this.rb2 = (RadioButton) findViewById(R.id.rb2);
        this.rb3 = (RadioButton) findViewById(R.id.rb3);
        this.rb4 = (RadioButton) findViewById(R.id.rb4);
        this.rg1 = (RadioGroup) findViewById(R.id.radioGroup);

        rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next();
            }
        });

        rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next();
            }
        });

        rb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next();
            }
        });

        rb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next();
            }
        });

        question = (TextView) findViewById(R.id.question);
        title = (TextView) findViewById(R.id.welcome);

        String message = getIntent().getStringExtra("keyName");
        title.setText("Hi, Welcome To Quiz " + message);

        next_que = (Button) findViewById(R.id.next);
        next_que.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next();
            }
        });
        score_ans = (TextView) findViewById(R.id.scoreanswer);
        score_ans.setText(""+totalAttend);
        rno();
        rQuestions();

    }

    //Random Number
    private void rno()
    {
        no.clear();
        cnt = 0;
        totalAttend = 0;
        totalCorrect = 0;
        score_ans.setText(""+totalAttend);

        while(no.size() != 5)
        {
            Random rnd = new Random();
            int n = rnd.nextInt(10) + 1;

            if(!no.contains(n))
            {
                no.add(n);
            }
        }
    }

    private void rQuestions() {

//        if (cnt != 5 || cnt != 0)
//        {
//            cnt ++;
//        }
        //number[index[cnt++]]

            switch (no.get(cnt)) {
                case 1:

                    question.setText("In which decade was the American Institute of Electrical Engineers (AIEE) founded?");
                    rb1.setText("1850s");
                    rb2.setText("1880s");
                    rb3.setText("1930s");
                    rb4.setText("1950s");
                    //correctAnswer = "2";
                    correctAnswer = "1880s";

                    break;

                case 2:

                    question.setText("What is part of a database that holds only one type of information?");
                    rb1.setText("Report");
                    rb2.setText("Field");
                    rb3.setText("Record");
                    rb4.setText("File");
                    //correctAnswer = "2";
                    correctAnswer = "Field";

                    break;

                case 3:

                    question.setText("Which is a type of Electrically-Erasable Programmable Read-Only Memory?");
                    rb1.setText("Flash");
                    rb2.setText("Flange");
                    rb3.setText("Fury");
                    rb4.setText("FRAM");
                    //correctAnswer = "1";
                    correctAnswer = "Flash";

                    break;

                case 4:

                    question.setText("Who developed Yahoo?");
                    rb1.setText("Dennis Ritchie & Ken Thompson");
                    rb2.setText("David Filo & Jerry Yang");
                    rb3.setText("Vint Cerf & Robert Kahn");
                    rb4.setText("Steve Case & Jeff Bezos");
                    //correctAnswer = "2";
                    correctAnswer = "David Filo & Jerry Yang";

                    break;

                case 5:

                    question.setText("In what year was the @ chosen for its use in e-mail addresses?");
                    rb1.setText("1976");
                    rb2.setText("1972");
                    rb3.setText("1980");
                    rb4.setText("1984");
                    //correctAnswer = "2";
                    correctAnswer = "1972";

                    break;

                case 6:

                    question.setText("Where is the headquarters of Intel located?");
                    rb1.setText("Redmond, Washington");
                    rb2.setText("Tucson, Arizona");
                    rb3.setText("Santa Clara, California");
                    rb4.setText("Richmond, Virginia");
                    //correctAnswer = "3";
                    correctAnswer = "Santa Clara, California";

                    break;

                case 7:

                    question.setText("Programs used to control system performance are classified as");
                    rb1.setText("experimental programs");
                    rb2.setText("system programs");
                    rb3.setText("specialized program");
                    rb4.setText("organized programs");
                    //correctAnswer = "2";
                    correctAnswer = "system programs";

                    break;

                case 8:

                    question.setText("What is Canada’s national sport?");
                    rb1.setText("Hockey");
                    rb2.setText("Curling");
                    rb3.setText("Lacrosse");
                    rb4.setText("Cricket");
                    //correctAnswer = "1";
                    correctAnswer = "Hockey";

                    break;

                case 9:

                    question.setText("Which of the following is not a feature of iOS 7?");
                    rb1.setText("Open-in management");
                    rb2.setText("Single sign-on");
                    rb3.setText("iCloud integration with third-party apps");
                    rb4.setText("Per app VPN");
                    //correctAnswer = "1";
                    correctAnswer = "Open-in management";

                    break;

                case 10:

                    question.setText("Which Apple iOS 7 features might IT be concerned about?");
                    rb1.setText("Improvements to the Mail app");
                    rb2.setText("AirDrop");
                    rb3.setText("Automatic application updates");
                    rb4.setText("All of the above");
                    //correctAnswer = "1";
                    correctAnswer = "Improvements to the Mail app";

                    break;

                default:

                    break;
            }
        cnt += 1;
    }

    private void next() {

        if(rg1.getCheckedRadioButtonId()!=-1)
        {
            int id= rg1.getCheckedRadioButtonId();
            View radioButton = rg1.findViewById(id);
            int radioId = rg1.indexOfChild(radioButton);
            RadioButton btn = (RadioButton) rg1.getChildAt(radioId);
            value = (String) btn.getText();
        }

        if(value.equals(correctAnswer))
        {
            totalCorrect += 1;
        }

        totalAttend += 1;

        if (totalAttend >= 5) {
            if (totalCorrect == 1 || totalCorrect == 2 || totalCorrect == 0) {
                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setTitle("Try Again!");
                alert.setMessage("Your Score is : " + totalCorrect + " / " + totalAttend);
                alert.setPositiveButton("Retry", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        rno();
                        rQuestions();
                    } });
                alert.setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    } });
                alert.show();
            } else if (totalCorrect == 3) {
                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setTitle("Good Work");
                alert.setMessage("Your Score is : " + totalCorrect + " / " + totalAttend);
                alert.setPositiveButton("Retry", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        rno();
                        rQuestions();
                    } });
                alert.setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    } });
                alert.show();
            } else if (totalCorrect == 4) {
                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setTitle("Excellent Work");
                alert.setMessage("Your Score is : " + totalCorrect + " / " + totalAttend);
                alert.setPositiveButton("Retry", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        rno();
                        rQuestions();
                    } });
                alert.setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    } });
                alert.show();
            } else if (totalCorrect == 5) {
                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setTitle("You are Genius");
                alert.setMessage("Your Score is : " + totalCorrect + " / " + totalAttend);
                alert.setPositiveButton("Retry", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        rno();
                        rQuestions();
                    } });
                alert.setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    } });
                alert.show();
            }

            score_ans.setText(""+totalAttend);
            //next_que.setEnabled(false);
            totalAttend = 0;
            totalCorrect = 0;

            rb1.setChecked(false);
            rb2.setChecked(false);
            rb3.setChecked(false);
            rb4.setChecked(false);
            rg1.clearCheck();
        }
        else
        {
            rQuestions();
            rb1.setChecked(false);
            rb2.setChecked(false);
            rb3.setChecked(false);
            rb4.setChecked(false);
            rg1.clearCheck();

            score_ans.setText(""+totalAttend);
        }
    }
}

