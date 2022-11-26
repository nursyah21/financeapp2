package com.nursyah.financeapp.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.nursyah.financeapp.R
import com.nursyah.financeapp.ui.screen.mainscreen.HomeScreen
import com.nursyah.financeapp.ui.screen.mainscreen.OptionsScreen
import com.nursyah.financeapp.ui.screen.mainscreen.StatsScreen

var screen: MainScreenViewModel = MainScreenViewModel()

@Composable
fun MainScreen(
  modifier: Modifier = Modifier
){
  Column(
    modifier = Modifier.padding(6.dp)
  ) {
    HomeScreen(visible = screen.getScreen() == 0)
    StatsScreen(visible = screen.getScreen() == 1)
    OptionsScreen(visible = screen.getScreen() == 2)
  }

  Column(
    verticalArrangement = Arrangement.Bottom,
    modifier = modifier
  ) {
    Navbar()
  }
}

@Composable
fun Navbar(){
  val items = listOf(R.string.home, R.string.stats, R.string.options)
  val itemsIcon = listOf(R.drawable.home, R.drawable.stats, R.drawable.setting)

  NavigationBar {
    repeat(3){
      NavigationBarItem(
        icon = {
          Icon(
            painter = painterResource(id = itemsIcon[it]),
            contentDescription = null
          )
        },
        label = {
          Text(stringResource(id = items[it]))
        },
        selected = screen.getScreen() == it,
        onClick = { screen.setScreen(it) }
      )
    }
  }
}
