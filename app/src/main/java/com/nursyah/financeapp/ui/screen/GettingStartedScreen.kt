package com.nursyah.financeapp.ui.screen

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
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nursyah.financeapp.R

@Composable
fun GettingStartedScreen(
  modifier: Modifier = Modifier
){
  Column(
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally,
    modifier = modifier.fillMaxWidth().padding(4.dp)
  ) {
    Image(
      painter = painterResource(id = R.drawable.gettingstarted_image),
      contentDescription = null 
    )
    Spacer(modifier = Modifier.height(24.dp))
    Text(
      text = gettingStartedText(),
      textAlign = TextAlign.Center
    )
    Spacer(modifier = Modifier.height(24.dp))
    Button(
      onClick = { /*TODO*/ },
      elevation = ButtonDefaults.elevatedButtonElevation(3.dp),
      colors = ButtonDefaults.elevatedButtonColors(Color.White),
      contentPadding = PaddingValues(horizontal = 100.dp)
    ) {
      Text(
        text = stringResource(id = R.string.getting_started),
        color = MaterialTheme.colorScheme.primary
      )
    }
  }
}

@Composable
fun gettingStartedText(): AnnotatedString{
  return buildAnnotatedString {
    pushStyle(SpanStyle(
      color = Color.Black
    ))
    append(stringResource(id = R.string.app_introduction))
    pushStyle(SpanStyle(color = Color.Blue))
    append(" ${stringResource(id = R.string.finance)} ")
    pushStyle(SpanStyle(color = Color.Black))
    append(stringResource(id = R.string.app_introduction2))

    toAnnotatedString()
  }
}

@Preview(
  showBackground = true,
  showSystemUi = true
)
@Composable
fun PreviewGettingStartedScreen(){
  GettingStartedScreen()
}