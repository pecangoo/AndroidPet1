package com.sber.testmvvm.domain.repository

import com.sber.testmvvm.domain.model.UserModel

interface UserRepository {
    fun save(userModel: UserModel): Boolean
    fun get():UserModel
}