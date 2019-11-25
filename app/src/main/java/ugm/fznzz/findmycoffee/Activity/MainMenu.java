package ugm.fznzz.findmycoffee.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import ugm.fznzz.findmycoffee.Fragment.HomeFragment;
import ugm.fznzz.findmycoffee.R;
import ugm.fznzz.findmycoffee.Fragment.SettingsFragment;
import ugm.fznzz.findmycoffee.Fragment.SortFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainMenu extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    private NavigationView navigationView;
    String loginState;
    String phoneNumber;
    String nameOwner;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            MenuItem item =  navigationView.getMenu().getItem(0);
            onNavigationItemSelected(item);
        }


    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_home: {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
                menuItem.setChecked(true);
                break;
            }
            case R.id.nav_sort: {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SortFragment()).commit();
                menuItem.setChecked(true);
                break;
            }
            case R.id.nav_settings: {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SettingsFragment()).commit();
                menuItem.setChecked(true);
                break;
            }
            case R.id.nav_login: {
                Intent login = new Intent(MainMenu.this, Login.class);
                startActivity(login);
                break;
            }
            case R.id.nav_signup:
                Intent sign_up = new Intent(MainMenu.this, SignUp.class);
//                sign_up.putExtra("stateLogin", loginState);
//                sign_up.putExtra("name", nameOwner);
//                sign_up.putExtra("phoneNum", phoneNumber);
                startActivity(sign_up);
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return false;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }


    }
}