package com.example.sagar.a4nationsinternationalapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.sagar.a4nationsinternationalapplication.R.id.etPassword;

public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button Login;
    private int Counter=5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name=(EditText)findViewById(R.id.etName);
        Password=(EditText)findViewById(etPassword);
        Info =(TextView)findViewById(R.id.tvInfo);
        Login=(Button)findViewById(R.id.btnLogin);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(),Password.getText().toString());
            }
        });
    }

    private void validate (String userName, String userPassword){
        if ((userName.equals("Admin")) && (userPassword.equals("1234"))){
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        }
        else{
            Counter--;

            Info.setText("No of attempts remaining:" +String.valueOf(Counter));

            if (Counter==0){
                Login.setEnabled(false);
            }
        }
    }
}
