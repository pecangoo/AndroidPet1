package com.sber.testmvvm.presentation.screen

import android.content.ContentResolver
import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.sber.testmvvm.R
import com.sber.testmvvm.presentation.modelviewers.InputScreenViewModel


@Composable
fun InputValueScreen(viewModelInputScreen: InputScreenViewModel,
    onNavigate: (String) -> Unit) {

    var ageField: MutableState<Int> =
        remember { mutableIntStateOf(0) }
    var seNameField: MutableState<String> =
        remember { mutableStateOf("") }
    var nameField: MutableState<String> =
        remember { mutableStateOf("") }

    ageField.value = viewModelInputScreen.ageField.value?:0;
    nameField.value = viewModelInputScreen.nameField.value?:""
    seNameField.value = viewModelInputScreen.seNameField.value?:""

    // TODO: Для оптимизации скорости работы интерфейса,
    //  можно каждую строку сделать блоком. На в пет проекте, считаю излишним.
    Column(verticalArrangement = Arrangement.SpaceBetween) {
        Row(horizontalArrangement = Arrangement.SpaceBetween){
            Text(text =  stringResource(R.string.field_input_name),
                modifier = Modifier.size(100.dp)) // From String
            TextField(value = nameField.value,
                onValueChange = {
                    nameField.value = it
                    viewModelInputScreen.nameField.postValue(nameField.value)
                },
                singleLine = true,
                modifier = Modifier.width(200.dp))
        }
        Row(horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = stringResource(id = R.string.field_input_se_name),
                modifier = Modifier.size(100.dp))
            TextField(value = seNameField.value,
                onValueChange = {
                    seNameField.value = it
                    viewModelInputScreen.seNameField.postValue(seNameField.value)
                },
                singleLine = true,
                modifier = Modifier.width(200.dp))
        }
        Row(horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = stringResource(id = R.string.field_input_age),
                modifier = Modifier.size(100.dp))
            TextField(value = ageField.value.toString(),
                onValueChange = {
                        ageField.value = it.toIntOrNull()?:0
                    viewModelInputScreen.ageField.postValue(ageField.value)
                },
                singleLine = true,
                modifier = Modifier.width(200.dp))
        }
        Row(horizontalArrangement = Arrangement.SpaceBetween) {
            Button(onClick = {
                // Сохраняем инфу, которая уже есть во ViewModel
                viewModelInputScreen.save()
            }) {
                Text(text = "save")

            }
            Button(onClick = { onNavigate("show")}) {
                Text(text = "Show Changed")

            }
        }
    }
}
