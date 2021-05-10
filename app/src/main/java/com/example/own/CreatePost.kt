package com.example.own

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.own.Models.username
import com.example.own.daos.PostDao
import kotlinx.android.synthetic.main.activity_create_post.*
import kotlinx.android.synthetic.main.activity_register_activity.*

class CreatePost : AppCompatActivity() {
    private lateinit var postdao: PostDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_post)
postdao = PostDao()
postbutton.setOnClickListener {


val input = createPost.text.toString().trim()
         if (input.isNotEmpty()){
           postdao.addPost(input)
         }

          val intent = Intent(this, MainActivity::class.java)
    startActivity(intent)
    finish()
       }


    }



}