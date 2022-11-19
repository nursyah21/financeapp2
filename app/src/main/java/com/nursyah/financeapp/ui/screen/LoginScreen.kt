package com.nursyah.financeapp.ui.screen

import androidx.annotation.NonNull
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nursyah.financeapp.R

@Composable
fun LoginScreen(
  modifier: Modifier = Modifier
){
  Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center,
    modifier = modifier
  ) {
    Button(
      onClick = { /*TODO*/ },
      elevation = ButtonDefaults.elevatedButtonElevation(3.dp),
      colors = ButtonDefaults.elevatedButtonColors(Color.White),
    ) {
      Image(
        painter = painterResource(id = R.drawable.google),
        contentDescription = null,
      )
      Spacer(modifier = Modifier.width(18.dp))
      Text(
        text = stringResource(id = R.string.login_with_google),
        color = MaterialTheme.colorScheme.primary
      )
    }
  }
  Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Bottom,
  ) {
    Button(
      onClick = { /*TODO*/ },
      elevation = ButtonDefaults.filledTonalButtonElevation(),
      colors = ButtonDefaults.filledTonalButtonColors(),
    ) {
      Text(
        text = stringResource(id = R.string.maybe_later),
        color = MaterialTheme.colorScheme.primary
      )
    }
    Spacer(modifier = Modifier.height(8.dp))
  }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun LoginScreenPreview(){
  LoginScreen()
}