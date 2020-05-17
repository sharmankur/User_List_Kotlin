package com.info.userlistdemo.dao
import android.content.Context
import com.info.userlistdemo.model.UserModel
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import java.lang.Exception
import io.reactivex.android.schedulers.AndroidSchedulers

/**
 * Creating a repository class for interacting with DB.
 * Here DataRepository as a Singleton class.
 */
object DataRepository {

    /**
     * This method returns the user data list.
     */
    fun getUserInfo(context: Context, databaseCallback: OnUserDataCallback<List<UserModel>>) {
        try {
            // accessing the user info from database and subscribing on it for data one data
            // available notify to callback.
            var dao = AppDatabase.getAppDatabase(context).userInfoDAO()
            dao.getUserInfo().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    databaseCallback.onUserDataAvailable(it)
                }
        } catch (e: Exception) {

        }
    }

    /**
     * This method will insert the user data record into room db.
     */
    fun insert(userModel: UserModel, context: Context) {
        var dao = AppDatabase.getAppDatabase(context).userInfoDAO()
        Single.fromCallable { dao.insert(userModel) }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
    }
}