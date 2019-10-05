package com.ko.practicalexam2quintojustinramille;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main2Activity extends AppCompatActivity {
    EditText edit;
    EditText edit2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("CONFIRMATION");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        edit = findViewById(R.id.editText2);
        edit2 = findViewById(R.id.editText3);

        FileInputStream reader = null;
        FileInputStream reader2 = null;
        String[] events = new String[8];
        String comment = "";
        String str = "";

        try {
            reader = openFileInput("data1.txt");
            reader2 = openFileInput("data2.txt");
            int token, token2;

            while((token = reader.read()) != -1) {
                str += (char)token;
            }
            while((token2 = reader2.read()) != -1) {
                comment += (char)token2;
            }
            //System.out.println(str + "search this");
            events = str.split(",");

            for(int i = 0; i < events.length; i++) {
                //System.out.println(events[i]);
                edit.append(events[i] + "\n");
            }
            edit2.setText(comment);
        } catch(FileNotFoundException ex) {
            Log.d("error", "file not found...");
        } catch(IOException ex) {
            Log.d("error", "io error found...");
        }
    }

    public void sendData(View v) {
        setTitle("SUMMARY");
        Toast.makeText(this, "registration sent...", Toast.LENGTH_LONG).show();
    }

    public void previousPage(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
