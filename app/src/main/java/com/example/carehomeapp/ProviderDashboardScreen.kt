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
fun ProviderDashboardScreen() {

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

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Silver Oaks Dashboard",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1E6B78),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Welcome, Manager!",
            fontSize = 13.sp,
            color = Color(0xFF6B8790),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(18.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            StatCard(
                number = "08",
                iconRes = R.drawable.icon_medical_services,
                label = "Available\nBeds",
                bg = Color(0xFFE4F4F7),
                modifier = Modifier.weight(1f)
            )

            StatCard(
                number = "12",
                iconRes = R.drawable.icon_email,
                label = "Pending\nInquiries",
                bg = Color(0xFFFFF1DC),
                modifier = Modifier.weight(1f)
            )

            RatingStatCard(
                modifier = Modifier.weight(1f)
            )
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
                        "Search Appearances",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF1E6B78)
                    )

                    Text(
                        "This Week⌄",
                        fontSize = 11.sp,
                        color = Color.Gray
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

                ActivityChart()

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    BottomStat(
                        iconRes = R.drawable.icon_eye,
                        number = "440",
                        label = "Total Visits",
                        bg = Color(0xFFE4F4F7),
                        modifier = Modifier.weight(1f)
                    )

                    BottomStat(
                        iconRes = R.drawable.icon_medical_services,
                        number = "20",
                        label = "Booked Beds",
                        bg = Color(0xFFFFF1DC),
                        modifier = Modifier.weight(1f)
                    )

                    BottomStat(
                        iconRes = R.drawable.icon_email,
                        number = "05",
                        label = "New Inquiries",
                        bg = Color(0xFFE4F4F7),
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        BottomNavBar()
    }
}

@Composable
private fun StatCard(
    number: String,
    iconRes: Int,
    label: String,
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
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                number,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1E6B78)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(bg, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(iconRes),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp)
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                label,
                fontSize = 10.sp,
                color = Color(0xFF1E6B78)
            )
        }
    }
}

@Composable
private fun RatingStatCard(
    modifier: Modifier
) {
    Card(
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(5.dp),
        modifier = modifier.height(122.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                "4.4",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1E6B78)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Row {
                repeat(4) {
                    Image(
                        painter = painterResource(R.drawable.rating_star_filled),
                        contentDescription = null,
                        modifier = Modifier.size(13.dp)
                    )
                }

                Image(
                    painter = painterResource(R.drawable.rating_star_half),
                    contentDescription = null,
                    modifier = Modifier.size(13.dp)
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                "Average\nReviews",
                fontSize = 10.sp,
                color = Color(0xFF1E6B78)
            )
        }
    }
}

@Composable
private fun ActivityChart() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(190.dp)
    ) {
        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
        ) {
            val width = size.width
            val height = size.height

            val points = listOf(
                Offset(width * 0.05f, height * 0.72f),
                Offset(width * 0.20f, height * 0.75f),
                Offset(width * 0.35f, height * 0.58f),
                Offset(width * 0.50f, height * 0.60f),
                Offset(width * 0.65f, height * 0.53f),
                Offset(width * 0.80f, height * 0.35f),
                Offset(width * 0.94f, height * 0.12f)
            )

            val path = Path().apply {
                moveTo(points[0].x, points[0].y)
                for (i in 1 until points.size) {
                    lineTo(points[i].x, points[i].y)
                }
            }

            drawLine(
                color = Color(0xFFE6E6E6),
                start = Offset(0f, height * 0.25f),
                end = Offset(width, height * 0.25f),
                strokeWidth = 1f
            )

            drawLine(
                color = Color(0xFFE6E6E6),
                start = Offset(0f, height * 0.50f),
                end = Offset(width, height * 0.50f),
                strokeWidth = 1f
            )

            drawLine(
                color = Color(0xFFE6E6E6),
                start = Offset(0f, height * 0.75f),
                end = Offset(width, height * 0.75f),
                strokeWidth = 1f
            )

            drawPath(
                path = path,
                color = Color(0xFFD59632),
                style = Stroke(width = 4f)
            )

            points.forEach {
                drawCircle(Color.White, radius = 7f, center = it)
                drawCircle(Color(0xFFD59632), radius = 4f, center = it)
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            listOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun").forEach {
                Text(it, fontSize = 9.sp, color = Color.Gray)
            }
        }
    }
}

@Composable
private fun BottomStat(
    iconRes: Int,
    number: String,
    label: String,
    bg: Color,
    modifier: Modifier
) {
    Column(
        modifier = modifier
            .height(100.dp)
            .background(bg, RoundedCornerShape(14.dp))
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(iconRes),
            contentDescription = null,
            modifier = Modifier.size(22.dp)
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            number,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1E6B78)
        )

        Text(
            label,
            fontSize = 9.sp,
            color = Color(0xFF6B8790)
        )
    }
}

@Composable
private fun BottomNavBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
            .background(Color.White, RoundedCornerShape(22.dp)),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        NavItem("🏠", "Dashboard", true)
        NavItem("🛏", "Beds", false)
        NavItem("✉", "Inquiries", false)
        NavItem("⚙", "Settings", false)
    }
}

@Composable
private fun NavItem(
    icon: String,
    text: String,
    selected: Boolean
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(icon, fontSize = 18.sp)

        Text(
            text,
            fontSize = 10.sp,
            color = if (selected) Color(0xFF1E6B78) else Color.Gray,
            fontWeight = if (selected) FontWeight.Bold else FontWeight.Normal
        )
    }
}