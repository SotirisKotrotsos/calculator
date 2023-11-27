package com.example.calculator;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


public class CurrencyActivity extends AppCompatActivity /*implements AdapterView.OnItemSelectedListener*/ {
    Button btn_one,btn_two,btn_three,btn_four,btn_five,btn_six,btn_seven,btn_eight,btn_nine,btn_zero;
    Button btn_ac,btn_c, btn_delimeter,btn_convert;
    TextView solution_text, solution_text2;
    ImageButton calculator_btn;

    ArrayList<String> currencyCodeList = new ArrayList<>();
    HashMap<String,String> currencyValues = new HashMap<>();
    String BASE_URL="http://data.fixer.io/api/";
    String API_KEY = "aa310ce9507e7640551e720748f7f65a";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.currency_layout);

        btn_convert = findViewById(R.id.convert_btn);
        calculator_btn = findViewById(R.id.home_btn);
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
        btn_ac = findViewById(R.id.ac_btn);
        btn_c = findViewById(R.id.c_btn);
        btn_delimeter = findViewById(R.id.delimeter_btn);
        solution_text = findViewById(R.id.currency_amount1);
        solution_text2 = findViewById(R.id.currency_amount2);


        symbolRequest();
        calculator_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CurrencyActivity.this,MainActivity.class);
                startActivity(i);
            }
        });




        Spinner spinner1 = findViewById(R.id.currency_name1);
        Spinner spinner2 = findViewById(R.id.currency_name2);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, currencyCodeList);
        adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);

        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);


        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        btn_convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                convertRequest();
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

    }


    public void symbolRequest(){
        String symbols_url = BASE_URL + "symbols?access_key=" + API_KEY;
        JsonObjectRequest symbolsRequest = new JsonObjectRequest(Request.Method.GET, symbols_url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    boolean res = response.getBoolean("success");
                    if(res){
                        JSONObject symbols = response.getJSONObject("symbols");
                        Iterator<String> keys = symbols.keys();

                        while (keys.hasNext()){
                            currencyCodeList.add(keys.next());
                        }

                    }else{
                        JSONObject symbols = response.getJSONObject("error");
                        JSONObject s = symbols.getJSONObject("code");
                        Iterator<String> keys = s.keys();
                        while (keys.hasNext()){
                            Toast.makeText(CurrencyActivity.this,"Error"+keys.next(),Toast.LENGTH_SHORT).show();

                        }
                    }
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


        Volley.newRequestQueue(this).add(symbolsRequest);
    }
    public void convertRequest(){
        String convert_url = BASE_URL + "latest?access_key=" + API_KEY;
        JsonObjectRequest convertRequest = new JsonObjectRequest(Request.Method.GET,convert_url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    boolean res = response.getBoolean("success");
                    if(res){
                        JSONObject value = response.getJSONObject("rates");
                        Iterator<String> keys = value.keys();
                        while(keys.hasNext()){
                            String txt = response.get(keys.next()).toString();
                            currencyValues.put(keys.next(), txt);
                        }
                    }
                    else{
                        JSONObject symbols = response.getJSONObject("error");
                        JSONObject s = symbols.getJSONObject("code");
                        Iterator<String> keys = s.keys();
                        while (keys.hasNext()){
                            Toast.makeText(CurrencyActivity.this,"Error"+keys.next(),Toast.LENGTH_SHORT).show();

                        }
                    }

                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        Volley.newRequestQueue(CurrencyActivity.this).add(convertRequest);
    }
}
