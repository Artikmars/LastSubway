package lnk.lastsubway;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class SecondActivity extends Activity {
    private Spinner spinner1, spinner2;
    private String[] timesB, timesR, timesG, timesB2, timesR2, timesG2, lastB1, lastB2, lastR1, lastR2, lastG1, lastG2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        //   adView = (AdView) findViewById(R.id.adView);
        //adView = new AdView(this);
        //adView.setAdSize(AdSize.SMART_BANNER);
        // AdRequest adRequest = new AdRequest.Builder()
        //             .addTestDevice("0xb900f6f8")
        //          .build();
        //   adView.loadAd(adRequest);

        final RelativeLayout body = findViewById(R.id.Body);
        body.setBackgroundColor(getResources().getColor(R.color.darkpurple));

        final TextView LineText = findViewById(R.id.LineText);
        final TextView About = findViewById(R.id.About);
        final TextView StationText = findViewById(R.id.StationText);
        final TextView StationCloseText = findViewById(R.id.StationCloseText1);
        final TextView StationClose = findViewById(R.id.StationClose);
        final TextView LastText1 = findViewById(R.id.StationLastText1);
        final TextView LastText2 = findViewById(R.id.StationLastText2);
        final TextView Last1 = findViewById(R.id.StationLast1);
        final TextView Last2 = findViewById(R.id.StationLast2);
        Typeface font3 = Typeface.createFromAsset(getAssets(), "Roboto-Thin.ttf");
        //Typeface font4 = Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf");
        LineText.setTypeface(font3);
        StationText.setTypeface(font3);
        StationCloseText.setTypeface(font3);
        LastText1.setTypeface(font3);
        LastText2.setTypeface(font3);

        spinner1 = findViewById(R.id.ListLines);
        spinner2 = findViewById(R.id.ListStations);

        timesB = getResources().getStringArray(R.array.BlueStationsClose);
        timesB2 = getResources().getStringArray(R.array.BlueStationsClose2);
        lastB1 = getResources().getStringArray(R.array.BlueStationsLastTerem);
        lastB2 = getResources().getStringArray(R.array.BlueStationsLastGeroev);
        timesR = getResources().getStringArray(R.array.RedStationsClose);
        timesR2 = getResources().getStringArray(R.array.RedStationsClose2);
        lastR1 = getResources().getStringArray(R.array.RedStationsLastLesnaya);
        lastR2 = getResources().getStringArray(R.array.RedStationsLastAkadem);

        timesG = getResources().getStringArray(R.array.GreenStationsClose);
        timesG2 = getResources().getStringArray(R.array.GreenStationsClose2);
        lastG1 = getResources().getStringArray(R.array.GreenStationsLastHutor);
        lastG2 = getResources().getStringArray(R.array.GreenStationsLastSyrec);

        //final ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this,
        //        android.R.layout.simple_spinner_item, stations);

        final ArrayAdapter dataAdapter11B = ArrayAdapter.createFromResource(this, R.array.LinesList, R.layout.spinner_item_b);
        //final ArrayAdapter dataAdapter11R = ArrayAdapter.createFromResource(this, R.array.LinesList, R.layout.spinner_item_r);
        //final ArrayAdapter dataAdapter11G = ArrayAdapter.createFromResource(this, R.array.LinesList, R.layout.spinner_item_g);

        //dataAdapter11.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        final ArrayAdapter dataAdapter21B = ArrayAdapter.createFromResource(this, R.array.BlueStationsList, R.layout.spinner_item_b);
        //dataAdapter21B.setDropDownViewResource(R.layout.spinner_item_b);

        final ArrayAdapter dataAdapter22R = ArrayAdapter.createFromResource(this, R.array.RedStationsList, R.layout.spinner_item_b);
        //dataAdapter22R.setDropDownViewResource(R.layout.spinner_item_b);

        final ArrayAdapter dataAdapter23G = ArrayAdapter.createFromResource(this, R.array.GreenStationsList, R.layout.spinner_item_b);
        //dataAdapter23G.setDropDownViewResource(R.layout.spinner_item_b);

        final Animation animation = AnimationUtils.loadAnimation(SecondActivity.this, R.anim.translate);
        final Animation animation1 = AnimationUtils.loadAnimation(SecondActivity.this, R.anim.translate1);
        final Animation animation2 = AnimationUtils.loadAnimation(SecondActivity.this, R.anim.translate2);


        About.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SecondActivity.this, AboutActivity.class));
            }
        });

        spinner1.setAdapter(dataAdapter11B);


        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                switch (spinner1.getSelectedItemPosition()) {
                    case 0:
                        spinner2.setAdapter(dataAdapter21B);
                        //body.setBackgroundColor(getResources().getColor(R.color.darkblue));
                        dataAdapter21B.notifyDataSetChanged();
                        break;
                    case 1:
                        spinner2.setAdapter(dataAdapter22R);
                        dataAdapter22R.notifyDataSetChanged();
                        break;
                    case 2:
                        spinner2.setAdapter(dataAdapter23G);
                        dataAdapter23G.notifyDataSetChanged();
                        break;
                    default:
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                switch (spinner1.getSelectedItemPosition()) {
                    case 0:
                        String time = timesB[spinner2.getSelectedItemPosition()];
                        String time02 = timesB2[spinner2.getSelectedItemPosition()];
                        if (time02.length() != 0) {
                            StationCloseText.setText(R.string.StationCloseText2);
                            StationClose.setText(time + "/" + time02);
                        } else {
                            StationCloseText.setText(R.string.StationCloseText);
                            StationClose.setText(time);
                        }
                        StationClose.startAnimation(animation);
                        String last1 = lastB1[spinner2.getSelectedItemPosition()];
                        LastText1.setText(R.string.StationLastTextTeremki);
                        Last1.setText(last1);
                        Last1.startAnimation(animation1);
                        String last2 = lastB2[spinner2.getSelectedItemPosition()];
                        LastText2.setText(R.string.StationLastTextGeroev);
                        Last2.setText(last2);
                        Last2.startAnimation(animation2);
                        break;
                    case 1:
                        String time1 = timesR[spinner2.getSelectedItemPosition()];
                        String time12 = timesR2[spinner2.getSelectedItemPosition()];
                        if (spinner2.getSelectedItemPosition() == 10) {
                            StationCloseText.setText("Закрытие выходов\nКрещ./Инст./Городец.: ");
                            StationClose.setText("00:12/11/13");
                        } else if (time12.length() != 0) {
                            StationCloseText.setText(R.string.StationCloseText2);
                            StationClose.setText(time1 + "/" + time12);
                        } else {
                            StationCloseText.setText(R.string.StationCloseText);
                            StationClose.setText(time1);
                        }
                        StationClose.startAnimation(animation);
                        String last3 = lastR1[spinner2.getSelectedItemPosition()];
                        LastText1.setText(R.string.StationLastTextLesnaya);
                        Last1.setText(last3);
                        Last1.startAnimation(animation1);
                        String last4 = lastR2[spinner2.getSelectedItemPosition()];
                        LastText2.setText(R.string.StationLastTextAkadem);
                        Last2.setText(last4);
                        Last2.startAnimation(animation2);
                        break;
                    case 2:
                        String time2 = timesG[spinner2.getSelectedItemPosition()];
                        String time22 = timesG2[spinner2.getSelectedItemPosition()];
                        if (time22.length() != 0) {
                            StationCloseText.setText(R.string.StationCloseText2);
                            StationClose.setText(time2 + "/" + time22);
                        } else {
                            StationCloseText.setText(R.string.StationCloseText);
                            StationClose.setText(time2);
                        }
                        StationClose.startAnimation(animation);
                        String last5 = lastG1[spinner2.getSelectedItemPosition()];
                        LastText1.setText(R.string.StationLastTextHutor);
                        Last1.setText(last5);
                        Last1.startAnimation(animation1);
                        String last6 = lastG2[spinner2.getSelectedItemPosition()];
                        LastText2.setText(R.string.StationLastTextSyrec);
                        Last2.setText(last6);
                        Last2.startAnimation(animation2);
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        /*if (adView != null) {
            adView.resume();
        }*/
    }

    @Override
    public void onPause() {
        // if (adView != null) {
        //      adView.pause();
        //   }
        super.onPause();
    }

    @Override
    public void onDestroy() {
     /*   if (adView != null) {
            adView.destroy();
        }*/
        super.onDestroy();
    }
}