package com.sber.testmvvm.domain.usecases

import com.sber.testmvvm.data.UserRepositoryImpl
import com.sber.testmvvm.domain.model.UserModel

class SaveUserModelUseCase (private  val userRepositoryImpl: UserRepositoryImpl){
    fun saveUserModel(user: UserModel): Boolean{
        userRepositoryImpl.save(user)
        return true;
    }
}