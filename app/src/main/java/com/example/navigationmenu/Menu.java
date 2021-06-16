package com.example.navigationmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class Menu extends AppCompatActivity {

    Toolbar appbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        appbar = findViewById(R.id.id_appbar);
        setSupportActionBar(appbar);

        drawerLayout = findViewById(R.id.id_main_activity_DrawerLayout);
        navigationView = findViewById(R.id.id_activity_main_navigationView);

        navigationView.bringToFront();
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, appbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigationView.setCheckedItem(R.id.id_nav_menu_home);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.id_nav_menu_contact:
                        Toast.makeText(getApplicationContext(), "contact clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.id_nav_menu_home:
                        Toast.makeText(getApplicationContext(), "home clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.id_nav_menu_profile:
                        Toast.makeText(getApplicationContext(), "profile clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.id_item2:
                        Toast.makeText(getApplicationContext(), "item 2 clicked", Toast.LENGTH_SHORT).show();
                        break;
                }

                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
            super.onBackPressed();
    }


    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.app_bar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.id_item1:
                Toast.makeText(getApplicationContext(), "item 1 clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.id_item2:
                Toast.makeText(getApplicationContext(), "item 2 clicked", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}