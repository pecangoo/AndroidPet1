package com.sber.testmvvm.data

import com.sber.testmvvm.data.storage.SharedStorage
import com.sber.testmvvm.data.model.UserModelStorage
import com.sber.testmvvm.domain.model.UserModel
import com.sber.testmvvm.domain.repository.UserRepository

class UserRepositoryImpl(private val userStorage: SharedStorage): UserRepository {
    override fun get(): UserModel {
        val user = userStorage.get()
        return UserModel(user.firstName,
            user.secondName,
            user.age);
    }

    override fun save(userModel: UserModel): Boolean {
        userStorage
            .save(
                UserModelStorage(
                    userModel.firstName,
                    userModel.secondName,
                    userModel.age)
            )
        return true;
    }
}