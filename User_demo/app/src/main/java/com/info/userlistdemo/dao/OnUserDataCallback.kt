package com.info.userlistdemo.dao

/**
 * Callback interface for User data.
 */
public interface OnUserDataCallback<T>{
    //callback method for user info.
    fun onUserDataAvailable(data: T?)
}