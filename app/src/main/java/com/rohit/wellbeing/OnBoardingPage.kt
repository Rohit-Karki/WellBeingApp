package com.rohit.wellbeing

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rohit.wellbeing.model.Page

@Composable
fun OnBoardingPage(page: Page) {
    var textValue by remember {
        mutableStateOf("")
    }
    Column(modifier= Modifier
        .background(color = Color.White)
        .padding(vertical = 40.dp),
        horizontalAlignment = CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween) {
        Text(text = "Fitness App", fontSize = 30.sp, fontWeight= FontWeight.Bold)
        Text(
            buildAnnotatedString {
            withStyle(style = ParagraphStyle(lineHeight = 40.sp)) {
                withStyle(style = SpanStyle(color = Color.Black)) {
                    append("Tell Us\n")
                }
                append(page.title)
            }
        }, fontSize = 50.sp, fontWeight= FontWeight.Bold,
        textAlign = TextAlign.Center
        )
        TextField(value = textValue,
            modifier = Modifier.drawBehind {
                val strokeWidth = 5 * density
                val y = size.height - strokeWidth / 2
                drawLine(
                    Color.Black,
                    Offset(0f, y),
                    Offset(size.width, y),
                    strokeWidth
                )
            },
            textStyle = TextStyle(fontSize = 20.sp),
            onValueChange ={
            textValue = it
        },
            placeholder={ Text(text = page.description, fontSize = 20.sp, fontWeight = FontWeight.Bold)},
            colors=TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                focusedIndicatorColor =  Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            )
        )

        androidx.compose.material3.IconButton(onClick = {},modifier=Modifier.background(color=Color.Black),colors=IconButtonDefaults.iconButtonColors(contentColor = Color.White)) {
            Icon(Icons.Default.ArrowForward, contentDescription = "Go Forward")
        }

    }
}