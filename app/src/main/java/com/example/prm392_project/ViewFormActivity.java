package com.example.prm392_project;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class ViewFormActivity extends AppCompatActivity {
    WebView formviewC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_form);

        formviewC = findViewById(R.id.formview);
        formviewC.getSettings().setJavaScriptEnabled(true);
        Intent intent = getIntent();
        String link = intent.getStringExtra("linknews");
        formviewC.loadUrl(link);
        formviewC.setWebViewClient(new WebViewClient());
    }
}