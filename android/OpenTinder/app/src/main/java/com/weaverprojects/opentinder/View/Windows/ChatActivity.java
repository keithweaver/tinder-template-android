package com.weaverprojects.opentinder.View.Windows;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.weaverprojects.opentinder.Controller.C;
import com.weaverprojects.opentinder.Model.Chat;
import com.weaverprojects.opentinder.R;
import com.weaverprojects.opentinder.View.Adapters.ListAdapters.MessageAdapter;

/**
 * Created by Keith on 2015-10-03.
 */
public class ChatActivity extends Activity {
    ListView chatListView;
    MessageAdapter mMessageAdapter;

    Chat currentChat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        declareUIObjects();

        Intent i = getIntent();
        currentChat = (Chat) i.getSerializableExtra(C.extra.CHAT_OBJ);

        chatListView = (ListView) findViewById(R.id.chatListView);
        mMessageAdapter = new MessageAdapter(this, R.layout.single_message, currentChat.getMessages(), currentChat.getUserId());
        chatListView.setAdapter(mMessageAdapter);

        scrollMyListViewToBottom();
    }
    private void scrollMyListViewToBottom() {
        chatListView.post(new Runnable() {
            @Override
            public void run() {
                // Select the last row so it will scroll into view...
                chatListView.setSelection(mMessageAdapter.getCount() - 1);
            }
        });
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
        chatListView = (ListView) findViewById(R.id.chatListView);
    }
}
