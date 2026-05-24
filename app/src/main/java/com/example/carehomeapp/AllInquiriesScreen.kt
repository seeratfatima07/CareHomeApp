package com.example.carehomeapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class InquiryItem(
    val name: String,
    val time: String,
    val message: String,
    val avatar: Int,
    val status: String
)

@Composable
fun AllInquiriesScreen() {

    val inquiries = listOf(
        InquiryItem(
            "Sara Ahmed",
            "2 hours ago",
            "Hi, I need data entry work completed for my\nbusiness.Please let me know if you are avail...",
            R.drawable.avatar_sara,
            "New"
        ),
        InquiryItem(
            "John Ellis",
            "5 hours ago",
            "I need help with AI tasks. Please let me know\nyour availability",
            R.drawable.avatar_john,
            "New"
        ),
        InquiryItem(
            "James Parker",
            "1 days ago",
            "Can you assist with data entry work\nthis week?",
            R.drawable.reviewer_avatar,
            "Replied"
        ),
        InquiryItem(
            "Anna Matthews",
            "3 days ago",
            "Good afternoon. I would like to\ndiscuss your service offerings",
            R.drawable.avatar_sara,
            "Replied"
        ),
        InquiryItem(
            "Michael Smith",
            "5 days ago",
            "How much do you charge for typing\nservices? Thanks.",
            R.drawable.avatar_michael,
            "Closed"
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8FAFB))
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 20.dp, vertical = 20.dp)
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
            text = "All Inquiries",
            color = Color(0xFF1E6B78),
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Card(
            shape = RoundedCornerShape(18.dp),
            colors = CardDefaults.cardColors(Color.White),
            elevation = CardDefaults.cardElevation(0.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(104.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 28.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "156",
                        color = Color(0xFF1E6B78),
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Total Inquiries",
                        color = Color.Black,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = "▲ 20%",
                    color = Color(0xFF1E6B78),
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = "This Week",
                    color = Color.Gray,
                    fontSize = 9.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(18.dp))

        inquiries.forEachIndexed { index, inquiry ->
            InquiryCard(
                inquiry = inquiry,
                showButtons = index == 0
            )

            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

@Composable
private fun InquiryCard(
    inquiry: InquiryItem,
    showButtons: Boolean
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(5.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(10.dp)
        ) {

            Row(
                verticalAlignment = Alignment.Top
            ) {
                Image(
                    painter = painterResource(inquiry.avatar),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(38.dp)
                        .clip(CircleShape)
                )

                Spacer(modifier = Modifier.width(10.dp))

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = inquiry.name,
                            color = Color(0xFF1E6B78),
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.weight(1f)
                        )

                        Text(
                            text = inquiry.time,
                            color = Color(0xFF1E6B78),
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Text(
                        text = inquiry.message,
                        color = Color(0xFF6F6F6F),
                        fontSize = 10.sp,
                        lineHeight = 13.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                if (showButtons) {
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(Color(0xFFE3ECEE)),
                        shape = RoundedCornerShape(6.dp),
                        contentPadding = PaddingValues(0.dp),
                        modifier = Modifier
                            .width(90.dp)
                            .height(28.dp)
                    ) {
                        Text(
                            text = "View Details",
                            color = Color(0xFF1E6B78),
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(Color(0xFF1E6B78)),
                        shape = RoundedCornerShape(6.dp),
                        contentPadding = PaddingValues(0.dp),
                        modifier = Modifier
                            .width(78.dp)
                            .height(28.dp)
                    ) {
                        Text(
                            text = "Reply",
                            color = Color.White,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                Spacer(modifier = Modifier.weight(1f))

                Box(
                    modifier = Modifier
                        .background(Color(0xFFFFF1DC), RoundedCornerShape(20.dp))
                        .padding(horizontal = 10.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = inquiry.status,
                        color = Color(0xFFC98A1C),
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

