package com.wizzpass.phaseonechallenge;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.Gravity;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class AboutALCActivity extends AppCompatActivity {

    private WebView webView;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_alc);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AboutALCActivity.this, MainActivity.class));
                finish();
            }
        });

        webView = findViewById(R.id.webview);
        progressDialog = new ProgressDialog(AboutALCActivity.this);
        progressDialog.setMessage("Please wait Loading...");
        progressDialog.show();
        webView.setWebViewClient(new SSLWebViewClient());
        webView.loadUrl("https://andela.com/alc/");
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);

    }

        @Override
        protected void onDestroy() {
            super.onDestroy();
            progressDialog.dismiss();
        }


    private class SSLWebViewClient extends WebViewClient{

        @Override
        public  void onReceivedSslError(WebView webView, SslErrorHandler handler, SslError error){
            handler.proceed();
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            System.out.println("on finish");
            if (progressDialog.isShowing()) {
                progressDialog.dismiss();
            }

        }

    }


}



