package com.sber.testmvvm.domain.usecases

import com.sber.testmvvm.data.UserRepositoryImpl
import com.sber.testmvvm.domain.model.UserModel

class GetUserModelUseCase(private val userRepositoryImpl: UserRepositoryImpl)
{
    fun getUserModel(): UserModel{
        return  userRepositoryImpl.get();
    }
}