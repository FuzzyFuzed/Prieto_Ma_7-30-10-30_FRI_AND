package com.example.prieto_calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText number1EditText;
    private EditText number2EditText;
    private TextView resultTextView;
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1EditText = findViewById(R.id.number1);
        number2EditText = findViewById(R.id.number2);
        resultTextView = findViewById(R.id.result);
        calculateButton = findViewById(R.id.calculate_button);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });
    }

    private void calculate() {
        try {
            String num1Str = number1EditText.getText().toString();
            String num2Str = number2EditText.getText().toString();

            if (num1Str.isEmpty() || num2Str.isEmpty()) {
                resultTextView.setText("Please enter both numbers");
                return;
            }

            double num1 = Double.parseDouble(num1Str);
            double num2 = Double.parseDouble(num2Str);

            double result = num1 + num2; // Simple addition, you can change it to other operations.

            resultTextView.setText(String.format("Result: %.2f", result));

        } catch (NumberFormatException e) {
            resultTextView.setText("Invalid input");
        }
    }
}