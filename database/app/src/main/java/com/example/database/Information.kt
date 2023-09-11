package com.example.database

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Information : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_information)


        val name =  intent.getStringExtra(SignIn.Key1)
        val mail =  intent.getStringExtra(SignIn.Key)
        val phone =  intent.getStringExtra(SignIn.Key2)
        val id=  intent.getStringExtra(SignIn.Key3)

        val nam = findViewById<TextView>(R.id.name)
        val email = findViewById<TextView>(R.id.mail)
        val phon = findViewById<TextView>(R.id.number)
        val identity= findViewById<TextView>(R.id.unique)

        nam.text =        "Welcome $name"
        email.text =      "Welcome $mail"
        phon.text =       "Welcome $phone"
        identity.text ="  $id"

    }
}