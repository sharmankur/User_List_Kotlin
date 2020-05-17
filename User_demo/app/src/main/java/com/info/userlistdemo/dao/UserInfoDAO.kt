package com.info.userlistdemo.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.info.userlistdemo.model.UserModel
import io.reactivex.Flowable
@Dao
interface UserInfoDAO {

    @Query("Select * from UserModel")
    fun getUserInfo(): Flowable<List<UserModel>?>



    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(userModel: UserModel)
}