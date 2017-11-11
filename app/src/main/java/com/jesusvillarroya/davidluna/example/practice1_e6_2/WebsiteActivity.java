package com.jesusvillarroya.davidluna.example.practice1_e6_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

public class WebsiteActivity extends AppCompatActivity {

    private WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_website);

        Bundle bundle = getIntent().getExtras();
        String url = bundle.getString("url");

        wv = (WebView)findViewById(R.id.wv1);
        wv.loadUrl("http://" + url);

    }



    public void finishView(View view){
        finish();
    }
}
