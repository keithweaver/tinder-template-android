package com.weaverprojects.opentinder.Controller.Testing;

import android.util.Log;

import com.weaverprojects.opentinder.Model.Chat;
import com.weaverprojects.opentinder.Model.Message;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Keith on 2016-01-12.
 */
public class Testing_Chat {
    public static final String TAG = "OpenTinder_TC_";
    public static final String markerZuckyImg = "http://a4.files.biography.com/image/upload/c_fill,cs_srgb,dpr_1.0,g_face,h_300,q_80,w_300/MTIwNjA4NjMzNjg3ODAzNDA0.jpg";

    public static ArrayList<Chat> getChats(){
        ArrayList<Chat> cList = new ArrayList<>();
        for(int i = 0;i < 10;i++){
            String firstName = "Jo" + String.valueOf(i) + "n";
            String lastName = "Smith"  + String.valueOf(i);
            String userId = "test" + String.valueOf(i);
            cList.add(new Chat("chatid" + String.valueOf(i), userId, firstName, lastName, markerZuckyImg, getMessages("kweaver", userId)));
        }
        return cList;
    }
    public static ArrayList<Message> getMessages(String currentUser, String otherUser){
        ArrayList<Message> m = new ArrayList<>();
        for(int i = 0;i < 20;i++){
            if(i % 2 == 0) {
                m.add(new Message("id" + String.valueOf(i), getTimestamp() - i, "Message " + String.valueOf(i), currentUser));
            }else{
                m.add(new Message("id" + String.valueOf(i), getTimestamp() - i, "Message " + String.valueOf(i), otherUser));
            }
        }
        return m;
    }
    public static int getTimestamp(){
        Calendar c = Calendar.getInstance();
        String s = String.valueOf(c.get(Calendar.YEAR)) + String.valueOf(c.get(Calendar.DAY_OF_YEAR)) + String.valueOf(c.get(Calendar.HOUR_OF_DAY)) + String.valueOf(c.get(Calendar.MINUTE)) + String.valueOf(c.get(Calendar.SECOND)) + String.valueOf(c.get(Calendar.MILLISECOND));
        Log.v(TAG, "[" + s + "]");
        try {
            return Integer.parseInt(s);
        }catch (Exception e){
            Log.e(TAG, e.toString());
        }
        return 0;
    }
}
