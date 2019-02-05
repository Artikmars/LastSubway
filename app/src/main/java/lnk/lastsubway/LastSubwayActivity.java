package lnk.lastsubway;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;


public class LastSubwayActivity extends Activity {
    Spinner spinner1;
    Spinner spinner2;
    TextView TitleText1, TitleText2;
    ArrayAdapter<CharSequence> adapter1;
    ArrayAdapter<CharSequence> adapter21, adapter22, adapter23;
    public static String COLORSPINNER = "empty";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_subway);

        TitleText1 = (TextView) findViewById(R.id.TitleText1);
        TitleText2 = (TextView) findViewById(R.id.TitleText2);
        Typeface font1 = Typeface.createFromAsset(getAssets(), "Roboto-Thin.ttf");
        Typeface font2 = Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf");
        TitleText1.setTypeface(font1);
        TitleText2.setTypeface(font2);

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
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_last_subway, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    */


}


