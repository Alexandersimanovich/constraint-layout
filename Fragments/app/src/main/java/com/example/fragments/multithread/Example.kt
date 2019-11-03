package com.example.fragments.multithread

import android.content.Context
import android.widget.Toast

class Example {

    var count: Int = 0

    fun example(count: Int){
        this.count = count

    }

    fun doWork(){
        Thread(Runnable {
            Thread.sleep(15000)
        }).start()

    }
}