package com.shikhar.shikharminorappl;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class NextPageActivity extends AppCompatActivity {
FirebaseAuth mFirebaeAuth;
Button b1;
private  FirebaseAuth.AuthStateListener mAuthStateListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b1=findViewById(R.id.button);
        setContentView(R.layout.activity_next_page);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent in=new Intent(NextPageActivity.this,MainActivity.class);
                startActivity(in);
            }
        });
    }
}
