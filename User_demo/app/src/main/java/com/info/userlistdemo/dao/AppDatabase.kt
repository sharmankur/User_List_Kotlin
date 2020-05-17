package com.info.userlistdemo.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.info.userlistdemo.model.UserModel

const val DATABASE_NAME = "user_db"
@Database(entities = [UserModel::class], version = 3,exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userInfoDAO(): UserInfoDAO

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getAppDatabase(context: Context): AppDatabase {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext, AppDatabase::class.java,
                        DATABASE_NAME
                    ).fallbackToDestructiveMigration().build();

                }
            }
            return INSTANCE!!
        }

    }
}