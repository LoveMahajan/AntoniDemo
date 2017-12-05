package com.example.admin.antoni;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import ResideMenuUtility.ResideMenu;
import ResideMenuUtility.ResideMenuItem;


public class MainActivity extends FragmentActivity implements View.OnClickListener{

    private TextView mTextMessage;
    private ResideMenu resideMenu;
    private MainActivity mContext;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext=MainActivity.this;
       setUpMenu();
       Utility.checkLocationPermissions(this);
    }

    private void setUpMenu() {

        // attach to current activity;
        resideMenu = new ResideMenu(MainActivity.this);
        //set background of menu
        resideMenu.setBackground(R.drawable.bg_menu);
        resideMenu.attachToActivity(this);
        //valid scale factor is between 0.0f and 1.0f. leftmenu'width is 150dip.
        resideMenu.setScaleValue(0.6f);


        // create menu items;
   /*   itemHome     = new ResideMenuItem(this, R.mipmap.ic_launcher_round,     "Home");
        itemProfile  = new ResideMenuItem(this, R.mipmap.ic_launcher_round,  "Profile");
        itemCalendar = new ResideMenuItem(this, R.mipmap.ic_launcher_round, "Calendar");
        itemSettings = new ResideMenuItem(this, R.mipmap.ic_launcher_round, "Settings");

        itemHome.setOnClickListener(this);
        itemProfile.setOnClickListener(this);
        itemCalendar.setOnClickListener(this);
        itemSettings.setOnClickListener(this);

        resideMenu.addMenuItem(itemHome, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemProfile, ResideMenu.DIRECTION_LEFT);
        resideMenu.addMenuItem(itemCalendar, ResideMenu.DIRECTION_RIGHT);
        resideMenu.addMenuItem(itemSettings, ResideMenu.DIRECTION_RIGHT);*/


        // You can disable a direction by setting ->
        // resideMenu.setSwipeDirectionDisable(com.example.admin.bottomnavigation.ResideMenu.DIRECTION_RIGHT);



        findViewById(R.id.title_bar_left_menu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resideMenu.openMenu(ResideMenu.DIRECTION_LEFT);
            }
        });
        findViewById(R.id.title_bar_right_menu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resideMenu.openMenu(ResideMenu.DIRECTION_RIGHT);
            }
        });
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return resideMenu.dispatchTouchEvent(ev);
    }

    @Override
    public void onClick(View view) {

       /* if (view == itemHome){
            changeFragment(new HomeFragment());
        }else if (view == itemProfile){
            changeFragment(new ProfileFragment());
        }else if (view == itemCalendar){
            changeFragment(new CalendarFragment());
        }else if (view == itemSettings){
            changeFragment(new SettingsFragment());
        }*/

        resideMenu.closeMenu();
    }

    private ResideMenu.OnMenuListener menuListener = new ResideMenu.OnMenuListener() {
        @Override
        public void openMenu() {
            Toast.makeText(mContext, "Menu is opened!", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void closeMenu() {
            Toast.makeText(mContext, "Menu is closed!", Toast.LENGTH_SHORT).show();
        }
    };

    private void changeFragment(Fragment targetFragment){
        resideMenu.clearIgnoredViewList();
        /*getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fragment, targetFragment, "fragment")
                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();*/
    }

    // What good method is to access resideMenuï¼Ÿ
    public ResideMenu getResideMenu(){
        return resideMenu;
    }
}
