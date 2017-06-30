package com.binhnq.mysecondapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Administrator on 25/06/2017.
 */

public class LoginSuccessActivity extends AppCompatActivity {
    private final String TAG = getClass().getSimpleName();
    private TextView tvUser;
    private Button btnContextMenu, btnPopupMenu;
    private PopupMenu popupMenu;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
        setContentView(R.layout.activity_views);
        tvUser = (TextView) findViewById(R.id.tvHello);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        getSupportActionBar().setDisplayUseLogoEnabled(false);

//        btnPopupMenu = (Button) findViewById(R.id.btnPopupMenu);
//        btnPopupMenu.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(LoginSuccessActivity.this, "???", Toast.LENGTH_SHORT).show();
//                popupMenu = new PopupMenu(getApplicationContext(),btnPopupMenu);
//                popupMenu.getMenuInflater().inflate(R.menu.popup_menu_layout,popupMenu.getMenu());
//                //popupMenu.show();
//            }
//        });

        Intent intent = getIntent();
        if (intent != null) {
            Bundle bundle = intent.getBundleExtra(MainActivity.BUNDLE);
            if (bundle != null) {
                tvUser.setText(bundle.getString(MainActivity.TITLE));
            } else {
                tvUser.setText(intent.getStringExtra(MainActivity.TITLE));
            }
        }

        btnContextMenu = (Button) findViewById(R.id.btnContextMenu);
        registerForContextMenu(btnContextMenu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_layout,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mnSetting:
                Toast.makeText(this, "Setting", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mnNotification:
                Toast.makeText(this, "Notification", Toast.LENGTH_SHORT).show();
                break;
            case android.R.id.home:
                Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu_layout,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch ( item.getItemId()){
            case R.id.itFriends:{
                Toast.makeText(this, "Friends clicked", Toast.LENGTH_SHORT).show();
                break;
            }

            case R.id.itSettings:{
                Toast.makeText(this, "Settings clicked", Toast.LENGTH_SHORT).show();
                break;
            }

        }
        return super.onContextItemSelected(item);
    }

}
