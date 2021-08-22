package com.example.sharedpreferencesactivitylevel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txvName, txvMajor, txvId;
    EditText etName, etMajor, etId;
    Switch pageColorSwitch;
    LinearLayout pageLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pageColorSwitch = findViewById(R.id.pageColorSwitch);
        pageLayout = findViewById(R.id.pageLayout);


        etName = findViewById(R.id.etName);
        etId = findViewById(R.id.etId);
        etMajor = findViewById(R.id.etMajor);

        txvId = findViewById(R.id.txvID);
        txvName = findViewById(R.id.txvName);
        txvMajor = findViewById(R.id.txvMajor);

        pageColorSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setPageColor(isChecked);
            }
        });

        SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);
        boolean isChecked = sharedPreferences.getBoolean("yellow",false);
        pageColorSwitch.setChecked(isChecked);
    }

    private void setPageColor(boolean isChecked) {
        SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("yellow",isChecked);

        editor.apply();
        pageLayout.setBackgroundColor(isChecked? Color.YELLOW : Color.WHITE);
    }


    public void saveData(View view) {
        //SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);

        SharedPreferences sharedPreferences = getSharedPreferences("my_pref_file",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("name",etName.getText().toString());
        editor.putString("id",etId.getText().toString());
        editor.putString("major",etMajor.getText().toString());

        editor.apply();
        //editor.commit();
    }

    public void loadData(View view) {
        //SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);

        SharedPreferences sharedPreferences = getSharedPreferences("my_pref_file",Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("name","Name is not available!");
        String major = sharedPreferences.getString("major","Major is not available!");
        String id = sharedPreferences.getString("id","Student Id is not available!");

        txvName.setText(name);
        txvMajor.setText(major);
        txvId.setText(id);
    }

    public void openSecondActivity(View view) {
        Intent intent = new Intent(this,SecondActivity.class);
        startActivity(intent);
    }
}