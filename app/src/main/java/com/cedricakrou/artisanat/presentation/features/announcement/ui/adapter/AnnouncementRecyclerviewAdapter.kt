package com.cedricakrou.artisanat.presentation.features.announcement.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cedricakrou.artisanat.R
import com.cedricakrou.artisanat.domain.entities.Announcement

class AnnouncementRecyclerviewAdapter( val context: Context, val list: MutableList<Announcement> ) : RecyclerView.Adapter<AnnouncementVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnnouncementVH {

        val view = LayoutInflater.from(context).inflate( R.layout.announcement_item , parent, false )

        return AnnouncementVH( view )
    }

    override fun onBindViewHolder(holder: AnnouncementVH, position: Int) {

        val announcement = list[position]

        holder.reference.text = announcement.reference
        holder.title.text = announcement.title
        holder.client.text = announcement.client!!.firstname + " " + announcement.client!!.lastname
        holder.date.text = announcement.date
        holder.description.text = announcement.description
        holder.speciality.text = announcement.speciality!!.name
        holder.reference.text = announcement.reference

    }

    override fun getItemCount(): Int = list.size
}