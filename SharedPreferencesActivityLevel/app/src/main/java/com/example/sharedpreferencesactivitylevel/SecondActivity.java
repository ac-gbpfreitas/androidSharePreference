package com.example.sharedpreferencesactivitylevel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView txvId, txvMajor, txvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txvId = findViewById(R.id.txvID);
        txvMajor = findViewById(R.id.txvMajor);
        txvName = findViewById(R.id.txvName);
    }

    public void loadData(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("my_pref_file", Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("name","Name is not available!");
        String major = sharedPreferences.getString("major","Major is not available!");
        String id = sharedPreferences.getString("id","Student Id is not available!");

        txvName.setText(name);
        txvMajor.setText(major);
        txvId.setText(id);
    }
    public void clearData(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("my_pref_file",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();

    }
    public void removeStudentMajor(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("my_pref_file",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.remove("major");
        editor.apply();
    }
}