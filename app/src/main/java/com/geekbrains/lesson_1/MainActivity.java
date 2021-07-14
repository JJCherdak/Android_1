package com.geekbrains.lesson_1;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText calculation;
    private EditText result;
    private String curr, res;
    public static final String PARAM_CURR = "PARAM_CURR";
    public static final String PARAM_RES = "PARAM_RES";

    private Button button_clear, button_del, button_div, button_mul, button_sub, button_point,
            button_result, button_add, button_0, button_1, button_2, button_3, button_4,
            button_5, button_6, button_7, button_8, button_9;

    public boolean dot_inserted, operator_inserted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculation = (EditText) findViewById(R.id.calculation);
        result = (EditText) findViewById(R.id.result);

        curr = "";
        res = "";
        dot_inserted = false;
        operator_inserted = false;

        button_0 = (Button) findViewById(R.id.button_0);
        button_1 = (Button) findViewById(R.id.button_1);
        button_2 = (Button) findViewById(R.id.button_2);
        button_3 = (Button) findViewById(R.id.button_3);
        button_4 = (Button) findViewById(R.id.button_4);
        button_5 = (Button) findViewById(R.id.button_5);
        button_6 = (Button) findViewById(R.id.button_6);
        button_7 = (Button) findViewById(R.id.button_7);
        button_8 = (Button) findViewById(R.id.button_8);
        button_9 = (Button) findViewById(R.id.button_9);
        button_clear = (Button) findViewById(R.id.button_clear);
        button_del = (Button) findViewById(R.id.button_del);
        button_mul = (Button) findViewById(R.id.button_mul);
        button_sub = (Button) findViewById(R.id.button_sub);
        button_point = (Button) findViewById(R.id.button_point);
        button_result = (Button) findViewById(R.id.button_result);
        button_add = (Button) findViewById(R.id.button_add);
        button_div = (Button) findViewById(R.id.button_div);



        button_0.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "0";
                displayOne();
            }
        });

        button_1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "1";
                displayOne();
            }
        });

        button_2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "2";
                displayOne();
            }
        });

        button_3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "3";
                displayOne();
            }
        });

        button_4.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "4";
                displayOne();
            }
        });

        button_5.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "5";
                displayOne();
            }
        });

        button_6.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "6";
                displayOne();
            }
        });

        button_7.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "7";
                displayOne();
            }
        });

        button_8.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "8";
                displayOne();
            }
        });

        button_9.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "9";
                displayOne();
            }
        });

        button_point.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (curr.isEmpty()){
                    curr = "0.";
                    dot_inserted = true;
                }
                if (dot_inserted == false){
                    curr = curr + ".";
                    dot_inserted = true;
                }
                displayOne();

            }
        });

        button_clear.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                clear();
                displayOne();
                displayTwo();
            }
        });

        button_del.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
               backspace();
               displayOne();
            }
        });

        button_div.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                dot_inserted = false;
                if(!curr.isEmpty()){
                    if(curr.substring(curr.length()-1, curr.length()).equals(".")){
                        backspace();

                    }
                    if(operator_inserted == false){
                        curr = curr + " / ";
                        operator_inserted = true;
                    }
                }
                displayOne();

            }
        });

        button_mul.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                dot_inserted = false;
                if(!curr.isEmpty()){
                    if(curr.substring(curr.length()-1, curr.length()).equals(".")){
                        backspace();

                    }
                    if(operator_inserted ==  false){
                        curr = curr + " * ";
                        operator_inserted = true;
                    }
                }

                displayOne();

            }
        });

        button_add.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                dot_inserted = false;
                if(!curr.isEmpty()){
                    if(curr.substring(curr.length()-1, curr.length()).equals(".")){
                        backspace();

                    }
                    if(operator_inserted ==   false){
                        curr = curr + " + ";
                        operator_inserted = true;
                    }
                }

                displayOne();

            }
        });

        button_sub.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                dot_inserted = false;
                if(!curr.isEmpty()){
                    if(curr.substring(curr.length()-1, curr.length()).equals(".")){
                        backspace();

                    }
                    if(operator_inserted ==  false){
                        curr = curr + " - ";
                        operator_inserted = true;
                    }
                }

                displayOne();

            }
        });


        button_result.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (operator_inserted = true && !curr.substring(curr.length() - 1, curr.length()).equals(" ")){

                    String [] arr = curr.split(" ");

                    switch (arr[1].charAt(0)){

                        case '+':
                            res = Double.toString(Double.parseDouble(arr[0]) + Double.parseDouble(arr[2]));
                            break;

                        case '-':
                            res  = Double.toString(Double.parseDouble(arr[0]) - Double.parseDouble(arr[2]));
                            break;

                        case '*':
                            res  = Double.toString(Double.parseDouble(arr[0]) * Double.parseDouble(arr[2]));
                            break;

                        case '/':
                            res = Double.toString(Double.parseDouble(arr[0]) / Double.parseDouble(arr[2]));
                            break;


                    }

                    displayTwo();


                }
            }
        });


    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(PARAM_CURR, curr);
        outState.putString(PARAM_RES, res);
        displayOne();
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        curr = savedInstanceState.getString(PARAM_CURR, " ");
        res = savedInstanceState.getString(PARAM_RES, " ");
        displayTwo();
    }

    public void displayOne(){
        calculation.setText(curr);
    }

    public void displayTwo(){
        result.setText(res);
    }

    public void clear(){
        curr= "";
        res = "";
        dot_inserted = false;
        operator_inserted = false;

    }

    public void backspace() {
        if (!curr.isEmpty()) {
            if (curr.substring(curr.length() - 1, curr.length()).equals(".")) {
                dot_inserted = false;

            }

            if (curr.substring(curr.length() - 1, curr.length()).equals(" ")) {
                curr = curr.substring(0, curr.length() - 3);
                operator_inserted = false;
            } else {

                curr = curr.substring(0, curr.length() - 1);
            }

        }

    }

}