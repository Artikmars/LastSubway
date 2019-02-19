package lnk.lastsubway

import android.app.Activity
import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.widget.TextView

import java.util.Timer
import java.util.TimerTask


class LastSubwayActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_last_subway)

        val titleText1 = findViewById<TextView>(R.id.TitleText1)
        val titleText2 = findViewById<TextView>(R.id.TitleText2)
        val font1 = Typeface.createFromAsset(assets, "Roboto-Thin.ttf")
        val font2 = Typeface.createFromAsset(assets, "Roboto-Light.ttf")
        titleText1.typeface = font1
        titleText2.typeface = font2

        Timer().schedule(object : TimerTask() {
            override fun run() {
               runOnUiThread {
                    startActivity(Intent(this@LastSubwayActivity, SecondActivity::class.java))
                    finish()
                }
            }
        }, 2000)

    }

}


