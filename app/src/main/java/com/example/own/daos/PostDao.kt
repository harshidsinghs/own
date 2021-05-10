package com.example.own.daos

import com.example.own.Models.Post
import com.example.own.Models.User
import com.example.own.Models.username
import com.example.own.register_activity
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_register_activity.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class PostDao {

    private val db = FirebaseFirestore.getInstance()
    val postCollection = db.collection("Posts")
    private val auth = Firebase.auth

    private val currentUserId = auth.currentUser!!.uid

    fun addPost(text: String) {
        GlobalScope.launch(Dispatchers.IO) {
            val userDao = Userdao()



            val user = userDao.getUserByUid(currentUserId).await().toObject(User::class.java)!!
            val currentTime = System.currentTimeMillis()

            val post = Post(text, user, currentTime, )

            postCollection.document().set(post)


        }
    }
    fun getPostById(postId: String): Task<DocumentSnapshot> {
        return postCollection.document(postId).get()
    }


    
}