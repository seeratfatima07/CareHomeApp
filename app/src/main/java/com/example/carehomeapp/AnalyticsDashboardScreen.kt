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
fun AnalyticsDashboardScreen(
    onBackClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8FAFB))
            .padding(horizontal = 18.dp, vertical = 20.dp)
    ) {

        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.ic_arrow_back),
                contentDescription = null,
                modifier = Modifier.size(18.dp)
            )
        }

        Spacer(modifier = Modifier.height(22.dp))

        Text(
            text = "Analytics Dashboard",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1E6B78),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Performance Overview",
            fontSize = 13.sp,
            color = Color(0xFF6F8B91),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(22.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            TopMetricCard("👁", "1,240", "Profile Views", "▲ 12%", Modifier.weight(1f))
            TopMetricCard("🔍", "890", "Search\nAppearances", "▲ 8%", Modifier.weight(1f))
            TopMetricCard("✉", "156", "Inquiries\nReceived", "▲ 20%", Modifier.weight(1f))
        }

        Spacer(modifier = Modifier.height(16.dp))

        ChartCard(title = "Profile Views Trend") {
            LineChart()
        }

        Spacer(modifier = Modifier.height(14.dp))

        ChartCard(title = "Inquiries Overview") {
            BarChart()
        }

        Spacer(modifier = Modifier.height(14.dp))

        BottomStatsCard()
    }
}

@Composable
private fun TopMetricCard(
    icon: String,
    number: String,
    label: String,
    percent: String,
    modifier: Modifier
) {
    Card(
        modifier = modifier.height(118.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .size(36.dp)
                    .background(Color(0xFFE2F3F6), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(icon, fontSize = 16.sp)
            }

            Spacer(modifier = Modifier.height(6.dp))

            Text(number, fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1E6B78))
            Text(label, fontSize = 9.sp, color = Color(0xFF1E6B78))
            Text(percent, fontSize = 10.sp, color = Color.Black)
        }
    }
}

@Composable
private fun ChartCard(
    title: String,
    chart: @Composable () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(145.dp),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 14.dp, vertical = 10.dp)
        ) {
            Text(
                text = title,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1E6B78)
            )

            Spacer(modifier = Modifier.height(6.dp))

            chart()
        }
    }
}

@Composable
private fun LineChart() {
    Column {
        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(92.dp)
        ) {
            val w = size.width
            val h = size.height

            val points = listOf(
                Offset(w * 0.15f, h * 0.70f),
                Offset(w * 0.32f, h * 0.55f),
                Offset(w * 0.48f, h * 0.58f),
                Offset(w * 0.63f, h * 0.50f),
                Offset(w * 0.76f, h * 0.25f),
                Offset(w * 0.88f, h * 0.28f),
                Offset(w * 0.96f, h * 0.45f)
            )

            drawLine(Color(0xFFE5E7EB), Offset(0f, h * 0.25f), Offset(w, h * 0.25f), 1.5f)
            drawLine(Color(0xFFE5E7EB), Offset(0f, h * 0.50f), Offset(w, h * 0.50f), 1.5f)
            drawLine(Color(0xFFE5E7EB), Offset(0f, h * 0.75f), Offset(w, h * 0.75f), 1.5f)

            val path = Path().apply {
                moveTo(points[0].x, points[0].y)
                for (i in 1 until points.size) {
                    lineTo(points[i].x, points[i].y)
                }
            }

            drawPath(
                path = path,
                color = Color(0xFFD59632),
                style = Stroke(width = 3.5f)
            )

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
                Text(it, fontSize = 8.sp, color = Color(0xFF1E6B78))
            }
        }
    }
}

@Composable
private fun BarChart() {
    Column {
        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(92.dp)
        ) {
            val w = size.width
            val h = size.height
            val bars = listOf(0.20f, 0.75f, 0.60f, 0.88f, 0.32f, 0.68f, 0.75f)
            val barWidth = w / 13f
            val gap = w / 18f

            drawLine(Color(0xFFE5E7EB), Offset(0f, h * 0.25f), Offset(w, h * 0.25f), 1.5f)
            drawLine(Color(0xFFE5E7EB), Offset(0f, h * 0.50f), Offset(w, h * 0.50f), 1.5f)
            drawLine(Color(0xFFE5E7EB), Offset(0f, h * 0.75f), Offset(w, h * 0.75f), 1.5f)

            bars.forEachIndexed { index, value ->
                val left = gap + index * (barWidth + gap)
                val top = h - (h * value)
                drawRoundRect(
                    color = Color(0xFF6F8B91),
                    topLeft = Offset(left, top),
                    size = androidx.compose.ui.geometry.Size(barWidth, h - top),
                    cornerRadius = androidx.compose.ui.geometry.CornerRadius(5f, 5f)
                )
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            listOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun").forEach {
                Text(it, fontSize = 8.sp, color = Color(0xFF1E6B78))
            }
        }
    }
}

@Composable
private fun BottomStatsCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(68.dp),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BottomStat("★ 4.6", "Average Rating")
            BottomStat("◔ 2 hrs", "Response Time")
            BottomStat("▥ 18%", "Conversion Rate")
        }
    }
}

@Composable
private fun BottomStat(
    value: String,
    label: String
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(value, fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color(0xFF1E6B78))
        Spacer(modifier = Modifier.height(4.dp))
        Text(label, fontSize = 9.sp, color = Color(0xFF6F8B91))
    }
}