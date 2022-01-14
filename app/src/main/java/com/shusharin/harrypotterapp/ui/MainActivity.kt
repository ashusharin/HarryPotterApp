package com.shusharin.harrypotterapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.shusharin.harrypotterapp.R
import com.shusharin.harrypotterapp.core.PotterApp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewModel = (application as PotterApp).mainViewModel

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = PersonAdapter(object : PersonAdapter.Retry {
            override fun tryAgain() {
                viewModel.fetchPerson()
            }
        })
        recyclerView.adapter = adapter
        viewModel.observe(this, {
            adapter.update(it)
        })
        viewModel.fetchPerson()
    }
}