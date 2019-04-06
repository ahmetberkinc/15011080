package com.example.k5odev;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginScreen extends AppCompatActivity {
    EditText id;
    EditText password;
    Button giris;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        id=(EditText)findViewById(R.id.id);
        password=(EditText)findViewById(R.id.password);
        giris=(Button)findViewById(R.id.giris);
        final Intent form=new Intent(this,MainActivity.class);

        giris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(id.getText().toString().equals("admin") && password.getText().toString().equals("password")){

                    startActivity(form);

                }
                else
                    Toast.makeText(getApplicationContext(),"Bilgiler Hatalı",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
