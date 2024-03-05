package com.sber.testmvvm.presentation.modelviewers

import androidx.compose.runtime.referentialEqualityPolicy
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sber.testmvvm.domain.model.UserModel
import com.sber.testmvvm.domain.usecases.SaveUserModelUseCase

class InputScreenViewModel(private val saveUser: SaveUserModelUseCase): ViewModel() {
    var nameField =  MutableLiveData<String>("")
    var seNameField = MutableLiveData<String>("")
    var ageField =  MutableLiveData<Int>(0)

    fun save() {
        saveUser
            .saveUserModel(UserModel(nameField.value!!,
            seNameField.value!!,
            ageField.value!!))
    }

}