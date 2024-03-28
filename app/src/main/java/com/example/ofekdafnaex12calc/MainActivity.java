package com.example.ofekdafnaex12calc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edt;
    Button btn, btn1, btn2, btn3, btn4, btn5, btn6;
    double inputNum = 0;
    double number = 0;
    String input;
    boolean plus1 = false, minus1 = false, multiply1 = false,  devide1 = false;
    boolean plus2 = false, minus2 = false, multiply2 = false, devide2 = false;
    //----------------------------------------------------------------
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
    //----------------------------------------------------------------
    public void problem(View view)
    {
        plus1 = plus2;
        minus1 = minus2;
        multiply1 = multiply2;
        devide1 = devide2;
        input = edt.getText().toString();
        if (!input.isEmpty())
        {
            inputNum = Double.parseDouble(input);
            if (plus1)
            {
                number += inputNum;
                plus2 = false;
            }
            else if (minus1)
            {
                number -= inputNum;
                minus2 = false;
            }
            else if (multiply1)
            {
                number *= inputNum;
                multiply2 = false;
            }
            else if (devide1)
            {
                if (inputNum == 0)
                {
                    Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    number /= inputNum;
                    devide2 = false;
                }
            }
            else
            {
                number = inputNum;
            }
            input = String.valueOf(number);
            edt.setHint(input);
            edt.setText("");
        }
    }



    //----------------------------------------------------------------
    public void plus(View view)
    {
        problem(view);
        plus2 = true;
    }
    //----------------------------------------------------------------
    public void minus(View view)
    {
        problem(view);
        minus2 = true;
    }
    //----------------------------------------------------------------
    public void devide(View view)
    {
        problem(view);
        devide2 = true;
    }
    //----------------------------------------------------------------
    public void multiply(View view)
    {
        problem(view);
        multiply2 = true;
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
        edt.setText("0");
    }
    //----------------------------------------------------------------
    public void credits(View view)
    {
        Intent send = new Intent(this, credits.class);
        send.putExtra("answer", number);
        startActivity(send);
    }

}