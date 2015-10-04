package com.weaverprojects.opentinder.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

import com.weaverprojects.opentinder.R;
import com.weaverprojects.opentinder.View.Windows.HomeActivity;

public class SplashActivity extends Activity {
    public static final String TAG = "OpenTinder_SA_";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);
        Log.v(TAG, "Starting...");

        Intent openHomeWindow = new Intent(this, HomeActivity.class);
        startActivity(openHomeWindow);
    }
}
