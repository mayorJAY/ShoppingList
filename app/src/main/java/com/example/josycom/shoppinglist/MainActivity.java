package com.example.josycom.shoppinglist;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final int TEXT_REQUEST = 1;
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        textView5 = findViewById(R.id.textView5);

        //Checks if the last state was saved before reconfiguration and displays the content of the saved state on the TextViews
        if (savedInstanceState != null){
            boolean isNotEmpty  = savedInstanceState.getBoolean("not_empty");
            if (isNotEmpty){
                textView1.setText(savedInstanceState.getString("list_item1"));
                textView2.setText(savedInstanceState.getString("list_item2"));
                textView3.setText(savedInstanceState.getString("list_item3"));
                textView4.setText(savedInstanceState.getString("list_item4"));
                textView5.setText(savedInstanceState.getString("list_item5"));
            }
        }
    }

    //Second activity
    public void launchSecondActivity(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST){
            if (resultCode == RESULT_OK){
                assert data != null;
                //Populates the TextViews by checking for an empty slot 1st and then sets the text to it
                String reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);
                if (textView1.getText().toString().isEmpty()){
                    textView1.setText(reply);
                } else if (!textView1.getText().toString().isEmpty() && textView2.getText().toString().isEmpty()){
                    textView2.setText(reply);
                } else if (!textView2.getText().toString().isEmpty() && textView3.getText().toString().isEmpty()){
                    textView3.setText(reply);
                } else if (!textView3.getText().toString().isEmpty() && textView4.getText().toString().isEmpty()){
                    textView4.setText(reply);
                } else if (!textView4.getText().toString().isEmpty() && textView5.getText().toString().isEmpty()){
                    textView5.setText(reply);
                }
                Log.d(LOG_TAG, "Get result");
            }
        }
    }

    //Checks if there is any content in the current state and saves it before reconfiguration
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (!textView1.getText().toString().isEmpty()){
            outState.putBoolean("not_empty", true);
            outState.putString("list_item1", textView1.getText().toString());
        }
        if (!textView2.getText().toString().isEmpty()){
            outState.putBoolean("not_empty", true);
            outState.putString("list_item2", textView2.getText().toString());
        }
        if (!textView3.getText().toString().isEmpty()){
            outState.putBoolean("not_empty", true);
            outState.putString("list_item3", textView3.getText().toString());
        }
        if (!textView4.getText().toString().isEmpty()){
            outState.putBoolean("not_empty", true);
            outState.putString("list_item4", textView4.getText().toString());
        }
        if (!textView5.getText().toString().isEmpty()){
            outState.putBoolean("not_empty", true);
            outState.putString("list_item5", textView5.getText().toString());
        }
    }
}
