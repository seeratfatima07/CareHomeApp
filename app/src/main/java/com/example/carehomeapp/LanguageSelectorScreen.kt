package com.example.carehomeapp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LanguageSelectorScreen(
    onCancelClick: () -> Unit = {},
    onApplyClick: () -> Unit = {},
    onLoginClick: () -> Unit = {}
) {
    var selectedLanguage by remember { mutableStateOf("English") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF9FAFB))
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 28.dp, vertical = 34.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Text("🌐 EN", fontSize = 13.sp, color = Color(0xFF123F4A))
            }

            Spacer(modifier = Modifier.height(36.dp))

            Text("Welcome", fontSize = 14.sp, color = Color.Gray)

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                "Find Care Homes Near You",
                fontSize = 21.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF144D5A)
            )

            Spacer(modifier = Modifier.height(34.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .background(Color.White, RoundedCornerShape(24.dp))
                    .padding(horizontal = 18.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(
                    "Search Location Or Care Type",
                    fontSize = 12.sp,
                    color = Color.Gray
                )

                Text(
                    "⌕",
                    fontSize = 22.sp,
                    color = Color(0xFF607D8B),
                    modifier = Modifier.align(Alignment.CenterEnd)
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = onLoginClick,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF145766)),
                shape = RoundedCornerShape(28.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp)
            ) {
                Text("Login / Sign Up", color = Color.White)
            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.35f))
        )

        LanguageDialog(
            selectedLanguage = selectedLanguage,
            onSelectLanguage = { selectedLanguage = it },
            onCancelClick = onCancelClick,
            onApplyClick = onApplyClick
        )
    }
}

@Composable
private fun LanguageDialog(
    selectedLanguage: String,
    onSelectLanguage: (String) -> Unit,
    onCancelClick: () -> Unit,
    onApplyClick: () -> Unit
) {
    val languages = listOf("English", "Urdu", "Arabic", "French")

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .width(280.dp)
                .background(Color.White, RoundedCornerShape(20.dp))
                .padding(horizontal = 20.dp, vertical = 18.dp)
        ) {
            Text(
                text = "🌍 Select Language",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(14.dp))

            languages.forEach { language ->
                LanguageRow(
                    language = language,
                    selected = selectedLanguage == language,
                    onClick = { onSelectLanguage(language) }
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = onCancelClick,
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE5E7EB)),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .width(90.dp)
                        .height(44.dp)
                ) {
                    Text("Cancel", color = Color(0xFF374151), fontSize = 12.sp)
                }

                Button(
                    onClick = onApplyClick,
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2F7E8A)),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .width(90.dp)
                        .height(44.dp)
                ) {
                    Text("Apply", color = Color.White, fontSize = 12.sp)
                }
            }
        }
    }
}

@Composable
private fun LanguageRow(
    language: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(46.dp)
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("🇺🇸", fontSize = 24.sp)

        Spacer(modifier = Modifier.width(12.dp))

        Text(
            text = language,
            fontSize = 14.sp,
            color = Color.Black,
            modifier = Modifier.weight(1f)
        )

        RadioButton(
            selected = selected,
            onClick = onClick,
            colors = RadioButtonDefaults.colors(
                selectedColor = Color(0xFF2F7E8A),
                unselectedColor = Color(0xFFB8C1CC)
            )
        )
    }

    Divider(color = Color(0xFFE5E7EB), thickness = 1.dp)
}