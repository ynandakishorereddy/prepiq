package com.nandakishore.Prepiq

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class SessionItem(val company: String, val role: String, val date: String, val score: Int)

@Composable
fun HomeScreen() {
    val backgroundColor = Color(0xFFF5F4F0)
    val textColor = Color(0xFF13151D)
    val subtitleColor = Color(0xFF6B6A70)
    val primaryBlue = Color(0xFF5C5AE8)

    val mockSessions = listOf(
        SessionItem("Stripe", "Senior Backend Engineer", "Jun 11, 2026", 84),
        SessionItem("Airbnb", "Full-Stack Engineer", "Jun 8, 2026", 72),
        SessionItem("Datadog", "Platform Engineer", "Jun 3, 2026", 61),
        SessionItem("Notion", "Systems Engineer", "May 28, 2026", 90)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(horizontal = 24.dp)
            .padding(top = 48.dp)
    ) {
        Text(
            text = "Sunday, 14 June",
            color = subtitleColor,
            fontSize = 14.sp,
            fontFamily = FontFamily.SansSerif
        )
        
        Spacer(modifier = Modifier.height(4.dp))
        
        Text(
            text = "Morning, Nanda.",
            color = textColor,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Top Cards
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Card(
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "5",
                        color = textColor,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Sessions",
                        color = subtitleColor,
                        fontSize = 14.sp
                    )
                }
            }

            Card(
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "72%",
                        color = primaryBlue,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Avg score",
                        color = subtitleColor,
                        fontSize = 14.sp
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // New Session Button
        Button(
            onClick = { /* TODO */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = primaryBlue)
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "New",
                tint = Color.White
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "New Session",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Past Sessions Header
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Past sessions",
                color = textColor,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "5 total",
                color = subtitleColor,
                fontSize = 14.sp
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Sessions List
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(bottom = 24.dp)
        ) {
            items(mockSessions) { session ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = session.company,
                                color = textColor,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = session.role,
                                color = subtitleColor,
                                fontSize = 14.sp
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = session.date,
                                color = subtitleColor,
                                fontSize = 12.sp
                            )
                        }

                        val scoreColor = when {
                            session.score >= 80 -> Color(0xFF22C55E)
                            session.score >= 70 -> Color(0xFFF59E0B)
                            else -> Color(0xFFEF4444)
                        }

                        Text(
                            text = session.score.toString(),
                            color = scoreColor,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                        
                        Spacer(modifier = Modifier.width(16.dp))
                        
                        Icon(
                            imageVector = Icons.Default.ChevronRight,
                            contentDescription = "Details",
                            tint = subtitleColor
                        )
                    }
                }
            }
        }
    }
}
