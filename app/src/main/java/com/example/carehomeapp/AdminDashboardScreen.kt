package com.example.carehomeapp

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AdminDashboardScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8FAFB))
            .padding(horizontal = 18.dp, vertical = 18.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Box {
                Image(
                    painter = painterResource(R.drawable.reviewer_avatar),
                    contentDescription = null,
                    modifier = Modifier
                        .size(42.dp)
                        .clip(CircleShape)
                )

                Box(
                    modifier = Modifier
                        .size(14.dp)
                        .background(Color.Red, CircleShape)
                        .align(Alignment.TopEnd),
                    contentAlignment = Alignment.Center
                ) {
                    Text("3", color = Color.White, fontSize = 8.sp)
                }
            }
        }

        Spacer(modifier = Modifier.height(18.dp))

        Text(
            text = "Admin Dashboard",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1E6B78),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Welcome back,Admin!",
            fontSize = 13.sp,
            color = Color(0xFF6B8790),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(18.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            AdminStatCard("850", "⌂", "Total Care\nHomes", "▲ 5%", Color(0xFFE4F4F7), Modifier.weight(1f))
            AdminStatCard("12", "📋", "Pending\nVerifications", "3 more than last...", Color(0xFFFFF1DC), Modifier.weight(1f))
            AdminStatCard("2,340", R.drawable.avatar_john, "Active Users", "▲ 8%", Modifier.weight(1f))
        }

        Spacer(modifier = Modifier.height(18.dp))

        Card(
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(Color.White),
            elevation = CardDefaults.cardElevation(5.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        "Platform Stats",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF1E6B78)
                    )

                    Text(
                        "This Week⌄",
                        fontSize = 11.sp,
                        color = Color.Gray,
                        modifier = Modifier
                            .background(Color.White, RoundedCornerShape(12.dp))
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    "Weekly Activity Overview",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1E6B78)
                )

                Spacer(modifier = Modifier.height(12.dp))

                AdminLineChart()

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    AdminBottomStat("👁", "35.6k", "Total Visits", Color(0xFFE4F4F7), Modifier.weight(1f))
                    AdminBottomStat("⌕", "7,412", "Searches Made", Color(0xFFFFF1DC), Modifier.weight(1f))
                    AdminBottomStat("✉", "4,128", "New Inquiries", Color(0xFFE4F4F7), Modifier.weight(1f))
                }
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1E6B78)),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp)
        ) {
            Text(
                "Announcements",
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
private fun AdminStatCard(
    number: String,
    icon: String,
    label: String,
    bottom: String,
    bg: Color,
    modifier: Modifier
) {
    Card(
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(5.dp),
        modifier = modifier.height(122.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(number, fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1E6B78))

            Spacer(modifier = Modifier.height(6.dp))

            Box(
                modifier = Modifier.size(36.dp).background(bg, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(icon, fontSize = 17.sp)
            }

            Spacer(modifier = Modifier.height(6.dp))

            Text(label, fontSize = 9.sp, color = Color(0xFF1E6B78))

            Spacer(modifier = Modifier.height(4.dp))

            Text(bottom, fontSize = 9.sp, color = Color(0xFF1E6B78))
        }
    }
}

@Composable
private fun AdminStatCard(
    number: String,
    avatar: Int,
    label: String,
    bottom: String,
    modifier: Modifier
) {
    Card(
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(5.dp),
        modifier = modifier.height(122.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(number, fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1E6B78))

            Spacer(modifier = Modifier.height(6.dp))

            Image(
                painter = painterResource(avatar),
                contentDescription = null,
                modifier = Modifier.size(36.dp).clip(CircleShape)
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(label, fontSize = 9.sp, color = Color(0xFF1E6B78))

            Spacer(modifier = Modifier.height(4.dp))

            Text(bottom, fontSize = 9.sp, color = Color(0xFF1E6B78))
        }
    }
}

@Composable
private fun AdminLineChart() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(185.dp)
    ) {
        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
        ) {
            val w = size.width
            val h = size.height

            val points = listOf(
                Offset(w * 0.06f, h * 0.78f),
                Offset(w * 0.22f, h * 0.75f),
                Offset(w * 0.35f, h * 0.55f),
                Offset(w * 0.52f, h * 0.58f),
                Offset(w * 0.68f, h * 0.50f),
                Offset(w * 0.82f, h * 0.20f),
                Offset(w * 0.94f, h * 0.30f)
            )

            val path = Path().apply {
                moveTo(points[0].x, points[0].y)
                for (i in 1 until points.size) {
                    lineTo(points[i].x, points[i].y)
                }
            }

            drawLine(Color(0xFFE5E7EB), Offset(0f, h * 0.25f), Offset(w, h * 0.25f), 1.5f)
            drawLine(Color(0xFFE5E7EB), Offset(0f, h * 0.50f), Offset(w, h * 0.50f), 1.5f)
            drawLine(Color(0xFFE5E7EB), Offset(0f, h * 0.75f), Offset(w, h * 0.75f), 1.5f)

            drawPath(path, Color(0xFFD59632), style = Stroke(width = 3.5f))

            points.forEach {
                drawCircle(Color.White, radius = 6f, center = it)
                drawCircle(Color(0xFFD59632), radius = 3.5f, center = it)
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            listOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun").forEach {
                Text(it, fontSize = 9.sp, color = Color(0xFF1E6B78))
            }
        }
    }
}

@Composable
private fun AdminBottomStat(
    icon: String,
    number: String,
    label: String,
    bg: Color,
    modifier: Modifier
) {
    Column(
        modifier = modifier
            .height(98.dp)
            .background(bg, RoundedCornerShape(14.dp))
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(icon, fontSize = 20.sp)

        Spacer(modifier = Modifier.height(5.dp))

        Text(number, fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1E6B78))

        Text(label, fontSize = 9.sp, color = Color(0xFF6B8790))
    }
}

