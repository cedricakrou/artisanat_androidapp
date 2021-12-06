package com.cedricakrou.artisanat.presentation.features.home.ui

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
import com.cedricakrou.artisanat.presentation.features.announcement.ui.AnnouncementActivity
import com.cedricakrou.artisanat.presentation.features.announcement.ui.adapter.AnnouncementRecyclerviewAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_home.recyclerview
import kotlinx.android.synthetic.main.layout_loading.*

class HomeActivity : BaseActivity<
        HomeIntent,
        HomeAction,
        HomeState,
        HomeViewModel>( HomeViewModel::class.java )
{

    lateinit var adapter : AnnouncementRecyclerviewAdapter

    var list : MutableList<Announcement> = mutableListOf()

    override fun getLayoutResId(): Int = R.layout.activity_home

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

            }
            false
        }


        bottom_navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

    }


    override fun initDATA() {

    }

    override fun initEVENT() {
        dispatchIntent( HomeIntent.INIT)
    }

    override fun render(state: HomeState) {

        when( state ) {
            is HomeState.LOADING -> {
                Utils.hideAndShowView( ll_body, loading_bar )
            }
            is HomeState.Error -> {
                Utils.hideAndShowView( loading_bar, ll_body )
                Toast.makeText( this, state.exception.getMessage(this), Toast.LENGTH_LONG ).show()
            }
            is HomeState.Success -> {

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