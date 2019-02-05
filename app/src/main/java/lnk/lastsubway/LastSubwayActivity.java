package lnk.lastsubway;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;


public class LastSubwayActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_subway);

        TextView titleText1 = findViewById(R.id.TitleText1);
        TextView titleText2 = findViewById(R.id.TitleText2);
        Typeface font1 = Typeface.createFromAsset(getAssets(), "Roboto-Thin.ttf");
        Typeface font2 = Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf");
        titleText1.setTypeface(font1);
        titleText2.setTypeface(font2);

        new Timer().schedule(new TimerTask() {
            public void run() {
                LastSubwayActivity.this.runOnUiThread(new Runnable() {
                    public void run() {
                        startActivity(new Intent(LastSubwayActivity.this, SecondActivity.class));
                        finish();
                    }
                });
            }
        }, 2000);

    }

}


