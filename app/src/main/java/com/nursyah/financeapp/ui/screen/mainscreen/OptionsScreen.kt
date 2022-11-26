package com.nursyah.financeapp.ui.screen.mainscreen

import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nursyah.financeapp.R


@Composable
fun OptionsScreen(
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
      LoginButton()
      Spacer(modifier = Modifier.height(5.dp))
      BackupButton()
      Spacer(modifier = Modifier.height(5.dp))
      Divider(thickness = 1.dp)
      Spacer(modifier = Modifier.height(5.dp))
      Info()
      OpenSourceLicense()
    }
  }
}

@Composable
fun LoginButton(
  modifier: Modifier = Modifier
){
  Card(
    modifier = modifier
      .fillMaxWidth()
  ) {
    Row(
      modifier = Modifier.padding(horizontal = 5.dp),
      verticalAlignment = Alignment.CenterVertically
    ) {
      Icon(
        modifier = Modifier.size(24.dp),
        painter = painterResource(id = R.drawable.account),
        contentDescription = null 
      )
      Spacer(modifier = Modifier.width(10.dp))
      Text(text = "Guess")
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End
      ) {
        Button(
          onClick = { /*TODO*/ },
          colors = ButtonDefaults.outlinedButtonColors()
        ) {
          Text(text = "Login")
        }
      }
    }
  }
}

@Composable
fun BackupButton(){
  Column() {
    Row {
      Button(
        onClick = { /*TODO*/ },
      ) {
        Text(text = "Backup Data")
      }
      Spacer(modifier = Modifier.width(10.dp))
      Button(
        onClick = { /*TODO*/ },
      ) {
        Text(text = "Restore Data")
      }
    }
    Spacer(modifier = Modifier.height(5.dp))
    Button(
      onClick = { /*TODO*/ }
    ) {
      Text(text = "Reset")
    }
  }
}

@Composable
fun Info(
  data: String = "0mb",
  sync: Boolean = false
){
  Column {
    Text(text = "usage of data: $data")
    Spacer(modifier = Modifier.height(5.dp))
    Text("sync: ${if(sync) "on" else "off"}")
  }
}

@Composable
fun OpenSourceLicense(
  modifier: Modifier = Modifier
){
  Column(
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Bottom
  ) {
    Button(
      onClick = { /*TODO*/ },
      colors = ButtonDefaults.outlinedButtonColors()
    ) {
      Text(text = "Open Source License")
    }
    Spacer(modifier = Modifier.height(80.dp))
  }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun OptionsScreenPreview(){
  OptionsScreen(true)
}