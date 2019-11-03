package com.example.fragments

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_thread_coroutines.*
import kotlinx.coroutines.*

class CoroutinesActivity: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread_coroutines)
        start_button.setOnClickListener{
            uiScope.launch {
                onProgressUpdate()
            }
        }
    }

    val viewModelJob = Job()
    val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private fun onProgressUpdate(){
        var progress = 10
        val textView = findViewById<TextView>(R.id.coroutines_threads_activiry_textview)
        while (progress>0){
            textView.setText(progress)
            progress--
        }
    }

}