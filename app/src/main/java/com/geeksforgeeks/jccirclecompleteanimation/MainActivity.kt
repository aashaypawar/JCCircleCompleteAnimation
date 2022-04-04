package com.geeksforgeeks.jccirclecompleteanimation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    @SuppressLint("RememberReturnType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            // Creating a Simple Scaffold Layout for the application
            Scaffold(

                // Creating a Top Bar
                topBar = { TopAppBar(title = { Text("GFG | Circle Animation", color = Color.White) }, backgroundColor = Color(0xff0f9d58)) },

                // Creating Content
                content = {

                    // Creating a Column Layout
                    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {

                        // Declaring circle radius
                        val radius = 200f

                        // Creating animation
                        val animateFloat = remember { Animatable(0f) }
                        LaunchedEffect(animateFloat) {
                            animateFloat.animateTo(
                                targetValue = 1f,
                                animationSpec = tween(durationMillis = 3000, easing = LinearEasing))
                        }

                        // Creating Arc with useCenter as True
                        Row{
                            Canvas(modifier = Modifier.width(100.dp).height(100.dp)){
                                drawArc(
                                    color = Color.Black,
                                    startAngle = 0f,
                                    sweepAngle = 360f * animateFloat.value,
                                    useCenter = true,
                                    size = Size(radius * 2 , radius * 2),
                                    style = Stroke(2.0f)
                                )
                            }
                        }

                        // Adding a Space of height 100dp
                        Spacer(modifier = Modifier.height(100.dp))

                        // Creating Arc with useCenter as False
                        Row{
                            Canvas(modifier = Modifier.width(100.dp).height(100.dp)){
                                drawArc(
                                    color = Color.Black,
                                    startAngle = 0f,
                                    sweepAngle = 360f * animateFloat.value,
                                    useCenter = false,
                                    size = Size(radius * 2 , radius * 2),
                                    style = Stroke(2.0f)
                                )
                            }
                        }

                    }
                }
            )
        }
    }
}