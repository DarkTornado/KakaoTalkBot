package com.darktornado.kakaobot;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.widget.Toast;

import java.util.HashMap;

/**
 * Created by Dark Tornado on 2018-01-17.
 */
public class KakaoTalkListener extends NotificationListenerService {

    HashMap<String, String> preChat = new HashMap<>();

    @Override
    public void onCreate(){
        super.onCreate();
        Toast.makeText(this, "카카오톡 봇이 알림에 접근하기 시작합니다.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        preChat.clear();
        Toast.makeText(this, "카카오톡 봇이 알림에 접근하는 것이 정지되었습니다.", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
        super.onNotificationPosted(sbn);
        if(!loadSetting("botOn")) return;
        if (sbn.getPackageName().equals("com.kakao.talk")) {
            try {
                Notification.WearableExtender wExt = new Notification.WearableExtender(sbn.getNotification());
                for (Notification.Action act : wExt.getActions()) {
                    if (act.getRemoteInputs() != null && act.getRemoteInputs().length > 0) {
                        if (act.title.toString().toLowerCase().contains("reply") ||
                                act.title.toString().toLowerCase().contains("답장")) {
                            Bundle data = sbn.getNotification().extras;
                            String sender = data.getString("android.title");
                            String msg = data.getString("android.text");
                            String room = data.getString(Build.VERSION.SDK_INT > 23 ? "android.summaryText" : "android.subText");
                            boolean isGroupChat = room != null;
                            if (room == null) room = sender;
                            chatHook(sender, msg.trim(), room, isGroupChat, act);
                        }
                    }
                }
            }catch(Exception e){
                toast(e.toString()+"\nAt:"+e.getStackTrace()[0].getLineNumber());
            }
        }
    }


    private void chatHook(String sender, String msg, String room, boolean isGroupChat, Notification.Action session) {
        //toast("sender: " + sender + "\nmsg: " + msg + "\nroom: " + room + "\nisGroupChat: " + isGroupChat);
        try {
            String chat = preChat.get(room);
            if(chat!=null&&chat.equals(msg)) return;
            preChat.put(room, msg);
            String cache = KakaoBot.readData("botData");
            if (cache == null) return;
            String[] data = cache.split("\n");
            for (int n = 0; n < data.length; n++) {
                //질문::::대답:::대답:::대답:::방확인::::방이름::::포함인지::::방종류
                String[] c = data[n].split("::::");
                String que = c[0];
                c[1] = c[1].replaceAll("\\[\\[보낸사람\\]\\]", sender);
                c[1] = c[1].replaceAll("\\[\\[내용\\]\\]", msg);
                c[1] = c[1].replaceAll("\\[\\[방\\]\\]", room);
                String[] ans = c[1].replaceAll("\\\\n", "\n").split(":::");
                int[] mode = {Integer.valueOf(c[4]), Integer.valueOf(c[5])};
                boolean roomCheck = false;
                if (c[2].equals("true")) roomCheck = true;
                else c[3] = null;
                String _room = c[3];
                if (mode[1] == 1 && isGroupChat) continue;
                if (mode[1] == 2 && !isGroupChat) continue;
                if (roomCheck) {
                    if (room == null) continue;
                    if(room.equals("")) continue;
                    if (!_room.equals(room)) continue;
                }
                String log = "[" + sender + "] " + msg;
                boolean isReplied = false;
                switch (mode[0]) {
                    case 0:
                        if (msg.equals(que)) {
                            for (int m = 0; m < ans.length; m++) {
                                reply(session, ans[m]);
                                log += "\n[봇] " + ans[m];
                                isReplied = true;
                            }
                        }
                        break;
                    case 1:
                        if (msg.contains(que)) {
                            for (int m = 0; m < ans.length; m++) {
                                reply(session, ans[m]);
                                log += "\n[봇] " + ans[m];
                                isReplied = true;
                            }
                        }
                        break;
                }
                if (isReplied) {
                    if (loadSetting("toast")) toast("<자동응답 실행됨>\n" + log);
                    if (loadSetting("makeLog")) {
                        String log2 = KakaoBot.readData("log");
                        if (log2 == null) KakaoBot.saveData("log", log);
                        else KakaoBot.saveData("log", log2 + "\n\n" + log);
                    }
                }
            }
        }catch (Exception e){
            toast(e.toString());
        }
    }

    private boolean loadSetting(String setting){
        String cache = KakaoBot.readData(setting);
        if(cache==null) return false;
        else return cache.equals("true");
    }

    private void toast(String value){
        Intent intent = new Intent(this, MainService.class);
        intent.putExtra("toast", value);
        startService(intent);
    }

    private void reply(Notification.Action session, String value){
        Intent sendIntent = new Intent();
        Bundle msg = new Bundle();
        for (RemoteInput inputable : session.getRemoteInputs()) msg.putCharSequence(inputable.getResultKey(), value);
        RemoteInput.addResultsToIntent(session.getRemoteInputs(), sendIntent, msg);

        try {
            session.actionIntent.send(this, 0, sendIntent);
        } catch (PendingIntent.CanceledException e) {

        }
    }

}
