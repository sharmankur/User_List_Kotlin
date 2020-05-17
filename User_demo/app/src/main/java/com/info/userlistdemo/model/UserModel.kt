package com.info.userlistdemo.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserModel(
    @PrimaryKey
    @ColumnInfo(name="fName")
    var fName: String,
    @ColumnInfo(name="lName")
    var lName: String?,
    @ColumnInfo(name = "phNo")
    var phNo: String?,
    @ColumnInfo(name = "city")
    var city: String?,
    @ColumnInfo(name = "state")
    var state: String?,
    @ColumnInfo(name = "pinCode")
    var pinCode: String?
)



