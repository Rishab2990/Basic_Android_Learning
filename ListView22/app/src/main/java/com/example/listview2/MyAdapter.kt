package com.example.listview2

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class MyAdapter(private val context: Activity, private val arrayList: ArrayList<Users>) : ArrayAdapter<Users>(context , R.layout.eachrow , arrayList){

    @SuppressLint("InflateParams", "ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater = LayoutInflater.from(context)

        val view  = inflater.inflate(R.layout.eachrow ,null)

        val image =view.findViewById<CircleImageView>(R.id.profile_image)
        val name = view.findViewById<TextView>(R.id.tvname)
        val message=view.findViewById<TextView>(R.id.tvmessage)
        val time = view.findViewById<TextView>(R.id.tvtime)

        name.text = arrayList[position].name
        message.text = arrayList[position].msg
        time.text = arrayList[position].time
        image.setImageResource(arrayList[position].imageId)


        return view
    }
}