package com.darktornado.kakaobot;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawer = null;
    String[] data;
    ArrayList<String> names = new ArrayList<>();
    String sdcard = Environment.getExternalStorageDirectory().getAbsolutePath();


    private void initSettings() {
        new File(sdcard + "/KakaoBot/").mkdirs();
        if (KakaoBot.readData("botOn") == null) {
            KakaoBot.saveData("botOn", "false");
        }
        if (KakaoBot.readData("preventCover") == null) {
            KakaoBot.saveData("preventCover", "false");
        }
        if (KakaoBot.readData("toast") == null) {
            KakaoBot.saveData("toast", "false");
        }
        if (KakaoBot.readData("makeLog") == null) {
            KakaoBot.saveData("makeLog", "false");
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        try {
            if (drawer.isDrawerOpen(Gravity.LEFT)) {
                drawer.closeDrawer(Gravity.LEFT);
            } else {
                drawer.openDrawer(Gravity.LEFT);
            }
        } catch (Exception e) {
            toast(e.toString());
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            LinearLayout layout0 = new LinearLayout(this);
            layout0.setOrientation(1);
            Toolbar toolbar = new Toolbar(this);
            toolbar.setTitle("카카오톡 봇");
            toolbar.setTitleTextColor(Color.WHITE);
            toolbar.setBackgroundColor(Color.argb(255, 76, 175, 80));
            LinearLayout.LayoutParams margin = new LinearLayout.LayoutParams(-1, -2);
            margin.setMargins(0, 0, 0, dip2px(10));
            toolbar.setLayoutParams(margin);
            ViewCompat.setElevation(toolbar, dip2px(5));
            setSupportActionBar(toolbar);
            layout0.addView(toolbar);

            String enl = Settings.Secure.getString(getContentResolver(), "enabled_notification_listeners");
            if (((enl != null && !enl.contains(BuildConfig.APPLICATION_ID)) || enl == null)
                    ||ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
                    || ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                layout0.addView(permissionCheck());
                setContentView(layout0);
                return;
            }

            initSettings();

            LinearLayout layout = new LinearLayout(this);
            layout.setOrientation(1);
            int pad = dip2px(5);
            Switch on = new Switch(this);
            on.setText("카카오톡 봇 활성화");
            on.setTextSize(17);
            on.setTextColor(Color.BLACK);
            on.setPadding(pad, pad, pad, dip2px(15));
            on.setChecked(KakaoBot.readData("botOn").equals("true"));
            on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton swit, boolean onoff) {
                    KakaoBot.saveData("botOn", String.valueOf(onoff));
                    if (onoff) toast("카카오톡 봇이 활성화되었습니다.");
                    else toast("카카오톡 봇이 비활성화되었습니다.");
                }
            });
            layout.addView(on);

            updateData();

            final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, names);

            Button add = new Button(this);
            add.setText("추가");
            add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    editDialog(adapter);
                }
            });
            add.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    adapter.notifyDataSetChanged();
                    return true;
                }
            });
            layout.addView(add);

            ListView list = new ListView(this);
            list.setAdapter(adapter);
            list.setFastScrollEnabled(true);
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {
                    //질문::::대답:::대답:::대답:::방확인::::방이름::::포함인지::::방종류
                    String[] c = data[pos].split("::::");
                    int[] mode = {Integer.valueOf(c[4]), Integer.valueOf(c[5])};
                    boolean roomCheck = false;
                    if (c[2].equals("true")) roomCheck = true;
                    else c[3] = null;
                    //title, que, ans, room, mode, roomCheck
                    editDialog(c[0], c[0], c[1].replaceAll(":::", "[[다음채팅]]"), c[3], mode, new boolean[]{roomCheck}, adapter, pos);
                }
            });
            layout.addView(list);
            pad = dip2px(20);
            layout.setPadding(pad, pad, pad, pad);
            layout0.addView(layout);
            drawer = new DrawerLayout(this);
            drawer.addView(layout0);
            drawer.addView(createDrawerLayout());
            setContentView(drawer);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.menu_list);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    checkSomething();
                }
            }).start();
        } catch (Exception e) {
            toast(e.toString());
        }
    }

    private LinearLayout createDrawerLayout() {
        try {
            LinearLayout layout = new LinearLayout(this);
            layout.setOrientation(1);
            int pad = dip2px(10);
            TextView vers = new TextView(this);
            vers.setText("vers. " + KakaoBot.VERSION);
            vers.setTextSize(14);
            vers.setTextColor(Color.WHITE);
            vers.setBackgroundColor(Color.argb(255, 76, 175, 80));
            vers.setGravity(Gravity.RIGHT);
            vers.setPadding(pad, dip2px(5), pad, dip2px(5));
            layout.addView(vers);
            TextView title = new TextView(this);
            title.setText("카카오톡 봇");
            title.setTextSize(24);
            title.setTextColor(Color.WHITE);
            title.setBackgroundColor(Color.argb(255, 76, 175, 80));
            title.setPadding(dip2px(25), 0, pad, dip2px(6));
            layout.addView(title);
            TextView maker = new TextView(this);
            maker.setText("ⓒ 2018 Dark Tornado");
            maker.setTextSize(12);
            maker.setTextColor(Color.WHITE);
            maker.setBackgroundColor(Color.argb(255, 76, 175, 80));
            maker.setPadding(dip2px(21), 0, pad, dip2px(15));
            LinearLayout.LayoutParams margin = new LinearLayout.LayoutParams(-1, -2);
            margin.setMargins(0, 0, 0, dip2px(10));
            maker.setLayoutParams(margin);
            layout.addView(maker);
            String[] menus = {"안드로이드 웨어 설치", "알림 접근 허용", "응답할 말 모두 삭제", "카카오톡 실행", "제작자 블로그", "앱 정보 / 도움말", "환경 설정", "종료"};
            ListView list = new ListView(this);
            ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, menus);
            list.setAdapter(adapter);
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int pos, long id) {
                    switch (pos) {
                        case 0:
                            Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.wearable.app");
                            startActivity(new Intent(Intent.ACTION_VIEW, uri));
                            toast("Play 스토어로 이동합니다.");
                            break;
                        case 1:
                            Intent intent = new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS");
                            startActivity(intent);
                            toast("알림 접근 허용 창으로 이동합니다.");
                            break;
                        case 2:
                            showRemoveDialog();
                            break;
                        case 3:
                            startActivity(getPackageManager().getLaunchIntentForPackage("com.kakao.talk"));
                            toast("카카오톡을 실행합니다.");
                            break;
                        case 4:
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://blog.naver.com/dt3141592")));
                            break;
                        case 5:
                            showDialog("앱 정보 / 도움말", "앱 이름 : 카카오톡 봇\n버전 : "+KakaoBot.VERSION+"\n제작자 : Dark Tornado\n\n상단바에 카카오톡 알림이 뜨면, 사용자가 정해놓은 조건에 따라 자동으로 답장을 보내주거나, 보내지 않습니다. 추가 버튼을 누르셔서, 어떤 상항에서 뭐라고 답변할지 정하시면 됩니다.\n카카오톡 봇은 카카오톡 알림이 켜져 있고, 안드로이드 웨어가 깔려있으며, 알림 접근 권한이 허용되어 있어야 정상적으로 작동합니다.\n\n[[보낸사람]] - 보낸 사람의 이름을 인용합니다.\n[[내용]] - 수신된 채팅의 내용을 인용합니다.\n[[방]] - 채팅이 수신된 방의 이름을 인용합니다.\n[[다음채팅]] - 해당 문구를 기준으로 채팅을 두 개로 나누어서 보냅니다.");
                            break;
                        case 6:
                            openSettings();
                            break;
                        case 7:
                            finish();
                            break;
                    }
                }
            });
            layout.addView(list);
            DrawerLayout.LayoutParams params = new DrawerLayout.LayoutParams(-1, -1);
            params.gravity = Gravity.LEFT;
            layout.setLayoutParams(params);
            layout.setBackgroundColor(Color.WHITE);
            pad = dip2px(5);
            list.setPadding(pad, pad, pad, pad);
            return layout;
        } catch (Exception e) {
            toast(e.toString());
        }
        return null;
    }

    private ScrollView permissionCheck(){
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(1);
        final Activity ctx = this;
        TextView txt1 = new TextView(this);
        txt1.setText(Html.fromHtml("&nbsp;<b>내장메모리 접근 권한</b>은 앱 설정 등을 기기에 저장할 때 필요한 권한입니다. 해당 권한을 허용해주셔야, 카카오톡 봇이 정상적으로 작동합니다. 권한 악용(?)은 하지 않는데, 위험함 권한으로 분류되는 권한들이라, 몇몇 백신들은 카카오톡 봇을 바이러스로 분류할 가능성이 있습니다. 정 의심되신다면, 디컴파일해보세요?<br><br>&nbsp;참고로, 화면 오버레이 어쩌고가 뜨는 경우는 현재 실행중인 앱들 중 하나가 이 화면을 건드는(?) 중이라거 그렇습니다. 안건들거나 못건들도록 하면 안뜰겁니다.<br>"));
        txt1.setTextSize(18);
        txt1.setTextColor(Color.BLACK);
        layout.addView(txt1);
        Button btn1 = new Button(this);
        btn1.setText("권한 허용하기");
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCompat.requestPermissions(ctx, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, 3);
            }
        });
        layout.addView(btn1);
        TextView txt2 = new TextView(this);
        txt2.setText(Html.fromHtml("<br>&nbsp;카카오톡 봇은 상단바에 카카오톡 알림이 뜨면, 그 알림을 읽어오는 방식으로 채팅 수신을 인식합니다. 즉, <b>카카오톡의 알림이 켜져있어야 작동</b>하니, 카카오톡의 알림을 켜주시길 바랍니다. 또한, <b>알림 접근 권한을 허용</b>해주셔야, 카카오톡 봇이 상단바에 뜬 알림에 접근할 수 있습니다.<br>"));
        txt2.setTextSize(18);
        txt2.setTextColor(Color.BLACK);
        layout.addView(txt2);
        Button btn2 = new Button(this);
        btn2.setText("알림 접근 허용하기");
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS");
                startActivity(intent);
                toast("알림 접근 허용 창으로 이동합니다.");
            }
        });
        layout.addView(btn2);
        TextView txt3 = new TextView(this);
        txt3.setText(Html.fromHtml("<br>&nbsp;카카오톡 봇은 <b>안드로이드 웨어가 설치되어야 답장이 가능</b>하니, 안드로이드 웨어를 설치해주시길 바랍니다.<br>"));
        txt3.setTextSize(18);
        txt3.setTextColor(Color.BLACK);
        layout.addView(txt3);
        Button btn3 = new Button(this);
        btn3.setText("안드로이드 웨어 설치하기");
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.wearable.app");
                startActivity(new Intent(Intent.ACTION_VIEW, uri));
                toast("Play 스토어로 이동합니다.");
            }
        });
        layout.addView(btn3);
        TextView txt4 = new TextView(this);
        txt4.setText("\n 본인이 해당 채팅방에 들어가서 채팅을 보고 있는 동안에는 알림이 뜨지 않기 때문에, 카카오톡 봇이 작동하지 않습니다. 그리고, 다시 한 번 언급합니다만, 카카오톡의 알림이 꺼진 상태에서는 작동하지 않습니다.\n\n 권한 허용, 알림 접근 권한 허용, 안드로이드 웨어 설치 등이 끝났으면, 카카오톡 봇을 다시 시작해주세요.\n");
        txt4.setTextSize(18);
        txt4.setTextColor(Color.BLACK);
        layout.addView(txt4);

        TextView maker = new TextView(this);
        maker.setText("\nⓒ 2018 Dark Tornado, All rights reserved.\n");
        maker.setTextSize(13);
        maker.setTextColor(Color.BLACK);
        maker.setGravity(Gravity.CENTER);
        layout.addView(maker);

        int pad = dip2px(15);
        layout.setPadding(pad, pad, pad, pad);
        ScrollView scroll = new ScrollView(this);
        scroll.setBackgroundColor(Color.WHITE);
        scroll.addView(layout);
        return scroll;
    }

    private void updateData() {
        String cache = KakaoBot.readData("botData");
        if (cache == null) data = new String[0];
        else data = cache.split("\n");
        names.clear();
        for (int n = 0; n < data.length; n++) {
            names.add(data[n].split("::::")[0]);
        }
    }

    private void editDialog(ArrayAdapter adapter) {
        boolean[] roomCheck = {false};
        int[] mode = {0, 0};
        editDialog("새 항목 추가", null, null, null, mode, roomCheck, adapter, -1);
    }

    private void editDialog(final String title, final String _que, String ans, String roomName, final int[] mode, final boolean[] roomCheck, final ArrayAdapter adapter0, final int pos) {
        try {
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setTitle(title);
            final LinearLayout layout = new android.widget.LinearLayout(this);
            layout.setOrientation(1);
            final TextView txt1 = new TextView(this);
            final EditText txt2 = new EditText(this);
            TextView txt3 = new TextView(this);
            final EditText txt4 = new EditText(this);
            final TextView txt5 = new TextView(this);
            final EditText txt6 = new EditText(this);
            CheckBox room = new CheckBox(this);
            room.setText("채팅방 이름도 확인");
            room.setChecked(roomCheck[0]);
            room.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    roomCheck[0] = isChecked;
                    if (isChecked) {
                        layout.addView(txt5, 4);
                        layout.addView(txt6, 5);
                    } else {
                        layout.removeView(txt5);
                        layout.removeView(txt6);
                    }
                }
            });
            layout.addView(room);
            TextView txt0 = new TextView(this);
            txt0.setText("채팅방 종류 : ");
            txt0.setTextSize(17);
            txt0.setTextColor(Color.BLACK);
            txt0.setPadding(0, dip2px(10), 0, 0);
            layout.addView(txt0);
            RadioGroup radios = new RadioGroup(this);
            radios.setOrientation(1);
            String[] menuR = {"모두 작동", "1:1 채팅에서만 작동", "단체 채팅에서만 작동"};
            RadioButton[] radio = new RadioButton[menuR.length];
            for (int n = 0; n < menuR.length; n++) {
                radio[n] = new RadioButton(this);
                radio[n].setText(menuR[n]);
                radio[n].setTextSize(16);
                radio[n].setTextColor(Color.BLACK);
                radio[n].setId(n);
                radios.addView(radio[n]);
            }
            radio[mode[1]].setChecked(true);
            radios.setPadding(0, 0, 0, dip2px(5));
            radios.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    mode[1] = checkedId;
                }
            });
            layout.addView(radios);
            String[] modes = {"채팅 내용이 일치", "채팅 내용이 포함"};
            Spinner spin = new Spinner(this);
            final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, modes);
            spin.setAdapter(adapter);
            spin.setSelection(mode[0]);
            spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    mode[0] = (int) id;
                    if (mode[0] == 0) txt1.setText("\n이 말을 하면...");
                    else if (mode[0] == 1) txt1.setText("\n이 말이 포함되어 있으면...");
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
            layout.addView(spin);
            txt1.setText("\n이 말을 하면...");
            txt1.setTextSize(18);
            txt1.setTextColor(Color.BLACK);
            txt2.setHint("내용을 입력하세요...");
            txt2.setTextColor(Color.BLACK);
            txt2.setHintTextColor(Color.GRAY);
            txt2.setSingleLine(true);
            txt3.setText("\n이렇게 대답...");
            txt3.setTextSize(18);
            txt3.setTextColor(Color.BLACK);
            txt4.setHint("내용을 입력하세요...");
            txt4.setTextColor(Color.BLACK);
            txt4.setHintTextColor(Color.GRAY);
            txt5.setText("\n이 채팅방에서...");
            txt5.setTextSize(18);
            txt5.setTextColor(Color.BLACK);
            txt6.setHint("채팅방 이름을 입력하세요...");
            txt6.setTextColor(Color.BLACK);
            txt6.setHintTextColor(Color.GRAY);
            txt6.setSingleLine(true);
            if (_que != null) txt2.setText(_que);
            if (ans != null) txt4.setText(ans.replace("\\n", "\n"));
            if (roomName != null) txt6.setText(roomName);
            layout.addView(txt1);
            layout.addView(txt2);
            layout.addView(txt3);
            layout.addView(txt4);
            if(roomCheck[0]) {
                layout.addView(txt5, 4);
                layout.addView(txt6, 5);
            }
            int pad = dip2px(10);
            layout.setPadding(pad, pad, pad, pad);
            ScrollView scroll = new ScrollView(this);
            scroll.addView(layout);
            dialog.setView(scroll);
            dialog.setNegativeButton("취소", null);
            if(pos!=-1) dialog.setNeutralButton("삭제", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if (data.length > 1) {
                        String str = "";
                        for (int n = 0; n < data.length; n++) {
                            if (n != pos) {
                                str = str + data[n] + "\n";
                            }
                        }
                        KakaoBot.saveData("botData", str);
                    } else {
                        KakaoBot.removeData("botData");
                    }
                    updateData();
                    adapter0.notifyDataSetChanged();
                }
            });
            dialog.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String que = txt2.getText().toString();
                    String ans = txt4.getText().toString();
                    String room = txt6.getText().toString();
                    if (que.equals("") || ans.equals("") || (room.equals("") && roomCheck[0])) {
                        toast("입력되지 않은 값이 있습니다.");
                        editDialog(title, que, ans, room, mode, roomCheck, adapter0, pos);
                    } else {
                        String result = createSource(que, ans, room, mode, roomCheck[0]);
                        if (result == null) {
                            toast("새로운 항목 생성을 실패하였습니다.");
                        } else {
                            if(pos==-1) {
                                String cache = KakaoBot.readData("botData");
                                if (cache == null) KakaoBot.saveData("botData", result);
                                else KakaoBot.saveData("botData", cache + "\n" + result);
                            }
                            else{
                                String str = "";
                                for (int n = 0; n < data.length; n++) {
                                    if (n == pos) str += result + "\n";
                                    else str += data[n] + "\n";
                                }
                                KakaoBot.saveData("botData", str);
                            }
                            toast("저장되었습니다.");
                            updateData();
                            adapter0.notifyDataSetChanged();
                        }
                    }
                }
            });
            dialog.show();
        } catch (Exception e) {
            toast(e.toString());
        }
    }

    public String createSource(String que, String ans, String room, int[] mode, boolean roomCheck) {
        try {
            //질문::::대답:::대답:::대답:::방확인::::방이름::::포함인지::::방종류
            if (!roomCheck) room = "null";
            ans = ans.replaceAll("\n", "\\\\n");
            String[] anss = ans.split("\\[\\[다음채팅\\]\\]");
            String str = anss[0];
            for (int n = 1; n < anss.length; n++)
                str += ":::" + anss[n];
            String result = que + "::::" + str + "::::" + roomCheck + "::::" + room + "::::" + mode[0] + "::::" + mode[1]+"::::0::::0::::0";
            return result;
        } catch (Exception e) {
            toast(e.toString());
        }
        return null;
    }

    private void openSettings(){
        try {
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            LinearLayout layout = new LinearLayout(this);
            layout.setOrientation(1);
            String[] menuS = {"도배 방지", "자동응답시 알림", "자동응답 내역 저장"};
            Switch[] sws = new Switch[menuS.length];
            final String[] bools = {"preventCover", "toast", "makeLog"};
            int pad = dip2px(1);
            int pad2 = dip2px(5);
            for (int n = 0; n < menuS.length; n++) {
                sws[n] = new Switch(this);
                sws[n].setText(menuS[n]);
                sws[n].setTextSize(17);
                sws[n].setTextColor(Color.BLACK);
                sws[n].setChecked(KakaoBot.readData(bools[n]).equals("true"));
                sws[n].setId(n);
                sws[n].setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton swit, boolean onoff) {
                        KakaoBot.saveData(bools[swit.getId()], String.valueOf(onoff));
                    }
                });
                sws[n].setPadding(pad, pad2, pad, pad2);
                layout.addView(sws[n]);
            }
            sws[menuS.length-1].setPadding(pad, pad2, pad, dip2px(12));
            String[] menus = {"자동 응답 로그 보기", "자동 응답 로그 삭제"};
            Button[] btns = new Button[menus.length];
            for (int n = 0; n < menus.length; n++) {
                btns[n] = new Button(this);
                btns[n].setText(menus[n]);
                btns[n].setId(n);
                btns[n].setTransformationMethod(null);
                btns[n].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        switch (v.getId()) {
                            case 0:
                                String cache = KakaoBot.readData("log");
                                if(cache==null) toast("저장된 자동응답 내역이 없습니다.");
                                else showDialog("자동응답 내역", cache);
                                break;
                            case 1:
                                KakaoBot.removeData("log");
                                toast("자동응답 내역이 삭지되었습니다.");
                                break;
                        }
                    }
                });
                layout.addView(btns[n]);
            }
            pad = dip2px(10);
            layout.setPadding(pad, pad, pad, pad);
            ScrollView scroll = new ScrollView(this);
            scroll.addView(layout);
            dialog.setView(scroll);
            dialog.setTitle("환경 설정");
            dialog.setNegativeButton("닫기", null);
            dialog.show();
        } catch (Exception e) {
            toast(e.toString());
        }
    }

    private void checkSomething() {
        String enl = Settings.Secure.getString(getContentResolver(), "enabled_notification_listeners");
        if ((enl != null && !enl.contains(BuildConfig.APPLICATION_ID)) || enl == null) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    showDialog("알림 접근 허용", "카카오톡 봇은 알림 접근 권한이 허용되어 있어야 작동합니다. 알림 접근 권한을 허용해주세요. 화면 왼쪽 끝에서 오른쪽으로 드래그하면 나오는 메뉴에서 설정 창으로 이동하실 수 있습니다.");
                }
            });
        }

        String[] apps = getAllApps();
        boolean noApp = true;
        for (int n = 0; n < apps.length; n++) {
            if (apps[n].equals("com.google.android.wearable.app")) noApp = false;
        }
        if (noApp) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    showDialog("안드로이드 웨어 설치", "카카오톡 봇은 안드로이드 웨어가 깔려있어야 정상적으로 작동합니다. Play 스토어에서 안드로이드 웨어를 설치해주세요. 화면 왼쪽 끝에서 오른쪽으로 드래그하면 나오는 메뉴에서 다운로드 링크로 이동할 수 있습니다.");
                }
            });
        }

    }

    public String[] getAllApps() {
        try {
            Intent intent = new Intent(Intent.ACTION_MAIN, null);
            intent.addCategory(Intent.CATEGORY_LAUNCHER);
            PackageManager pm = getPackageManager();
            List<ResolveInfo> apps = pm.queryIntentActivities(intent, 0);
            String[] strArr = new String[apps.size()];
            for (int n = 0; n < apps.size(); n++) {
                ResolveInfo pack = apps.get(n);
                strArr[n] = pack.activityInfo.applicationInfo.packageName;
            }
            return strArr;
        } catch (Exception e) {
            toast("getAllApps\n" + e.toString());
        }
        return null;
    }

    public void showRemoveDialog() {
        try {
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setTitle("응답할 말 모두 삭제");
            dialog.setMessage("응답할 말들을 모두 삭제하시겠습니까?");
            dialog.setNegativeButton("아니요", null);
            dialog.setPositiveButton("네", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    KakaoBot.removeData("botData");
                    toast("응답할 말이 모두 삭제되었습니다.");
                }
            });
            dialog.show();
        } catch (Exception e) {
            toast(e.toString());
        }
    }

    @Override
    public void onBackPressed(){
        if(drawer==null) {
            finish();
            return;
        }
        if (drawer.isDrawerOpen(Gravity.LEFT)) {
            drawer.closeDrawer(Gravity.LEFT);
        } else {
            finish();
        }
    }

    public void showDialog(String title, String msg) {
        try {
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setTitle(title);
            dialog.setMessage(msg);
            dialog.setNegativeButton("닫기", null);
            dialog.show();
        } catch (Exception e) {
            toast(e.toString());
        }
    }

    private int dip2px(int dips){
        return (int)Math.ceil(dips*this.getResources().getDisplayMetrics().density);
    }

    public void toast(final String msg) {
        runOnUiThread(new Runnable() {
            public void run() {
                Toast toast = Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }
}
