package com.example.own.daos

import com.example.own.Models.User
import com.example.own.register_activity
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_register_activity.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class Userdao {
    fun getUserByUid(uid: String): Task<DocumentSnapshot> {
    return userCollection.document(uid).get()
}
    private val db = FirebaseFirestore.getInstance()
    private val userCollection = db.collection("Users")

    fun addUser(user: User?) {
        user?.let {
            GlobalScope.launch(Dispatchers.IO) {
                userCollection.document(user.uid).set(it)

            }

        }



    }
}