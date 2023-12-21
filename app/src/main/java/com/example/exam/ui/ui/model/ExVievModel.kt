package com.example.exam.ui.ui.model

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.exam.data.Expenses


class ExVievModel : ViewModel() {
    private val _uiState = mutableStateListOf<Expenses>()
    val uiState: List<Expenses>
        get() = _uiState


    fun addEx(category: String, price: Double){
        _uiState.add(Expenses(price, category))
    }

    fun removeEx(expenses: Expenses){
        _uiState.remove(expenses)
    }


}



