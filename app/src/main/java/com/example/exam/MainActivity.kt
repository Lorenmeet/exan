package com.example.exam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.exam.data.Category
import com.example.exam.data.Expenses
import com.example.exam.theme.ExamTheme
import com.example.exam.ui.ui.AddCategory
import com.example.exam.ui.ui.AddExpenses
import com.example.exam.ui.ui.CategoruEx
import com.example.exam.ui.ui.model.ExVievModel
import com.example.exam.ui.ui.StartScreen
import com.example.exam.ui.ui.model.CategoryViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExamTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModel = viewModel<ExVievModel>()
                    val catViewModel = viewModel<CategoryViewModel>()
                    val navController = rememberNavController()


                    NavHost(navController = navController, startDestination = "/startScreen" , ){
                        composable("/startScreen"){
                            StartScreen(viewModel =  viewModel, navController = navController)
                        }
                        composable("/addExpenses"){

                            AddExpenses(viewModel = viewModel, navController = navController,catViewModel = catViewModel,)
                        }
                        composable("/addCategory"){
                            AddCategory(viewModel = catViewModel, navController = navController)
                        }
                        composable("/categoryExpenses"){

                            CategoruEx(viewModel = viewModel, catVievModel = catViewModel , navController =navController )
                        }
                    }
                }
            }
        }
    }
}
