package com.example.carehomeapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class CareHomeData(
    val name: String,
    val location: String,
    val status: String,
    val image: Int,
    val filledStars: Int
)

@Composable
fun SearchCareHomeScreen() {

    var searchText by remember { mutableStateOf("") }

    val careHomes = listOf(

        CareHomeData(
            "Care Home A",
            "Los Angeles, CA",
            "Full",
            R.drawable.care_home_a,
            5
        ),

        CareHomeData(
            "Care Home B",
            "Chicago , IL",
            "Available",
            R.drawable.care_home_b,
            3
        ),

        CareHomeData(
            "Care Home C",
            "New York , NY",
            "Full",
            R.drawable.care_home_c,
            4
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7F7F7))
    ) {

        // TOP SECTION
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFEFF5F5))
                .padding(horizontal = 22.dp, vertical = 18.dp)
        ) {

            // BACK BUTTON
            Box(
                modifier = Modifier
                    .size(42.dp)
                    .clip(RoundedCornerShape(50.dp))
                    .background(Color.White),

                contentAlignment = Alignment.Center
            ) {

                Image(
                    painter = painterResource(R.drawable.ic_arrow_back),
                    contentDescription = null,
                    modifier = Modifier.size(18.dp)
                )
            }

            Spacer(modifier = Modifier.height(34.dp))

            // CENTER TITLE
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {

                Text(
                    text = "Search Care Homes",
                    color = Color(0xFF1E6B78),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // SEARCH BAR
            OutlinedTextField(
                value = searchText,

                onValueChange = {
                    searchText = it
                },

                placeholder = {

                    Text(
                        text = "Search Here",
                        fontSize = 12.sp,
                        color = Color.Gray
                    )
                },

                leadingIcon = {

                    Image(
                        painter = painterResource(R.drawable.ic_search),
                        contentDescription = null,
                        modifier = Modifier.size(15.dp)
                    )
                },

                trailingIcon = {

                    Image(
                        painter = painterResource(R.drawable.ic_filter),
                        contentDescription = null,
                        modifier = Modifier.size(18.dp)
                    )
                },

                shape = RoundedCornerShape(24.dp),

                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedBorderColor = Color.Transparent,
                    unfocusedBorderColor = Color.Transparent
                ),

                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp)
                    .shadow(
                        elevation = 3.dp,
                        shape = RoundedCornerShape(24.dp)
                    )
            )

            Spacer(modifier = Modifier.height(18.dp))

            // FILTER BUTTONS
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                Box(modifier = Modifier.weight(1f)) {

                    FilterChip(
                        text = "Distance",
                        selected = true
                    )
                }

                Box(modifier = Modifier.weight(1f)) {

                    FilterChip(
                        text = "Rating",
                        selected = false,
                        showArrow = true
                    )
                }

                Box(modifier = Modifier.weight(1f)) {

                    FilterChip(
                        text = "Newest",
                        selected = false
                    )
                }
            }
        }

        // CARD LIST
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 18.dp, vertical = 18.dp),

            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            items(careHomes) { home ->

                CareHomeCard(home)
            }
        }
    }
}

@Composable
fun FilterChip(
    text: String,
    selected: Boolean,
    showArrow: Boolean = false
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(36.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(
                if (selected)
                    Color(0xFF1E6B78)
                else
                    Color.White
            ),

        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = text,

            color = if (selected)
                Color.White
            else
                Color.Black,

            fontSize = 11.sp,
            fontWeight = FontWeight.Medium
        )

        if (showArrow) {

            Spacer(modifier = Modifier.width(4.dp))

            Image(
                painter = painterResource(R.drawable.ic_arrow_down),
                contentDescription = null,
                modifier = Modifier.size(10.dp)
            )
        }
    }
}

@Composable
fun CareHomeCard(
    home: CareHomeData
) {

    Card(
        shape = RoundedCornerShape(18.dp),

        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),

        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp
        ),

        modifier = Modifier.fillMaxWidth()
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),

            verticalAlignment = Alignment.CenterVertically
        ) {

            // IMAGE
            Image(
                painter = painterResource(home.image),
                contentDescription = null,
                contentScale = ContentScale.Crop,

                modifier = Modifier
                    .size(58.dp)
                    .clip(RoundedCornerShape(12.dp))
            )

            Spacer(modifier = Modifier.width(10.dp))

            // CENTER SECTION
            Column(
                modifier = Modifier.weight(1f)
            ) {

                Text(
                    text = home.name,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(2.dp))

                Text(
                    text = home.location,
                    fontSize = 11.sp,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(8.dp))

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(20.dp))
                        .background(
                            if (home.status == "Full")
                                Color(0xFFFF4D4D)
                            else
                                Color(0xFF34C759)
                        )
                        .padding(horizontal = 14.dp, vertical = 4.dp)
                ) {

                    Text(
                        text = home.status,
                        color = Color.White,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            // RIGHT SIDE
            Column(
                horizontalAlignment = Alignment.End
            ) {

                Text(
                    text = "📍",
                    fontSize = 13.sp
                )

                Text(
                    text = "Location",
                    fontSize = 10.sp,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(10.dp))

                Row {

                    repeat(home.filledStars) {

                        Image(
                            painter = painterResource(R.drawable.ic_star_filled),
                            contentDescription = null,
                            modifier = Modifier.size(12.dp)
                        )
                    }

                    repeat(5 - home.filledStars) {

                        Image(
                            painter = painterResource(R.drawable.ic_star_empty),
                            contentDescription = null,
                            modifier = Modifier.size(12.dp)
                        )
                    }
                }
            }
        }
    }
}