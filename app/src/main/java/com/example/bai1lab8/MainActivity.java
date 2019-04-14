package com.example.bai1lab8;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView lvList;

    private MyAdapter myAdapter;
    private Boolean is =true;
    private  ArrayList<Gioithieu> gioithieus = new ArrayList<>();
    private FrameLayout layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //code new


        layout=findViewById(R.id.FrameLayout);



        //
       
        lvList = findViewById(R.id.lvList);
        gioithieus.clear();
        addrecyclerview();

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // VISIBLE:Hiện lên
                    lvList.setVisibility(View.VISIBLE);
                    //INVISIBLE:ẨN ĐI
                    layout.setVisibility(View.INVISIBLE);

                    if (is==true){
                       
                        gioithieus.add(new Gioithieu(R.drawable.anh,R.drawable.ic_menu_camera,R.drawable.ic_menu_share));
                        gioithieus.add(new Gioithieu(R.drawable.anh1,R.drawable.ic_menu_camera,R.drawable.ic_menu_share));
                        gioithieus.add(new Gioithieu(R.drawable.anh,R.drawable.ic_menu_camera,R.drawable.ic_menu_share));
                        gioithieus.add(new Gioithieu(R.drawable.anh1,R.drawable.ic_menu_camera,R.drawable.ic_menu_share));
                        myAdapter.notifyDataSetChanged();
                        is=false;

                    }else {

                        gioithieus.add(new Gioithieu(android.R.drawable.ic_menu_edit,R.drawable.ic_menu_camera,R.drawable.ic_menu_share));
                        myAdapter.notifyDataSetChanged();
                        Toast.makeText(MainActivity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                        
                    }
                    

                    }
            });

        


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
    
    
    private void addrecyclerview(){
        myAdapter = new MyAdapter(MainActivity.this,gioithieus,R.layout.item);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        lvList.setLayoutManager(linearLayoutManager);
        lvList.setAdapter(myAdapter);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        switch (id) {
            case R.id.nav_First:

                fragmentTransaction.replace(R.id.FrameLayout, new Fragment_First()).commit();

                break;
            case R.id.nav_Second:
                fragmentTransaction.replace(R.id.FrameLayout, new Fragment_Second()).commit();

                break;
            case R.id.nav_Third:
                fragmentTransaction.replace(R.id.FrameLayout, new Fragment_Third()).commit();

                break;
            case R.id.nav_SubItem1:
                fragmentTransaction.replace(R.id.FrameLayout, new Fragment_Sub_Item1()).commit();

                break;
            case R.id.nav_SubItem2:
                fragmentTransaction.replace(R.id.FrameLayout, new Fragment_Sub_Item2()).commit();

                break;
        }
        is=true;
        lvList.setVisibility(View.INVISIBLE);
        layout.setVisibility(View.VISIBLE);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
