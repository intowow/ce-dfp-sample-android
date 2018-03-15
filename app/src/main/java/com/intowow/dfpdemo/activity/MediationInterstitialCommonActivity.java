package com.intowow.dfpdemo.activity;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.intowow.dfpdemo.R;

public class MediationInterstitialCommonActivity extends Activity {

    private static final String TAG = MediationInterstitialCommonActivity.class.getSimpleName();

    private static final String AD_UNIT_ID = "/57931037/test_intowow_splash";

    private PublisherInterstitialAd mCustomEventInterstitial = null;

    //UI
    private Button mLoadAdBtn = null;
    private Button mShowAdBtn = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setContentView(R.layout.activity_mediation_common);

        setupUI();
    }

    private void setupUI() {
        mLoadAdBtn = (Button) findViewById(R.id.loadAd);
        mLoadAdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                loadAd();
            }
        });

        mShowAdBtn = (Button) findViewById(R.id.showAd);
        mShowAdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                if (mCustomEventInterstitial != null && mCustomEventInterstitial.isLoaded()) {
                    mCustomEventInterstitial.show();
                }
            }
        });
        mShowAdBtn.setVisibility(View.VISIBLE);
        mShowAdBtn.setEnabled(false);
    }

    private void loadAd() {
        // Sample custom event interstitial.
        mCustomEventInterstitial = new PublisherInterstitialAd(this);
        mCustomEventInterstitial.setAdUnitId(AD_UNIT_ID);
        mCustomEventInterstitial.setAdListener(new AdListener() {
            @Override
            public void onAdFailedToLoad(int errorCode) {
                Log.d(TAG, "Interstitial ad failed to loaded");
                Toast.makeText(MediationInterstitialCommonActivity.this,
                        "Error loading custom event interstitial, code " + errorCode,
                        Toast.LENGTH_SHORT).show();
                mShowAdBtn.setEnabled(false);
            }

            @Override
            public void onAdLoaded() {
                Log.d(TAG, "Interstitial ad loaded");
                Toast.makeText(MediationInterstitialCommonActivity.this,
                        "Interstitial ad loaded",
                        Toast.LENGTH_SHORT).show();
                mShowAdBtn.setEnabled(true);
            }

            @Override
            public void onAdOpened() {
                Log.d(TAG, "Interstitial ad opened");
                mShowAdBtn.setEnabled(false);
            }

            @Override
            public void onAdClosed() {
                Log.d(TAG, "Interstitial ad closed");
                mCustomEventInterstitial.loadAd(new PublisherAdRequest.Builder().build());
            }
        });
        mCustomEventInterstitial.loadAd(new PublisherAdRequest.Builder().build());
    }

}
