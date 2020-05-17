package com.info.userlistdemo.activity

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.HorizontalScrollView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.info.userlistdemo.R
import com.info.userlistdemo.adapter.UserListAdapter
import com.info.userlistdemo.dao.DataRepository
import com.info.userlistdemo.dao.OnUserDataCallback
import com.info.userlistdemo.model.UserModel

class MainActivity : AppCompatActivity() {

    var userList = ArrayList<UserModel>()
    private lateinit var horizontalScrollView: HorizontalScrollView
    private lateinit var recyclerView: RecyclerView
    private lateinit var btnSave:Button
    private lateinit var btnCancel:Button
    private lateinit var userListAdapter: RecyclerView.Adapter<*>
    private lateinit var linearLayoutManager: RecyclerView.LayoutManager

    //simply initializing the tag for the screen logs.
    companion object {
        val TAG: String = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUserData()
        getUserData()
        initiliseView()
    }

    /**
     * initialize the components.
     */
    fun initiliseView() {
        linearLayoutManager = LinearLayoutManager(this)
        btnSave = findViewById(R.id.btnSave)
        btnCancel = findViewById(R.id.btnCancel)
        //getting recyclerview from xml
        recyclerView = findViewById(R.id.recUserList) as RecyclerView
        recyclerView?.layoutManager = linearLayoutManager

        btnSave.setOnClickListener(){
            Toast.makeText(this,"Save Clicked", Toast.LENGTH_SHORT).show()
        }
        btnCancel.setOnClickListener(){
            Toast.makeText(this,"Cancel clicked", Toast.LENGTH_SHORT).show()
        }


    }

    /**
     * fatch user data from db.
     */
    fun getUserData() {
        DataRepository.getUserInfo(this@MainActivity, object : OnUserDataCallback<List<UserModel>> {
            override fun onUserDataAvailable(data: List<UserModel>?) {
                Log.d(TAG, "userData ${data?.size}")
                userList = data as ArrayList<UserModel>
                setAdapter(userList);
            }
        })
    }

    /**
     * set adapter to recycler view.
     */
    fun setAdapter(userList: ArrayList<UserModel>) {
        userListAdapter = UserListAdapter(userList)
        //now adding the adapter to recyclerview
        recyclerView?.adapter = userListAdapter
    }

    /**
     * this method insert multiple records into the database.
     */
    fun setUserData() {

        //first record adding header row to db.
        DataRepository.insert(
            UserModel(
                getString(R.string.first_name), getString(R.string.last_name), getString(R.string.phone_number),
                getString(R.string.city), getString(R.string.state), getString(R.string.pincode)
            ), context = this@MainActivity
        )
        // adding other records to db.
        DataRepository.insert(
            UserModel(
                "Ankur1", "Sharma", "9098871605",
                "Indore", "MP", "452009"
            ), context = this@MainActivity
        )
        DataRepository.insert(
            UserModel(
                "Ankur2", "Sharma", "9098871605",
                "Indore", "MP", "452009"
            ), context = this@MainActivity
        )
        DataRepository.insert(
            UserModel(
                "Ankur3", "Sharma", "9098871605",
                "Indore", "MP", "452009"
            ), context = this@MainActivity
        )
        DataRepository.insert(
            UserModel(
                "Ankur4", "Sharma", "9098871605",
                "Indore", "MP", "452009"
            ), context = this@MainActivity
        )
        DataRepository.insert(
            UserModel(
                "Ankur5", "Sharma", "9098871605",
                "Indore", "MP", "452009"
            ), context = this@MainActivity
        )
        DataRepository.insert(
            UserModel(
                "Ankur6", "Sharma", "9098871605",
                "Indore", "MP", "452009"
            ), context = this@MainActivity
        )
        DataRepository.insert(
            UserModel(
                "Ankur7", "Sharma", "9098871605",
                "Indore", "MP", "452009"
            ), context = this@MainActivity
        )
        DataRepository.insert(
            UserModel(
                "Ankur8", "Sharma", "9098871605",
                "Indore", "MP", "452009"
            ), context = this@MainActivity
        )
        DataRepository.insert(
            UserModel(
                "Ankur9", "Sharma", "9098871605",
                "Indore", "MP", "452009"
            ), context = this@MainActivity
        )
        DataRepository.insert(
            UserModel(
                "Ankur10", "Sharma", "9098871605",
                "Indore", "MP", "452009"
            ), context = this@MainActivity
        )
        DataRepository.insert(
            UserModel(
                "Ankur11", "Sharma", "9098871605",
                "Indore", "MP", "452009"
            ), context = this@MainActivity
        )
        DataRepository.insert(
            UserModel(
                "Ankur12", "Sharma", "9098871605",
                "Indore", "MP", "452009"
            ), context = this@MainActivity
        )
        DataRepository.insert(
            UserModel(
                "Ankur13", "Sharma", "9098871605",
                "Indore", "MP", "452009"
            ), context = this@MainActivity
        )
        DataRepository.insert(
            UserModel(
                "Ankur14", "Sharma", "9098871605",
                "Indore", "MP", "452009"
            ), context = this@MainActivity
        )
        DataRepository.insert(
            UserModel(
                "Ankur15", "Sharma", "9098871605",
                "Indore", "MP", "452009"
            ), context = this@MainActivity
        )
        DataRepository.insert(
            UserModel(
                "Ankur16", "Sharma", "9098871605",
                "Indore", "MP", "452009"
            ), context = this@MainActivity
        )
        DataRepository.insert(
            UserModel(
                "Ankur17", "Sharma", "9098871605",
                "Indore", "MP", "452009"
            ), context = this@MainActivity
        )
        DataRepository.insert(
            UserModel(
                "Ankur18", "Sharma", "9098871605",
                "Indore", "MP", "452009"
            ), context = this@MainActivity
        )
        DataRepository.insert(
            UserModel(
                "Ankur19", "Sharma", "9098871605",
                "Indore", "MP", "452009"
            ), context = this@MainActivity
        )
        DataRepository.insert(
            UserModel(
                "Ankur20", "Sharma", "9098871605",
                "Indore", "MP", "452009"
            ), context = this@MainActivity
        )
        DataRepository.insert(
            UserModel(
                "Ankur21", "Sharma", "9098871605",
                "Indore", "MP", "452009"
            ), context = this@MainActivity
        )
        DataRepository.insert(
            UserModel(
                "Ankur22", "Sharma", "9098871605",
                "Indore", "MP", "452009"
            ), context = this@MainActivity
        )
        DataRepository.insert(
            UserModel(
                "Ankur23", "Sharma", "9098871605",
                "Indore", "MP", "452009"
            ), context = this@MainActivity
        )
    }


}

