package com.nursyah.financeapp.ui.screen.mainscreen

import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.himanshoe.charty.bar.BarChart
import com.nursyah.financeapp.data.barChartFakeData
import com.nursyah.financeapp.data.fakeData
import kotlinx.datetime.LocalDate

val sortStats = listOf("Year", "Month", "Week", "All Days")

val statsScreenViewModel = StatsScreenViewModel()

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
    } + expandVertically(expandFrom = Alignment.Top) + fadeIn(initialAlpha = 0.3f),
    exit = slideOutVertically() + shrinkVertically() + fadeOut()
  ) {
    Column(
      modifier = modifier,
    ) {
      SortStats()
      Spacer(modifier = Modifier.height(5.dp))
      StatsBar()
      Spacer(modifier = Modifier.height(5.dp))
      SpendIncome()
      Spacer(modifier = Modifier.height(5.dp))
      HistorySpendIncome()
      Spacer(modifier = Modifier.height(100.dp))
    }
  }
}

@Composable
fun SortStats(
  modifier: Modifier = Modifier
){
  Row(
    modifier = modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.spacedBy(space = 6.dp, alignment = Alignment.CenterHorizontally)
  ) {
    sortStats.forEach{
      Button(
        onClick = { /*TODO*/ },
        elevation = ButtonDefaults.filledTonalButtonElevation(4.dp),
      ) {
        Text(text = it)
      }
    }
  }
}

@Composable
fun StatsBar(
  modifier: Modifier = Modifier
){
  Card(
    modifier = modifier.fillMaxWidth(),
    elevation = CardDefaults.outlinedCardElevation(4.dp),
  ) {
    LazyColumn(
      modifier = Modifier.padding(6.dp)
    ){
      item {
        BarChart(
          modifier = Modifier
            .fillMaxWidth()
            .height(220.dp)
            .padding(32.dp),
          barData = barChartFakeData,
          color = MaterialTheme.colorScheme.primary,
          onBarClick = {}
        )
      }
    }
  }
}

@Composable
fun SpendIncome(
  modifier: Modifier = Modifier
){
  Row(
    modifier = Modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.Center
  ){
    Button(
      onClick = { /*TODO*/ }
    ) {
      Text(text = "spend")
    }
    Spacer(modifier = Modifier.width(10.dp))
    Button(
      onClick = { /*TODO*/ }
    ) {
      Text(text = "income")
    }
  }
}

@Composable
fun HistorySpendIncome(
  modifier: Modifier = Modifier
){
  Card(
    modifier = modifier.fillMaxWidth(),
    elevation = CardDefaults.outlinedCardElevation(4.dp),
  ) {
    Column(modifier = Modifier.padding(10.dp, 15.dp)) {
      Text(text = "20 Nov 2022")
      Spacer(modifier = Modifier.height(3.dp))
      fakeData.forEach{
        Row {
          Text(
            text = it.Category,
            color = Color.Gray
          )
          Spacer(modifier = Modifier.width(10.dp))
          Text(
            text = it.item
          )
          Spacer(modifier = Modifier.width(10.dp))
          Text(text = numberFormat(it.value))
        }
        Spacer(modifier = Modifier.height(2.dp))
        Divider(thickness = 1.dp)
        Spacer(modifier = Modifier.height(2.dp))
      }
    }
  }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun StatsScreenPreview(){
  StatsScreen(true)
}