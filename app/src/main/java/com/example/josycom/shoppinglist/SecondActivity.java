package com.example.josycom.shoppinglist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

public class SecondActivity extends AppCompatActivity {
    public static final String EXTRA_REPLY = "com.example.josycom.shoppinglist.extra.REPLY";
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
    }

    //Displays the appropriate selected content when the button is clicked
    public void returnList(View view) {
        Intent replyIntent = new Intent();
        switch (view.getId()){
            case R.id.button1:
                String reply1 = button1.getText().toString();
                replyIntent.putExtra(EXTRA_REPLY, reply1);
                setResult(RESULT_OK, replyIntent);
                finish();
                break;
            case R.id.button2:
                String reply2 = button2.getText().toString();
                replyIntent.putExtra(EXTRA_REPLY, reply2);
                setResult(RESULT_OK, replyIntent);
                finish();
                break;
            case R.id.button3:
                String reply3 = button3.getText().toString();
                replyIntent.putExtra(EXTRA_REPLY, reply3);
                setResult(RESULT_OK, replyIntent);
                finish();
                break;
            case R.id.button4:
                String reply4 = button4.getText().toString();
                replyIntent.putExtra(EXTRA_REPLY, reply4);
                setResult(RESULT_OK, replyIntent);
                finish();
                break;
            case R.id.button5:
                String reply5 = button5.getText().toString();
                replyIntent.putExtra(EXTRA_REPLY, reply5);
                setResult(RESULT_OK, replyIntent);
                finish();
                break;
        }
    }
}
