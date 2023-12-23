package com.example.projecttpmobile.view;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.projecttpmobile.model.user;
import com.example.projecttpmobile.R;
import com.example.projecttpmobile.controller.UserController;

public class MainActivity extends AppCompatActivity {
    private Button connect;
    private UserController userController;
    private user user;
    private EditText username;
    private EditText password;
    private TextView ink;
    private CheckBox check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        }

    private void init(){
        username= findViewById(R.id.email);
        password=findViewById(R.id.password);
        check=findViewById(R.id.rememberCheckBox);
        userController = new UserController();
        connect=findViewById(R.id.connect);
        ink=findViewById(R.id.inkwell);
        ink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        connect.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String mail = String.valueOf(username.getText());
                String pd = String.valueOf(password.getText());

                if (mail.isEmpty() || pd.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Verify username or password", Toast.LENGTH_LONG).show();
                } else {
                    if (check.isActivated()) {
                        //System.out.print(check.isActivated());
                        userController.recapUser(MainActivity.this);
                    }

                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    intent.putExtra("mail",mail);
                    startActivity(intent);
                    finish();
                }
            }

        });
}}