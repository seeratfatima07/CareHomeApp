package com.example.carehomeapp.ui.theme

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.example.carehomeapp.R
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * Inria Serif font family used for titles and headings.
 */
val inriaSerif = FontFamily(
    Font(R.font.inriaserif_bold, FontWeight.Bold)
)

/**
 * Inter font family used for body text and taglines.
 */
val inter = FontFamily(
    Font(R.font.inter_semibold, FontWeight.SemiBold, FontStyle.Italic)
)
