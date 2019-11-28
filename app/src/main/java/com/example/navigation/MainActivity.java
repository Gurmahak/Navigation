package com.example.navigation;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        /************* BOTTOM MENU INITIALISATION *****************/

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications, R.id.navigation_chat)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }




    /************* TOP MENU *****************/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.topmenu, menu);

        return true;

    }


    /************* TOP MENU ITEM ACTIONS *****************/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.profile:
                Toast.makeText(this, "Profile Selected",Toast.LENGTH_SHORT).show();
//                Intent i = new Intent(MainActivity.this, loginGoogle.class);
//                startActivity(i);
                return  true;

            case R.id.settings:
                Toast.makeText(this, "Settings Menu Selected",Toast.LENGTH_SHORT).show();
                return  true;

            case R.id.profile1:
                Toast.makeText(this, "Sub Profile Menu Selected",Toast.LENGTH_SHORT).show();
                return  true;

            case R.id.contact:
                Toast.makeText(this, "Contacts Menu Selected",Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }

    }

}
