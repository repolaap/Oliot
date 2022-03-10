package com.example.t3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView text;
    EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.textView);
        input = findViewById(R.id.textInput);
        text.setText("Terve maailma!");
    }
    public void onButtonClick (View view) {
        String newText = input.getText().toString();
        text.setText(newText);
        input.setText("");
    }

}