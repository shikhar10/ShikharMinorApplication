package com.shikhar.shikharminorappl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AccountSetupActivity extends AppCompatActivity implements View.OnClickListener {
EditText et1,et2,et3,et4;
Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_setup);
        et1=findViewById(R.id.editText);
        et2=findViewById(R.id.editText2);
        et3=findViewById(R.id.editText5);
        et4=findViewById(R.id.editText6);
       b1=findViewById(R.id.button6);
       b2=findViewById(R.id.button7);
       b1.setOnClickListener(this);//next page
       b2.setOnClickListener(this);//add a user
    }
    @Override
    public void onClick(View v) {
        if(v==b1)
        {
            Intent in=new Intent(this,CategoriesActivity.class);
            startActivity(in);
        }
        else if(v==b2)
        {
             String amount=et1.getText().toString();
            //String time=et2.getText().toString();
            //String targe=et3.getText().toString();
            String name=et4.getText().toString();
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("User");
            myRef.child(name).setValue(amount);
            Toast.makeText(this, "Data Saved Succesfully", Toast.LENGTH_SHORT).show();
        }
    }
}
