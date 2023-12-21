package com.example.exam.ui.ui.model

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.exam.data.Category

class CategoryViewModel : ViewModel() {
    private val _uiState = mutableStateListOf<Category>(Category("Питание"),Category("Транспорт"), Category("Развлечения"))
    val uiState: List<Category>
        get() = _uiState


    fun addCategory(category: String){
        _uiState.add(Category(category))
    }

    fun removeCategory(category: Category)
    {
        _uiState.remove(category)
    }


}