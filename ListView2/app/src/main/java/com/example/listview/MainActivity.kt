package com.example.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.listView)

        val  listItem = arrayListOf<String>()
        listItem.add("Create Resume")
        listItem.add("learn listView")
        listItem.add("learn Recycler View")
        listItem.add("create a project")
        listItem.add("Add project on github")

        val listItemAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1 , listItem)
        listView.adapter = listItemAdapter

        listView.setOnItemClickListener { parent, view, position, id ->
          val clicking = "Clicked On Item : " +  (view as TextView).text.toString()
            Toast.makeText(this,"clicking", Toast.LENGTH_SHORT).show()
        }

    }
}