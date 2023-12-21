package com.example.exam.ui.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.exam.ui.ui.model.CategoryViewModel
import com.example.exam.ui.ui.model.ExVievModel

@Composable
fun AddExpenses(viewModel: ExVievModel,
                navController: NavController,
                catViewModel: CategoryViewModel,
                onSelectionChanged: (String) -> Unit = {}){
    var selectedValue by rememberSaveable { mutableStateOf("") }
    var price by remember { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        TextField(value = price, onValueChange = {price = it},
            modifier = Modifier
                .size(200.dp,60.dp)
                .background(color = Color.White),keyboardOptions =
                    KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        catViewModel.uiState.forEach { item ->
            Row(
                modifier = Modifier.selectable(
                    selected = selectedValue == item.category,
                    onClick = {
                        selectedValue = item.category
                        onSelectionChanged(item.category)
                    }
                ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                RadioButton(
                    selected = selectedValue == item.category,
                    onClick = {
                        selectedValue = item.category
                        onSelectionChanged(item.category)
                    },

                )
                Text(item.category)
                IconButton(onClick = { catViewModel.removeCategory(item)
                })
                { Icon(Icons.Rounded.Delete, contentDescription = null) }
            }
        }

        Button(enabled = price.isNotEmpty() && selectedValue.isNotEmpty(),
            onClick = { viewModel.addEx(selectedValue, price.toDouble())
            navController.navigateUp() }) {
            Text(text = "Добавить")
        }
        Button(onClick = { navController.navigate("/addCategory") }) {
        Text(text = "Добавить категорию")
        }


    }

}