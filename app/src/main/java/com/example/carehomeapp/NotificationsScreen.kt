package com.example.carehomeapp


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class NotificationItem(
    val icon: String,
    val title: String,
    val time: String,
    val subText: String = "",
    val badge: String = "",
    val iconBg: Color
)

@Composable
fun NotificationsScreen(
    onBackClick: () -> Unit = {}
) {

    val items = listOf(
        NotificationItem("🛏", "2 beds are now available\nat your care home.", "5 mins ago", "⌃ Available", "", Color(0xFFE2F3F6)),
        NotificationItem("✉", "New inquiry from Sara Ahmed", "1 hr ago", "", "1", Color(0xFFFFE8B8)),
        NotificationItem("🔔", "Your verification documents\nhave been approved.", "3 hrs ago", "✔ Verified", "", Color(0xFFFFD6D6)),
        NotificationItem("✉", "New inquiry from James Parker", "5 hrs ago", "", "2", Color(0xFFFFE8B8)),
        NotificationItem("⟳", "System update available at 3 AM", "1 day ago", "", "", Color(0xFFE2F3F6)),
        NotificationItem("🛏", "3 beds are now available\nat your care home.", "2 days ago", "", "", Color(0xFFE2F3F6)),
        NotificationItem("✉", "New inquiry schedule at your\nhome care.", "", "", "", Color(0xFFFFE8B8))
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8FAFB))
            .padding(horizontal = 22.dp, vertical = 22.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Back Button
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .shadow(
                        elevation = 4.dp,
                        shape = CircleShape,
                        ambientColor = Color(0x26000000)
                    )
                    .background(Color.White, CircleShape)
                    .clickable { onBackClick() },
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_arrow_back),
                    contentDescription = stringResource(R.string.content_desc_back),
                    modifier = Modifier.size(20.dp)
                )
            }

            Box {
                Text("🔔", fontSize = 22.sp)

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
            text = "Notifications",
            color = Color(0xFF1E6B78),
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(22.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(42.dp)
                .background(Color(0xFFE3ECEE), RoundedCornerShape(22.dp)),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TabText("All", true, Modifier.weight(1f))
        }

        Spacer(modifier = Modifier.height(20.dp))

        Card(
            shape = RoundedCornerShape(18.dp),
            colors = CardDefaults.cardColors(Color.White),
            elevation = CardDefaults.cardElevation(0.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(14.dp)) {
                items.forEach {
                    NotificationRow(it)
                    Divider(color = Color(0xFFE5E7EB))
                }

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    "Mark all as read",
                    color = Color(0xFF1E6B78),
                    fontSize = 15.sp,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}

@Composable
private fun CircleButton(text: String) {
    Box(
        modifier = Modifier
            .size(38.dp)
            .clip(CircleShape)
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Text(text, color = Color(0xFF1E6B78), fontSize = 18.sp)
    }
}

@Composable
private fun TabText(
    text: String,
    selected: Boolean,
    modifier: Modifier
) {
    Box(
        modifier = modifier.fillMaxHeight(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text,
            color = Color(0xFF1E6B78),
            fontSize = 13.sp,
            fontWeight = if (selected) FontWeight.Bold else FontWeight.Normal
        )
    }
}

@Composable
private fun NotificationRow(item: NotificationItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        verticalAlignment = Alignment.Top
    ) {
        Box(
            modifier = Modifier
                .size(36.dp)
                .background(item.iconBg, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Text(item.icon, fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.width(10.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(
                item.title,
                color = Color(0xFF1E6B78),
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                lineHeight = 16.sp
            )

            if (item.subText.isNotEmpty()) {
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    item.subText,
                    color = Color.Black,
                    fontSize = 9.sp,
                    modifier = Modifier
                        .background(Color(0xFFE5E7EB), RoundedCornerShape(8.dp))
                        .padding(horizontal = 8.dp, vertical = 3.dp)
                )
            }

            if (item.time.isNotEmpty()) {
                Spacer(modifier = Modifier.height(4.dp))
                Text(item.time, color = Color.Gray, fontSize = 10.sp)
            }
        }

        if (item.time.isNotEmpty() && item.subText.isEmpty()) {
            Text(item.time, color = Color.Gray, fontSize = 10.sp)
        }

        if (item.badge.isNotEmpty()) {
            Box(
                modifier = Modifier
                    .size(18.dp)
                    .background(Color(0xFFFFA000), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(item.badge, color = Color.White, fontSize = 9.sp)
            }
        }
    }
}
