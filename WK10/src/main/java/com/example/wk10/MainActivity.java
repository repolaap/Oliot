package com.example.wk10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    WebView web;
    EditText urlText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        web = findViewById(R.id.webView);
        web.setWebViewClient(new WebViewClient());
        web.getSettings().setJavaScriptEnabled(true);

        urlText = findViewById(R.id.webAddressText);

    }

    public void getUrl(View view) {
        if (urlText.getText().toString().equals("index.html")) {
            web.loadUrl("file:///android_asset/index.html");
            urlText.setText("");
        } else {
            String url = "http://" + urlText.getText().toString();
            web.loadUrl(url);
            urlText.setText("");
        }
    }

    public void refreshPage(View view) {
        web.loadUrl(web.getUrl().toString());
    }

    public void executeJS1(View view) {
        web.evaluateJavascript("javascript:shoutOut()", null);
        urlText.setText("");
    }

    public void executeJS2(View view) {
        web.evaluateJavascript("javascript:initialize()", null);
        urlText.setText("");
    }
}
