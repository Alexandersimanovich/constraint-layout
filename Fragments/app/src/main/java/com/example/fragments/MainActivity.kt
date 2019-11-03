package com.example.fragments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.MenuItem
import com.example.fragments.multithread.Example

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val firstFragment = FirstFragment()
        supportFragmentManager
            .beginTransaction()
            .add(R.id.activity_main__frame, firstFragment)
            .commit()
    }
    fun onThreadMenuClicked (item: MenuItem){
        val intent = Intent (this, ThreadActivity::class.java)
        startActivity(intent)
    }

    fun onCoroutinesMenuClicked (item: MenuItem) {
        val intent = Intent(this, CoroutinesActivity::class.java)
        startActivity(intent)
    }

}