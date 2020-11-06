package com.example.ecommerce.firebase

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.ecommerce.R
import com.example.ecommerce.data.model.DatabaseModel
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_getdata.*

class Getdata : AppCompatActivity() {
    private lateinit var database: FirebaseDatabase
    private lateinit var ref: DatabaseReference

    val Rname: EditText = findViewById(R.id.iname)
    val Rmail: EditText = findViewById(R.id.imail)
    val button: Button = findViewById(R.id.add)
    val button1: Button = findViewById(R.id.add)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_getdata)


        database = FirebaseDatabase.getInstance()
        ref = database.getReference("Users")

        getData()
    }


    private fun getData() {
        ref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {

                Log.e("cancel", p0.toString())
            }

            override fun onDataChange(p0: DataSnapshot) {
                var list = ArrayList<DatabaseModel>()
                for(data in p0.children)
                {
                    var model = data.getValue(DatabaseModel::class.java)
                    list.add(model as DatabaseModel)
                }
                if(list.size>0) {

                    val adapter = DataAdapter(list)
                    rcyc.adapter = adapter
                }
            }

        })


    }
}
