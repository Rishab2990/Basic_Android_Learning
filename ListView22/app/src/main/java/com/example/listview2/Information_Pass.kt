package com.example.listview2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class Information_Pass : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_information_pass)

        val name = intent.getStringExtra("name")
        val phone = intent.getStringExtra("number")
        val image = intent.getIntExtra("userImage" , R.drawable.human)


        val image1 = findViewById<CircleImageView>(R.id.profile_image)
        val name1 =findViewById<TextView>(R.id.name)
        val number1 =findViewById<TextView>(R.id.number)

        image1.setImageResource(image)
        name1.text = name
        number1.text = phone





    }
}