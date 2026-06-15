package com.nandakishore.Prepiq

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(onSplashFinished: () -> Unit) {
    LaunchedEffect(Unit) {
        delay(1000L) // 1 second delay
        onSplashFinished()
    }

    val backgroundColorTop = Color(0xFFFCFCFB)
    val backgroundColorBottom = Color(0xFFEFECE2)
    val prepColor = Color(0xFF13151D)
    val iqColor = Color(0xFF3333FF)
    val subtitleColor = Color(0xFF6B6A70)
    val dotColor = Color(0xFF9093EE)
    val bottomTextColor = Color(0xFF6B6A70)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(backgroundColorTop, backgroundColorBottom)
                )
            )
    ) {
        // Main Content (Centered)
        Column(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(horizontal = 48.dp)
                .offset(y = (-40).dp), // slightly above center
            horizontalAlignment = Alignment.Start
        ) {
            // Logo Row
            Row(
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = "Prep",
                    color = prepColor,
                    fontSize = 64.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif
                )
                Text(
                    text = "IQ",
                    color = iqColor,
                    fontSize = 64.sp,
                    fontWeight = FontWeight.Normal,
                    fontStyle = FontStyle.Italic,
                    fontFamily = FontFamily.Serif
                )
            }

            // Line under "Prep"
            Box(
                modifier = Modifier
                    .width(110.dp) // matches approx width of "Prep"
                    .height(2.dp)
                    .background(prepColor)
                    .offset(y = 4.dp)
            )
            
            Spacer(modifier = Modifier.height(32.dp))

            // Subtitle
            Text(
                text = "A quieter way to get ready for\nthe interview that matters.",
                color = subtitleColor,
                fontSize = 20.sp,
                lineHeight = 28.sp,
                fontFamily = FontFamily.SansSerif
            )
        }

        // Bottom Loading Text
        Row(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(start = 48.dp, bottom = 64.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(8.dp)
                    .clip(CircleShape)
                    .background(dotColor)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                text = "Getting your workspace ready",
                color = bottomTextColor,
                fontSize = 16.sp,
                fontFamily = FontFamily.SansSerif
            )
        }
    }
}
