package com.example.webtoandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.graphics.Bitmap;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private WebView mywebView;
    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        swipeRefreshLayout = findViewById(R.id.swipelayout);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mywebView=(WebView) findViewById(R.id.webview);
                mywebView.setWebViewClient(new WebViewClient());
                mywebView.loadUrl("https://www.google.com/");
                WebSettings webSettings=mywebView.getSettings();
                webSettings.setJavaScriptEnabled(true);

                swipeRefreshLayout.setRefreshing(false);

            }
        });

        mywebView=(WebView) findViewById(R.id.webview);
        mywebView.setWebViewClient(new WebViewClient());
        mywebView.loadUrl("https://www.google.com/");
        WebSettings webSettings=mywebView.getSettings();
        webSettings.setJavaScriptEnabled(true);


    }

    public class mywebClient extends WebViewClient{
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon){
            super.onPageStarted(view,url,favicon);
        }
        @Override
        public boolean shouldOverrideUrlLoading(WebView view,String url){
            view.loadUrl(url);
            return true;
        }
    }
    @Override
    public void onBackPressed(){
        if(mywebView.canGoBack()) {
            mywebView.goBack();
        }
        else{
            super.onBackPressed();
        }
    }
}