package com.weaverprojects.opentinder.View.Adapters.ListAdapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.weaverprojects.opentinder.Controller.C;
import com.weaverprojects.opentinder.Controller.Image.CircleTransform;
import com.weaverprojects.opentinder.Model.BasicProfile;
import com.weaverprojects.opentinder.Model.Chat;
import com.weaverprojects.opentinder.R;
import com.weaverprojects.opentinder.View.Windows.ChatActivity;

import java.util.ArrayList;

/**
 * Created by Keith on 2016-01-12.
 */
public class ChatsAdapter extends ArrayAdapter<Chat> {
    Context context;
    int layoutResourceId;
    ArrayList<Chat> data = new ArrayList<Chat>();

    public ChatsAdapter(Context context, int layoutResourceId, ArrayList<Chat> data) {
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

            holder.chatWrapper = (LinearLayout) row.findViewById(R.id.chatWrapper);
            holder.profileImageView = (ImageView) row.findViewById(R.id.profileImageView);
            holder.nameTextView = (TextView) row.findViewById(R.id.nameTextView);
            holder.messageTextView  = (TextView) row.findViewById(R.id.messageTextView);

            row.setTag(holder);
        } else {
            holder = (UserHolder) row.getTag();
        }
        final Chat singleChat = data.get(position);

        holder.nameTextView.setText(singleChat.getFirstName());
        String lastMessage = singleChat.getMessages().get(singleChat.getMessages().size()-1).getMessage();
        holder.messageTextView.setText(lastMessage);

        if(singleChat.getImageURL() != null) {
            Picasso.with(context).load(singleChat.getImageURL()).transform(new CircleTransform()).into(holder.profileImageView);
        }

        holder.chatWrapper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openChatActivity = new Intent(context, ChatActivity.class);
                openChatActivity.putExtra(C.extra.CHAT_OBJ, singleChat);
                context.startActivity(openChatActivity);
            }
        });

        return row;
    }
    static class UserHolder{
        LinearLayout chatWrapper;
        ImageView profileImageView;
        TextView nameTextView;
        TextView messageTextView;
    }
}
