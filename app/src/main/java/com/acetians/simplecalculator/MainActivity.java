package com.acetians.simplecalculator;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnAdd, btnSub, btnMultiply, btnDivide;
    EditText number1, number2;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.btn_add);
        btnSub = findViewById(R.id.btn_sub);
        btnMultiply = findViewById(R.id.btn_multiply);
        btnDivide = findViewById(R.id.btn_divide);

        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        textView = findViewById(R.id.answer);

        // Set click listeners for buttons
        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btnDivide.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        // Get numbers from EditText
        String num1Str = number1.getText().toString();
        String num2Str = number2.getText().toString();

        if (num1Str.isEmpty() || num2Str.isEmpty()) {
            showToast("Please enter both numbers");
            return;
        }

        int num1 = Integer.parseInt(num1Str);
        int num2 = Integer.parseInt(num2Str);
        int result;
        String message;
        result =10;
        if(view.getId()==R.id.btn_add){
            result = num1+num2;
        }else if(view.getId() == R.id.btn_multiply){
            result = num1*num2;
        }else if(view.getId() == R.id.btn_sub){
            result = num1-num2;
        }else if(view.getId() == R.id.btn_divide){
            result = num1/num2;
        }

        message= String.valueOf(result);
        // Show the result in TextView
        textView.setText(message);
    }

    // Method to show Toast messages
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
