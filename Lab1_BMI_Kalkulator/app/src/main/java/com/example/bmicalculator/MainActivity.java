package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    //Wzór na BMI = masa ciała(kg)/wzrost(m)^2

    private static final DecimalFormat decimalFormat = new DecimalFormat("#.##");
    private double weight;
    private double height;
    private double score;
    private TextView scoreTextView;
    private EditText inputWeight;
    private EditText inputHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputWeight = (EditText) findViewById(R.id.inputWeightEditText);
        inputHeight = (EditText) findViewById(R.id.inputHeightEditText);
        scoreTextView = (TextView) findViewById(R.id.scoreView);
        Button countBtn = findViewById(R.id.countBtn);

        countBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weight = Double.parseDouble(inputWeight.getText().toString());
                height = Double.parseDouble(inputHeight.getText().toString()) / 100;
                score = weight / Math.pow(height, 2);
                scoreTextView.setText(String.format("%s%s", getString(R.string.scoreBmiMessage), decimalFormat.format(score)));
            }
        });

    }


}