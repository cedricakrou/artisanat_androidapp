package com.cedricakrou.artisanat.presentation.features.announcement.ui

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cedricakrou.artisanat.R
import com.cedricakrou.artisanat.domain.entities.Announcement
import com.cedricakrou.artisanat.domain.entities.Client
import com.cedricakrou.artisanat.domain.entities.Speciality
import com.cedricakrou.artisanat.presentation.common.BaseActivity
import com.cedricakrou.artisanat.presentation.features.announcement.AnnouncementAction
import com.cedricakrou.artisanat.presentation.features.announcement.AnnouncementIntent
import com.cedricakrou.artisanat.presentation.features.announcement.AnnouncementState
import com.cedricakrou.artisanat.presentation.features.announcement.AnnouncementViewModel
import com.cedricakrou.artisanat.presentation.features.announcement.ui.adapter.AnnouncementRecyclerviewAdapter
import kotlinx.android.synthetic.main.annoncement.*

class AnnouncementActivity : BaseActivity<AnnouncementIntent,
        AnnouncementAction,
        AnnouncementState,
        AnnouncementViewModel>( AnnouncementViewModel::class.java ) {

    var list : MutableList<Announcement> = mutableListOf(

        Announcement().apply {
            title = "text"
            description = "xdgfchjvbkxdgfchvjbkxcgvhbjxfchgvjhbkjxdgfchgvjhbdwxgfchgvjxfcgvhjcghvxchgvcvcv"
            client = Client().apply {
                firstname = "cedric"
                lastname = "akroou"
            }
            speciality = Speciality().apply {
                name = "Cedric Akrou"
            }
            date = "22/15/2020"
            reference = "22/10/2021"
        },

        Announcement().apply {
            title = "text"
            description = "xdgfchjvbkxdgfchvjbkxcgvhbjxfchgvjhbkjxdgfchgvjhbdwxgfchgvjxfcgvhjcghvxchgvcvcv"
            client = Client().apply {
                firstname = "cedric"
                lastname = "akroou"
            }
            speciality = Speciality().apply {
                name = "Cedric Akrou"
            }
            date = "22/15/2020"
            reference = "22/10/2021"
        },

        Announcement().apply {
            title = "text"
            description = "xdgfchjvbkxdgfchvjbkxcgvhbjxfchgvjhbkjxdgfchgvjhbdwxgfchgvjxfcgvhjcghvxchgvcvcv"
            client = Client().apply {
                firstname = "cedric"
                lastname = "akroou"
            }
            speciality = Speciality().apply {
                name = "Cedric Akrou"
            }
            date = "22/15/2020"
            reference = "22/10/2021"
        }
    )



    override fun getLayoutResId(): Int = R.layout.activity_announcements

    override fun initUI() {

        initAdapter( this, recyclerview, list )

    }

    override fun initDATA() {

    }

    fun initAdapter(context : Context, recyclerView: RecyclerView, list : MutableList<Announcement> ) {

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = AnnouncementRecyclerviewAdapter( context, list )

        recyclerView.scrollToPosition(list.size - 1)
    }

    override fun initEVENT() {

    }

    override fun render(state: AnnouncementState) {
        TODO("Not yet implemented")
    }
}