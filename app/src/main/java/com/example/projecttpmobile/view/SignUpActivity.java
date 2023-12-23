package com.example.projecttpmobile.view;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projecttpmobile.R;
import com.example.projecttpmobile.controller.UserController;

public class SignUpActivity extends AppCompatActivity {
    private Button connect;
    private UserController userController;
    private EditText username;
    private EditText email;
    private EditText pwd;
    private CheckBox check;
    private TextView ink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        init();
    }

    private void init() {
        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        check = findViewById(R.id.rememberCheckBox);
        pwd=findViewById(R.id.password);
        userController = new UserController();
        connect = findViewById(R.id.connect);
        ink=findViewById(R.id.inkwell);
        ink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SignUpActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String us = String.valueOf(username.getText());
                String mail = String.valueOf(email.getText());
                String password = String.valueOf(pwd.getText());

                if (us.isEmpty() || mail.isEmpty()) {
                    Toast.makeText(SignUpActivity.this, "Please enter a Username or an Email or a Password", Toast.LENGTH_SHORT).show();
                } else  {
                    if(check.isActivated()){
                    userController.createUser(us, password, mail, SignUpActivity.this);
                    }

                    Intent intent = new Intent(SignUpActivity.this, HomeActivity.class);
                    intent.putExtra("mail",mail);
                    startActivity(intent);
                    finish();
                }
            }});
    }
}
