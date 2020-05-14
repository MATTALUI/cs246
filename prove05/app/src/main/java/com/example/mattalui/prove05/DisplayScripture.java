package com.example.mattalui.prove05;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DisplayScripture extends AppCompatActivity {
    TextView displayText;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_scripture);

        Intent intent = getIntent();
        String scripture = intent.getStringExtra("com.example.mattalui.prove05.SCRIPTURE");

        displayText = (TextView)findViewById(R.id.scriptureDisplay);
        displayText.setText(scripture);
    }
}
