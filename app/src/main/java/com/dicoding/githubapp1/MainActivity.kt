package com.dicoding.githubapp1

import android.content.Intent
import android.content.res.TypedArray
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    lateinit var adapter: UserAdapter
    private lateinit var dataAvatar: TypedArray
    private lateinit var dataUsername: Array<String>
    private lateinit var dataName: Array<String>
    private lateinit var dataLocation: Array<String>
    private lateinit var dataRepository: Array<String>
    private lateinit var dataCompany: Array<String>
    private lateinit var dataFollowers: Array<String>
    private lateinit var dataFollowing: Array<String>
    private lateinit var users: ArrayList<UserData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        prepare()

        adapter = UserAdapter(this, addItem())
        newlist.adapter = adapter
        newlist.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val newDataUser = UserData(
                    0,"","","","","", "", "")
            newDataUser.avatar = dataAvatar.getResourceId(position, position)
            newDataUser.username = dataUsername [position]
            newDataUser.name = dataName [position]
            newDataUser.location = dataLocation [position]
            newDataUser.repository = dataRepository [position]
            newDataUser.company = dataCompany [position]
            newDataUser.followers = dataFollowers [position]
            newDataUser.following = dataFollowing [position]

            val intent = Intent(this@MainActivity, UserDetail::class.java)
            intent.putExtra(UserDetail.EXTRA_DATA, newDataUser)

            this@MainActivity.startActivity(intent)
            Toast.makeText(this@MainActivity, users[position].name, Toast.LENGTH_SHORT).show()
        }


    }

    private fun prepare() {
        dataAvatar = resources.obtainTypedArray(R.array.avatar)
        dataUsername = resources.getStringArray(R.array.username)
        dataName = resources.getStringArray(R.array.name)
        dataLocation = resources.getStringArray(R.array.location)
        dataRepository = resources.getStringArray(R.array.repository)
        dataCompany = resources.getStringArray(R.array.company)
        dataFollowers = resources.getStringArray(R.array.followers)
        dataFollowing = resources.getStringArray(R.array.following)
    }

    private fun addItem(): ArrayList<UserData> {
        users = ArrayList()
        for(i in dataName.indices){
        val user = UserData()
            user.avatar = dataAvatar.getResourceId(i, -1)
            user.name = dataName[i]
            user.company = dataCompany [i]
            user.location = dataLocation [i]
            users.add(user)
        }
        return users
    }
}

