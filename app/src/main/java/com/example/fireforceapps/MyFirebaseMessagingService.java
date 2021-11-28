package com.example.fireforceapps;

import static androidx.core.app.ActivityCompat.startActivityForResult;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    public Map<String, String> data;
    @Override
    public void onNewToken(@NonNull String s) {
        super.onNewToken(s);
    }

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        Intent intentIn = new Intent("fcm-data-in");

        Map<String, String> data = remoteMessage.getData();
        for(Map.Entry<String, String> minidata : data.entrySet()){
            Log.d(minidata.getKey(), minidata.getValue());
            intentIn.putExtra(minidata.getKey(), minidata.getValue());
        }
        LocalBroadcastManager.getInstance(this).sendBroadcast(intentIn);



//        Intent localIntent = new Intent("miui.intent.action.APP_PERM_EDITOR");
//        localIntent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
//        localIntent.putExtra("extra_pkgname", getPackageName());

        Intent localIntent = new Intent(getApplicationContext(), MainActivity.class);

//        localIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        localIntent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(localIntent);

    }
}
