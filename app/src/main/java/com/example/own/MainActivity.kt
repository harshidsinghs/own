package com.example.own

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.own.Models.Post
import com.example.own.Models.username
import com.example.own.daos.PostDao
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.firestore.Query
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var postDao: PostDao
    private lateinit var adapter: postadapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
fab.setOnClickListener {
    val intent = Intent(this, CreatePost::class.java)
    startActivity(intent)
}
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
postDao = PostDao()
        val postCollect = postDao.postCollection
        val query = postCollect.orderBy("createdAt", Query.Direction.DESCENDING)
        val RecyclerViewOptions = FirestoreRecyclerOptions.Builder<Post>().setQuery(query, Post::class.java).build()
        adapter = postadapter(RecyclerViewOptions,this)
        RecyclerView.adapter = adapter
        RecyclerView.layoutManager = LinearLayoutManager(this)
    }
    override fun onStart() {
        super.onStart()
        adapter.startListening()
    }

    override fun onStop() {
        super.onStop()
        adapter.stopListening()
    }


}