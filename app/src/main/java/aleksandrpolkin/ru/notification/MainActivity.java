package aleksandrpolkin.ru.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static int NOTIFY_ID = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onCLick(View view) {
        Intent notificationIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://developer.alexanderklimov.ru/android/"));
        PendingIntent contentIntent = PendingIntent.getActivity(this,
                0,notificationIntent,PendingIntent.FLAG_CANCEL_CURRENT);

        Resources res = getApplicationContext().getResources();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentIntent(contentIntent)

                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Посетите мой сайт")
                .setContentText("http://developer.alexanderklimov.ru/android/")
                .setContentIntent(contentIntent)
                .setDefaults(Notification.DEFAULT_LIGHTS)
                .setTicker("Внимание!")

                .setWhen(System.currentTimeMillis())
              //  .setProgress(100,50,false)
                .setAutoCancel(true);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(NOTIFY_ID++, builder.build());




    }
}
