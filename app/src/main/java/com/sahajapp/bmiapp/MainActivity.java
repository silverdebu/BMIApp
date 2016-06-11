package com.sahajapp.bmiapp;

import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import static com.sahajapp.bmiapp.CommonUtil.showToastMessage;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

       /* TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("Tab 1"));
        tabs.addTab(tabs.newTab().setText("Tab 2"));
        tabs.addTab(tabs.newTab().setText("Tab 3"));*/

        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            getPortraitFrag(savedInstanceState);
        } else
            getPortraitFrag(savedInstanceState);
    }

    private void getPortraitFrag(Bundle savedInstanceState) {
        if (savedInstanceState != null) return;
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.inputFrame, MainActivityFragment.newInstance());
        transaction.replace(R.id.detailFrame, DetailFragment.newInstance());
        transaction.commit();
        showToastMessage("Started Frag",this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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


    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        showToastMessage("Destroy", this);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        showToastMessage("PostResume", this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        showToastMessage("Pause", this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        showToastMessage("Resume", this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        showToastMessage("Start", this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        showToastMessage("BackPressed", this);
    }
}
