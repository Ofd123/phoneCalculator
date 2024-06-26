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
    double inputNum = 0;
    double number = 0;
    String input;
    boolean plus1 = false, minus1 = false, multiply1 = false,  divide1 = false;
    boolean plus2 = false, minus2 = false, multiply2 = false, divide2 = false;
    //----------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt = findViewById(R.id.EDT);
    }
    //----------------------------------------------------------------
    public boolean valid(String input)
    {
        if (input.isEmpty())
        {
            return false;
        }
        else if (input.length() == 1)
        {
            char firstChar = input.charAt(0);
            if (firstChar == '.' || firstChar == '-')
            {
                return false;
            }
        }
        else
        {
            char firstChar = input.charAt(0);
            char lastChar = input.charAt(input.length() - 1);
            if (lastChar == '.' || lastChar == '-' || firstChar == '.')
            {
                return false;
            }
        }
        return true;
    }

    //----------------------------------------------------------------
    public void problem(View view)
    {
        plus1 = plus2;
        minus1 = minus2;
        multiply1 = multiply2;
        divide1 = divide2;
        input = edt.getText().toString();
        if (valid(input))
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
            else if (divide1)
            {
                if (inputNum == 0)
                {
                    Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    number /= inputNum;
                    divide2 = false;
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
        divide2 = true;
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
        edt.setText("");
    }
    //----------------------------------------------------------------
    public void credits(View view)
    {
        Intent send = new Intent(this, credits.class);
        send.putExtra("answer", number);
        startActivity(send);
    }

}