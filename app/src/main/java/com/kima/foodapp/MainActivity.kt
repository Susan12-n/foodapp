package com.kima.foodapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetBehavior

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        fetch your recyclerview by id
        val recyclerview= findViewById<RecyclerView>(R.id.recylerview)

//        define the layout manager
//         the layout manager set the recycler views appear in vertical format
        val layoutmanager = LinearLayoutManager(applicationContext)
//        put the layout manager inside the recycler to make items appear vertical
        recyclerview.layoutManager = layoutmanager
//        get an instance of recycler adapter
//        the recycler adapter contains all the arrays
//        the arrays includes the images,titles,description and cost

        val adapter = RecyclerAdapter(applicationContext)
//        bind the data to recycler view
        recyclerview.adapter = adapter


//        find the bottom sheet by id
        val bottomsheet = findViewById<FrameLayout>(R.id.bottomsheet)
        BottomSheetBehavior.from(bottomsheet).apply {
            peekHeight = 350
            this.state = BottomSheetBehavior.STATE_COLLAPSED
        }
//    fetch order now button
            val btnorder =findViewById<Button>(R.id.ordernow)
        btnorder.setOnClickListener {
            val intent = Intent(applicationContext,OrderActivity::class.java)
            startActivity(intent)
        }

    }
}