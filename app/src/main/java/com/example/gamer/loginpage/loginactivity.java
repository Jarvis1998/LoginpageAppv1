package com.example.gamer.loginpage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;

public class loginactivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int counter = 5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactivity);

        Name = (EditText) findViewById(R.id.nameid);
        Password = (EditText)findViewById(R.id.passwordid);
        Info = (TextView)findViewById(R.id.attempsid);
        Login = (Button)findViewById(R.id.signupbut);

        Info.setText("Number of Attempts Remaining: 5");

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(),Password.getText().toString());
            }
        });


    }

    private void validate(String userName,String userPassword){
    if((userName.equals("Admin") && userPassword == "12345")){
        Intent intent = new Intent (loginactivity.this, menuactivity.class);
        startActivity(intent);
    }else{
        counter--;

        Info.setText("Number of Attempts Remaining: " + String.valueOf(counter));

        if (counter == 0) {
            Login.setEnabled(false);
            }

        }
    }
}