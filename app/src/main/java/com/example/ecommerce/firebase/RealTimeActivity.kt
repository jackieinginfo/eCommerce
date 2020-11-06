package com.example.ecommerce.firebase

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ecommerce.R
import com.example.ecommerce.data.model.DatabaseModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

public class RealTimeActivity : AppCompatActivity() {


    private lateinit var database: FirebaseDatabase
    private lateinit var ref: DatabaseReference

    private val Rname: EditText = findViewById(R.id.iname)
    private val Rmail: EditText = findViewById(R.id.imail)
    private val button: Button = findViewById(R.id.add)
    private val button1: Button = findViewById(R.id.leer)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_real_time)
        button.setOnClickListener() {

            sendData()
        }
        button1.setOnClickListener() {
            startActivity(Intent(this, Getdata::class.java))

        }

        database = FirebaseDatabase.getInstance()
        ref = database.getReference("Users")
    }


     fun sendData() {

        val name = Rname.text.toString().trim()
        val mail = Rmail.text.toString().trim()

        if (mail.isNotEmpty() && name.isNotEmpty()) {

            var model = DatabaseModel(name, mail)
            var id = ref.push().key

            //here we send the data
            ref.child(id!!).setValue(model)

            Rname.setText(" ")
            Rmail.setText(" ")

        }

        else Toast.makeText(this,
            "all field Required",
            Toast.LENGTH_LONG
        ).show()

    }
}




