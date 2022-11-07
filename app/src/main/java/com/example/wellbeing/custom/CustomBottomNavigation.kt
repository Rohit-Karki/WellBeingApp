package com.example.wellbeing.custom

import android.graphics.Color.parseColor
import android.widget.GridLayout
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Center
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

import com.example.wellbeing.ui.theme.BackGroundColor
import com.example.wellbeing.ui.theme.BackGroundColorSecondary
import com.example.wellbeing.ui.theme.Poppins
import com.example.wellbeing.ui.theme.Shapes



@Composable
fun CustomBottomNavigation(
//    currentScreenId:String,
//    onItemSelected:(Screen)->Unit,
    navController: NavController
){
    val items = Screen.Items.list
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination




    Row(
        modifier = Modifier
//            .background(MaterialTheme.colors.background, RoundedCornerShape(9.dp))

//            .padding(50.dp, 0.dp, 0.dp, 10.dp)


            .background(color = Color.LightGray, RoundedCornerShape(12.dp))
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 40.dp)

            ,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically

    ) {
        items.forEach{
                item ->

//            CustomBottomNavigationItem(item = item,isSelected = item.id == currentScreenId)
//            {
//                onItemSelected(item)
//            }
            CustomBottomNavigationItem(item = item, currentDestination = currentDestination,navController = navController)

            }
    }
}



@Composable
//fun CustomBottomNavigationItem(item:Screen, isSelected:Boolean,onClick: () -> Unit){
fun CustomBottomNavigationItem(item:Screen, currentDestination: NavDestination?,
                               navController: NavController,
                               isSelected: Boolean = currentDestination?.hierarchy?.any {
                                   it.route == item.id
                               }== true,

                               onClick: () -> Unit ={
                                   navController.navigate(item.id)
                               },

){

    val background = if (isSelected) BackGroundColorSecondary.copy(alpha = 0.69f) else Color.Transparent
//    val background = if (isSelected) MaterialTheme.colors.primary.copy(alpha = 0.1f) else Color.Transparent
    val contentColor = if (isSelected) BackGroundColor else MaterialTheme.colors.onBackground

        Box(
            modifier = Modifier
//                .clip(RoundedCornerShape(40.dp))
//                .background(background, CircleShape)
                .clickable(onClick = onClick)
                .fillMaxHeight(),
            contentAlignment = Alignment.Center

        ) {

            Column(
                if (isSelected)
                    Modifier.offset(y = (-8).dp)
                else Modifier,

                horizontalAlignment = Alignment.CenterHorizontally,

                ) {
                Box(
                    Modifier
                        .background(background, CircleShape)
                        .size(36.dp),
                    contentAlignment = Alignment.Center
                ) {



                    Icon(
                        imageVector = item.icon,
                        contentDescription = null,
                        tint = contentColor,
                        modifier = Modifier
                            .size(24.dp)



                    )
                    Spacer(Modifier.height(12.dp))




                }
                AnimatedVisibility(visible = isSelected) {

                    Text(
                        text = item.title,
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                        fontFamily = Poppins,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.ExtraLight,
                        modifier = Modifier.padding(top = 4.dp)


                    )

                }
            }



        }
    }




