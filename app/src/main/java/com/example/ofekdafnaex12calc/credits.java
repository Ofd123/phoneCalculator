package com.example.ofekdafnaex12calc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class credits extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
        Intent send = getIntent();
        double answer = send.getDoubleExtra("answer", 0);
    }
}