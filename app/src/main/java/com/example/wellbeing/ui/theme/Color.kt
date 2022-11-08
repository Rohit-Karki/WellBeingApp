package com.example.wellbeing.ui.theme

import androidx.compose.ui.graphics.Color
import com.example.wellbeing.custom.color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

val String.color
    get() = Color(android.graphics.Color.parseColor(this))

val BackGroundColor = "#F4A950".color
val WaterColor = "#3AB0FF".color
val BackGroundColorSecondary = "#000000".color
val PrimaryColor = "#F4A950".color
val SecondaryColor = Color(0xFFFFFFFF)



val PrimaryTextColor = Color(0xFF060719)
val SecondaryTextColor = "#F96167".color
val SubTextColor = Color(0xFF85858)