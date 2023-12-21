package com.example.exam.ui.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.exam.ui.ui.model.CategoryViewModel
import com.example.exam.ui.ui.model.ExVievModel


@Composable
fun CategoruEx(viewModel: ExVievModel, catVievModel: CategoryViewModel , navController: NavController){
    val category = catVievModel.uiState
    val expenses = viewModel.uiState

Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
    LazyColumn(modifier = Modifier ){
        items(category) { category ->
            Card (modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)) {
                Column {
                    Text(text = category.category)
                    Text(text = expenses.filter { it.category == category.category }.sumBy { it.price.toInt() }.toString())
                }
            }
        }
    }
    Button(onClick = { navController.navigate("/startScreen") }, modifier = Modifier.padding(20.dp)) {
        Text(text = "Назад")
         }
    }
}