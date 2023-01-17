package ru.novotelecom.recyclertest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recyclerView.adapter = CustomRecyclerAdapter(fillList(), object : SettingsItemListener {
            override fun onItemClick(position: Int) {
                Log.e("MainActivity", "onItemClick")
            }

            override fun onFocusChanged() {
                Log.e("MainActivity", "onFocusChanged")
            }
        })

        recyclerView.setOnClickListener {
            Log.e("MainActivity", "OnClickListener")
        }
        recyclerView.setOnFocusChangeListener { view, b ->
            Log.e("MainActivity", "OnFocusChangeListener")
        }

        val button: Button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            recyclerView.requestFocus()
            recyclerView.getChildAt(0).requestFocus();
        }
    }

    private fun fillList(): List<String> {
        val data = mutableListOf<String>()
        (0..30).forEach { i -> data.add("$i element") }
        return data
    }
}