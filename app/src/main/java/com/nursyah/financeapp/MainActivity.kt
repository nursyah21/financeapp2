package com.nursyah.financeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.nursyah.financeapp.ui.App
import com.nursyah.financeapp.ui.theme.FinanceAppTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      FinanceAppTheme {
        App()
      }
    }
  }
}
