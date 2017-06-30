package com.binhnq.mysecondapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

/**
 * Created by Administrator on 25/06/2017.
 */

public class RegisterActivity extends AppCompatActivity {
    private CheckBox cbSale, cbCoder,cbOther;
    private RadioButton rdMale, rdFemale;
    private TextView tvUsername, tvPassword;
    private ImageButton imbDone;
    private ToggleButton btnTog;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initComponent();
        imbDone.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String text="";
                if (rdMale.isChecked())
                    text=text+rdMale.getText();
                else text=text+rdFemale.getText();
                text=text + " ";
                if (cbCoder.isChecked()) text=text+cbCoder.getText();
                if (cbSale.isChecked()) text=text+cbSale.getText();
                if (cbOther.isChecked()) text=text+cbOther.getText();
                text=text + " " + tvUsername.getText();
                Toast.makeText(RegisterActivity.this, text, Toast.LENGTH_LONG).show();
            }
        })  ;
        btnTog.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(RegisterActivity.this, "Is Checked",Toast.LENGTH_LONG).show();
                } else{
                    Toast.makeText(RegisterActivity.this, "Not Checked",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void initComponent(){
        cbSale = (CheckBox) findViewById(R.id.cbSale);
        cbCoder = (CheckBox) findViewById(R.id.cbCoder);
        cbOther = (CheckBox) findViewById(R.id.cbOther);

        rdMale = (RadioButton) findViewById(R.id.rdMale);
        rdFemale = (RadioButton) findViewById(R.id.rdFemale);

        tvUsername = (TextView) findViewById(R.id.edtUser);
        tvPassword = (TextView) findViewById(R.id.edtPass);

        imbDone = (ImageButton) findViewById(R.id.imgButton);
        btnTog = (ToggleButton) findViewById(R.id.btnTog);
    }
}
