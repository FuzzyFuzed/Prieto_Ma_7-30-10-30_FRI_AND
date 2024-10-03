package com.example.prieto_calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView resultTextView;
    private String input = "";
    private String operator = "";
    private double firstNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.result);

        // Set up number and operation buttons
        setupButtonListeners();
    }

    private void setupButtonListeners() {
        int[] numberButtonIds = {
                R.id.button_0, R.id.button_1, R.id.button_2, R.id.button_3, R.id.button_4,
                R.id.button_5, R.id.button_6, R.id.button_7, R.id.button_8, R.id.button_9
        };

        View.OnClickListener numberListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button = (Button) v;
                input += button.getText().toString();
                resultTextView.setText(input);
            }
        };

        for (int id : numberButtonIds) {
            findViewById(id).setOnClickListener(numberListener);
        }

        // Set up operator buttons
        findViewById(R.id.button_add).setOnClickListener(operationListener);
        findViewById(R.id.button_subtract).setOnClickListener(operationListener);
        findViewById(R.id.button_multiply).setOnClickListener(operationListener);
        findViewById(R.id.button_divide).setOnClickListener(operationListener);

        // Set up equals and clear buttons
        findViewById(R.id.button_equals).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });

        findViewById(R.id.button_clear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear();
            }
        });

        findViewById(R.id.button_dot).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!input.contains(".")) {
                    input += ".";
                    resultTextView.setText(input);
                }
            }
        });

        findViewById(R.id.button_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!input.isEmpty()) {
                    input = input.substring(0, input.length() - 1);
                    resultTextView.setText(input);
                }
            }
        });
    }

    private View.OnClickListener operationListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button button = (Button) v;
            operator = button.getText().toString();
            if (!input.isEmpty()) {
                firstNumber = Double.parseDouble(input);
                input = "";
            }
        }
    };

    private void calculate() {
        if (!input.isEmpty() && !operator.isEmpty()) {
            double secondNumber = Double.parseDouble(input);
            double result = 0;
            switch (operator) {
                case "+":
                    result = firstNumber + secondNumber;
                    break;
                case "-":
                    result = firstNumber - secondNumber;
                    break;
                case "*":
                    result = firstNumber * secondNumber;
                    break;
                case "/":
                    if (secondNumber != 0) {
                        result = firstNumber / secondNumber;
                    } else {
                        resultTextView.setText("Error");
                        return;
                    }
                    break;
            }

            resultTextView.setText(String.format("%.2f", result));
            input = "";
            operator = "";
        }
    }

    private void clear() {
        input = "";
        operator = "";
        firstNumber = 0;
        resultTextView.setText("0");
    }
}
