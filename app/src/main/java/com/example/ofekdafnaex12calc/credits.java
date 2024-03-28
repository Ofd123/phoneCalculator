package com.example.ofekdafnaex12calc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class credits extends AppCompatActivity
{
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
        tv = findViewById(R.id.textView);
        Intent send = getIntent();
        double answer = send.getDoubleExtra("answer", 0);
        tv.setText("HELLO\nthe answer to your problem is:\t"+answer);
    }
    //----------------------------------------------------------------
    public void back(View view)
    {
        finish();
    }
}