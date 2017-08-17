package com.einfo.mylibrary;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by joker on 8/10/17.
 */

public class BadgeCount extends LinearLayout {

    Context context;
    AttributeSet attrs;
    private TextView countText;
    private RelativeLayout countLay;
    private ImageView countObject;

    public BadgeCount(Context context) {
        super(context);
        this.context = context;

        initialize(context);
    }


    public BadgeCount(Context context, AttributeSet attrs) {
        super(context, attrs);

        this.context = context;
        this.attrs = attrs;
        initialize(context);
    }

    public static ShapeDrawable drawCircle(Context context, int width, int height, int color) {

        //////Drawing oval & Circle programmatically /////////////

        ShapeDrawable oval = new ShapeDrawable(new OvalShape());
        oval.setIntrinsicHeight(height);
        oval.setIntrinsicWidth(width);
        oval.getPaint().setColor(ContextCompat.getColor(context, color));

        return oval;
    }

    private void initialize(Context context) {
        inflate(context, R.layout.my_view, this);

        countObject = findViewById(R.id.count_attach_image);
        countLay = findViewById(R.id.count_lay);
        countText = findViewById(R.id.count_txt);
    }

    public void setBadgeView(int resource) {
        this.countObject.setImageResource(resource);

    }

    public void setCountText(int value) {
        if (value == 0)
            countLay.setVisibility(GONE);
        else countLay.setVisibility(VISIBLE);
        countText.setText(String.valueOf(value));
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void setBadgeBackground(int color) {

        Drawable drawable = drawCircle(context, 50, 50, color);
        countLay.setBackground(drawable);

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void setBadgeBackground(int color, int width, int height) {

        Drawable drawable = drawCircle(context, width, height, color);
        countLay.setBackground(drawable);
    }

    public void setCountTextColor(int color) {
        countText.setTextColor(ContextCompat.getColor(context, color));
    }


}
