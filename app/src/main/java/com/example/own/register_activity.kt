package com.example.own

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.own.Models.User
import com.example.own.Models.username
import com.example.own.daos.Userdao
import com.example.own.daos.usernamedao
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_register_activity.*

class register_activity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_activity)

        auth = Firebase.auth

        register_button.setOnClickListener {
            val firebaseUser :FirebaseUser

            val uss = USERNAME.text.toString().trim()
            val ii = username(uss,)
            val usernamedao = usernamedao()

            if (uss.isNotEmpty()){

                usernamedao.addUsername(ii,)

                createAccount()
                progressBar.visibility = View.VISIBLE
                textView34.visibility = View.GONE}

        }
    }
    private fun createAccount() {





        val ref2 = FirebaseAuth.getInstance()
        auth = Firebase.auth

    ref2.createUserWithEmailAndPassword(
            email2.text.toString().trim(),
    password2.text.toString().trim()
    )
    .addOnSuccessListener {
        Toast.makeText(this, "account created successfully", Toast.LENGTH_SHORT).show()

        val intent2 = Intent(this, MainActivity::class.java)
        startActivity(intent2)
    }
            .addOnFailureListener {
                note.text = "account creation failed"
                progressBar.visibility = View.GONE
                textView34.visibility = View.VISIBLE


    }
    }

    override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUsers = auth.currentUser


         updateUI(currentUsers,)

    }



    private fun updateUI(firebaseUser: FirebaseUser?
    ) {
val uper = USERNAME.text.toString()
        if (firebaseUser != null){

val user = User (firebaseUser.uid)


            val intent = Intent(this, MainActivity::class.java)

            val usersdao = Userdao()
            usersdao.addUser(user)

            startActivity(intent)
            finish()

        }

    }
}