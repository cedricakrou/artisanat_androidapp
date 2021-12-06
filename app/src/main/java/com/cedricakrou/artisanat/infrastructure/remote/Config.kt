package com.cedricakrou.artisanat.infrastructure.remote

object Config {
    const val API_BASE_URL = "http://192.168.193.206:8080/api/v1/"

    const val client = "client/"

    const val signIn = "${client}sign-in"
    const val signUp = "${client}sign-up"
    const val verifyOtp = "${client}verify-otp"

    const val announcements = "announcement/"

    const val save = "${announcements}save"
    const val listAnnouncements = "${ announcements}list-announcements"
    const val myAnnouncements = "${ announcements }my-announcements"
}