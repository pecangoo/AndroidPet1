package com.sber.testmvvm.presentation.modelviewers

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import com.sber.testmvvm.domain.model.UserModel
import com.sber.testmvvm.domain.usecases.GetUserModelUseCase


class ShowValueScreenViewModel(private val getUser:GetUserModelUseCase) : ViewModel() {
    var name:String = "";
    var seName:String = ""
    var age: Int = 0

    fun getUserModel(){
        // Запрашиваем данные из бд

        val testUser =  getUser.getUserModel()
        name = testUser.firstName
        seName = testUser.secondName
        age = testUser.age
    }
}