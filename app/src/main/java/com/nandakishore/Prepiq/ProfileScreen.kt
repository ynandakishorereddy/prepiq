package com.nandakishore.Prepiq

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.HelpOutline
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.PersonOutline
import androidx.compose.material.icons.outlined.Logout
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileScreen() {
    val backgroundColor = Color(0xFFF5F4F0)
    val textColor = Color(0xFF13151D)
    val subtitleColor = Color(0xFF6B6A70)
    val primaryBlue = Color(0xFF5C5AE8)
    val redColor = Color(0xFFEF4444)
    val lightRedColor = Color(0xFFFEF2F2)
    val redBorderColor = Color(0xFFFCA5A5)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(horizontal = 24.dp)
            .padding(top = 48.dp)
    ) {
        Text(
            text = "Profile",
            color = textColor,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Profile Header Card
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
                // Avatar
                Box(
                    modifier = Modifier
                        .size(64.dp)
                        .clip(CircleShape)
                        .background(primaryBlue),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "NK",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.width(16.dp))

                // Info
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Nanda Kishore",
                        color = textColor,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = "Senior Backend Engin...",
                        color = subtitleColor,
                        fontSize = 14.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        text = "nanda@prepiq.app",
                        color = subtitleColor,
                        fontSize = 14.sp
                    )
                }

                Spacer(modifier = Modifier.width(16.dp))

                // Edit Button
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(Color(0xFFF5F4F0))
                        .clickable { /* TODO */ },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "Edit Profile",
                        tint = subtitleColor,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Stats Row
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            StatCard(modifier = Modifier.weight(1f), title = "5", subtitle = "Sessions")
            StatCard(modifier = Modifier.weight(1f), title = "73%", subtitle = "Avg score")
            StatCard(modifier = Modifier.weight(1f), title = "3", subtitle = "Resumes")
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Menu List Card
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column {
                MenuItem(
                    icon = Icons.Default.Edit,
                    text = "Edit profile",
                    onClick = { /* TODO */ }
                )
                Divider(color = Color(0xFFF5F4F0), thickness = 1.dp, modifier = Modifier.padding(horizontal = 16.dp))
                MenuItem(
                    icon = Icons.Default.Notifications,
                    text = "Reminders",
                    trailingText = "3 active",
                    onClick = { /* TODO */ }
                )
                Divider(color = Color(0xFFF5F4F0), thickness = 1.dp, modifier = Modifier.padding(horizontal = 16.dp))
                MenuItem(
                    icon = Icons.Default.Description,
                    text = "My resumes",
                    trailingText = "3",
                    onClick = { /* TODO */ }
                )
                Divider(color = Color(0xFFF5F4F0), thickness = 1.dp, modifier = Modifier.padding(horizontal = 16.dp))
                MenuItem(
                    icon = Icons.Default.HelpOutline,
                    text = "Help & feedback",
                    onClick = { /* TODO */ }
                )
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Sign out Button
        OutlinedButton(
            onClick = { /* TODO */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(16.dp),
            border = BorderStroke(1.dp, redBorderColor),
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = lightRedColor,
                contentColor = redColor
            )
        ) {
            Icon(
                imageVector = Icons.Outlined.Logout,
                contentDescription = "Sign out",
                tint = redColor
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Sign out",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = redColor
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        // Version Info
        Box(
            modifier = Modifier.fillMaxWidth().padding(bottom = 24.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "PrepIQ v1.0.0",
                color = subtitleColor,
                fontSize = 12.sp
            )
        }
    }
}

@Composable
fun StatCard(modifier: Modifier = Modifier, title: String, subtitle: String) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                color = Color(0xFF13151D),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = subtitle,
                color = Color(0xFF6B6A70),
                fontSize = 12.sp
            )
        }
    }
}

@Composable
fun MenuItem(
    icon: ImageVector,
    text: String,
    trailingText: String? = null,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(0xFF6B6A70),
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = text,
            color = Color(0xFF13151D),
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.weight(1f)
        )
        if (trailingText != null) {
            Text(
                text = trailingText,
                color = Color(0xFF6B6A70),
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.width(8.dp))
        }
        Icon(
            imageVector = Icons.Default.ChevronRight,
            contentDescription = null,
            tint = Color(0xFF6B6A70)
        )
    }
}
