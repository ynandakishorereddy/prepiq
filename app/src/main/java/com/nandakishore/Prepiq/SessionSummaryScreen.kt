package com.nandakishore.Prepiq

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class SummaryQuestionItem(val id: Int, val text: String, val status: String)

@Composable
fun SessionSummaryScreen(
    onNavigateBack: () -> Unit,
    onDone: () -> Unit,
    onStartNewSession: () -> Unit
) {
    val backgroundColor = Color(0xFFF5F4F0)
    val textColor = Color(0xFF13151D)
    val subtitleColor = Color(0xFF6B6A70)
    val scoreColor = Color(0xFFE15131)
    val greenButtonColor = Color(0xFF16803C)
    val indexBgColor = Color(0xFFEBE9E0)

    val mockQuestions = listOf(
        SummaryQuestionItem(1, "How would you design a rate limiter?", "Skipped"),
        SummaryQuestionItem(2, "Tell me about a time you disagreed...", "Skipped"),
        SummaryQuestionItem(3, "Explain how you'd containerize this...", "Skipped"),
        SummaryQuestionItem(4, "When would you reach for Redis ov...", "Skipped"),
        SummaryQuestionItem(5, "Describe a project that failed.", "Skipped"),
        SummaryQuestionItem(6, "Walk me through scaling a database.", "Skipped"),
        SummaryQuestionItem(7, "How do you prioritize when you ha...", "Skipped")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(horizontal = 24.dp)
            .padding(top = 48.dp)
    ) {
        // Top Bar
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(Color.White)
                    .clickable { onNavigateBack() },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.Black
                )
            }
            
            Spacer(modifier = Modifier.width(16.dp))
            
            Text(
                text = "Session Summary",
                color = textColor,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Overall Score Card
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "0%",
                    color = scoreColor,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif
                )
                
                Spacer(modifier = Modifier.width(24.dp))
                
                Column {
                    Text(
                        text = "Overall score",
                        color = textColor,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "8 questions  •  Nanda_SWE_202",
                        color = subtitleColor,
                        fontSize = 14.sp
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Questions List
        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(mockQuestions) { question ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Index Circle
                        Box(
                            modifier = Modifier
                                .size(32.dp)
                                .clip(CircleShape)
                                .background(indexBgColor),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = question.id.toString(),
                                color = textColor,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Spacer(modifier = Modifier.width(16.dp))

                        // Question Text
                        Text(
                            text = question.text,
                            color = textColor,
                            fontSize = 14.sp,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.weight(1f)
                        )

                        Spacer(modifier = Modifier.width(16.dp))

                        // Status Text
                        Text(
                            text = question.status,
                            color = subtitleColor,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Bottom Actions
        Column(
            modifier = Modifier.padding(bottom = 32.dp)
        ) {
            Button(
                onClick = { onDone() },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = greenButtonColor)
            ) {
                Text(
                    text = "Done",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedButton(
                onClick = { onStartNewSession() },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(16.dp),
                border = BorderStroke(1.dp, Color(0xFFE0E0E0)),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color.Transparent,
                    contentColor = subtitleColor
                )
            ) {
                Text(
                    text = "Start New Session",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = subtitleColor
                )
            }
        }
    }
}
