package com.sber.testmvvm.presentation.factories

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sber.testmvvm.data.UserRepositoryImpl
import com.sber.testmvvm.data.storage.SharedStorage
import com.sber.testmvvm.domain.usecases.GetUserModelUseCase
import com.sber.testmvvm.presentation.modelviewers.ShowValueScreenViewModel

class ShowViewModelFactory(context: Context) : ViewModelProvider.Factory {

  private val userRepository by lazy (LazyThreadSafetyMode.NONE ) {
      UserRepositoryImpl(SharedStorage(context))
  }

    private val getUser by lazy (LazyThreadSafetyMode.NONE ) {
            GetUserModelUseCase(userRepository)
    }


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ShowValueScreenViewModel(getUser = getUser) as T
    }
}