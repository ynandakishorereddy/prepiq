package com.nandakishore.Prepiq

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class ReminderItem(
    val title: String,
    val description: String,
    val time: String,
    val frequency: String,
    val isActive: Boolean
)

@Composable
fun RemindersScreen() {
    val backgroundColor = Color(0xFFF5F4F0)
    val textColor = Color(0xFF13151D)
    val subtitleColor = Color(0xFF6B6A70)
    val primaryBlue = Color(0xFF5C5AE8)
    val iconBgColor = Color(0xFFEAE9FE)

    var mockReminders by remember {
        mutableStateOf(
            listOf(
                ReminderItem("Daily warm-up", "Answer one behavioral\nquestion to keep momentum.", "8:30 AM", "Every day", true),
                ReminderItem("System design drill", "Work through one design\nprompt end-to-end.", "7:00 PM", "Mon, Wed, Fri", true),
                ReminderItem("Resume review", "Revisit AI rewrites and\nupdate one bullet.", "6:00 PM", "Sundays", false),
                ReminderItem("Mock interview", "Full 8-question session\nbefore your Stripe loop.", "10:00 AM", "Sat, Jun 20", true)
            )
        )
    }

    val activeCount = mockReminders.count { it.isActive }
    val totalCount = mockReminders.size

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(horizontal = 24.dp)
            .padding(top = 48.dp)
    ) {
        // Top Header
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "Reminders",
                    color = textColor,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "$activeCount of $totalCount active",
                    color = subtitleColor,
                    fontSize = 14.sp
                )
            }

            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(primaryBlue),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add Reminder",
                    tint = Color.White
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Reminders List
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(bottom = 24.dp)
        ) {
            items(mockReminders.indices.toList()) { index ->
                val reminder = mockReminders[index]
                
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Column(
                        modifier = Modifier.padding(20.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.Top
                        ) {
                            // Icon
                            Box(
                                modifier = Modifier
                                    .size(40.dp)
                                    .clip(CircleShape)
                                    .background(iconBgColor),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Notifications,
                                    contentDescription = null,
                                    tint = primaryBlue,
                                    modifier = Modifier.size(20.dp)
                                )
                            }

                            Spacer(modifier = Modifier.width(16.dp))

                            // Texts
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = reminder.title,
                                    color = if (reminder.isActive) textColor else subtitleColor,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = reminder.description,
                                    color = subtitleColor,
                                    fontSize = 14.sp,
                                    lineHeight = 20.sp
                                )
                            }

                            Spacer(modifier = Modifier.width(16.dp))

                            // Switch
                            Switch(
                                checked = reminder.isActive,
                                onCheckedChange = { isChecked ->
                                    val newList = mockReminders.toMutableList()
                                    newList[index] = reminder.copy(isActive = isChecked)
                                    mockReminders = newList
                                },
                                colors = SwitchDefaults.colors(
                                    checkedThumbColor = Color.White,
                                    checkedTrackColor = primaryBlue,
                                    uncheckedThumbColor = Color.White,
                                    uncheckedTrackColor = Color(0xFFE0E0E0),
                                    uncheckedBorderColor = Color.Transparent
                                )
                            )
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        // Time & Frequency
                        Row(
                            modifier = Modifier.padding(start = 56.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                // Note: Typically you'd use a Clock icon here, using generic as fallback
                                imageVector = Icons.Default.Notifications, 
                                contentDescription = null,
                                tint = subtitleColor,
                                modifier = Modifier.size(14.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "${reminder.time}  •  ${reminder.frequency}",
                                color = subtitleColor,
                                fontSize = 12.sp
                            )
                        }
                    }
                }
            }
        }
    }
}
