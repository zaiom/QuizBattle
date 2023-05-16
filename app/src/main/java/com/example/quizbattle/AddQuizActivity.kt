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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val spinner: Spinner = findViewById(R.id.spinner)
        val adapter: ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(this,R.array.categories, android.R.layout.simple_spinner_dropdown_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        spinner.onItemSelectedListener = this

        binding.root.findViewById<View>(R.id.acceptButton).setOnClickListener {

            val intent = Intent(this, QuestionActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        val item: String = p0?.getItemAtPosition(p2).toString()
        //Toast.makeText(p0?.context, item, Toast.LENGTH_SHORT).show()
        if (item == "Losowo")
        {
           val  p2 = (0 until p3).random()
           println(p2)
            val item: String = p0?.getItemAtPosition(p2.toInt()).toString()
            Constants.node = item
            }
        else {
            Constants.node = item
        }

    }


    override fun onNothingSelected(p0: AdapterView<*>?) {
        // pusta implementacja metody
    }


}


