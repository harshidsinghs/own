package com.example.own

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.own.Models.Post
import com.example.own.Models.username
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions

class postadapter(options: FirestoreRecyclerOptions<Post>, val listener: MainActivity) :
    FirestoreRecyclerAdapter<Post, postadapter.postviewholder>(
    options
) {
    class postviewholder(itemview: View):RecyclerView.ViewHolder(itemview) {
        val username: TextView = itemview.findViewById(R.id.userrrrrr)
        val createdat: TextView = itemview.findViewById(R.id.createdAt)
        val Text: TextView = itemview.findViewById(R.id.postedText)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): postviewholder {

        val viewholder = postviewholder(LayoutInflater.from(parent.context).inflate(R.layout.feed,parent,false))

        return viewholder
    }
    override fun onBindViewHolder(holder: postviewholder, position: Int ,model: Post) {

        holder.username.text = model.createdBy.uid
        holder.Text.text = model.text
        holder.createdat.text = utils.getTimeAgo(model.createdAt)
    }

}