package com.example.mattalui.prove05;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class InputScripture extends AppCompatActivity {
    EditText bookInput;
    EditText chapterInput;
    EditText verseInput;
    SharedPreferences pref;
    SharedPreferences.Editor prefEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_input_scripture);

        bookInput = (EditText)findViewById(R.id.book);
        chapterInput = (EditText)findViewById(R.id.chapter);
        verseInput = (EditText)findViewById(R.id.verse);

        pref = getPreferences(Context.MODE_PRIVATE);
        prefEditor = pref.edit();

        String book = pref.getString("com.example.mattalui.prove05.STORE_BOOK", "");
        String chapter = pref.getString("com.example.mattalui.prove05.STORE_CHAPTER", "'");
        String verse = pref.getString("com.example.mattalui.prove05.STORE_VERSE", "");

        bookInput.setText(book);
        chapterInput.setText(chapter);
        verseInput.setText(verse);
    }

    private String buildScripture() {
        String book = bookInput.getText().toString();
        String chapter = chapterInput.getText().toString();
        String verse = verseInput.getText().toString();

        return book + " " + chapter + ":" + verse;
    }

    public void goAndDo(View v) {
        String scripture = buildScripture();
        Log.d("scripture","About to create intent with " + scripture);

        Intent intent = new Intent(this, DisplayScripture.class);
        intent.putExtra("com.example.mattalui.prove05.SCRIPTURE", scripture);
        startActivity(intent);
    }

    public void  saveScripture(View v) {
        String book = bookInput.getText().toString();
        String chapter = chapterInput.getText().toString();
        String verse = verseInput.getText().toString();

        prefEditor.putString("com.example.mattalui.prove05.STORE_BOOK", book);
        prefEditor.putString("com.example.mattalui.prove05.STORE_CHAPTER", chapter);
        prefEditor.putString("com.example.mattalui.prove05.STORE_VERSE", verse);
        prefEditor.commit();

        Toast toast = Toast.makeText(this, "Scripture Saved", Toast.LENGTH_LONG);
        toast.show();
    }

    public void loadScripture(View v) {
        String book = pref.getString("com.example.mattalui.prove05.STORE_BOOK", "");
        String chapter = pref.getString("com.example.mattalui.prove05.STORE_CHAPTER", "'");
        String verse = pref.getString("com.example.mattalui.prove05.STORE_VERSE", "");

        bookInput.setText(book);
        chapterInput.setText(chapter);
        verseInput.setText(verse);

        String scripture = buildScripture();

        Toast toast = Toast.makeText(this, "Loaded " + scripture, Toast.LENGTH_LONG);
        toast.show();
    }
}

