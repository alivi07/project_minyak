package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        //Menampilkan halaman Fragment yang pertama kali muncul
        getFragmentPage(new HomeFragment());

        /*Inisialisasi BottomNavigationView beserta listenernya untuk
         *menangkap setiap kejadian saat salah satu menu item diklik
         */
        BottomNavigationView bottomNavigation = findViewById(R.id.bn_main);
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fragment = null;

                //Menantukan halaman Fragment yang akan tampil
                switch (item.getItemId()){
                    case R.id.home_menu:
                        fragment = new HomeFragment();
                        break;

                    case R.id.metode_menu:
                        fragment = new MetodeFragment();
                        break;

                    case R.id.favorite_menu:
                        fragment = new FavoriteFragment();
                        break;
                }
                return getFragmentPage(fragment);
            }
        });
    }

    //Menampilkan halaman Fragment
    private boolean getFragmentPage(Fragment fragment){
        if (fragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fl_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.keluar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.logout_menu:

//                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity2.this);
//                builder.setMessage("Apakah yakin ingin keluar ?");
//                builder.setCancelable(true);
//                builder.setPositiveButton("Ok", new View.OnClickListener(){
//                    @Override
//                    public void onClick(DialogInterface dialog, int id){
//                        finish();
//                    }
//                });
//                builder.setNegativeButton("Cancel", new View.OnClickListener(){
//
//                    @Override
//                    public void onClick(DialogInterface dialog, int id) {
//                        dialog.cancel();
//
//                    }
//                });
//                AlertDialog alert = builder.create();
//                alert.show();
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}