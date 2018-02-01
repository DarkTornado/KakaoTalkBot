package com.darktornado.kakaobot;

import android.app.Application;
import android.content.Context;
import android.os.Environment;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

/**
 * Created by Dark Tornado on 2018-01-18.
 */
public class KakaoBot extends Application{

    private static String sdcard = Environment.getExternalStorageDirectory().getAbsolutePath();
    public static final String VERSION = "1.0";
    private static Context ctx;


    @Override
    public void onCreate(){
        super.onCreate();
        ctx = getApplicationContext();
    }

    public static String readData(String name) {
        try {
            File file = new File(sdcard+"/KakaoBot/"+name+".txt");
            if (!file.exists()) return null;
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String str = br.readLine();
            String line = "";
            while ((line = br.readLine()) != null) {
                str += "\n" + line;
            }
            fis.close();
            isr.close();
            br.close();
            return str;
        } catch (Exception e) {
            //toast(e.toString());
        }
        return "";
    }

    public static void saveData(String name, String value) {
        try {
            File file = new File(sdcard+"/KakaoBot/"+name+".txt");
            FileOutputStream fos = new java.io.FileOutputStream(file);
            fos.write(value.getBytes());
            fos.close();
        } catch (Exception e) {
            //toast(e.toString());
        }
    }

    public static void removeData(String name){
        try {
            File file = new File(sdcard+"/KakaoBot/"+name+".txt");
            if(file.exists()) file.delete();
        } catch (Exception e) {
            //toast(e.toString());
        }
    }

    private static void toast(String msg) {
        Toast.makeText(ctx, msg, Toast.LENGTH_LONG).show();
    }

}
