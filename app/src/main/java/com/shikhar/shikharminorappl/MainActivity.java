package com.shikhar.shikharminorappl;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.shikhar.shikharminorappl.R;

public class MainActivity extends AppCompatActivity {
EditText et1,et2;
Button b1;
TextView tv1;
    private FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFirebaseAuth = FirebaseAuth.getInstance();
        et1=findViewById(R.id.editText3);
        et2=findViewById(R.id.editText4);
        tv1=findViewById(R.id.textView3);

        b1=findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = et1.getText().toString();
                String pwd = et2.getText().toString();

                if (email.isEmpty()) {
                    et1.setError("Please enter an email id");
                    et1.requestFocus();
                } else if (pwd.isEmpty()) {
                    et2.setError("Please enter a password");
                    et2.requestFocus();
                } else if (email.isEmpty() && pwd.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Please enter password and email", Toast.LENGTH_SHORT).show();
                }
                else if(!(email.isEmpty() && pwd.isEmpty()))
                {
                    mFirebaseAuth.createUserWithEmailAndPassword(email,pwd).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful())
                            {
                                Toast.makeText(MainActivity.this, "Sign up unSuccesfull.Please Try Again Later", Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                Intent in=new Intent(MainActivity.this,NextPageActivity.class);
                                startActivity(in);

                            }
                        }
                    });
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Error Occured", Toast.LENGTH_SHORT).show();
                }
            }
        });
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(MainActivity.this,NextPageActivity.class);
                startActivity(i);
            }
        });

    }
}
