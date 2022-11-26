package com.nursyah.financeapp

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.nursyah.financeapp.ui.App
import com.nursyah.financeapp.ui.theme.FinanceAppTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    val sharedPref = applicationContext.getSharedPreferences(
      getString(R.string.shared_preferences),
      Context.MODE_PRIVATE
    )

    setContent {
      FinanceAppTheme {
        App()
      }
    }
  }
}
