package com.weaverprojects.opentinder.View.Windows;

import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.weaverprojects.opentinder.Controller.Image.BlurTransform;
import com.weaverprojects.opentinder.Controller.Image.CircleTransform;
import com.weaverprojects.opentinder.R;

/**
 * Created by Keith on 2015-10-03.
 */
public class ProfileActivity extends Activity {
    String markerZuckyImg = "http://a4.files.biography.com/image/upload/c_fill,cs_srgb,dpr_1.0,g_face,h_300,q_80,w_300/MTIwNjA4NjMzNjg3ODAzNDA0.jpg";
    String coverImg = "https://lh3.googleusercontent.com/IQoInMEsZsucHLfyq5OVthg4E1LXER8xjoyxrEBfZYh20y1rcdLyV5K7qPxoWg0eqPG6=s926-fcrop64=1,1fff1fc4df94e03a";
    ImageView profileImageView;
    ImageView coverImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profileImageView = (ImageView) findViewById(R.id.profileImageView);
        coverImageView = (ImageView) findViewById(R.id.coverImageView);

        Picasso.with(this).load(markerZuckyImg).transform(new CircleTransform()).into(profileImageView);
        //coverImageView
        Picasso.with(this).load(coverImg).transform(new BlurTransform(this)).into(coverImageView);
    }
    @Override
    protected void onPause(){
        super.onPause();
    }
    @Override
    protected void onResume(){
        super.onResume();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
    }
}