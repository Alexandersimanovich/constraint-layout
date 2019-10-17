package com.example.constraintlayout

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.activity_main__button)
        button.setOnClickListener { openUrl("https://www.youtube.com/watch?v=fFM-pC1qCSE") }
    }
    fun openUrl (url: String){
        val intent = Intent (Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
}
