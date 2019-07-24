package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    String tag ="Lifecycle Step";
    ProgressDialog progressDialog;
    int request_Code = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        Log.d(tag, "In the onCreate() event");
    }

    public void onStart(){
        super.onStart();
/**
        progressDialog = ProgressDialog.show(this, "Please Wait", "Processing...", true);
        CountDownTimer timer = new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                progressDialog.dismiss();
            }
        }.start();
*/
        Log.d(tag, "In the onStart() event");
    }

    public void onRestart() {
        super.onRestart();
        Log.d(tag, "In the onRestart() event");
    }

    public void onResume() {
        super.onResume();
        Log.d(tag, "In the OnResume() event");
    }

    public void onPause() {
        super.onPause();
        Log.d(tag, "In the onPause() event");
    }

    public void onStop() {
        super.onStop();
        Log.d(tag, "In the onStop() event");
    }

    public void onDestroy() {
        super.onDestroy();
        Log.d(tag, "In the onDestroy() event");
    }

    public void sendMessage(View view) {
        //Intent intent = new Intent(this, DialogActivity.class);
        //Intent intent = new Intent(this, DisplayMessageActivity.class);
        //EditText editText = (EditText) findViewById(R.id.editText);
        //String message = editText.getText().toString();
        //intent.putExtra(EXTRA_MESSAGE,message);
        //startActivity(intent);

        Intent i = new Intent("com.example.myfirstapp.SecondActivity");
        //Intent i = new Intent(this, SecondActivity.class);
        i.putExtra("str1", "This is a tring");
        i.putExtra("age1", 25);
        Bundle extras = new Bundle();
        extras.putString("str2", "This is another string");
        extras.putInt("age2", 35);
        i.putExtras(extras);

        //Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.amazon.com"));
        startActivityForResult(i, request_Code);
        //startActivity(i);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == request_Code) {
            if (resultCode == RESULT_OK) {
                //Toast.makeText(this,data.getData().toString(), Toast.LENGTH_SHORT).show();
                Toast.makeText(this, Integer.toString(data.getIntExtra("age3",0)),Toast.LENGTH_SHORT).show();
                Toast.makeText(this,data.getData().toString(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
