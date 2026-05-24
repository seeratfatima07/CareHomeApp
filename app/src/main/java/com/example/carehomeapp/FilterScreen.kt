package com.example.carehomeapp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

enum class OpenFilter {
    NONE, CARE_TYPE, PRICE_RANGE, AVAILABILITY, MIN_RATING
}

@Composable
fun FilterScreen(
    onCloseClick: () -> Unit = {},
    onApplyClick: () -> Unit = {},
    onResetClick: () -> Unit = {}
) {
    val primary = Color(0xFF2F7E8A)

    var openFilter by remember { mutableStateOf(OpenFilter.NONE) }
    var selectedCareType by remember { mutableStateOf("Nursing Home") }
    var selectedAvailability by remember { mutableStateOf("Available Now") }
    var selectedRating by remember { mutableStateOf("4 & Up") }
    var priceValue by remember { mutableFloatStateOf(0.5f) }

    Box(modifier = Modifier.fillMaxSize()) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.45f))
        )

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .width(270.dp)
                .background(Color.White)
                .padding(horizontal = 22.dp, vertical = 28.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Filters",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1F2933)
                )

                Text(
                    text = "×",
                    fontSize = 24.sp,
                    color = Color(0xFF6B7280),
                    modifier = Modifier.clickable { onCloseClick() }
                )
            }

            Spacer(modifier = Modifier.height(26.dp))

            FilterHeader(
                text = "Care Type",
                isOpen = openFilter == OpenFilter.CARE_TYPE,
                onClick = { openFilter = OpenFilter.CARE_TYPE }
            )

            if (openFilter == OpenFilter.CARE_TYPE) {
                CareTypeDropdown(
                    selected = selectedCareType,
                    onSelect = { selectedCareType = it }
                )
                Spacer(modifier = Modifier.height(14.dp))
            } else {
                Spacer(modifier = Modifier.height(10.dp))
            }

            FilterHeader(
                text = "Price Range",
                isOpen = openFilter == OpenFilter.PRICE_RANGE,
                onClick = { openFilter = OpenFilter.PRICE_RANGE }
            )

            if (openFilter == OpenFilter.PRICE_RANGE) {
                PriceRangeDropdown(
                    value = priceValue,
                    onValueChange = { priceValue = it }
                )
                Spacer(modifier = Modifier.height(14.dp))
            } else {
                Spacer(modifier = Modifier.height(10.dp))
            }

            FilterHeader(
                text = "Availability",
                isOpen = openFilter == OpenFilter.AVAILABILITY,
                onClick = { openFilter = OpenFilter.AVAILABILITY }
            )

            if (openFilter == OpenFilter.AVAILABILITY) {
                AvailabilityDropdown(
                    selected = selectedAvailability,
                    onSelect = { selectedAvailability = it }
                )
                Spacer(modifier = Modifier.height(14.dp))
            } else {
                Spacer(modifier = Modifier.height(10.dp))
            }

            FilterHeader(
                text = "Minimum Rating",
                isOpen = openFilter == OpenFilter.MIN_RATING,
                onClick = { openFilter = OpenFilter.MIN_RATING }
            )

            if (openFilter == OpenFilter.MIN_RATING) {
                RatingDropdown(
                    selected = selectedRating,
                    onSelect = { selectedRating = it }
                )
                Spacer(modifier = Modifier.height(14.dp))
            } else {
                Spacer(modifier = Modifier.height(10.dp))
            }

            VerificationItem()

            Spacer(modifier = Modifier.weight(1f))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = {
                        selectedCareType = "Nursing Home"
                        selectedAvailability = "Available Now"
                        selectedRating = "4 & Up"
                        priceValue = 0.5f
                        openFilter = OpenFilter.NONE
                        onResetClick()
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE5E7EB)),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .width(94.dp)
                        .height(48.dp)
                ) {
                    Text("Reset", color = Color(0xFF374151), fontSize = 12.sp)
                }

                Button(
                    onClick = onApplyClick,
                    colors = ButtonDefaults.buttonColors(containerColor = primary),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .width(94.dp)
                        .height(48.dp)
                ) {
                    Text("Apply", color = Color.White, fontSize = 12.sp)
                }
            }
        }
    }
}

@Composable
private fun FilterHeader(
    text: String,
    isOpen: Boolean,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .background(
                if (isOpen) Color(0xFFEAF5F6) else Color(0xFFF1F1F3),
                RoundedCornerShape(10.dp)
            )
            .clickable { onClick() }
            .padding(horizontal = 14.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = text, fontSize = 13.sp, color = Color.Black)

        Text(
            text = if (isOpen) "⌄" else "›",
            fontSize = if (isOpen) 18.sp else 24.sp,
            color = Color(0xFF9CA3AF)
        )
    }
}

@Composable
private fun CareTypeDropdown(
    selected: String,
    onSelect: (String) -> Unit
) {
    val items = listOf("Nursing Home", "Assisted Living", "Memory Care", "Home Care")

    Column(
        modifier = Modifier
            .width(235.dp)
            .shadow(8.dp, RoundedCornerShape(10.dp))
            .background(Color.White, RoundedCornerShape(10.dp))
            .padding(vertical = 8.dp)
    ) {
        items.forEach {
            RadioOption(
                text = it,
                selected = selected == it,
                onClick = { onSelect(it) }
            )
        }
    }
}

@Composable
private fun PriceRangeDropdown(
    value: Float,
    onValueChange: (Float) -> Unit
) {
    Column(
        modifier = Modifier
            .width(235.dp)
            .shadow(8.dp, RoundedCornerShape(10.dp))
            .background(Color.White, RoundedCornerShape(10.dp))
            .padding(horizontal = 20.dp, vertical = 18.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Min", fontSize = 11.sp, color = Color(0xFF2F7E8A))
            Text("Max", fontSize = 11.sp, color = Color(0xFF2F7E8A))
        }

        Slider(
            value = value,
            onValueChange = onValueChange,
            colors = SliderDefaults.colors(
                thumbColor = Color(0xFF2F7E8A),
                activeTrackColor = Color(0xFF9FD3D8),
                inactiveTrackColor = Color(0xFFD9EDEE)
            )
        )
    }
}

@Composable
private fun AvailabilityDropdown(
    selected: String,
    onSelect: (String) -> Unit
) {
    val items = listOf("Available Now", "Within 7 days", "Anytime")

    Column(
        modifier = Modifier
            .width(250.dp)
            .shadow(8.dp, RoundedCornerShape(10.dp))
            .background(Color.White, RoundedCornerShape(10.dp))
            .padding(vertical = 10.dp)
    ) {
        items.forEach {
            RadioOption(
                text = it,
                selected = selected == it,
                onClick = { onSelect(it) }
            )
        }
    }
}

@Composable
private fun RatingDropdown(
    selected: String,
    onSelect: (String) -> Unit
) {
    val items = listOf(
        Pair("★", "1 & Up"),
        Pair("★★", "2 & Up"),
        Pair("★★★", "3 & Up"),
        Pair("★★★★", "4 & Up"),
        Pair("★★★★★", "5 only")
    )

    Column(
        modifier = Modifier
            .width(250.dp)
            .shadow(8.dp, RoundedCornerShape(10.dp))
            .background(Color.White, RoundedCornerShape(10.dp))
            .padding(vertical = 8.dp)
    ) {
        items.forEach { item ->
            RatingOption(
                stars = item.first,
                text = item.second,
                selected = selected == item.second,
                onClick = { onSelect(item.second) }
            )
        }
    }
}

@Composable
private fun RadioOption(
    text: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .clickable { onClick() }
            .padding(horizontal = 14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = selected,
            onClick = onClick,
            colors = RadioButtonDefaults.colors(
                selectedColor = Color(0xFF2F7E8A),
                unselectedColor = Color(0xFF2F7E8A)
            )
        )

        Spacer(modifier = Modifier.width(6.dp))

        Text(
            text = text,
            fontSize = 12.sp,
            color = Color(0xFF2F7E8A)
        )
    }
}

@Composable
private fun RatingOption(
    stars: String,
    text: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(38.dp)
            .clickable { onClick() }
            .padding(horizontal = 14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            selected = selected,
            onClick = onClick,
            colors = RadioButtonDefaults.colors(
                selectedColor = Color(0xFF2F7E8A),
                unselectedColor = Color(0xFF2F7E8A)
            )
        )

        Spacer(modifier = Modifier.width(6.dp))

        Text(
            text = stars,
            fontSize = 16.sp,
            color = Color(0xFFFFA000),
            modifier = Modifier.width(80.dp)
        )

        Text(
            text = text,
            fontSize = 11.sp,
            color = Color.Black
        )
    }
}

@Composable
private fun VerificationItem() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .background(Color(0xFFF1F1F3), RoundedCornerShape(10.dp))
            .padding(horizontal = 14.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Verification Badge",
            fontSize = 13.sp,
            color = Color.Black
        )

        Box(
            modifier = Modifier
                .size(18.dp)
                .background(Color(0xFF2ECC71), RoundedCornerShape(4.dp)),
            contentAlignment = Alignment.Center
        ) {
            Text("✓", color = Color.White, fontSize = 13.sp)
        }
    }
}