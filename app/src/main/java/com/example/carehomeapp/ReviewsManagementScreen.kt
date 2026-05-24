package com.example.carehomeapp


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class ReviewManageItem(
    val name: String,
    val time: String,
    val comment: String,
    val avatar: Int
)

@Composable
fun ReviewsManagementScreen(
    onBackClick: () -> Unit = {}
) {
    val reviews = listOf(
        ReviewManageItem(
            "Michael Smith",
            "1 day ago",
            "Great care facilities and friendly staff.\nHighly recommended!",
            R.drawable.avatar_michael
        ),
        ReviewManageItem(
            "Sara Ahmed",
            "3 days ago",
            "My mother received excellent care. Thank\nyou!",
            R.drawable.avatar_sara
        ),
        ReviewManageItem(
            "John Ellis",
            "5 days ago",
            "Good facilities, but there is room for improvement.",
            R.drawable.avatar_john
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8FAFB))
            .verticalScroll(rememberScrollState())
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
            text = "Reviews Management",
            color = Color(0xFF1E6B78),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Summary Rating",
            color = Color(0xFF6F8B91),
            fontSize = 13.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))

        SummaryRatingCard()

        Spacer(modifier = Modifier.height(16.dp))

        reviews.forEach {
            ReviewManagementCard(it)
            Spacer(modifier = Modifier.height(14.dp))
        }
    }
}

@Composable
private fun SummaryRatingCard() {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(5.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(112.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 14.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "4.6 ★★★★★",
                    color = Color(0xFFFF9800),
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = "Based on 124 Reviews",
                    color = Color(0xFF1E6B78),
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "⌃ 89%",
                    color = Color(0xFF1E6B78),
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Column(
                modifier = Modifier.width(118.dp)
            ) {
                RatingBarRow(5, 80)
                RatingBarRow(4, 30)
                RatingBarRow(3, 10)
                RatingBarRow(2, 2)
            }
        }
    }
}

@Composable
private fun RatingBarRow(
    star: Int,
    count: Int
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(18.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("★", color = Color(0xFFFF9800), fontSize = 11.sp)

        Spacer(modifier = Modifier.width(5.dp))

        Box(
            modifier = Modifier
                .weight(1f)
                .height(6.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color(0xFFDDECEF))
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(count / 80f)
                    .background(Color(0xFF1E6B78))
            )
        }

        Spacer(modifier = Modifier.width(5.dp))

        Text(
            text = count.toString(),
            color = Color(0xFF1E6B78),
            fontSize = 10.sp
        )
    }
}

@Composable
private fun ReviewManagementCard(
    item: ReviewManageItem
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(5.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(12.dp)
        ) {
            Row(
                verticalAlignment = Alignment.Top
            ) {
                Image(
                    painter = painterResource(item.avatar),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(38.dp)
                        .clip(CircleShape)
                )

                Spacer(modifier = Modifier.width(10.dp))

                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = item.name,
                        color = Color(0xFF1E6B78),
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "★★★★★",
                        color = Color(0xFFFF9800),
                        fontSize = 12.sp
                    )
                }

                Text(
                    text = item.time,
                    color = Color(0xFF1E6B78),
                    fontSize = 11.sp
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = item.comment,
                color = Color.Black,
                fontSize = 11.sp,
                lineHeight = 14.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(30.dp)
                    .clip(RoundedCornerShape(6.dp))
                    .background(Color(0xFFE3ECEE))
                    .padding(horizontal = 10.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(
                    text = if (item.name == "Michael Smith")
                        "Thank you,Michael! We are glad you are happy with\nour services"
                    else
                        "Write a reply...",
                    color = Color(0xFF6F8B91),
                    fontSize = 9.sp
                )

                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(Color(0xFF1E6B78)),
                    shape = RoundedCornerShape(5.dp),
                    contentPadding = PaddingValues(0.dp),
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .width(60.dp)
                        .height(22.dp)
                ) {
                    Text("Reply", color = Color.White, fontSize = 10.sp)
                }
            }
        }
    }
}