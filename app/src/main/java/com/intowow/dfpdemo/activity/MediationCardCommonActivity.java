package com.intowow.dfpdemo.activity;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.intowow.dfpdemo.R;


public class MediationCardCommonActivity extends Activity implements AppEventListener {

    private static final String TAG = MediationCardCommonActivity.class.getSimpleName();

    private static final String AD_UNIT_ID = "/57931037/test_intowow_card";

    private PublisherAdView mAdView = null;

    // UI
    private Button mLoadAdBtn = null;
    private RelativeLayout mAdViewLayout = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setContentView(R.layout.activity_mediation_common);

        setupUI();
    }

    @Override
    protected void onDestroy() {
        if (mAdView != null) {
            mAdViewLayout.removeAllViews();
            mAdView.setAdListener(null);
            mAdView.destroy();
        }
        super.onDestroy();
    }

    private void setupUI() {
        mAdViewLayout = (RelativeLayout) findViewById(R.id.adView);

        mLoadAdBtn = (Button) findViewById(R.id.loadAd);
        mLoadAdBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                loadAd();
            }
        });
    }

    private void loadAd() {
        if (mAdView != null) {
            mAdViewLayout.removeView(mAdView);
            mAdView.destroy();
            mAdView = null;
        }
        mAdView = new PublisherAdView(this);
        mAdView.setAdUnitId(AD_UNIT_ID);
        // You can customize your ad size
        mAdView.setAdSizes(AdSize.MEDIUM_RECTANGLE);
        mAdView.setAdListener(new AdListener() {

            @Override
            public void onAdLoaded() {
                Log.d(TAG, "Card ad loaded");
                mAdViewLayout.addView(mAdView);
            }

            @Override
            public void onAdClosed() {
                Log.d(TAG, "Card ad closed");
            }

            @Override
            public void onAdFailedToLoad(int var1) {
                Log.d(TAG, "Card ad failed to load");
            }

            @Override
            public void onAdLeftApplication() {
                Log.d(TAG, "Card ad left application");
            }

            @Override
            public void onAdOpened() {
                Log.d(TAG, "Card ad opened");
            }

            @Override
            public void onAdClicked() {
                Log.d(TAG, "Card ad clicked");
            }

            @Override
            public void onAdImpression() {
                Log.d(TAG, "Card ad impression");
            }

        });
        mAdView.setAppEventListener(this);
        mAdView.loadAd(new PublisherAdRequest.Builder().build());
    }

    @Override
    public void onAppEvent(String name, String info) {
        Log.d(TAG, "On app event - name: " + name + " into: " + info);
    }
}
