package com.example.app03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText text1;
    private long backKeyTime = 0;
    private long sendTime = 0;
    private long closeTime = 0;
    private static Toast toast;

    @Override
    public void onBackPressed() {
        if(System.currentTimeMillis() > backKeyTime + 2000){
            backKeyTime = System.currentTimeMillis();

            if (toast != null) {
                toast.cancel(); //이전에 생성된 TOAST 삭제
            }
            toast = Toast.makeText(this, "한번 더 누르면 앱을 종료합니다", Toast.LENGTH_SHORT);
            toast.show();
        }
        else{
            Toast.makeText(this, "종료되었습니다.", Toast.LENGTH_LONG).show();
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = findViewById(R.id.inputMessage);
    }

    public void onclickButton1(View view) {
        if(System.currentTimeMillis() > sendTime + 2000){
            sendTime = System.currentTimeMillis();

            if (toast != null) {
                toast.cancel(); //이전에 생성된 TOAST 삭제
            }
            toast = Toast.makeText(this, "메시지를 전송하였습니다.", Toast.LENGTH_SHORT);
            toast.show();
            text1.clearFocus();

            /*
            * contents
            * */
        }
    }

    public void onclickButton2(View view) {
        if (toast != null) {
            toast.cancel(); //이전에 생성된 TOAST 삭제
        }
        toast = Toast.makeText(this, "종료.", Toast.LENGTH_SHORT);
        toast.show();
    }
}