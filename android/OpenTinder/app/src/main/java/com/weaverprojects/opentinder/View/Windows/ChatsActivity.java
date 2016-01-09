package com.weaverprojects.opentinder.View.Windows;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.weaverprojects.opentinder.Model.Chat;
import com.weaverprojects.opentinder.R;

import java.util.ArrayList;

/**
 * Created by keithweaver on 16-01-08.
 */
public class ChatsActivity extends Activity {

    //UI
    ListView chatsListView;
    TextView noChatsTextView;

    ArrayList<Chat> ongoingChats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chats);

        declareUIObjects();

        ongoingChats = new ArrayList();
        
        //Load past chats

        handleXChats();




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
        chatsListView = (ListView) findViewById(R.id.chatsListView);
        noChatsTextView = (TextView) findViewById(R.id.noChatsTextView);
    }
    protected void handleXChats(){
        if(ongoingChats.size() == 0){
            chatsListView.setVisibility(View.GONE);
            noChatsTextView.setVisibility(View.VISIBLE);
        }else{
            noChatsTextView.setVisibility(View.GONE);
            chatsListView.setVisibility(View.VISIBLE);
        }
    }
}

