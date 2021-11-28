package com.example.fireforceapps;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceIdReceiver;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import io.socket.client.Socket;

public class MainActivity extends AppCompatActivity {

    private Socket mSocket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SocketApp app = (SocketApp) getApplication();
        mSocket = app.getSocket();

        mSocket.connect();


        FirebaseMessaging.getInstance().subscribeToTopic("/topics/SmokeDetected-C1");

        LocalBroadcastManager.getInstance(this).registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String message = intent.getStringExtra("floor");
                Log.d("receiver", "floor : " + message);
            }
        }, new IntentFilter("fcm-data-in"));

//        FirebaseMessaging.getInstance().send(new RemoteMessage.Builder("1@fcm.googleapis.com").setMessageId());


//        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>() {
//            @Override
//            public void onComplete(@NonNull Task<String> task) {
//                if (!task.isSuccessful()) {
//                    Log.w("TOKET", "Fetching FCM registration token failed", task.getException());
//                    return;
//                }
//
//                // Get new FCM registration token
//                String token = task.getResult();
//
//                // Log and toast
////                String msg = getString(R.string.msg_token_fmt, token);
//                Log.d("TOKET", token);
//                Toast.makeText(MainActivity.this, token, Toast.LENGTH_SHORT).show();
//            }
//        });

        getSupportActionBar().hide();

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, BuildingCondition.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        }, 3000L); //3000 L = 3 detik
    }
}