package com.example.bottomnavigationprieto;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class CalculatorFragment extends Fragment {

    private TextView resultTextView;
    private String input = "";
    private String operator = "";
    private double firstNumber = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_calculator, container, false); // Reuse your calculator layout

        resultTextView = rootView.findViewById(R.id.result);

        setupButtonListeners(rootView);

        return rootView;
    }

    private void setupButtonListeners(View rootView) {
        int[] numberButtonIds = {
                R.id.button_0, R.id.button_1, R.id.button_2, R.id.button_3, R.id.button_4,
                R.id.button_5, R.id.button_6, R.id.button_7, R.id.button_8, R.id.button_9
        };

        View.OnClickListener numberListener = v -> {
            Button button = (Button) v;
            input += button.getText().toString();
            resultTextView.setText(input);
        };

        for (int id : numberButtonIds) {
            rootView.findViewById(id).setOnClickListener(numberListener);
        }

        rootView.findViewById(R.id.button_add).setOnClickListener(operationListener);
        rootView.findViewById(R.id.button_subtract).setOnClickListener(operationListener);
        rootView.findViewById(R.id.button_multiply).setOnClickListener(operationListener);
        rootView.findViewById(R.id.button_divide).setOnClickListener(operationListener);

        rootView.findViewById(R.id.button_equals).setOnClickListener(v -> calculate());
        rootView.findViewById(R.id.button_clear).setOnClickListener(v -> clear());
        rootView.findViewById(R.id.button_dot).setOnClickListener(v -> {
            if (!input.contains(".")) {
                input += ".";
                resultTextView.setText(input);
            }
        });
        rootView.findViewById(R.id.button_delete).setOnClickListener(v -> {
            if (!input.isEmpty()) {
                input = input.substring(0, input.length() - 1);
                resultTextView.setText(input);
            }
        });
    }

    private View.OnClickListener operationListener = v -> {
        Button button = (Button) v;
        operator = button.getText().toString();
        if (!input.isEmpty()) {
            firstNumber = Double.parseDouble(input);
            input = "";
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