package com.sber.testmvvm

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sber.testmvvm.presentation.factories.InputScrViewModelFactory
import com.sber.testmvvm.presentation.factories.ShowViewModelFactory
import com.sber.testmvvm.presentation.modelviewers.InputScreenViewModel
import com.sber.testmvvm.presentation.modelviewers.ShowValueScreenViewModel
import com.sber.testmvvm.presentation.screen.InputValueScreen
import com.sber.testmvvm.presentation.screen.OutputValueScreen

class MainActivity : ComponentActivity() {

    private lateinit var viewModelInputScreen: InputScreenViewModel;
    private lateinit var viewModelShowScreen: ShowValueScreenViewModel;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModelInputScreen = ViewModelProvider(
            this,
            InputScrViewModelFactory(applicationContext)
        ).get((InputScreenViewModel::class.java))

        viewModelShowScreen = ViewModelProvider(this,
            ShowViewModelFactory(applicationContext)
        )
            .get(ShowValueScreenViewModel::class.java)

        setContent {
            NavMenu(viewModelInputScreen,
                viewModelShowScreen)
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun NavMenu(viewModelInputScreen: InputScreenViewModel,
            viewModelShowScreen: ShowValueScreenViewModel
            ) {
    val navController = rememberNavController()


    NavHost(navController = navController,
        startDestination = "main"){
        Log.e("AAA", "Create Nav Host")

        composable("main") {
            InputValueScreen(viewModelInputScreen,
                onNavigate = { navController.navigate(it) })

        }
        composable("show") {
            OutputValueScreen(viewModelShowScreen)
            {navController.navigate(it)};
        }
    }
}

