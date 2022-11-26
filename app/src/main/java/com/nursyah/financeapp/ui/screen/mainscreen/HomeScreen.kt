package com.nursyah.financeapp.ui.screen.mainscreen

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nursyah.financeapp.R
import com.nursyah.financeapp.data.fakeData
import com.nursyah.financeapp.ui.theme.Purple40
import com.nursyah.financeapp.ui.theme.Purple80
import com.nursyah.financeapp.ui.theme.fontOpenSanRegular
import com.nursyah.financeapp.ui.theme.fontOpenSansLight
import java.text.NumberFormat
import java.util.*

fun numberFormat(value: Int): String{
  val format = NumberFormat.getCurrencyInstance(Locale.getDefault())
  format.maximumFractionDigits = 0

  return format.format(value)
}

@Composable
fun HomeScreen(
  visible: Boolean,
  modifier: Modifier = Modifier
){
  val density = LocalDensity.current
  val scrollState = rememberScrollState()

  AnimatedVisibility(
    visible = visible,
    enter =  slideInVertically {
      with(density) { -40.dp.roundToPx() }
    } + expandVertically(expandFrom = Alignment.Top) + fadeIn(initialAlpha = 0.3f),
    exit = slideOutVertically() + shrinkVertically() + fadeOut()
  ) {
    Column(
      modifier = Modifier.verticalScroll(scrollState)
    ) {
      Summary(spend = 1000000)
      Spacer(modifier = Modifier.height(15.dp))
      Text(text = "Latest History")
      Spacer(modifier = Modifier.height(5.dp))
      LatestHistory()
      Spacer(modifier = Modifier.height(15.dp))
      Text(text = "Allocations")
      Spacer(modifier = Modifier.height(5.dp))
      Row{
        Allocations(item = "Makan", value = 300000)
      }
      Spacer(modifier = Modifier.height(15.dp))
      Text(text = "Savings")
      Spacer(modifier = Modifier.height(5.dp))
      Row {
        Savings(item = "Laptop", target = 6000000, currentSaving = 350000)
      }
      Spacer(modifier = Modifier.height(15.dp))
      Text(text = "Pockets")
      Spacer(modifier = Modifier.height(5.dp))
      Row {
        Pockets(item = "Wallet", value = 50000)
      }
      Spacer(modifier = Modifier.height(100.dp))
    }
  }
}

@Composable
fun Summary(
  modifier: Modifier = Modifier,
  balance: Int = 0,
  spend: Int = 0,
  income: Int = 0
){
  Card(
    modifier = modifier.fillMaxWidth(),
    elevation = CardDefaults.outlinedCardElevation(4.dp),
  ) {
    Column(
      modifier = Modifier.padding(10.dp, 15.dp)
    ) {
      Text(
        text = stringResource(R.string.balance),
        fontFamily = fontOpenSansLight
      )
      Spacer(modifier = Modifier.height(10.dp))
      Text(
        text = numberFormat(balance),
        fontFamily = fontOpenSanRegular,
        fontSize = 32.sp
      )
      Spacer(modifier = Modifier.height(20.dp))
      Row {
        Button(
          onClick = { /*TODO*/ },
          elevation = ButtonDefaults.filledTonalButtonElevation(4.dp),
        ) {
          Text(
            text = "Spend\n${numberFormat(spend)}",
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(horizontal = 5.dp)
          )
        }
        Spacer(modifier = Modifier.width(10.dp))
        Button(
          onClick = { /*TODO*/ },
          elevation = ButtonDefaults.filledTonalButtonElevation(4.dp),
        ) {
          Text(
            text = "Income\n${numberFormat(income)}",
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(horizontal = 5.dp)
          )
        }
      }
    }
  }
}

@Composable
fun LatestHistory(
  modifier: Modifier = Modifier
){
  Card(
    modifier = modifier.fillMaxWidth(),
    elevation = CardDefaults.outlinedCardElevation(4.dp),
  ) {
    Column(modifier = Modifier.padding(10.dp, 15.dp)) {
      val size = if(fakeData.size < 4) fakeData.size else 4
      fakeData.subList(0, size).forEach{
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

@Composable
fun Allocations(
  modifier: Modifier = Modifier,
  item: String = "",
  value: Int = 0,
){
  Card(
    modifier = modifier,
    elevation = CardDefaults.outlinedCardElevation(4.dp),
  ) {
    Column(
      modifier = Modifier.padding(10.dp, 15.dp)
    ) {
      Text(text = item)
      Spacer(modifier = Modifier.height(4.dp))
      Text(text = numberFormat(value))
    }
  }
}

@Composable
fun Savings(
  modifier: Modifier = Modifier,
  item: String = "",
  target: Int = 0,
  currentSaving: Int = 0,
  Deadline: Date? = null
){
  Card(
    modifier = modifier
      .width(140.dp),
    elevation = CardDefaults.outlinedCardElevation(4.dp),
  ) {
    Column(
      modifier = Modifier.padding(10.dp, 15.dp)
    ){
      Text(text = item)
      Spacer(Modifier.height(4.dp))
      Text(text = numberFormat(target))
      Spacer(Modifier.height(6.dp))
      val progress: Float = currentSaving.toFloat().div(target)
      val progressText = "%.2f".format(progress*100)
      Text(
        text = "${numberFormat(currentSaving)} / $progressText%",
        fontWeight = FontWeight.Light,
        fontSize = 12.sp
      )
      Spacer(Modifier.height(5.dp))
      LinearProgressIndicator(
        progress,
        color = Purple40,
        trackColor = Color.LightGray
      )
    }
  }
}

@Composable
fun Pockets(
  modifier: Modifier = Modifier,
  item: String,
  value: Int
){
  Card(
    modifier = modifier,
    elevation = CardDefaults.outlinedCardElevation(4.dp),
  ) {
    Column(
      modifier = Modifier.padding(10.dp, 15.dp)
    ) {
      Text(text = item)
      Spacer(Modifier.height(5.dp))
      Text(text = numberFormat(value))
    }
  }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun HomeScreenPreview(){
  HomeScreen(true)
}