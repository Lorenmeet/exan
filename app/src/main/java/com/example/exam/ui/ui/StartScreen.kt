package com.example.exam.ui.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.exam.R
import com.example.exam.data.Expenses
import com.example.exam.ui.ui.model.ExVievModel

@Composable
fun StartScreen(viewModel: ExVievModel, navController: NavController,){
Column(modifier = Modifier
    .fillMaxSize()
    .background(color = Color.White)
    .verticalScroll(rememberScrollState()),
    horizontalAlignment = Alignment.CenterHorizontally) {
    Text(text = stringResource(R.string.expenses),  color = Color.Black,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold, modifier = Modifier.padding(40.dp))
    viewModel.uiState.forEach { expens ->
        Card(modifier = Modifier
            .size(200.dp, 100.dp)
            .padding(10.dp)
       ) {
                Text(text = expens.category)
                Text(
                    text = stringResource(R.string.price, expens.price),
                )
                 Button(onClick = { viewModel.removeEx(expens)},
                 )
                 { Icon(imageVector = Icons.Rounded.Delete, contentDescription = null ) }
         }
    }
    Spacer(modifier = Modifier.weight(1f))

    Row(modifier = Modifier.padding(start = 5.dp, end = 5.dp, bottom = 30.dp, top = 0.dp)) {
        Button(onClick = { navController.navigate("/addExpenses") }) {
            Text(text = "Добавить расходы")
            }

        Button(onClick = { navController.navigate("/categoryExpenses") }) {
            Text(text = "Статистика расходов")
             }
         }
    }
}