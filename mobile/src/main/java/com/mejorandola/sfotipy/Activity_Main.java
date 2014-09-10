package com.mejorandola.sfotipy;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;

import fragments.Fragment_Play;


public class Activity_Main extends FragmentActivity implements Fragment_Play.OnFragmentInteractionListener {

    // The TAG for debugging
    private static final String TAG = "Activity_Main";

    // The DrawerLayout and its toggle
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;


    // The fragment manager and the first fragment
    private FragmentManager fragmentManager;
    private Fragment_Play fragment_play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // The fragment manager and the first fragment
        fragmentManager = getSupportFragmentManager();

        // Add the first fragment
        if (fragment_play == null) {
            fragment_play = new Fragment_Play();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.activity_main_fragment_container, fragment_play)
                    .commit();
        }

        // Open and Close the drawer with the App Icon
        drawerLayout = (DrawerLayout) findViewById(R.id.activity_main_drawerlayout);
        getActionBar().setDisplayHomeAsUpEnabled(true);


        getActionBar().setTitle(getResources().getString(R.string.none));
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
                R.drawable.ic_drawer, R.string.none,
                R.string.none) {
            public void onDrawerClosed(View view) {
                getActionBar().setIcon(
                        getResources().getDrawable(R.drawable.ic_launcher));

                invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {

                getActionBar().setIcon(
                        getResources().getDrawable(R.drawable.ic_logo));
                invalidateOptionsMenu();
            }
        };
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        actionBarDrawerToggle.syncState();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity__main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // The action bar home/up action should open or close the drawer.
        // ActionBarDrawerToggle will take care of this.
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentPlayPlay(boolean isPlaying) {

    }

    @Override
    public void onFragmentPlayBackward() {

    }

    @Override
    public void onFragmentPlayForward() {

    }

    @Override
    public void onFragmentPlayRandom(boolean isRandom) {

    }
}
