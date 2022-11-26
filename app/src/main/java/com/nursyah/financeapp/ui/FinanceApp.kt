package com.nursyah.financeapp.ui

import android.content.Context
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.nursyah.financeapp.R
import com.nursyah.financeapp.ui.screen.GettingStartedScreen
import com.nursyah.financeapp.ui.screen.LoginScreen

val financeAppViewModel = FinanceAppViewModel()

@Composable
fun App(){
  val sharedPref = LocalContext.current.getSharedPreferences(
    stringResource(R.string.shared_preferences),
    Context.MODE_PRIVATE
  )

  Surface(
    modifier = Modifier.fillMaxSize(),
    color = MaterialTheme.colorScheme.background
  ) {
    GettingStarted()
  }
}

@Composable
fun GettingStarted(){
  AnimatedVisibility(visible = true) {
    LoginScreen()
  }
  AnimatedVisibility(visible = false) {
    GettingStartedScreen()
  }
}
