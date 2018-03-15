package com.intowow.dfpdemo;

import android.app.Activity;
import android.os.Bundle;

import com.intowow.dfpdemo.activity.MediationCardCommonActivity;
import com.intowow.dfpdemo.activity.MediationInterstitialCommonActivity;
import com.intowow.dfpdemo.common.CEMenu;
import com.intowow.dfpdemo.common.LayoutManager;

public class MainActivity extends Activity {

    private CEMenu mMenu = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMenu = new CEMenu(this, LayoutManager.getInstance(this));
        mMenu.addButton(new CEMenu.CEButton(this, "Card Ad", MediationCardCommonActivity.class));
        mMenu.addButton(new CEMenu.CEButton(this, "Interstitial Ad", MediationInterstitialCommonActivity.class));
        setContentView(mMenu);
    }
}
