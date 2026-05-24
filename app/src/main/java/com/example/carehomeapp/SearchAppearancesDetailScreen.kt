

package com.example.carehomeapp

import androidx.compose.foundation.Canvas
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
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SearchAppearancesDetailScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8FAFB))
            .padding(horizontal = 20.dp, vertical = 20.dp)
    ) {

        // BACK BUTTON
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_arrow_back),
                contentDescription = null,
                modifier = Modifier.size(18.dp)
            )
        }

        Spacer(modifier = Modifier.height(26.dp))

        // TITLE
        Text(
            text = "Search Appearances Detail",
            color = Color(0xFF1E6B78),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(22.dp))

        // MAIN CARD
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(18.dp),
            colors = CardDefaults.cardColors(Color.White),
            elevation = CardDefaults.cardElevation(3.dp)
        ) {

            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                // TOP STATS
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = "890",
                        fontSize = 34.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF1E6B78)
                    )

                    Spacer(modifier = Modifier.width(6.dp))

                    Text(
                        text = "Total Appearances",
                        fontSize = 13.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Medium
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    Text(
                        text = "▲150.2%",
                        fontSize = 12.sp,
                        color = Color(0xFF1E6B78),
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "This Week",
                        fontSize = 9.sp,
                        color = Color.Gray
                    )
                }

                Spacer(modifier = Modifier.height(18.dp))

                // WEEKLY BUTTON
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .width(150.dp)
                        .height(34.dp)
                        .background(
                            Color(0xFFE3ECEE),
                            RoundedCornerShape(18.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Weekly",
                        color = Color(0xFF1E6B78),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // DATE SELECTOR
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(38.dp)
                        .background(
                            Color.White,
                            RoundedCornerShape(8.dp)
                        )
                        .padding(horizontal = 12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = "Apr 16, 2024 - Apr 22, 2024  📅",
                        fontSize = 12.sp,
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    Text(
                        text = "⌄",
                        fontSize = 18.sp,
                        color = Color.Gray
                    )
                }

                Spacer(modifier = Modifier.height(18.dp))

                // GRAPH
                SearchAppearanceBarChart()
            }
        }

        Spacer(modifier = Modifier.height(18.dp))

        // KEYWORD INSIGHTS
        Text(
            text = "Keyword Insights",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(12.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(18.dp),
            colors = CardDefaults.cardColors(Color.White),
            elevation = CardDefaults.cardElevation(3.dp)
        ) {

            Column {

                // HEADER
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFE3ECEE))
                        .padding(vertical = 14.dp, horizontal = 18.dp)
                ) {

                    Text(
                        text = "Keyword",
                        modifier = Modifier.weight(1f),
                        color = Color(0xFF1E6B78),
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )

                    Text(
                        text = "Appearances",
                        color = Color(0xFF1E6B78),
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )
                }

                KeywordRow("Data Entry", "320")
                KeywordRow("AI Tasks", "210")
                KeywordRow("Typing", "180")

                Divider(color = Color(0xFFE5E7EB))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {

                    Text(
                        text = "Appearances: 890",
                        modifier = Modifier.weight(1f),
                        color = Color(0xFF1E6B78),
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp
                    )

                    Text(
                        text = "Profile Clicks: 240",
                        color = Color(0xFF1E6B78),
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp
                    )
                }
            }
        }
    }
}

@Composable
fun KeywordRow(
    keyword: String,
    appearances: String
) {

    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 18.dp, vertical = 14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = keyword,
                modifier = Modifier.weight(1f),
                fontSize = 14.sp,
                color = Color.Black
            )

            Text(
                text = appearances,
                fontSize = 14.sp,
                color = Color.Black,
                fontWeight = FontWeight.Medium
            )
        }

        Divider(color = Color(0xFFE5E7EB))
    }
}

@Composable
fun SearchAppearanceBarChart() {

    Column {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
        ) {

            Canvas(
                modifier = Modifier.fillMaxSize()
            ) {

                val width = size.width
                val height = size.height

                val barWidth = 34f
                val spacing = 28f

                val values = listOf(0.18f, 0.70f, 0.58f, 0.82f, 0.30f, 0.65f, 0.72f)

                values.forEachIndexed { index, value ->

                    val left = 70f + index * (barWidth + spacing)
                    val top = height - (height * value) - 40f

                    drawRoundRect(
                        color = Color(0xFF6F8B91),
                        topLeft = Offset(left, top),
                        size = Size(barWidth, height - top - 30f),
                        cornerRadius = CornerRadius(10f, 10f)
                    )
                }
            }

            // TOOLTIP
            Box(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(top = 12.dp, end = 8.dp)
                    .background(
                        Color.White,
                        RoundedCornerShape(8.dp)
                    )
                    .padding(horizontal = 10.dp, vertical = 6.dp)
            ) {

                Column {
                    Text(
                        text = "Friday",
                        color = Color(0xFF1E6B78),
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "Appearances: 165",
                        color = Color.Gray,
                        fontSize = 9.sp
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(6.dp))

        // DAYS
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {

            listOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun").forEach {

                Text(
                    text = it,
                    color = Color(0xFF1E6B78),
                    fontSize = 10.sp
                )
            }
        }
    }
}