package com.example.a5imdb.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a5imdb.R

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*
            val goToSecondPageLayout = findViewById<View>(R.id.screen)
        val sendToSecondScreen = Runnable {
            startActivity(Intent(this, LoginPage::class.java))
            finish()
        }
        //open thread and sleep
        val handler = Handler()
        handler.postDelayed(sendToSecondScreen, 1500)
        goToSecondPageLayout.setOnClickListener {
            sendToSecondScreen.run()
        }
         */
    }
}

