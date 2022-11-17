package com.nursyah.financeapp.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.nursyah.financeapp.ui.theme.FinanceAppTheme

@Composable
fun App(){
  Surface(
    modifier = Modifier.fillMaxSize(),
    color = MaterialTheme.colorScheme.background
  ) {
    Greeting("mom")
  }
}

@Composable
fun Greeting(name: String) {
  Text(text = "Hi $name")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
  FinanceAppTheme {
    Greeting("mom")
  }
}