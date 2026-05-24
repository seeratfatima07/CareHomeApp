package com.example.carehomeapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.carehomeapp.ui.theme.AppTheme
import com.example.carehomeapp.ui.theme.inter
import androidx.compose.material3.Switch
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.scale

/**
 * Login screen composable that displays the login/sign up interface.
 * 
 * This screen allows users to:
 * - Switch between Login and Sign Up tabs
 * - Enter email and password credentials
 * - Toggle password visibility
 * - Navigate to forgot password flow
 * - Submit login credentials
 * 
 * @param onBackClick Callback invoked when back button is clicked
 * @param onLoginClick Callback invoked when login button is clicked with email and password
 * @param onSignUpClick Callback invoked when sign up tab or link is clicked
 * @param onForgotPasswordClick Callback invoked when forgot password is clicked
 */
@Composable
fun LoginScreen(
    onBackClick: () -> Unit = {},
    onLoginClick: (email: String, password: String) -> Unit = { _, _ -> },
    onSignUpClick: () -> Unit = {},
    onForgotPasswordClick: () -> Unit = {}
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isPasswordVisible by remember { mutableStateOf(false) }
    var selectedTab by remember { mutableStateOf(LoginTab.LOGIN) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(LoginColors.background)
    ) {
        // Background Image
        Image(
            painter = painterResource(R.drawable.email_background),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.BottomCenter)
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            // Header Section
            LoginHeader(
                onBackClick = onBackClick
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Content Card
            LoginContent(
                email = email,
                onEmailChange = { email = it },
                password = password,
                onPasswordChange = { password = it },
                isPasswordVisible = isPasswordVisible,
                onPasswordVisibilityToggle = { isPasswordVisible = !isPasswordVisible },
                selectedTab = selectedTab,
                onTabSelected = { selectedTab = it },
                onLoginClick = { onLoginClick(email, password) },
                onSignUpClick = onSignUpClick,
                onForgotPasswordClick = onForgotPasswordClick
            )
        }
    }
}

/**
 * Header section containing back button and welcome text.
 */
@Composable
private fun LoginHeader(
    onBackClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 24.dp)
    ) {
        // Back Button
        Text(
            text = stringResource(R.string.back_button),
            color = LoginColors.primary,
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = inter
            ),
            modifier = Modifier.clickable { onBackClick() }
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Welcome Text
        Text(
            text = stringResource(R.string.welcome_back),
            color = LoginColors.primary,
            style = TextStyle(
                fontSize = 32.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = inter
            ),
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = stringResource(R.string.login_subtitle),
            color = LoginColors.subtitleText,
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                fontFamily = inter
            ),
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

/**
 * Main content section with tabs, input fields, and action buttons.
 */
@Composable
private fun LoginContent(
    email: String,
    onEmailChange: (String) -> Unit,
    password: String,
    onPasswordChange: (String) -> Unit,
    isPasswordVisible: Boolean,
    onPasswordVisibilityToggle: () -> Unit,
    selectedTab: LoginTab,
    onTabSelected: (LoginTab) -> Unit,
    onLoginClick: () -> Unit,
    onSignUpClick: () -> Unit,
    onForgotPasswordClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Tab Selector
        LoginTabSelector(
            selectedTab = selectedTab,
            onTabSelected = onTabSelected
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Email Field
        LoginTextField(
            value = email,
            onValueChange = onEmailChange,
            placeholder = stringResource(R.string.email_placeholder),
            leadingIcon = R.drawable.icon_email,
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Password Field
        LoginTextField(
            value = password,
            onValueChange = onPasswordChange,
            placeholder = stringResource(R.string.password_placeholder),
            leadingIcon = R.drawable.icon_lock,
            trailingIcon = R.drawable.icon_eye,
            onTrailingIconClick = onPasswordVisibilityToggle,
            isPassword = true,
            isPasswordVisible = isPasswordVisible,
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Forgot Password
        Text(
            text = stringResource(R.string.forgot_password),
            color = LoginColors.primary,
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = inter
            ),
            textAlign = TextAlign.End,
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onForgotPasswordClick() }
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Login Button
        LoginButton(
            text = stringResource(R.string.login_button),
            onClick = onLoginClick
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Sign Up Link
        SignUpLink(onSignUpClick = onSignUpClick)

        Spacer(modifier = Modifier.height(48.dp))
    }
}

/**
 * Tab selector for switching between Login and Sign Up.
 */
@Composable
private fun LoginTabSelector(
    selectedTab: LoginTab,
    onTabSelected: (LoginTab) -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        LoginTab.entries.forEach { tab ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .clickable { onTabSelected(tab) }
                    .padding(horizontal = 24.dp)
            ) {
                Text(
                    text = when (tab) {
                        LoginTab.LOGIN -> stringResource(R.string.tab_login)
                        LoginTab.SIGN_UP -> stringResource(R.string.tab_sign_up)
                    },
                    color = if (selectedTab == tab) LoginColors.primary else LoginColors.inactiveTab,
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontWeight = if (selectedTab == tab) FontWeight.SemiBold else FontWeight.Medium,
                        fontFamily = inter
                    )
                )

                Spacer(modifier = Modifier.height(8.dp))

                if (selectedTab == tab) {
                    Box(
                        modifier = Modifier
                            .width(62.dp)
                            .height(2.dp)
                            .background(LoginColors.primary)
                    )
                } else {
                    Spacer(modifier = Modifier.height(2.dp))
                }
            }
        }
    }
}

/**
 * Custom text field for login form.
 */
@Composable
private fun LoginTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    leadingIcon: Int,
    trailingIcon: Int? = null,
    onTrailingIconClick: () -> Unit = {},
    isPassword: Boolean = false,
    isPasswordVisible: Boolean = false,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Default
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = {
            Text(
                text = placeholder,
                color = LoginColors.placeholderText,
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                    fontFamily = inter
                )
            )
        },
        leadingIcon = {
            Image(
                painter = painterResource(leadingIcon),
                contentDescription = null,
                modifier = Modifier.size(20.dp)
            )
        },
        trailingIcon = if (trailingIcon != null) {
            {
                IconButton(onClick = onTrailingIconClick) {
                    Image(
                        painter = painterResource(trailingIcon),
                        contentDescription = stringResource(R.string.toggle_password_visibility),
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        } else null,
        visualTransformation = if (isPassword && !isPasswordVisible) {
            PasswordVisualTransformation()
        } else {
            VisualTransformation.None
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = imeAction
        ),
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = LoginColors.inputBackground,
            unfocusedContainerColor = LoginColors.inputBackground,
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent
        ),
        shape = RoundedCornerShape(14.dp),
        textStyle = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = inter,
            color = LoginColors.primary
        ),
        singleLine = true,
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
    )
}

/**
 * Primary login button with gradient background.
 */
@Composable
private fun LoginButton(
    text: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent
        ),
        shape = RoundedCornerShape(26.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(52.dp)
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        LoginColors.buttonGradientStart,
                        LoginColors.buttonGradientEnd
                    )
                ),
                shape = RoundedCornerShape(26.dp)
            )
    ) {
        Text(
            text = text,
            color = LoginColors.buttonText,
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = inter
            )
        )
    }
}

/**
 * Sign up link text at the bottom of the form.
 */
@Composable
private fun SignUpLink(
    onSignUpClick: () -> Unit
) {
    Text(
        text = buildAnnotatedString {
            withStyle(style = SpanStyle(color = LoginColors.primary)) {
                append(stringResource(R.string.no_account_text))
            }
            append(" ")
            withStyle(style = SpanStyle(color = LoginColors.accent)) {
                append(stringResource(R.string.sign_up_link))
            }
        },
        style = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = inter
        ),
        textAlign = TextAlign.Center,
        modifier = Modifier.clickable { onSignUpClick() }
    )
}

/**
 * Enum representing the login/sign up tabs.
 */
enum class LoginTab {
    LOGIN,
    SIGN_UP
}

/**
 * Color constants for the login screen.
 */
private object LoginColors {
    val background = Color(0xFFFFFFFF)
    val primary = Color(0xFF2F6F7E)
    val subtitleText = Color(0xFF6497A3)
    val placeholderText = Color(0xFF6E8E90)
    val inputBackground = Color(0xE6EAF4F5)
    val inactiveTab = Color(0xFF6E8E90)
    val accent = Color(0xFFB28118)
    val buttonGradientStart = Color(0xFF2F6F7E)
    val buttonGradientEnd = Color(0xFF1A4A55)
    val buttonText = Color(0xFFFFFFFF)
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    AppTheme {
        LoginScreen()
    }
}
