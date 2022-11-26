package com.nursyah.financeapp.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class FinanceAppViewModel : ViewModel(){
  var loginScreen: MutableState<Boolean> = mutableStateOf(false)
  var gettingStartedScreen: MutableState<Boolean> = mutableStateOf(true)

}