package com.dicoding.githubapp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_user_detail.*

class UserDetail : AppCompatActivity() {
    companion object{
        var EXTRA_DATA = "0"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_detail)

        val activeUser : UserData? = intent.getParcelableExtra(EXTRA_DATA)


        detail_avatar.setImageResource(activeUser?.avatar!!)
        detail_username.text = getString(R.string.username, activeUser.username)
        detail_name.text = activeUser.name
        detail_location.text = getString(R.string.location, activeUser.location)
        detail_repository.text = getString(R.string.repository, activeUser.repository)
        detail_company.text = getString(R.string.company, activeUser.company)
        detail_followers.text = getString(R.string.followers, activeUser.followers)
        detail_following.text = getString(R.string.following, activeUser.following)

    }

}