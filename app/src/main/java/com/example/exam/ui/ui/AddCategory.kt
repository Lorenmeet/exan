package com.example.exam.ui.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.exam.ui.ui.model.CategoryViewModel
import com.example.exam.ui.ui.model.ExVievModel

@Composable
fun AddCategory(viewModel: CategoryViewModel, navController: NavController){
var text by remember{ mutableStateOf("")}
    
    Column(horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center) {
        TextField(value = text, onValueChange = {text = it} )

        Button(onClick = { viewModel.addCategory(text)
        navController.navigateUp()}, modifier = Modifier.padding(20.dp)) {
            Text(text = "Добавить категорию")
        }
    }

}