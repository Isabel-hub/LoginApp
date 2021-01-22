package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    EditText etName, etPassword ;
    Button btnLogin;
    TextView tvAttemptsInfo;
    String Username = "Admin";
    String Password = "123456";
    boolean isValid = false;
    int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: started");

        etName = findViewById(R.id.etName);
        etPassword = findViewById(R.id.etPassword);
        tvAttemptsInfo = findViewById(R.id.tvAttemptsInfo);
        btnLogin = findViewById(R.id.btnLogin);




        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String inputName = etName.getText().toString();
                String inputPassword = etPassword.getText().toString();

                if (inputName.isEmpty() || inputPassword.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "input the all details", Toast.LENGTH_SHORT).show();
                }else
                    {
isValid = validate(inputName, inputPassword);
if (!isValid){
    counter --;
    Toast.makeText(MainActivity.this, "incorrect credentials", Toast.LENGTH_SHORT).show();
    tvAttemptsInfo.setText("No. of attempts remaining:5" + counter);

    if (counter == 0){
        btnLogin.setEnabled(false);
    }else {
        Toast.makeText(MainActivity.this, "Login success", Toast.LENGTH_SHORT).show();
        //go to the new activity
        Intent intent = new Intent(MainActivity.this, HomePageActivity.class);
        startActivity(intent);
    }
}
                }
            }
        });
    }
    public boolean validate(String Name, String Password){
      if (etName.equals(Username) && (etPassword.equals(Password)))
      {
          return true;
      }else {
          return false;
      }
    }
}