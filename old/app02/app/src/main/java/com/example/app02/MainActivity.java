package com.example.app02;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.app02.R;

public class MainActivity extends AppCompatActivity {
    ImageView imageview1;
    ImageView imageview2;
    BitmapDrawable bitmap;

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageview1 = findViewById(R.id.imageview1);
        imageview2 = findViewById(R.id.imageview2);

        Resources res = getResources();
        bitmap = (BitmapDrawable) res.getDrawable(R.drawable.cat);

        imageview1.setImageDrawable(bitmap);
        imageview1.setScaleType(ImageView.ScaleType.FIT_XY);
    }

    public void onClickButton2(View view) {

        imageview2.setImageDrawable(bitmap);
        imageview2.setScaleType(ImageView.ScaleType.FIT_XY);
        imageview1.setImageDrawable(null);
    }

    public void onClickButton1(View view) {
        imageview1.setImageDrawable(bitmap);
        imageview1.setScaleType(ImageView.ScaleType.FIT_XY);

        imageview2.setImageDrawable(null);
    }
}