package com.sber.testmvvm.data.storage

import com.sber.testmvvm.data.model.UserModelStorage

interface UserStorage {
    fun get(): UserModelStorage

    fun save(userStorage: UserModelStorage) : Boolean
}