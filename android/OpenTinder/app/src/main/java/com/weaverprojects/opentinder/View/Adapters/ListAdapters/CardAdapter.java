package com.weaverprojects.opentinder.View.Adapters.ListAdapters;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.weaverprojects.opentinder.Model.BasicProfile;
import com.weaverprojects.opentinder.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by keithweaver on 16-01-08.
 */
public class CardAdapter extends ArrayAdapter<BasicProfile> {
    Context context;
    int layoutResourceId;
    ArrayList<BasicProfile> data = new ArrayList<BasicProfile>();

    public CardAdapter(Context context, int layoutResourceId, ArrayList<BasicProfile> data) {
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

            holder.cardId = (CardView) row.findViewById(R.id.cardId);
            holder.profileImageView = (ImageView) row.findViewById(R.id.profileImageView);
            holder.nameTextView = (TextView) row.findViewById(R.id.nameTextView);
            holder.ageTextView = (TextView) row.findViewById(R.id.ageTextView);


            row.setTag(holder);
        } else {
            holder = (UserHolder) row.getTag();
        }
        BasicProfile singleProfile = data.get(position);

        Picasso.with(context).load(singleProfile.getImageURL()).into(holder.profileImageView);

        holder.nameTextView.setText(singleProfile.getFirstName() + " " + singleProfile.getLastName());
        holder.ageTextView.setText(String.valueOf(singleProfile.getAge()));

        //Picasso.with(context).load("file:///android_asset/DvpvklR.png").into(imageView2);


        return row;
    }
    static class UserHolder{
        CardView cardId;
        ImageView profileImageView;
        TextView nameTextView;
        TextView ageTextView;
    }
}
