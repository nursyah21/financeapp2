package com.nursyah.financeapp.ui.screen.mainscreen

import androidx.compose.animation.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun StatsScreen(
  visible: Boolean,
  modifier: Modifier = Modifier
){
  val density = LocalDensity.current

  AnimatedVisibility(
    visible = visible,
    enter =  slideInVertically {
      with(density) { -40.dp.roundToPx() }
    } + expandVertically(expandFrom = Alignment.Top
    ) + fadeIn(initialAlpha = 0.3f),
    exit = slideOutVertically() + shrinkVertically() + fadeOut()
  ) {
    Column(
      modifier = modifier,
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.Center
    ) {
      Text("stats")
    }
  }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun StatsScreenPreview(){
  StatsScreen(true)
}