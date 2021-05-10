package com.example.own

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_register_activity.*
import kotlinx.android.synthetic.main.login.*


class login : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

register.setOnClickListener {
val intent = Intent(this, register_activity::class.java)
    startActivity(intent)
}

     button.setOnClickListener {
signIn()
         progressBar2.visibility = View.VISIBLE
         textView3.visibility = View.GONE
     }
    }
    private fun signIn() {
        val ref = FirebaseAuth.getInstance()
        auth = Firebase.auth

            ref.signInWithEmailAndPassword(
                    email.text.toString().trim(),
                    password.text.toString().trim()

            ).addOnSuccessListener {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
                    .addOnFailureListener {
                        textView2.text = "false info"
                progressBar2.visibility = View.GONE
                textView3.visibility = View.VISIBLE
                    }

      }



}
