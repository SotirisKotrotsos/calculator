package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    Button btn_one,btn_two,btn_three,btn_four,btn_five,btn_six,btn_seven,btn_eight,btn_nine,btn_zero;
    Button btn_plus,btn_minus,btn_sub,btn_div,btn_percentage,btn_equals,btn_ac,btn_c, btn_delimeter;
    TextView solution_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        solution_text = findViewById(R.id.solution_text);
        btn_one = findViewById(R.id.one_btn);
        btn_two = findViewById(R.id.two_btn);
        btn_three = findViewById(R.id.three_btn);
        btn_four = findViewById(R.id.four_btn);
        btn_five = findViewById(R.id.five_btn);
        btn_six = findViewById(R.id.six_btn);
        btn_seven = findViewById(R.id.seven_btn);
        btn_eight = findViewById(R.id.eight_btn);
        btn_nine = findViewById(R.id.nine_btn);
        btn_zero = findViewById(R.id.zero_btn);
        btn_plus = findViewById(R.id.plus_btn);
        btn_minus = findViewById(R.id.minus_btn);
        btn_div = findViewById(R.id.div_btn);
        btn_equals = findViewById(R.id.equals_btn);
        btn_div = findViewById(R.id.div_btn);
        btn_sub = findViewById(R.id.sub_btn);
        btn_percentage = findViewById(R.id.percentage_btn);
        btn_ac = findViewById(R.id.ac_btn);
        btn_c = findViewById(R.id.c_btn);
        btn_delimeter = findViewById(R.id.delimeter_btn);


        btn_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                solution_text.append(btn_one.getText().toString());

            }
        });

        btn_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                solution_text.append(btn_two.getText().toString());

            }
        });

        btn_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                solution_text.append(btn_three.getText().toString());

            }
        });

        btn_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                solution_text.append(btn_four.getText().toString());

            }
        });

        btn_five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                solution_text.append(btn_five.getText().toString());

            }
        });

        btn_six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                solution_text.append(btn_seven.getText().toString());

            }
        });

        btn_eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                solution_text.append(btn_eight.getText().toString());

            }
        });

        btn_nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                solution_text.append(btn_nine.getText().toString());

            }
        });

        btn_zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                solution_text.append(btn_zero.getText().toString());

            }
        });
    }

//    @Override
//    public void onClick(View view) {
//        Button button = (Button) view;
//        String text = solution_text.getText().toString();
//
//        if(btn_ac.callOnClick()){
//            solution_text.setText("0");
//        }
//        if(btn_one.getText().toString() == "1"){
//            solution_text.append(button.getText().toString());
//            Toast.makeText(this,"click",Toast.LENGTH_LONG);
//        }
//        if(btn_c.callOnClick()){
//          String newText = text.substring(0,text.length()-1);
//          solution_text.setText(newText);
//        }
//        else{
//           solution_text.append(button.getText().toString());
//        }
//    }



}