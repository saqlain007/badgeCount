package com.einfo.myapplication;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;

import com.einfo.mylibrary.BadgeCount;

public class MainActivity extends AppCompatActivity {

    private BadgeCount badgeCount;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        badgeCount = (BadgeCount) findViewById(R.id.badge_count);


        badgeCount.setBadgeView(R.drawable.ic_notice_board);
        badgeCount.setCountText(2);
        //badgeCount.setBadgeBackground(R.color.black);
        badgeCount.setBadgeBackground(R.color.red, 50, 50);
        badgeCount.setCountTextColor(R.color.white);

    }
}
