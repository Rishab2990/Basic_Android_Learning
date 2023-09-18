package com.example.listview2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

   private lateinit var  userArrayList : ArrayList<Users>

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = arrayOf("Rishab" , "Rohan" , "Ricky" , "Shubham" ,"Pankaj")
        val message = arrayOf("Hello Everyone" , "Nice To meet you" , "how's going", "cool" , "very nice")
        val time = arrayOf("1:00 PM" , "2:00 AM" , "3:00 AM" , "4:00 AM" , "5:00 AM" )
        val number = arrayOf("0001112220" , "7893214560" , "0137984562" , "9876543210" , "1234567890" )
        val image = arrayOf(R.drawable.human , R.drawable.aihuman1 , R.drawable.aihuman2 , R.drawable.aihuma2, R.drawable.aihuman4)

        userArrayList = ArrayList()

        for(eachIndex in name.indices){

            val user = Users(name[eachIndex],message[eachIndex],time[eachIndex],number[eachIndex],image[eachIndex])
            userArrayList.add(user)

        }
        val listview = findViewById<ListView>(R.id.listview)
      //  listview.isClickable = true

        //Android Custom Adapter
        listview.adapter = MyAdapter(this,userArrayList)

        listview.setOnItemClickListener { parent, view, position, id ->
            val userName = name[position]
            val userNumber = number[position]
            val userImage = image[position]

          val info = Intent(this,Information_Pass::class.java)

             info.putExtra("name" , userName)
             info.putExtra("number", userNumber)
             info.putExtra("userImage" , userImage)
              startActivity(info)




        }

    }
}