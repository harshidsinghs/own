package com.example.own.daos

import com.example.own.Models.User
import com.example.own.Models.username
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class usernamedao {

    fun getuserbyname(name: username): Task<DocumentSnapshot> {
        return userCollection.document(name.toString()).get()
    }
    private val db = FirebaseFirestore.getInstance()
    private val userCollection = db.collection("Username")

    fun addUsername(users: username?) {
        users?.let {
            GlobalScope.launch(Dispatchers.IO) {
                userCollection.document(users.usernames).set(it)

            }

        }
}
}