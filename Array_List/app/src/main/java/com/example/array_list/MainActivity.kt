package com.example.array_list

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

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

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
//        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.setHasFixedSize(true)

        val itemList = listOf(
            itemList("Judul 1","Deskripsi 1",
                "https://i.pinimg.com/originals/40/29/e8/4029e81f1da34e646b778f8dae172d65.jpg"),
            itemList("Judul 2","Deskripsi 2",
                "https://i.pinimg.com/originals/40/29/e8/4029e81f1da34e646b778f8dae172d65.jpg"),
            itemList("Judul 3","Deskripsi 3",
                "https://i.pinimg.com/originals/40/29/e8/4029e81f1da34e646b778f8dae172d65.jpg")
        )
        val adapter= AdapterList(itemList)
        recyclerView.adapter = adapter
    }
}