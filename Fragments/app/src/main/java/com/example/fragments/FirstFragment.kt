package com.example.fragments

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.ListFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class FirstFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?) : View {

//        val list = view?.findViewById<RecyclerView>(R.id.recyclerView)
        val view = inflater.inflate(R.layout.fragment_first, container, false)
        val list = view.findViewById<RecyclerView>(R.id.recyclerView)
        val movies = generateMovie()
        val adapter = MovieAdapter(movies, { movie ->
            movieClicked(movie)
        })
        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(getActivity())
        return view

    }


    private fun movieClicked(movie: Movie) {
//        val intent = Intent(this, SecondActivity::class.java)
//        intent.putExtra(moviekey, movie)
//        startActivity(intent)
        val newInstance = SecondFragment.newInstance(movie)
        fragmentManager
            ?.beginTransaction()
            ?.replace(R.id.activity_main__frame, newInstance)
            ?.addToBackStack(FirstFragment::class.java.canonicalName)
            ?.commit()
    }

}






