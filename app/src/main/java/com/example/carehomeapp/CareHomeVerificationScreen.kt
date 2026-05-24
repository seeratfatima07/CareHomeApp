

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

@Composable
fun CareHomeVerificationScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8FAFB))
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 20.dp, vertical = 20.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CircleIcon(R.drawable.ic_arrow_back)

            Box {
                Image(
                    painter = painterResource(R.drawable.reviewer_avatar),
                    contentDescription = null,
                    modifier = Modifier
                        .size(40.dp)
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

        Spacer(modifier = Modifier.height(22.dp))

        Text(
            text = "Care Home Verification",
            color = Color(0xFF1E6B78),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "3 Pending Applications",
            color = Color(0xFF1E6B78),
            fontSize = 13.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Card(
            shape = RoundedCornerShape(18.dp),
            colors = CardDefaults.cardColors(Color.White),
            elevation = CardDefaults.cardElevation(5.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(R.drawable.care_home_b),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(68.dp)
                            .clip(RoundedCornerShape(12.dp))
                    )

                    Spacer(modifier = Modifier.width(12.dp))

                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            "Anna's Care Home",
                            fontSize = 15.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            "123 Main St, Springfield, IL",
                            fontSize = 11.sp,
                            color = Color.Gray
                        )

                        Text(
                            "Submitted 2 hours ago",
                            fontSize = 10.sp,
                            color = Color.Gray
                        )
                    }

                    StatusBadge("• Pending")
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(R.drawable.avatar_sara),
                        contentDescription = null,
                        modifier = Modifier
                            .size(42.dp)
                            .clip(CircleShape)
                    )

                    Spacer(modifier = Modifier.width(12.dp))

                    Column {
                        Text(
                            "Anna Matthews",
                            color = Color(0xFF1E6B78),
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            "(123) 456-7890",
                            color = Color.Gray,
                            fontSize = 11.sp
                        )

                        Text(
                            "anna.matthews@email.com",
                            color = Color.Gray,
                            fontSize = 11.sp
                        )
                    }
                }

                Spacer(modifier = Modifier.height(18.dp))
                Divider(color = Color(0xFFE5E7EB))
                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    "Submitted Documents",
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(12.dp))

                DocumentRow(
                    icon = "🪪",
                    title = "Anna_ID_Verification.pdf",
                    subtitle = "Government-issued ID",
                    size = "(250 KB)",
                    rightIcon = "✓"
                )

                DocumentRow(
                    icon = "📄",
                    title = "Care_Home_License.pdf",
                    subtitle = "License - government six",
                    size = "(500 KB)",
                    rightIcon = "⇩"
                )

                DocumentRow(
                    icon = "✉",
                    title = "Insurance_Certificate.pdf",
                    subtitle = "Proof - government",
                    size = "(350 KB)",
                    rightIcon = "⇩"
                )

                Spacer(modifier = Modifier.height(14.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(44.dp)
                        .background(Color(0xFFF8FAFB), RoundedCornerShape(10.dp))
                        .padding(horizontal = 10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(34.dp)
                            .background(Color(0xFFE3ECEE), CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("🏅", fontSize = 16.sp)
                    }

                    Spacer(modifier = Modifier.width(10.dp))

                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(26.dp)
                            .background(Color.White, RoundedCornerShape(6.dp)),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Text(
                            text = "  Assign Verification Badge",
                            color = Color.Gray,
                            fontSize = 11.sp
                        )
                    }

                    Text("›", color = Color.Gray, fontSize = 22.sp)
                }

                Spacer(modifier = Modifier.height(18.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(14.dp)
                ) {
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(Color(0xFFFF4D4D)),
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .weight(1f)
                            .height(44.dp)
                    ) {
                        Text("Reject", color = Color.White, fontSize = 14.sp)
                    }

                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(Color(0xFF22C55E)),
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .weight(1f)
                            .height(44.dp)
                    ) {
                        Text("Approve", color = Color.White, fontSize = 14.sp)
                    }
                }
            }
        }
    }
}

@Composable
private fun CircleIcon(icon: Int) {
    Box(
        modifier = Modifier
            .size(40.dp)
            .clip(CircleShape)
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(icon),
            contentDescription = null,
            modifier = Modifier.size(18.dp)
        )
    }
}

@Composable
private fun StatusBadge(text: String) {
    Box(
        modifier = Modifier
            .background(Color(0xFFFFF1DC), RoundedCornerShape(20.dp))
            .padding(horizontal = 10.dp, vertical = 5.dp)
    ) {
        Text(
            text,
            color = Color(0xFFC98A1C),
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
private fun DocumentRow(
    icon: String,
    title: String,
    subtitle: String,
    size: String,
    rightIcon: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .padding(bottom = 8.dp)
            .background(Color(0xFFF2F7F8), RoundedCornerShape(8.dp))
            .padding(horizontal = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(30.dp)
                .background(Color(0xFFE3ECEE), RoundedCornerShape(6.dp)),
            contentAlignment = Alignment.Center
        ) {
            Text(icon, fontSize = 15.sp)
        }

        Spacer(modifier = Modifier.width(10.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = title,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Text(
                text = subtitle,
                fontSize = 9.sp,
                color = Color.Gray
            )
        }

        Text(size, fontSize = 8.sp, color = Color.Gray)

        Spacer(modifier = Modifier.width(6.dp))

        Text(rightIcon, color = Color(0xFF1E6B78), fontSize = 13.sp)
    }
}