package com.example.t5v2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    EditText fileName;
    EditText text;
    TextView display;
    Context context = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;
        fileName = findViewById(R.id.fileName);
        display = findViewById(R.id.textOutput);
        text = findViewById(R.id.inputText);
    }

    public void readFile(View view) {
        try {
            InputStream in = context.openFileInput(fileName.getText().toString());
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String s = "";
            while ((s = br.readLine()) != null) {
                display.setText(s);
            }
            in.close();
        } catch (IOException e) {
            Log.e("IOException", "Input error");
        }
    }

    public void writeFile(View view) {
        try {
            OutputStreamWriter out = new OutputStreamWriter(context.openFileOutput(fileName.getText().toString(), Context.MODE_PRIVATE));
            String s = text.getText().toString();
            out.write(s);
            out.close();
            fileName.setText("");
            text.setText("");
        } catch (IOException e) {
            Log.e("IOException", "Input error");
        }
    }
}