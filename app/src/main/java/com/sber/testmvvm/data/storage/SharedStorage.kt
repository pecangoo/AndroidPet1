package com.sber.testmvvm.data.storage

import android.content.Context
import android.util.Log
import com.sber.testmvvm.data.model.UserModelStorage

private const val CONST_PREFS_NAME = "name_repository"
private const val KEY_FIRST_NAME = "first_name"
private const val KEY_SECOND_NAME = "second_name"
private const val KEY_AGE = "age"
class SharedStorage(context: Context): UserStorage {

    private var sharedPrefs = context.getSharedPreferences(CONST_PREFS_NAME, Context.MODE_PRIVATE)
    override fun get(): UserModelStorage {
        Log.d("AAA", sharedPrefs.all.toString())
        return UserModelStorage(
            sharedPrefs.getString(KEY_FIRST_NAME, "No Name")?:"Null" ,
            sharedPrefs.getString(KEY_SECOND_NAME, "No Name")?:"Null",
            sharedPrefs.getInt(KEY_AGE, 0))
    }

    override fun save(userStorageModel: UserModelStorage) : Boolean {
        Log.d("AAA", userStorageModel.age.toString())
        Log.d("AAA", userStorageModel.firstName.toString())
        Log.d("AAA", userStorageModel.secondName.toString())
        sharedPrefs.edit()
            .putString(KEY_FIRST_NAME, userStorageModel.firstName).apply()
        sharedPrefs.edit()
            .putString(KEY_SECOND_NAME, userStorageModel.secondName).apply()
        sharedPrefs.edit()
            .putInt(KEY_AGE, userStorageModel.age).apply()
        return true;
    }
}