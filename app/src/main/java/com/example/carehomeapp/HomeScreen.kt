package com.example.carehomeapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(
    onLoginClick: () -> Unit = {}
) {
    var searchQuery by remember { mutableStateOf("") }
    var showLanguageDialog by remember { mutableStateOf(false) }
    var selectedLanguage by remember { mutableStateOf("English") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp, vertical = 20.dp)
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { showLanguageDialog = true },
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "🌐 EN",
                    color = Color(0xFF1E6B78),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(28.dp))

            Text("Welcome", color = Color.Gray, fontSize = 14.sp)

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Find your perfect care\nhome",
                color = Color(0xFF1E6B78),
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(18.dp))

            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                placeholder = {
                    Text("Search by location or care type", fontSize = 14.sp)
                },
                trailingIcon = {
                    Text("⌕", fontSize = 24.sp, color = Color(0xFF78909C))
                },
                shape = RoundedCornerShape(16.dp),
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(58.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))

            Image(
                painter = painterResource(id = R.drawable.care_home_illustration),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            )

            Spacer(modifier = Modifier.height(18.dp))

            Button(
                onClick = onLoginClick,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1E6B78)),
                shape = RoundedCornerShape(14.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(54.dp)
            ) {
                Text(
                    text = "Login / Sign up",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        if (showLanguageDialog) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.35f))
            )

            LanguageDialog(
                selectedLanguage = selectedLanguage,
                onSelect = { selectedLanguage = it },
                onCancel = { showLanguageDialog = false },
                onApply = { showLanguageDialog = false }
            )
        }
    }
}

@Composable
private fun LanguageDialog(
    selectedLanguage: String,
    onSelect: (String) -> Unit,
    onCancel: () -> Unit,
    onApply: () -> Unit
) {
    val languages = listOf("English", "Urdu", "Arabic", "French")

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Column(
            modifier = Modifier
                .width(280.dp)
                .background(Color.White, RoundedCornerShape(18.dp))
                .padding(horizontal = 20.dp, vertical = 18.dp)
        ) {

            Text(
                text = "🌍 Select Language",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(12.dp))
            Divider(color = Color(0xFFE5E7EB))

            languages.forEach { language ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                        .clickable { onSelect(language) },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = language,
                        fontSize = 14.sp,
                        modifier = Modifier.weight(1f)
                    )

                    RadioButton(
                        selected = selectedLanguage == language,
                        onClick = { onSelect(language) },
                        colors = RadioButtonDefaults.colors(
                            selectedColor = Color(0xFF1E6B78),
                            unselectedColor = Color(0xFFB8C1CC)
                        )
                    )
                }

                Divider(color = Color(0xFFE5E7EB))
            }

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {

                Button(
                    onClick = onCancel,
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE5E7EB)),
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .width(90.dp)
                        .height(44.dp)
                ) {
                    Text("Cancel", color = Color(0xFF374151), fontSize = 12.sp)
                }

                Button(
                    onClick = onApply,
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1E6B78)),
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