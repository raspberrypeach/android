package com.example.fragmentexample02;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, FragmentCallback {
    Fragment menu01;
    Fragment menu02;
    Fragment menu03;

    Toolbar toolbar;
    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        FragmentManager manager = getSupportFragmentManager();

        getSupportFragmentManager().beginTransaction().add(R.id.Mycontainer, menu01).commit();


        BottomNavigationView bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.tab1:
                        Toast.makeText(getApplicationContext(), "첫번째", Toast.LENGTH_SHORT).show();

                        menu01 = new Fragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.Mycontainer, menu01).commit();
                        toolbar.setTitle("첫번째 화면");
                        return true;

                    case R.id.tab2:
                        Toast.makeText(getApplicationContext(), "두번째", Toast.LENGTH_SHORT).show();

                        menu01 = new Fragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.Mycontainer, menu02).commit();
                        toolbar.setTitle("두번째 화면");
                        return true;

                    case R.id.tab3:
                        Toast.makeText(getApplicationContext(), "세번째", Toast.LENGTH_SHORT).show();

                        menu01 = new Fragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.Mycontainer, menu03).commit();
                        toolbar.setTitle("세번째 화면");
                        return true;
                }
                return false;
            }
        });

    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();

        if (id == R.id.menubar01) {
            Toast.makeText(this, "menu 01", Toast.LENGTH_SHORT).show();
            onFragmentSelected(0, null);
        } else if (id == R.id.menubar02) {
            Toast.makeText(this, "menu 02", Toast.LENGTH_SHORT).show();
            onFragmentSelected(1, null);
        } else if (id == R.id.menubar03) {
            Toast.makeText(this, "menu 03", Toast.LENGTH_SHORT).show();
            onFragmentSelected(2, null);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentSelected(int position, Bundle bundle) {

    }
}
