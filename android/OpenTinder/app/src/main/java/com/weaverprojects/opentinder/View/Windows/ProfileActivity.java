package com.weaverprojects.opentinder.View.Windows;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.weaverprojects.opentinder.Controller.Image.BlurTransform;
import com.weaverprojects.opentinder.Controller.Image.CircleTransform;
import com.weaverprojects.opentinder.R;
import com.weaverprojects.opentinder.View.Adapters.ListAdapters.ImageAdapter;

import java.util.ArrayList;

/**
 * Created by Keith on 2015-10-03.
 */
public class ProfileActivity extends Activity {
    public static final String TAG = "OpenTinder_PA_";

    String markerZuckyImg = "http://a4.files.biography.com/image/upload/c_fill,cs_srgb,dpr_1.0,g_face,h_300,q_80,w_300/MTIwNjA4NjMzNjg3ODAzNDA0.jpg";
    String coverImg = "https://lh3.googleusercontent.com/IQoInMEsZsucHLfyq5OVthg4E1LXER8xjoyxrEBfZYh20y1rcdLyV5K7qPxoWg0eqPG6=s926-fcrop64=1,1fff1fc4df94e03a";

    //UI
    ImageView profileImageView;
    ImageView coverImageView;
    TextView nameTextView;
    TextView ageTextView;
    TextView distanceTextView;
    TextView activeTextView;
    TextView aboutTextView;
    ListView photosListView;
    LinearLayout getTopWrapper;

    ImageAdapter mImageAdapter;
    ArrayList<com.weaverprojects.opentinder.Model.Image> profileImages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profileImages = new ArrayList<>();

        profileImages.add(new com.weaverprojects.opentinder.Model.Image(markerZuckyImg));
        profileImages.add(new com.weaverprojects.opentinder.Model.Image(markerZuckyImg));
        profileImages.add(new com.weaverprojects.opentinder.Model.Image(markerZuckyImg));
        profileImages.add(new com.weaverprojects.opentinder.Model.Image(markerZuckyImg));
        profileImages.add(new com.weaverprojects.opentinder.Model.Image(markerZuckyImg));
        profileImages.add(new com.weaverprojects.opentinder.Model.Image(markerZuckyImg));

        declareUIObjects();

        mImageAdapter = new ImageAdapter(this, R.layout.single_image, profileImages);
        photosListView.setAdapter(mImageAdapter);

        Picasso.with(this).load(markerZuckyImg).transform(new CircleTransform()).into(profileImageView);
        Picasso.with(this).load(coverImg).transform(new BlurTransform(this)).into(coverImageView);

        nameTextView.setText("Keith");
        ageTextView.setText(", 21");
        distanceTextView.setText("12 kilometers away");
        activeTextView.setText("Active 13 minutes ago");
        aboutTextView.setText("I like pizza");

        int topWrapperHeight = getTopWrapper.getHeight();
//        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) getTopWrapper.getLayoutParams();
//        lp.height = topWrapperHeight;
//        getTopWrapper.setLayoutParams(lp);
        setListViewHeightBasedOnChildren(photosListView);

        Log.v(TAG, "[" + String.valueOf(topWrapperHeight) + "]");

        //LinearLayout.LayoutParams lp2 = (LinearLayout.LayoutParams) photosListView.getLayoutParams();
        //photosListView.setPadding(0, topWrapperHeight, 0,0);
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
    protected void declareUIObjects(){
        profileImageView = (ImageView) findViewById(R.id.profileImageView);
        coverImageView = (ImageView) findViewById(R.id.coverImageView);
        nameTextView = (TextView) findViewById(R.id.nameTextView);
        ageTextView = (TextView) findViewById(R.id.ageTextView);
        distanceTextView = (TextView) findViewById(R.id.distanceTextView);
        activeTextView = (TextView) findViewById(R.id.activeTextView);
        aboutTextView = (TextView) findViewById(R.id.aboutTextView);
        photosListView = (ListView) findViewById(R.id.photosListView);
        getTopWrapper = (LinearLayout) findViewById(R.id.getTopWrapper);
    }
    public void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = 0;
        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.AT_MOST);
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
        listView.requestLayout();

    }
}