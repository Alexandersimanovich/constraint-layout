package com.example.reciclerview

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val movie = intent.getSerializableExtra() as Movie
        activity_second__header_text.text = movie.name
        activity_main__description_text.text = movie.description
        Glide.with(this).load(movie.pic).into(activity_second__top_image)
        Glide.with(this).load(movie.pic).into(activity_second__left_image)
    }
}