package com.example.reciclerview

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

val moviekey = "movie_activity_movie"
class MoviesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)

        val list = findViewById<RecyclerView>(R.id.recyclerView)
        val movies = generateMovie()
        val adapter = MovieAdapter(movies, { movie ->
            movieClicked(movie)
        })
        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(this)

    }

    private fun movieClicked(movie: Movie) {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra(moviekey, movie)
        startActivity(intent)
    }

}







