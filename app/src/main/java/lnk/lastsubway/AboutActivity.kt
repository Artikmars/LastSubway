package lnk.lastsubway

import android.app.Activity
import android.os.Bundle
import android.widget.TextView

class AboutActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val aboutContent = findViewById<TextView>(R.id.about_content)
        aboutContent.setOnClickListener { finish() }
    }
}
