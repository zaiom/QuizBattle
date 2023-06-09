package com.example.quizbattle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.quizbattle.databinding.ActivityAddQuizBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError

class AddQuizActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var binding: ActivityAddQuizBinding


    //private var mQuestionsList: ArrayList<Question>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*val listview = findViewById<ListView>(R.id.myListView)
        val names = arrayOf("html", "Css", "php")

        val arrayAdapter: ArrayAdapter<String> = ArrayAdapter(
            this, android.R.layout.simple_list_item_1, names)

        listview.adapter = arrayAdapter

        listview.setOnItemClickListener { adapterView, view, i, l ->
            Toast.makeText(this, "Item Selected " + names[i], Toast.LENGTH_SHORT).show()
        }*/


        val spinner: Spinner = findViewById(R.id.spinner)
        val adapter: ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(this,R.array.categories, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = this





    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        val text: String = p0?.getItemAtPosition(p2).toString()
        Toast.makeText(p0?.context, text, Toast.LENGTH_SHORT).show()

    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        // metoda może pozostać pusta
    }
}


