package com.quizapp.fittrack;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;
import androidx.activity.OnBackPressedCallback;

import com.quizapp.fittrack.R;


public class MainActivity extends AppCompatActivity {
    WebView webView;
    
    // Handle back button
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView webView = findViewById(R.id.webView); // Make sure you have this in your layout
        webView.getSettings().setJavaScriptEnabled(true);

        // Load FIRST page (index.html)
        webView.loadUrl("file:///android_asset/index.html");

        this.getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                if (webView.canGoBack()) {
                    webView.goBack();
                } else {
                    finish();
                }
   }
});
    }


}