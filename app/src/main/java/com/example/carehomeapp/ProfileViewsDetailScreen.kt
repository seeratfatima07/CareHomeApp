package com.example.carehomeapp


import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class TopVisitor(
    val name: String,
    val location: String,
    val views: String,
    val avatar: Int
)

@Composable
fun ProfileViewsDetailScreen() {

    val visitors = listOf(
        TopVisitor("Michael Smith", "London, UK", "235 Views", R.drawable.avatar_michael),
        TopVisitor("Sara Ahmed", "Marketing Manager", "290 Views", R.drawable.avatar_sara),
        TopVisitor("John Ellis", "Austin, TX", "157 Views", R.drawable.avatar_john)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8FAFB))
            .padding(horizontal = 22.dp, vertical = 22.dp)
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

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Profile Views Detail",
            color = Color(0xFF1E6B78),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(22.dp))

        Card(
            shape = RoundedCornerShape(18.dp),
            colors = CardDefaults.cardColors(Color.White),
            elevation = CardDefaults.cardElevation(0.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "1,240",
                        color = Color(0xFF1E6B78),
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.width(18.dp))

                    Text(
                        "Total Views",
                        color = Color.Black,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    Text(
                        "▲ 15.8%",
                        color = Color(0xFF1E6B78),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        " This Week",
                        color = Color.Gray,
                        fontSize = 9.sp
                    )
                }

                Spacer(modifier = Modifier.height(14.dp))

                Box(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .width(150.dp)
                        .height(36.dp)
                        .background(Color(0xFFE3ECEE), RoundedCornerShape(20.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Weekly", color = Color(0xFF1E6B78), fontSize = 14.sp)
                }

                Spacer(modifier = Modifier.height(14.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(34.dp)
                        .background(Color.White, RoundedCornerShape(8.dp))
                        .padding(horizontal = 12.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Text(
                        "Apr 16, 2024 - Apr 22, 2024  ▾",
                        color = Color.Black,
                        fontSize = 12.sp
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                ProfileViewsChart()
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            "Top Visitors",
            color = Color.Black,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(10.dp))

        Card(
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(Color.White),
            elevation = CardDefaults.cardElevation(0.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(12.dp)) {
                visitors.forEachIndexed { index, visitor ->
                    VisitorRow(visitor)
                    if (index != visitors.lastIndex) {
                        Divider(color = Color(0xFFE5E7EB))
                    }
                }
            }
        }
    }
}

@Composable
private fun ProfileViewsChart() {
    Column {
        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(115.dp)
        ) {
            val w = size.width
            val h = size.height

            val points = listOf(
                Offset(w * 0.15f, h * 0.70f),
                Offset(w * 0.30f, h * 0.66f),
                Offset(w * 0.40f, h * 0.50f),
                Offset(w * 0.58f, h * 0.55f),
                Offset(w * 0.72f, h * 0.42f),
                Offset(w * 0.82f, h * 0.18f),
                Offset(w * 0.95f, h * 0.35f)
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
                Text(it, fontSize = 9.sp, color = Color(0xFF1E6B78))
            }
        }
    }
}

@Composable
private fun VisitorRow(visitor: TopVisitor) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 9.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(visitor.avatar),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(38.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.width(12.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(
                visitor.name,
                color = Color(0xFF1E6B78),
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                visitor.location,
                color = Color.Gray,
                fontSize = 11.sp
            )
        }

        Text(
            visitor.views,
            color = Color.Black,
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold
        )
    }
}