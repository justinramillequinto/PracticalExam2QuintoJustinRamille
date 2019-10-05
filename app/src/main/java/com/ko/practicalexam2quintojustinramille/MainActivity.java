package com.ko.practicalexam2quintojustinramille;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    CheckBox[] checkBoxes = new CheckBox[8];
    EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FileInputStream reader = null;
        String events[] = new String[checkBoxes.length];
        String str = " ";

        checkBoxes[0] = findViewById(R.id.checkBox5);
        checkBoxes[1] = findViewById(R.id.checkBox6);
        checkBoxes[2] = findViewById(R.id.checkBox7);
        checkBoxes[3] = findViewById(R.id.checkBox8);
        checkBoxes[4] = findViewById(R.id.checkBox9);
        checkBoxes[5] = findViewById(R.id.checkBox10);
        checkBoxes[6] = findViewById(R.id.checkBox11);
        checkBoxes[7] = findViewById(R.id.checkBox12);

        edit = findViewById(R.id.editText);
    }

    public void writeDate(View v) {
        String data = "";
        String comment = edit.getText().toString();
        for(int i = 0; i < checkBoxes.length; i++) {
            if(checkBoxes[i].isChecked()) {
                data += checkBoxes[i].getText().toString() + ",";
            }
        }

        FileOutputStream writer = null;
        FileOutputStream writer2 = null;
        try {
            writer = openFileOutput("data1.txt", MODE_PRIVATE);
            writer.write(data.getBytes());

            writer2 = openFileOutput("data2.txt", MODE_PRIVATE);
            writer2.write(comment.getBytes());
        } catch (FileNotFoundException ex) {
            Log.d("error", "File not found...");
        } catch (IOException ex) {
            Log.d("error", "IOError found...");
        } finally {
            try {
                writer.close();
                writer2.close();
            } catch (IOException ex) {
                Log.d("error", "File not found...");
            }
        }
        Toast.makeText(this, "Data saved...", Toast.LENGTH_LONG).show();
    }

    public void nextPage(View v) {
        Intent i = new Intent(this, Main2Activity.class);
        startActivity(i);
    }
}
