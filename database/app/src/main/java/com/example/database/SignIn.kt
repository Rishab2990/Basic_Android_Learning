package com.example.database

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignIn : AppCompatActivity() {
     private lateinit var databaseReference: DatabaseReference

    companion object{
        const val  Key =  "com.example.database.Key.mail"
        const val  Key1 =  "com.example.database.Key.name"
        const val  Key2 =  "com.example.database.Key.phone"
        const val  Key3 =  "com.example.database.Key.id"
    }
    @SuppressLint("MissingInflatedId", "SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val id = findViewById<EditText>(R.id.unique)
        val button  = findViewById<Button>(R.id.button)

        button.setOnClickListener{

          val uniqueId= id.text.toString()
          if(uniqueId.isNotEmpty()){
              
              readdata(uniqueId)

          }  else{
              Toast.makeText(this, "Enter User Name" , Toast.LENGTH_SHORT).show()

          }

        }





    }

    private fun readdata(uniqueId: String) {

       databaseReference = FirebaseDatabase.getInstance().getReference("Users")
        databaseReference.child(uniqueId).get().addOnSuccessListener {
            Toast.makeText(this, "Sign In Successful" , Toast.LENGTH_SHORT).show()

            if(it.exists()){
                val mail = it.child("mail").value
                val name = it.child("name").value
                val phone = it.child("phone").value
                val id = it.child("id").value

                val intentWelcome = Intent(this, Information ::class.java)
                intentWelcome.putExtra(Key,mail.toString())
                intentWelcome.putExtra(Key1,name.toString())
                intentWelcome.putExtra(Key2,phone.toString())
                intentWelcome.putExtra(Key3,id.toString())
                startActivity(intentWelcome)
            }
            else{
                Toast.makeText(this,"User does not exist " , Toast.LENGTH_SHORT).show()
            }
        }
            .addOnFailureListener{
                Toast.makeText(this,"Failed" , Toast.LENGTH_SHORT).show()
            }

    }
}