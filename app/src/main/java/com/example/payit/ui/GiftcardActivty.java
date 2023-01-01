package com.example.payit.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.VideoView;

import com.example.payit.R;

public class GiftcardActivty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giftcard_activty);


//        VideoView videoView = (VideoView) findViewById(R.id.gift_vid);
//        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.giftscard);
//        videoView.start();
            // Find the WebView by its unique ID
            WebView webView = findViewById(R.id.web_gft);

            // loading http://www.google.com url in the WebView.
            webView.loadUrl("https://play.google.com/about/play-pass/");
            //https://appopener.com/web/z8cb36gs8

            // this will enable the javascript.
            webView.getSettings().setJavaScriptEnabled(true);

            // WebViewClient allows you to handle
            // onPageFinished and override Url loading.
            webView.setWebViewClient(new WebViewClient());
        }
    }
