package com.sber.testmvvm.presentation.screen

import android.content.Context
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.sber.testmvvm.presentation.modelviewers.InputScreenViewModel
import com.sber.testmvvm.presentation.modelviewers.ShowValueScreenViewModel


@Composable
fun OutputValueScreen(viewModelInputScreen: ShowValueScreenViewModel,
                      function: (String) -> Unit) {


    viewModelInputScreen.getUserModel()
    Column(verticalArrangement = Arrangement.SpaceBetween) {
            Text(text = "%Age: ${viewModelInputScreen.age}")
            Text(text = "Name: ${viewModelInputScreen.name}")
            Text(text = "SeName: ${viewModelInputScreen.seName}")
        Button(onClick = {
            function("main")
        }) {
            Text(text = "To Main Page")
        }
    }

}