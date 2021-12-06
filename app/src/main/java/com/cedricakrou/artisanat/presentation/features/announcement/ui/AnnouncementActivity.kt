package com.cedricakrou.artisanat.presentation.features.announcement.ui

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cedricakrou.artisanat.R
import com.cedricakrou.artisanat.domain.entities.Announcement
import com.cedricakrou.artisanat.presentation.Utils
import com.cedricakrou.artisanat.presentation.common.BaseActivity
import com.cedricakrou.artisanat.presentation.common.getMessage
import com.cedricakrou.artisanat.presentation.features.announcement.AnnouncementAction
import com.cedricakrou.artisanat.presentation.features.announcement.AnnouncementIntent
import com.cedricakrou.artisanat.presentation.features.announcement.AnnouncementState
import com.cedricakrou.artisanat.presentation.features.announcement.AnnouncementViewModel
import com.cedricakrou.artisanat.presentation.features.announcement.ui.adapter.AnnouncementRecyclerviewAdapter
import com.cedricakrou.artisanat.presentation.features.home.ui.HomeActivity
import com.cedricakrou.artisanat.presentation.features.myAnnouncements.MyAnnouncementsActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_announcements.*
import kotlinx.android.synthetic.main.annoncement.*
import kotlinx.android.synthetic.main.annoncement.ll_body
import kotlinx.android.synthetic.main.annoncement.recyclerview
import kotlinx.android.synthetic.main.layout_loading.*

class AnnouncementActivity : BaseActivity<AnnouncementIntent,
        AnnouncementAction,
        AnnouncementState,
        AnnouncementViewModel>( AnnouncementViewModel::class.java ) {

    lateinit var adapter : AnnouncementRecyclerviewAdapter

    var list : MutableList<Announcement> = mutableListOf()

    override fun getLayoutResId(): Int = R.layout.activity_announcements

    override fun initUI() {

        initAdapter( this, recyclerview, list )

        val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    val intent = Intent( this, HomeActivity::class.java )
                    startActivity( intent )
                    finish()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_announcements -> {
                    val intent = Intent( this, AnnouncementActivity::class.java )
                    startActivity( intent )
                    finish()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_settings-> {
                    finish()
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

        bottom_navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

    }


    override fun initDATA() {

    }

    override fun initEVENT() {
        dispatchIntent( AnnouncementIntent.INIT)

        btn_add_announce.setOnClickListener {

            val intent = Intent( this, MyAnnouncementsActivity::class.java )

            startActivity( intent )

            finish()
        }

    }

    override fun render(state: AnnouncementState) {

        when( state ) {
            is AnnouncementState.LOADING -> {
                Utils.hideAndShowView( ll_body, loading_bar )
            }
            is AnnouncementState.Error -> {
                Utils.hideAndShowView( loading_bar, ll_body )
                Toast.makeText( this, state.exception.getMessage(this), Toast.LENGTH_LONG ).show()
            }
            is AnnouncementState.Success -> {

                Utils.hideAndShowView( loading_bar, ll_body )

                val response = state.response

                if ( response.error ) {
                    Toast.makeText( this, response.message, Toast.LENGTH_LONG ).show()
                }
                else {

                    list = response.data as MutableList<Announcement>

                    initAdapter( context = this, recyclerview, list )

                }


            }
        }

    }


    fun initAdapter(context : Context, recyclerView: RecyclerView, list : MutableList<Announcement> ) {

        adapter = AnnouncementRecyclerviewAdapter( context, list )

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

        recyclerView.scrollToPosition(list.size - 1)
    }


}