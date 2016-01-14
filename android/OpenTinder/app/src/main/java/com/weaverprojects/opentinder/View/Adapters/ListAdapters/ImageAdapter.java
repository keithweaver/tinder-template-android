package com.weaverprojects.opentinder.View.Adapters.ListAdapters;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.weaverprojects.opentinder.Model.BasicProfile;
import com.weaverprojects.opentinder.Model.Image;
import com.weaverprojects.opentinder.R;

import java.util.ArrayList;

/**
 * Created by Keith on 2016-01-13.
 */
public class ImageAdapter extends ArrayAdapter<Image> {
    Context context;
    int layoutResourceId;
    ArrayList<Image> data = new ArrayList<Image>();

    public ImageAdapter(Context context, int layoutResourceId, ArrayList<Image> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }
    public View getView(final int position, View convertView, ViewGroup parent) {
        View row = convertView;
        UserHolder holder = null;
        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new UserHolder();

            holder.image1 = (ImageView) row.findViewById(R.id.image1);

            row.setTag(holder);
        } else {
            holder = (UserHolder) row.getTag();
        }
        Image singleImage = data.get(position);


        Picasso.with(context).load(singleImage.getUrl()).into(holder.image1);


        return row;
    }
    static class UserHolder{
        ImageView image1;
    }
}
