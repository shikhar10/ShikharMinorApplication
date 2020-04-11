package com.shikhar.shikharminorappl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenuActivity extends AppCompatActivity implements View.OnClickListener {
Button b1,b2,b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        b1=findViewById(R.id.button3);
        b2=findViewById(R.id.button4);
        b3=findViewById(R.id.button5);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);

        b3.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v==b1)
        {
            Intent in=new Intent(this,AccountSetupActivity.class);
            startActivity(in);
        }
        if(v==b2)
        {
            Intent in=new Intent(this,CategoriesActivity.class);
            startActivity(in);
        }
        if(v==b3)
        {
            Intent in=new Intent(this,ExpenseEntryActivity.class);
            startActivity(in);
        }

    }
}
