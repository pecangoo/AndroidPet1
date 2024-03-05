package com.sber.testmvvm.presentation.factories

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sber.testmvvm.data.UserRepositoryImpl
import com.sber.testmvvm.data.storage.SharedStorage
import com.sber.testmvvm.domain.model.UserModel
import com.sber.testmvvm.domain.repository.UserRepository
import com.sber.testmvvm.domain.usecases.SaveUserModelUseCase
import com.sber.testmvvm.presentation.modelviewers.InputScreenViewModel

class InputScrViewModelFactory(context: Context) : ViewModelProvider.Factory {


    private val userRepository by lazy (LazyThreadSafetyMode.NONE ) {
        UserRepositoryImpl(SharedStorage(context))
    }

    private val saveUser by lazy(LazyThreadSafetyMode.NONE) {
        SaveUserModelUseCase(userRepository)
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return  InputScreenViewModel(saveUser = saveUser) as T;
    }
}