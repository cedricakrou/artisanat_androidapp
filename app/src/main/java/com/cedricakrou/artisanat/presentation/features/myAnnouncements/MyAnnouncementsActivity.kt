package com.cedricakrou.artisanat.presentation.features.myAnnouncements

import android.content.Intent
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.cedricakrou.artisanat.R
import com.cedricakrou.artisanat.domain.entities.Speciality
import com.cedricakrou.artisanat.presentation.common.BaseActivity
import com.cedricakrou.artisanat.presentation.common.getMessage
import com.cedricakrou.artisanat.presentation.features.StoreData
import com.cedricakrou.artisanat.presentation.features.announcement.ui.AnnouncementActivity
import kotlinx.android.synthetic.main.activity_my_announcements.*
import kotlinx.android.synthetic.main.layout_loading.*

class MyAnnouncementsActivity : BaseActivity<
        MyAnnoucementIntent,
        MyAnnoucementAction,
        MyAnnoucementState,
        MyAnnouncementViewModel> ( MyAnnouncementViewModel::class.java ) {


    var specialityChoose : String = ""



    override fun getLayoutResId(): Int = R.layout.activity_my_announcements


    override fun initUI() {

    }

    override fun initDATA() {

    }

    override fun initEVENT() {
        if (StoreData.listSpecialities.isEmpty()) dispatchIntent( MyAnnoucementIntent.INIT )


        btn_submit.setOnClickListener {
            dispatchIntent(
                MyAnnoucementIntent.SUBMIT(
                    title = edt_title.text.toString(),
                    description = edt_description.text.toString(),
                    client = StoreData.clientConnected.username,
                    speciality = specialityChoose
                )
            )
        }

    }

    override fun render(state: MyAnnoucementState) {
        when( state ) {

            is MyAnnoucementState.LOADING -> {

                ll_body.visibility = View.GONE
                loading_bar.visibility = View.VISIBLE

            }

            is MyAnnoucementState.Error -> {
                ll_body.visibility = View.VISIBLE
                loading_bar.visibility = View.GONE
                Toast.makeText( this, "Erreur " + state.exception.getMessage(this)  , Toast.LENGTH_LONG ).show()
            }

            is MyAnnoucementState.Success -> {

                ll_body.visibility = View.VISIBLE
                loading_bar.visibility = View.GONE

                val response = state.response

                if ( response.error ) {
                    Toast.makeText( this, response.message, Toast.LENGTH_LONG ).show()
                }
                else {
                    Toast.makeText( this, "Annonce créee", Toast.LENGTH_LONG ).show()

                    val intent = Intent( this, AnnouncementActivity::class.java )
                    startActivity( intent )

                    finish()
                }

            }

            is MyAnnoucementState.SuccessLoad -> {

                ll_body.visibility = View.VISIBLE
                loading_bar.visibility = View.GONE

                val response = state.response

                if ( response.error ) {
                    Toast.makeText( this, response.message, Toast.LENGTH_LONG ).show()
                }
                else {

                    StoreData.listSpecialities = response.data!!

                    initSpinner( response.data!! )

                }

            }

        }
    }

    fun initSpinner(  list : List<Speciality>) {

        val listString : MutableList<String> = mutableListOf()
        list.forEach {
            listString.add( it.name )
        }

        val arrayAdapterTypeSous: ArrayAdapter<String> = ArrayAdapter<String>(
            this,
            android.R.layout.simple_spinner_item,
            listString
        )
        arrayAdapterTypeSous.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spn_speciality.adapter = arrayAdapterTypeSous
        spn_speciality.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                specialityChoose = parent.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

    }
}