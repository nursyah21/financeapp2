package com.nursyah.financeapp.ui.screen

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class MainScreenViewModel : ViewModel(){
  private val _uiState:MutableState<Int> = mutableStateOf(0)
//
  fun setScreen(selectedScreen: Int){
    _uiState.value = selectedScreen
  }
//
  fun getScreen(): Int{
    return _uiState.value
  }

}