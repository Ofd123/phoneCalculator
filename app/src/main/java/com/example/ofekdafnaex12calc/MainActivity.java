package com.example.ofekdafnaex12calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edt;
    Button btn, btn1, btn2, btn3, btn4, btn5, btn6;
    double inputNum = 0;
    double number = 0;
    String input;
    boolean plus1 = false, minus1 = false, multiply1 = false,  devide1 = false;
    @Override

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt = findViewById(R.id.EDT);
        btn = findViewById(R.id.btn);
        btn1 =findViewById(R.id.btn1);
        btn2 =findViewById(R.id.btn2);
        btn3 =findViewById(R.id.btn3);
        btn4 =findViewById(R.id.btn4);
        btn5 =findViewById(R.id.btn5);
        btn6 =findViewById(R.id.btn6);
    }

    public void problem(View view)
    {
        if (number == 0)
        {
            input = edt.getText().toString();
        }
        else
        {
            input = String.valueOf(number);
        }
        if (!(input.isEmpty()))
        {
            edt.setHint(input);
            edt.setText("");
            //------------------------'

            inputNum = Double.parseDouble(input);
            if (plus1)
            {
                number += inputNum;
                plus1 = false;
            }
            if (minus1)
            {
                number -= inputNum;
                minus1 = false;
            }
            if (multiply1)
            {
                number *= inputNum;
                multiply1 = false;
            }
            if (devide1)
            {
                number /= inputNum;
                devide1 = false;
            }
        }
    }


    //----------------------------------------------------------------
    public void plus(View view)
    {
        problem(view);
        plus1 = true;
    }
    //----------------------------------------------------------------
    public void minus(View view)
    {
        problem(view);
        minus1 = true;
    }
    //----------------------------------------------------------------
    public void devide(View view)
    {
        problem(view);
        devide1 = true;
    }
    //----------------------------------------------------------------
    public void multiply(View view)
    {
        problem(view);
        multiply1 = true;
    }
    //----------------------------------------------------------------
    public void answer(View view)
    {
        problem(view);
    }
    //----------------------------------------------------------------
    public void reset(View view)
    {
        number = 0;
        input = "0";
        edt.setHint(input);
    }
    //----------------------------------------------------------------
    public void credits(View view)
    {
    }

}