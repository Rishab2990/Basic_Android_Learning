package com.example.recyclerview

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class myAdapter(val newsArrayList: ArrayList<News> , var context : Activity):RecyclerView.Adapter<myAdapter.MyViewHolder>(){


    //To create new view instance
    //when layout manager are failed to find view for each item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myAdapter.MyViewHolder {
        // this piece of code is used to create view for every item
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.eachrow ,parent,false)
        return MyViewHolder(itemView)

    }

    //populate item with data
    override fun onBindViewHolder(holder: myAdapter.MyViewHolder, position: Int) {
        //used to check the item position
        var currentItem = newsArrayList[position]
        holder.hTitle.text = currentItem.NewsHeading
        holder.hImage.setImageResource(currentItem.NewsImage)
    }


    // how many item are present in array
    override fun getItemCount(): Int {
      return newsArrayList.size
    }

    // viewholder are used  for : It hold the view so that view are not created everytime so that memory can be saved
    class MyViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {

        val hTitle = itemView.findViewById<TextView>(R.id.headingTitle)
        val hImage = itemView.findViewById<ShapeableImageView>(R.id.headingImage)

    }



}