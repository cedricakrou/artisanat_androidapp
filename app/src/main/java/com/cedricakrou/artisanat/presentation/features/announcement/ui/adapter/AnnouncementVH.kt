package com.cedricakrou.artisanat.presentation.features.announcement.ui.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.announcement_item.view.*

class AnnouncementVH( itemView : View ) : RecyclerView.ViewHolder(itemView) {

    var reference = itemView.tv_announcements_reference

    var title: TextView = itemView.tv_announcements_title

    var description: TextView = itemView.tv_announcements_description

    var date: TextView = itemView.tv_announcements_date

    var client: TextView = itemView.tv_announcements_client

    var speciality: TextView = itemView.tv_announcements_speciality

}