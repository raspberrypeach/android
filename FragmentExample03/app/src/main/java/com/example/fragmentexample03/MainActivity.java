package com.example.fragmentexample03;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    Menu01 menu01;
    Menu02 menu02;
    Menu03 menu03;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menu01 = new Menu01();
        menu02 = new Menu02();
        menu03 = new Menu03();

        getSupportFragmentManager().beginTransaction().replace(R.id.mycontainer, menu01).commit();

        BottomNavigationView bottomnavigation = findViewById(R.id.bottom_navigation);
        bottomnavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.tab1:
                        Toast.makeText(getApplicationContext(), "첫번째 메뉴", Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction().replace(R.id.mycontainer, menu01).commit();
                        return true;

                    case R.id.tab2:
                        Toast.makeText(getApplicationContext(), "두번째 메뉴", Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction().replace(R.id.mycontainer, menu02).commit();
                        return true;

                    case R.id.tab3:
                        Toast.makeText(getApplicationContext(), "세번째 메뉴", Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction().replace(R.id.mycontainer, menu03).commit();
                        return true;
                }
                return false;
            }
        });
    }
}