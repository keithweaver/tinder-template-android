package com.weaverprojects.opentinder.View.Adapters.ListAdapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.weaverprojects.opentinder.Model.Message;
import com.weaverprojects.opentinder.R;

import java.util.ArrayList;

/**
 * Created by Keith on 2016-01-12.
 */
public class MessageAdapter extends ArrayAdapter<Message> {
    Context context;
    int layoutResourceId;
    ArrayList<Message> data = new ArrayList<>();
    String currentUserId;

    public MessageAdapter(Context context, int layoutResourceId, ArrayList<Message> data, String currentUserId){
        super(context, layoutResourceId, data);
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.data = data;
        this.currentUserId = currentUserId;
    }
    public View getView(final int position, View row, ViewGroup parent){
        MessageHolder mHolder = null;
        if(row == null){
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            mHolder = new MessageHolder();
            mHolder.messageMasterWrapper = (LinearLayout) row.findViewById(R.id.messageMasterWrapper);
            mHolder.messageWrapper = (LinearLayout) row.findViewById(R.id.messageWrapper);
            mHolder.messageText = (TextView) row.findViewById(R.id.messageText);

            row.setTag(mHolder);
        }else{
            mHolder = (MessageHolder) row.getTag();
        }

        Message singleMessage = data.get(position);

        if(singleMessage.getSentBy().equals(currentUserId)) {
            mHolder.messageMasterWrapper.setGravity(Gravity.RIGHT);
            mHolder.messageWrapper.setBackgroundColor(Color.parseColor("#FFD5EEFF"));
        }else{
            mHolder.messageMasterWrapper.setGravity(Gravity.LEFT);
            mHolder.messageWrapper.setBackgroundColor(Color.parseColor("#FFBAFFA8"));
        }
        mHolder.messageText.setText(singleMessage.getMessage());

        return row;
    }
    static class MessageHolder{
        LinearLayout messageMasterWrapper;
        LinearLayout messageWrapper;
        TextView messageText;
    }
}