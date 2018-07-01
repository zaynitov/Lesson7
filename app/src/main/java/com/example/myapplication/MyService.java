package com.example.myapplication;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class MyService extends Service {
    private final static int MODE = Service.START_NOT_STICKY;
    public final static String intentFilterString = "COLORS";

    @Override
    public int onStartCommand(final Intent intent, int flags, int startId) {


        Intent intentCOLOR = new Intent(intentFilterString);
        intentCOLOR.putExtra("colour1", "#FF007F");
        intentCOLOR.putExtra("colour2", "#0000FF");
        intentCOLOR.putExtra("colour3", "#FF00FF");

        sendBroadcast(intentCOLOR);


        return MODE;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context,MyService.class);
        return intent;
    }
}
