package com.example.vendingmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView displayText;
    SeekBar scale;
    TextView moneyDisplay;

    BottleDispenser bd = BottleDispenser.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayText = findViewById(R.id.display1);
        scale = findViewById(R.id.seekBar);
        moneyDisplay = findViewById(R.id.moneyAdded);

        scale.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                moneyDisplay.setText(Integer.toString(i));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }

    public void addMoneyClick(View view) {
        int money = Integer.valueOf(String.valueOf(moneyDisplay.getText()));
        displayText.setText(bd.addMoney(money));
        scale.setProgress(0);
    }

    public void returnMoneyClick(View view) {
        displayText.setText(bd.returnMoney());
    }

    public void buyBottleClick(View view) {
        if (view.getId() == R.id.button1) {
            displayText.setText(bd.buyBottle(1));
        }
        if (view.getId() == R.id.button2) {
            displayText.setText(bd.buyBottle(2));
        }
        if (view.getId() == R.id.button3) {
            displayText.setText(bd.buyBottle(3));
        }
        if (view.getId() == R.id.button4) {
            displayText.setText(bd.buyBottle(4));
        }
        if (view.getId() == R.id.button5) {
            displayText.setText(bd.buyBottle(5));
        }
    }
}