package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    Button btn_one,btn_two,btn_three,btn_four,btn_five,btn_six,btn_seven,btn_eight,btn_nine,btn_zero;
    Button btn_plus,btn_minus,btn_sub,btn_div,btn_percentage,btn_equals,btn_ac,btn_c, btn_delimeter;
    TextView solution_text;
    ImageButton currency_btn;
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
        currency_btn = findViewById(R.id.currency_btn);

        currency_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,CurrencyActivity.class);
                startActivity(i);
            }
        });

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
                solution_text.append(btn_six.getText().toString());

            }
        });

        btn_seven.setOnClickListener(new View.OnClickListener() {
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


        btn_delimeter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                solution_text.append(btn_delimeter.getText().toString());

            }
        });
        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                solution_text.append(btn_plus.getText().toString());

            }
        });

        btn_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                solution_text.append(btn_minus.getText().toString());

            }
        });

        btn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                solution_text.append(btn_sub.getText().toString());

            }
        });

        btn_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                solution_text.append(btn_div.getText().toString());

            }
        });

        btn_ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                solution_text.setText("");

            }
        });

        btn_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!solution_text.getText().toString().equals(""))
                    solution_text.setText(solution_text.getText().toString().substring(0,solution_text.length()-1));

            }
        });

        btn_equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Operations op = new Operations(solution_text.getText().toString());
                solution_text.setText(op.postfix());
            }
        });

        btn_percentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Operations op = new Operations(solution_text.getText().toString());
                solution_text.setText(op.percentage());

            }
        });
    }




}