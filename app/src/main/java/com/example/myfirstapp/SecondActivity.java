package com.example.myfirstapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Toast.makeText(this, getIntent().getStringExtra("str1"), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, Integer.toString(getIntent().getIntExtra("age1",0)),Toast.LENGTH_SHORT).show();
        Bundle bundle = getIntent().getExtras();
        Toast.makeText(this, bundle.getString("str2"), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, Integer.toString(bundle.getInt("age2")), Toast.LENGTH_SHORT).show();
    }

    public void onClick(View view){
        Intent i = new Intent();
        i.putExtra("age3", 45);
        i.setData(Uri.parse("Something passed back to main activity"));
        setResult(RESULT_OK,i);
        finish();
    }

}
