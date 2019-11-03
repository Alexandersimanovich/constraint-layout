package com.example.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
//import kotlinx.android.synthetic.main.fragment_second.*

class SecondFragment : Fragment() {


    companion object{

        fun newInstance(movie: Movie): SecondFragment{
            val fragment = SecondFragment()
            val args: Bundle = Bundle()
            args.putSerializable("newInstance_key", movie)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view = inflater.inflate(R.layout.fragment_second, container, false)
        val movie = arguments?.getSerializable("newInstance_key") as Movie
        val header = view.findViewById<TextView>(R.id.activity_second__header_text)
        header.text = movie.name
        val description = view.findViewById<TextView>(R.id.activity_main__description_text)
            description.text = movie.description
        val image = view.findViewById<ImageView>(R.id.activity_second__top_image)
        val imageMain = view.findViewById<ImageView>(R.id.activity_second__left_image)
        Glide.with(this).load(movie.pic).into(image)
        Glide.with(this).load(movie.pic).into(imageMain)
        val button = view.findViewById<Button>(R.id.activity_main__button)
        button.setOnClickListener{openUrl("https://www.youtube.com/watch?v=fFM-pC1qCSE")}

        return view
    }

    private fun openUrl(url: String) {
        val intent = Intent (Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)

    }

}