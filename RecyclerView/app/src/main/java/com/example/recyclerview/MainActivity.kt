package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var myRecyclerView: RecyclerView
    lateinit var newsArrayList: ArrayList<News>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myRecyclerView = findViewById(R.id.recyclerView)

        val newsImage = arrayOf(R.drawable.img1 , R.drawable.img2 , R.drawable.img3 , R.drawable.img4 , R.drawable.img5
         , R.drawable.img6)

        val newsHeading =  arrayOf( "U.K. Foreign Secretary James Cleverly raises issue of BBC tax searches with EAM Jaishankar",
            "Cooking gas prices hiked by ₹50 for domestic, ₹350.50 for commercial cylinders",
            "Joe Biden appoints two prominent Indian-American corporate leaders to his Export Council",
            "Sergey Lavrov will raise suspected bombing of Nord Stream II at G20: Russian Foreign Ministry",
            "Belarusian leader Lukashenko visits China amid Ukraine tensions",
            "China rips new U.S. House committee on countering Beijing",
            "Largest gathering of Foreign Ministers hosted by any G20 presidency: Foreign Secretary Vinay Kwatra")

        // Layout Manager is used to set the item inside the recycler view vertically , scrolling , horizontally ,uniform grid
        myRecyclerView.layoutManager = LinearLayoutManager(this)

        newsArrayList = arrayListOf<News>()

        for(index in newsImage.indices){

        val news = News(newsHeading[index]  ,  newsImage[index])
            newsArrayList.add(news)
        }

        myRecyclerView.adapter = myAdapter(newsArrayList , this)
    }
}