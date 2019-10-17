package com.example.reciclerview

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.parcel.Parcelize
import java.io.Serializable
import com.example.reciclerview.SecondActivity as SecondActivity

data class Movie  (
    val name: String,
    val pic: String,
    val description: String): Serializable

    fun generateMovie(): List<Movie> {
        return listOf(
            Movie(
                "Don't Be a Menace to South Central",
                "https://upload.wikimedia.org/wikipedia/ru/f/fd/Dontbeamenace.jpg",
                "Don't Be a Menace to South Central While Drinking Your Juice in the Hood (or simply Don't Be a Menace) is a 1996 American crime comedy parody film directed by Paris Barclay in his feature film directorial debut, and produced by Keenen Ivory Wayans, and also written by Wayans brothers Shawn and Marlon Wayans, who also both starred in the lead roles."
            ),
            Movie(
                "I'm Gonna Git You Sucka",
                "https://upload.wikimedia.org/wikipedia/en/3/3a/I%27m_Gonna_Git_You_Sucka_film.jpg",
                "is a 1988 American action comedy parody film of blaxploitation films written, directed by, and starring Keenen Ivory Wayans in his feature film directorial debut. Featured in the film are several noteworthy African-American actors who were part of the genre of blaxploitation: Jim Brown, Bernie Casey, Antonio Fargas, and Isaac Hayes."
            ),
            Movie(
                "Breaking Bad",
                "https://www.episodegenerator.com/wp-content/uploads/brekaing-bad.jpg",
                "Breaking Bad is an American neo-Western crime drama television series created and produced by Vince Gilligan. The show originally aired on AMC for five seasons, from January 20, 2008, to September 29, 2013. Set and filmed in Albuquerque, New Mexico, the series tells the story of Walter White (Bryan Cranston), a struggling and depressed high school chemistry teacher who is diagnosed with stage-3 lung cancer."
            ),
            Movie(
                "Джокер",
                "https://avatars.mds.yandex.net/get-afishanew/23114/9b3f5c33f4887e128708434b288a9d51/s190x280",
                "Готэм, начало 1980-х годов. Комик Артур Флек живёт с больной матерью, которая с детства учит его «ходить с улыбкой». Пытаясь нести в мир хорошее и дарить людям радость, Артур сталкивается с человеческой жестокостью и постепенно приходит к выводу, что этот мир получит от него не добрую улыбку, а ухмылку злодея Джокера."
            ),
            Movie(
                "Гемини",
                "https://avatars.mds.yandex.net/get-afishanew/29882/a1456d40e544e5bfa3dde7441b270d16/s190x280",
                "Генри Броган, первоклассный киллер, становится мишенью таинственного оперативника, который, кажется, знает каждый его шаг наперёд…"
            ),
            Movie(
                "Эверест",
                "https://avatars.mds.yandex.net/get-afishanew/29022/78d828778f4e15f6b57a12238226e65e/s190x280",
                "Путешествие на самую высокую точку мира? Что может быть круче! Так решает Лу, когда случайно находит огромное, но очень милое чудовище посреди шумного мегаполиса. Пусть их преследуют учёные из сверхсекретной лаборатории, зато её новый друг умеет смешить и творить чудеса."
            )
        )
    }


class MovieAdapter (private val movies: List<Movie>, private val clickListener: (Movie) -> Unit) :
    RecyclerView.Adapter<MovieAdapter.MovieHolder>() {
    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        holder.bind(movies[position], clickListener)

    }

    override fun getItemCount(): Int {
       return movies.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MovieHolder(LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false))


    class MovieHolder (view: View) : RecyclerView.ViewHolder(view) {
         private val name: TextView = itemView.findViewById(R.id.movie_item__header_text)
        private val pic: ImageView = itemView.findViewById(R.id.movie_item__avatar)
        private val description: TextView = itemView.findViewById(R.id.movie_item__descroption_text)

        fun bind(movie: Movie, clickListener: (Movie) -> Unit) {
            Glide.with(itemView.context).load(movie.pic).into(pic)
            name.text = movie.name
            description.text = movie.description
            itemView.setOnClickListener{clickListener(movie)}
        }

    }




}