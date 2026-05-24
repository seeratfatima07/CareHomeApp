package com.example.carehomeapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SignUpScreen(
    onBackClick: () -> Unit = {},
    onLoginClick: () -> Unit = {},
    onCreateAccountClick: () -> Unit = {}
) {
    var selectedRole by remember { mutableStateOf("user") }

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    var careHomeName by remember { mutableStateOf("") }
    var ownerName by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var location by remember { mutableStateOf("") }
    var services by remember { mutableStateOf("") }

    val primary = Color(0xFF2F7E8A)
    val fieldColor = Color(0xFFE8F4F5)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7FCFC))
            .padding(horizontal = 22.dp, vertical = 22.dp)
    ) {
        Text(
            text = "← Back",
            color = primary,
            fontSize = 16.sp,
            modifier = Modifier.clickable { onBackClick() }
        )

        Spacer(modifier = Modifier.height(58.dp))

        Text(
            text = "Create Account",
            color = primary,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Sign Up to continue",
            color = Color(0xFF5D9AA5),
            fontSize = 16.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(42.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .shadow(10.dp, RoundedCornerShape(28.dp))
                .background(Color.White, RoundedCornerShape(28.dp))
                .padding(horizontal = 24.dp, vertical = 24.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.care_home_illustration),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .alpha(0.14f)
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Text(
                        text = "Login",
                        color = primary,
                        fontSize = 19.sp,
                        modifier = Modifier.clickable { onLoginClick() }
                    )

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "Sign Up",
                            color = primary,
                            fontSize = 19.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Box(
                            modifier = Modifier
                                .width(66.dp)
                                .height(2.dp)
                                .background(primary)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(42.dp)
                        .background(fieldColor, RoundedCornerShape(12.dp))
                ) {
                    RoleButton(
                        text = "User",
                        selected = selectedRole == "user",
                        modifier = Modifier.weight(1f)
                    ) {
                        selectedRole = "user"
                    }

                    RoleButton(
                        text = "Care Provider",
                        selected = selectedRole == "care_provider",
                        modifier = Modifier.weight(1f)
                    ) {
                        selectedRole = "care_provider"
                    }
                }

                Spacer(modifier = Modifier.height(26.dp))

                if (selectedRole == "user") {
                    SignUpField(name, { name = it }, "Name")
                    SignUpField(email, { email = it }, "Email")
                    SignUpField(password, { password = it }, "Password")
                    SignUpField(confirmPassword, { confirmPassword = it }, "Confirm Password")
                } else {
                    SignUpField(careHomeName, { careHomeName = it }, "Care Home Name")
                    SignUpField(ownerName, { ownerName = it }, "Owner Name")
                    SignUpField(email, { email = it }, "Email")
                    SignUpField(phone, { phone = it }, "Phone")
                    SignUpField(location, { location = it }, "Location")
                    SignUpField(services, { services = it }, "Services")
                    SignUpField(password, { password = it }, "Password")
                    SignUpField(confirmPassword, { confirmPassword = it }, "Confirm Password")

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(66.dp)
                            .background(fieldColor, RoundedCornerShape(12.dp))
                            .padding(horizontal = 18.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Text(
                            text = "↥  Upload License\n     PDF or Image",
                            color = Color(0xFF6A8F94),
                            fontSize = 16.sp
                        )
                    }
                }

                Spacer(modifier = Modifier.height(36.dp))

                Button(
                    onClick = onCreateAccountClick,
                    colors = ButtonDefaults.buttonColors(containerColor = primary),
                    shape = RoundedCornerShape(28.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp)
                        .shadow(10.dp, RoundedCornerShape(28.dp))
                ) {
                    Text(
                        text = "Create Account",
                        color = Color.White,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}

@Composable
private fun RoleButton(
    text: String,
    selected: Boolean,
    modifier: Modifier,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxHeight()
            .clickable { onClick() }
            .background(
                if (selected) Color(0xFF2F7E8A) else Color.Transparent,
                RoundedCornerShape(12.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = if (selected) Color.White else Color(0xFF6A8F94),
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
private fun SignUpField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = {
            Text(
                text = placeholder,
                color = Color(0xFF6A8F94),
                fontSize = 16.sp
            )
        },
        singleLine = true,
        shape = RoundedCornerShape(12.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = Color(0xFFE8F4F5),
            unfocusedContainerColor = Color(0xFFE8F4F5),
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent,
            disabledBorderColor = Color.Transparent
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(62.dp)
            .padding(bottom = 10.dp)
    )
}