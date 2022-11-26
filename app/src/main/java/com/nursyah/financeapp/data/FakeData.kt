package com.nursyah.financeapp.data

import com.himanshoe.charty.bar.model.BarData
import com.nursyah.financeapp.model.Data
import kotlinx.datetime.LocalDate

val fakeData = listOf(
  Data("spend", "nasi bungkus", 50000),
  Data("income", "uang saku", 50000),
  Data("spend", "nasi bungkus", 50000),
  Data("income", "uang saku", 50000),
  Data("spend", "nasi bungkus", 50000),
  Data("income", "uang saku", 50000),
)

val barChartFakeData = listOf(
  BarData(10, 1f),
  BarData(11, 4f),
  BarData(12, 5f),
  BarData(13, 2f),
  BarData(14, 1f),
  BarData(15, 4f),
  BarData(16, 5f),
  BarData(17, 2f),
)
