package com.example.app08;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_CUSTOMER = 201;
    public static final int REQUEST_CODE_REVENUE = 202;
    public static final int REQUEST_CODE_PRODUCT = 203;

    Button CustomerButton;
    Button SalesButton;
    Button productButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // process received intent (LoginActivity, CustomerActivity ...)
        Intent receivedIntent = getIntent();
        String username = receivedIntent.getStringExtra("username");
        String password = receivedIntent.getStringExtra("password");

        Toast.makeText(this, "username : " + username + ", password : " + password, Toast.LENGTH_LONG).show();

        CustomerButton = findViewById(R.id.customerButton);
        CustomerButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) { // click first button
                Intent intent = new Intent(getApplicationContext(), CustomerActivity.class); //Main -> Customer
                intent.putExtra("titleMsg", "고객관리 화면");

                startActivityForResult(intent, REQUEST_CODE_CUSTOMER);
            }
        });

        SalesButton = findViewById(R.id.salesButton);
        SalesButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.out.println("acacac");
                Intent intent = new Intent(getApplicationContext(), SalesActivity.class); //Main -> Sales
                intent.putExtra("titleMsg", "매출관리 화면");

                startActivityForResult(intent, REQUEST_CODE_REVENUE);
            }
        });

        productButton = (Button) findViewById(R.id.productButton);
        productButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ProductActivity.class); //Main -> product
                intent.putExtra("titleMsg", "상품관리 화면");

                startActivityForResult(intent, REQUEST_CODE_PRODUCT);
            }
        });

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent) { // get Result from next Activity
        super.onActivityResult(requestCode, resultCode, intent);

        if (intent != null) {
            if (requestCode == REQUEST_CODE_CUSTOMER) {
                String message = intent.getStringExtra("message");

                if (message != null) {
                    Toast toast = Toast.makeText(getBaseContext(), "고객관리 응답, result code : " + resultCode + ", message : " + message, Toast.LENGTH_LONG);
                    toast.show();
                }
            } else if (requestCode == REQUEST_CODE_REVENUE) {
                String message = intent.getStringExtra("message");

                if (message != null) {
                    Toast toast = Toast.makeText(getBaseContext(), "매출관리 응답, result code : " + resultCode + ", message : " + message, Toast.LENGTH_LONG);
                    toast.show();

                    if (message.equals("login")) {
                        finish();
                    }
                }
            } else if (requestCode == REQUEST_CODE_PRODUCT) {
                String message = intent.getStringExtra("message");

                if (message != null) {

                    Toast toast = Toast.makeText(getBaseContext(), "상품관리 응답, result code : " + resultCode + ", message : " + message, Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        }

    }

}