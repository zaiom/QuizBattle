package com.example.quizbattle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.example.quizbattle.databinding.ActivityAddQuizBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError

class AddQuizActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddQuizBinding


    private var mQuestionsList: ArrayList<Question>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listview = findViewById<ListView>(R.id.myListView)
        val names = arrayOf("html", "Css", "php")

        val arrayAdapter: ArrayAdapter<String> = ArrayAdapter(
            this, android.R.layout.simple_list_item_1, names)

        listview.adapter = arrayAdapter

        listview.setOnItemClickListener { adapterView, view, i, l ->
            Toast.makeText(this, "Item Selected " + names[i], Toast.LENGTH_SHORT).show()
        }

    }
}


