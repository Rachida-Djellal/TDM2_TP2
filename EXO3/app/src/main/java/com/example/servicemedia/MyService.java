package com.example.servicemedia;


import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.IBinder;
import android.provider.Settings;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class MyService extends Service {
    private MediaPlayer player = null;
    public int ID_NOTIFICATION = 0;
    public String CHANNEL_ID = "";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //getting systems default ringtone
        if (player == null) {
            player = MediaPlayer.create(this, R.raw.song);

        }

     /*   Intent intent1 = new Intent(this,MainActivity.class);
        intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);

        Uri soundUri = Uri.parse("android.resource://" + getApplicationContext().getPackageName() + "/" + R.raw.song);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, "CH_ID")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(getString(R.string.app_name))
                .setContentText("salat")
                .setAutoCancel(true)
                .setSound(soundUri)
                .setContentIntent(pendingIntent);

        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {

            if(soundUri != null){
                // Changing Default mode of notification
                notificationBuilder.setDefaults(Notification.DEFAULT_VIBRATE);
                // Creating an Audio Attribute
                AudioAttributes audioAttributes = new AudioAttributes.Builder()
                        .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                        .setUsage(AudioAttributes.USAGE_ALARM)
                        .build();

                // Creating Channel
                NotificationChannel notificationChannel = new NotificationChannel("CH_ID","Testing_Audio",NotificationManager.IMPORTANCE_HIGH);
                notificationChannel.setSound(soundUri,audioAttributes);
                mNotificationManager.createNotificationChannel(notificationChannel);
            }
        }
        mNotificationManager.notify(0, notificationBuilder.build());*/

     Calendar cal = Calendar.getInstance();
            int hour = cal.get(Calendar.HOUR_OF_DAY);
            int minute = cal.get(Calendar.MINUTE);
            System.out.println(hour);
            System.out.println(minute);
        if (hour == 03 && minute == 49  || hour==23 && minute==24 || hour==23 && minute==23) {
            Uri sound = Uri.parse("android.resource://com.example.dectionnaire/" + R.raw.song);

             player.start();
            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, "10");
            mBuilder.setSmallIcon(R.drawable.ic_stat_name);
            mBuilder.setContentTitle("My notification");
            mBuilder.setContentText("Hello World!");
            mBuilder.setSound(sound);// Gets an instance of the NotificationManager service//
            NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            mNotificationManager.notify(001, mBuilder.build());

        }

          /*  if (hour == 03 && minute == 49) {
                // player.start();
                Log.d("kotlin", "player");
                //setting loop play to true
                //this will make the ringtone continuously playing
                // player.setLooping(true);

                //staring the player
                player.start();
                Intent intent1 = new Intent(this, MainActivity.class);
                intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

                Uri sound = Uri.parse("android.resource://com.example.dectionnaire/" + R.raw.song);
                // Create an explicit intent for an Activity in your app
                Notification notification = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID)
                        // Show controls on lock screen even when user hides sensitive content.
                        .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                        .setSmallIcon(R.drawable.ic_stat_name)


                        .setContentTitle("Preire time")
                        .setContentText("fajr time " + hour + ":" + minute)
                        .setContentIntent(pendingIntent)
                        .setSound(sound)
                        .build();


                startForeground(0, notification);
            }
            if (hour == 12 && minute == 38) {
                // player.start();
                Log.d("kotlin", "player");
                //setting loop play to true
                //this will make the ringtone continuously playing
                // player.setLooping(true);

                //staring the player
                player.start();
                Intent intent1 = new Intent(this, MainActivity.class);
                intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

                Uri sound = Uri.parse("android.resource://com.example.dectionnaire/" + R.raw.song);
                // Create an explicit intent for an Activity in your app
                Notification notification = new NotificationCompat.Builder(getApplicationContext(), "10")
                        // Show controls on lock screen even when user hides sensitive content.
                        .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                        .setSmallIcon(R.drawable.ic_stat_name)


                        .setContentTitle("Preire time")
                        .setContentText("dhor time " + hour + ":" + minute)
                        .setContentIntent(pendingIntent)
                        .setSound(sound)
                        .build();


                startForeground(0, notification);
            }
            if (hour == 16 && minute == 46) {
                // player.start();
                Log.d("kotlin", "player");
                //setting loop play to true
                //this will make the ringtone continuously playing
                // player.setLooping(true);

                //staring the player
                player.start();
                Intent intent1 = new Intent(this, MainActivity.class);
                intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

                Uri sound = Uri.parse("android.resource://com.example.dectionnaire/" + R.raw.song);
                // Create an explicit intent for an Activity in your app
                Notification notification = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID)
                        // Show controls on lock screen even when user hides sensitive content.
                        .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                        .setSmallIcon(R.drawable.ic_stat_name)


                        .setContentTitle("Preire time")
                        .setContentText("el 3aser  time " + hour + ":" + minute)
                        .setContentIntent(pendingIntent)
                        .setSound(sound)
                        .build();


                 startForeground(0,notification);
            }
            if (hour == 19 && minute == 39) {
                // player.start();
                Log.d("kotlin", "player");
                //setting loop play to true
                //this will make the ringtone continuously playing
                // player.setLooping(true);

                //staring the player
                //player.start();
                Intent intent1 = new Intent(this, MainActivity.class);
                intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

                Uri sound = Uri.parse("android.resource://com.example.dectionnaire/" + R.raw.song);
                // Create an explicit intent for an Activity in your app
                Notification notification = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID)
                        // Show controls on lock screen even when user hides sensitive content.
                        .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                        .setSmallIcon(R.drawable.ic_stat_name)


                        .setContentTitle("Preire time")
                        .setContentText("El Maghreb time " + hour + ":" + minute)
                        .setContentIntent(pendingIntent)
                        .setSound(sound)
                        .build();


                startForeground(0, notification);
            }
            if (hour == 21 && minute == 15) {
                // player.start();
                Log.d("kotlin", "player");
                //setting loop play to true
                //this will make the ringtone continuously playing
                // player.setLooping(true);

                //staring the player
                //player.start();
                Intent intent1 = new Intent(this, MainActivity.class);
                intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);

                Uri sound = Uri.parse("android.resource://com.example.dectionnaire/" + R.raw.song);
                // Create an explicit intent for an Activity in your app
                Notification notification = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID)
                        // Show controls on lock screen even when user hides sensitive content.
                        .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                        .setSmallIcon(R.drawable.ic_stat_name)


                        .setContentTitle("Preire time")
                        .setContentText("dhor time " + hour + ":" + minute)
                        .setContentIntent(pendingIntent)
                        .setSound(sound)
                        .build();


                startForeground(0, notification);
            }*/


            //we have some options for service
            //start sticky means service will be explicity started and stopped
            return START_STICKY;
        }


        @Override
        public void onDestroy () {
            super.onDestroy();
            //stopping the player when service is destroyed
            player.stop();
        }

    }
