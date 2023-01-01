package com.example.payit.ui;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationManagerCompat;

import com.example.payit.R;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class PushNotificationService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        String title=remoteMessage.getNotification().getTitle();
        String text =remoteMessage.getNotification().getBody();
        final String CHANNEL_ID="HEADS_UP_NOTIFICATION";
        NotificationChannel channel=new NotificationChannel(
                CHANNEL_ID,
                "Heads up notification",
                NotificationManager.IMPORTANCE_HIGH
        );
        getSystemService(NotificationManager.class).createNotificationChannel(channel);
        Notification.Builder notification = new Notification.Builder(this,CHANNEL_ID)
                .setContentTitle(title)
                        .setContentText(text)
                                .setSmallIcon(R.drawable.payit_1)
                                        .setAutoCancel(true);
        NotificationManagerCompat.from(this).notify(1,notification.build());
        super.onMessageReceived(remoteMessage);

    }
}
