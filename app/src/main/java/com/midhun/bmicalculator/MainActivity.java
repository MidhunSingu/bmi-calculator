package com.midhun.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ProgressBar prog;
    private RadioButton male_btn;
    private RadioButton female_btn;
    private EditText age;
    private EditText weight;
    private EditText height;
    private Button calculate;
    private TextView ans;

    private boolean isMale = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prog = findViewById(R.id.prog);
        male_btn = findViewById(R.id.male_radio);
        female_btn = findViewById(R.id.female_radio);
        age = findViewById(R.id.age);
        weight = findViewById(R.id.weight);
        height = findViewById(R.id.height);
        calculate = findViewById(R.id.bmicalci);
        ans = findViewById(R.id.ans);

        if(male_btn.isChecked()){
            isMale = true;
        }


        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int int_age = Integer.parseInt(age.getText().toString()+"");
                int int_weight = Integer.parseInt(weight.getText().toString());
                int int_height = Integer.parseInt(height.getText().toString());

                prog.setVisibility(View.VISIBLE);

                Log.d("debug",int_weight+"");
                Log.d("debug",int_height+"");

                double BMI = int_weight/(Math.pow(int_height,2))*10000;

                Toast.makeText(MainActivity.this, BMI+"", Toast.LENGTH_SHORT).show();
                if(BMI<18.5){
                    prog.setProgress(25);
                    ans.setText("Underweight");
                }else if(BMI>=18.5 && BMI<=24){
                    prog.setProgress(50);
                    ans.setText("Normal Weight");
                }else if(BMI>=25 && BMI<=29.9){
                    prog.setProgress(75);
                    ans.setText("Overweight");
                }else if(BMI>=30){
                    prog.setProgress(100);
                    ans.setText("Obess");
                }
            }
        });

    }
}