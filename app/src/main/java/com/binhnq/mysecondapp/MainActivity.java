package com.binhnq.mysecondapp;

import android.app.Dialog;
import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final String TAG = getClass().getSimpleName();
    private Button btnLogin,btnRegister;
    private EditText edtUser, edtPass;
    public static final String TITLE ="title";
    public static final String BUNDLE = "bundle";
    private Dialog dialog;
    private ActionBar ab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
        setContentView(R.layout.activity_login);

        ab = getSupportActionBar();
        ab.setDisplayUseLogoEnabled(true);
        ab.setDisplayShowHomeEnabled(true);

        edtPass = (EditText) findViewById(R.id.edtPass);
        edtUser = (EditText) findViewById(R.id.edtUser);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtUser.getText().toString().compareTo("a")==0
                    && edtPass.getText().toString().compareTo("")==0){
                        Intent intent = new Intent(MainActivity.this,LoginSuccessActivity.class);
                        intent.putExtra(TITLE,edtUser.getText().toString());
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(MainActivity.this,edtUser.getText().toString()+ " " + edtPass.getText().toString(),Toast.LENGTH_LONG).show();
                        dialog = new Dialog(MainActivity.this);
                        dialog.setTitle("Erorr!!");
                        dialog.setContentView(R.layout.dialog);
                        dialog.show();
                    }

            }
        });

        btnRegister=(Button) findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    // Example of a call to a native method
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.activity_main_actions,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.like_id:{
                Toast.makeText(MainActivity.this,item.getTitle().toString(),Toast.LENGTH_SHORT).show();
                return  true;
            }
            case R.id.watchlater_id:{
                Toast.makeText(this, "Binh Success", Toast.LENGTH_SHORT).show();
            }
            default:return super.onOptionsItemSelected(item);
        }
    }

    protected void onStart(){
        super.onStart();
        Log.d(TAG, "onStart: ");
    }
    
    protected void onResume(){
        super.onResume();
        Log.d(TAG, "onResume: ");
    }
    
    protected void onPause(){
        super.onPause();
        Log.d(TAG, "onPause: ");
    }
    
    protected void onStop(){
        super.onStop();
        Log.d(TAG, "onStop: ");
    }
    
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }


    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }
}
