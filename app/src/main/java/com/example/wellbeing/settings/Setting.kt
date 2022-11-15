package com.example.wellbeing.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.wellbeing.ui.theme.*




@Composable
fun SettingScreen(){
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            //.background(color = "#161B21".color)
//        ,
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
//    ) {
//        Icon(
//            imageVector = Icons.Outlined.Settings,
//            contentDescription = "settings",
//            tint = "#F4A950".color
//        )
//        // Text to Display the current Screen
//        Text(text = "Settings", color = "#F96167".color)
//    }

    Column {

            HeaderText()
            ProfileCardUI()
            GeneralCardUI()
            OthersUI()


    }
}



                @Composable
                fun HeaderText() {
                    Text(
                        text = "Settings",

                        fontFamily = Poppins,
                        color = PrimaryColor,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 30.dp, bottom = 10.dp),
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 20.sp

                    )
                }

                @Composable
                fun ProfileCardUI() {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp)
                            .padding(15.dp),
                        backgroundColor = BackGroundColor.copy(alpha = 0.3f),
                        elevation = 0.dp,
                        shape = Shapes.large
                    ) {
                        Row(
                            modifier = Modifier.padding(20.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column {
                                Text(
                                    text = "Check your Dashford",
                                    fontFamily = Poppins,
                                    color = "#000000".color,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,

                                    )
                                Button(
                                    onClick = { },
                                    modifier = Modifier.padding(top = 10.dp),
                                    colors = ButtonDefaults.buttonColors(
                                        backgroundColor = PrimaryColor
                                    ),
                                    contentPadding = PaddingValues(horizontal = 30.dp),
                                    elevation = ButtonDefaults.elevation(
                                        defaultElevation = 0.dp,
                                        pressedElevation = 2.dp,
                                    ),
                                    shape = Shapes.medium
                                ) {
                                    Text(
                                        text = "View",
                                        fontFamily = Poppins,
                                        color = SecondaryColor,
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.Bold

                                    )

                                }
                            }


                        }
                    }
                }

                @Composable
                fun GeneralCardUI() {
                    Column(
                        modifier = Modifier
                            .padding(horizontal = 14.dp)
                            .padding(top = 10.dp)
                    ) {
                        Text(
                            text = "General",
                            fontFamily = Poppins,
                            color = PrimaryTextColor,
                            fontSize = 16.sp,
                            modifier = Modifier.padding(vertical = 8.dp)


                        )
                        GeneralItem(
                            icon = Icons.Default.Notifications,
                            mainText = "Notifications",
                            subText = "Customize notifications",
                            onClick = {
                                //handle click
                            }
                        )


                    }
                }

                @OptIn(ExperimentalMaterialApi::class)
                @Composable
                fun GeneralItem(
                    icon: ImageVector,
                    mainText: String,
                    subText: String,
                    onClick: () -> Unit
                ) {

                    Card(
                        onClick = {
                            onClick()
                        },
                        backgroundColor = BackGroundColor.copy(alpha = 0.3f),
                        modifier = Modifier
                            .padding(bottom = 8.dp)
                            .fillMaxWidth(),
                        elevation = 0.dp
                    ) {
                        Row(
                            modifier = Modifier.padding(vertical = 10.dp, horizontal = 14.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Box(
                                    modifier = Modifier
                                        .size(34.dp)
                                        .clip(shape = Shapes.medium)


                                ) {
                                    Icon(
                                        imageVector = icon,
                                        contentDescription = null,
                                        tint = SecondaryTextColor,
                                        modifier = Modifier.padding(8.dp)
                                    )
                                }
                                Spacer(modifier = Modifier.width(14.dp))
                                Column {
                                    Text(
                                        text = mainText,
                                        fontFamily = Poppins,
                                        color = SecondaryTextColor,
                                        fontSize = 14.sp,
                                        fontWeight = FontWeight.ExtraLight,

                                        )
                                    Text(
                                        text = subText,
                                        fontFamily = Poppins,
                                        color = Color.DarkGray,
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.ExtraLight,
                                        modifier = Modifier.offset(y = (-4).dp)
                                    )
                                }
                            }
                            Icon(
                                imageVector = Icons.Default.ArrowRight,
                                contentDescription = null,

                                modifier = Modifier.size(20.dp)
                            )

                        }

                    }
                }

@Composable
fun OthersUI() {
    Column(
        modifier = Modifier
            .padding(horizontal = 14.dp)
            .padding(top = 10.dp)
    ) {
        Text(
            text = "Support",
            fontFamily = Poppins,
            color = PrimaryTextColor,
            fontSize = 16.sp,
            modifier = Modifier.padding(vertical = 8.dp)


        )
        OthersUIItem(
            icon = Icons.Default.WaterDrop,
            mainText = "Water Drink ",
            onClick = {
                //handle click
            }
        )
        OthersUIItem(
            icon = Icons.Default.MonitorWeight,
            mainText = "Weight",
            onClick = {
                //handle click
            }
        )
        OthersUIItem(
            icon = Icons.Default.IntegrationInstructions,
            mainText = "Instructions ",
            onClick = {
                //handle click
            }
        )
        OthersUIItem(
            icon = Icons.Default.Contacts,
            mainText = "Contact",
            onClick = {
                //handle click
            }
        )
    }
}

    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    fun OthersUIItem(
        icon: ImageVector,
        mainText: String,
        onClick: () -> Unit

    ) {
        Card(
            onClick = {
                onClick()
            },
            backgroundColor = BackGroundColor.copy(alpha = 0.3f),
            modifier = Modifier
                .padding(bottom = 8.dp)
                .fillMaxWidth(),
            elevation = 0.dp

        ) {
            Row(
                modifier = Modifier.padding(vertical = 10.dp, horizontal = 14.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(34.dp)
                            .clip(shape = Shapes.medium)


                    ) {
                        Icon(
                            imageVector = icon,
                            contentDescription = null,
                            tint = SecondaryTextColor,
                            modifier = Modifier.padding(8.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(14.dp))
                    Column {
                        Text(
                            text = mainText,
                            fontFamily = Poppins,
                            color = SecondaryTextColor,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.ExtraLight,

                            )

                    }
                }
                Icon(
                    imageVector = Icons.Default.ArrowRight,
                    contentDescription = null,
//                tint = ,
                    modifier = Modifier.size(20.dp)
                )
            }
        }
    }

