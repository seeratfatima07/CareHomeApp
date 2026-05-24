package com.example.carehomeapp

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Design tokens object containing all shared design values used throughout the app.
 * This includes colors, font sizes, and other reusable design constants.
 */
object DesignTokens {
    // region Color Tokens
    
    /** Pure white color */
    val colorWhite: Color = Color(0xFFFFFFFF)

    /** Pure black color */
    val colorBlack: Color = Color(0xFF000000)

    /** Primary teal color used for titles and branding */
    val colorTeal: Color = Color(0xFF2F6F7E)
    
    /** Alias for colorTeal to be used as primary brand color */
    val colorPrimary: Color = colorTeal

    /** Accent color, currently same as primary */
    val colorAccent: Color = colorTeal
    
    /** Light slate gray color used for secondary text */
    val colorLightSlateGray: Color = Color(0xFF8FA3B0)

    /** Alias for colorLightSlateGray for secondary text */
    val colorTextSecondary: Color = colorLightSlateGray

    /** Primary text color */
    val colorTextPrimary: Color = Color(0xFF1A1A1A)

    /** Tertiary text color */
    val colorTextTertiary: Color = Color(0xFF666666)

    /** Border color for input fields */
    val colorBorder: Color = Color(0xFFE0E0E0)

    /** Background color for screens */
    val colorBackground: Color = Color(0xFFF8F9FA)

    /** Success color (e.g., available status) */
    val colorSuccess: Color = Color(0xFF4CAF50)

    /** Error color (e.g., full status) */
    val colorError: Color = Color(0xFFF44336)

    /** Divider color */
    val colorDivider: Color = Color(0xFFEEEEEE)
    
    // endregion

    // region Font Size Tokens
    
    /** Extra large font size for headings */
    val fontSizeXXLarge = 40.sp

    /** Large font size for titles */
    val fontSizeXLarge = 24.sp

    /** Large font size for section headers */
    val fontSizeLarge = 32.sp

    /** Alias for fontSizeLarge for main titles */
    val fontSizeTitle = 32.sp
    
    /** Medium font size for subtitles and taglines */
    val fontSizeMedium = 20.sp

    /** Standard body text size */
    val fontSizeBody = 16.sp

    /** Small text size for hints and secondary info */
    val fontSizeSmall = 14.sp

    /** Extra small text size */
    val fontSizeXSmall = 10.sp

    /** Caption text size */
    val fontSizeCaption = 12.sp

    /** Emoji font size */
    val fontSizeEmoji = 24.sp
    
    // endregion

    // region Spacing Tokens

    val spacingXSmall = 4.dp
    val spacingSmall = 8.dp
    val spacingMedium = 16.dp
    val spacingLarge = 24.dp
    val spacingXLarge = 32.dp
    val spacingXXLarge = 48.dp

    // endregion

    // region Component Tokens

    val iconSizeSmall = 20.dp
    val iconSizeMedium = 24.dp
    val iconSizeLarge = 32.dp
    val iconSizeXLarge = 40.dp
    
    val buttonHeight = 56.dp
    val searchFieldHeight = 56.dp
    val filterChipHeight = 40.dp
    val cardHeight = 120.dp
    val cardImageSize = 88.dp
    val decorativeDotSize = 12.dp
    
    val thumbnailSize = 80.dp
    val avatarSize = 48.dp
    
    val cornerRadiusSmall = 8.dp
    val smallCornerRadius = 8.dp
    val cornerRadiusMedium = 16.dp
    val cardCornerRadius = 16.dp
    val cornerRadiusLarge = 12.dp
    val cornerRadiusChip = 20.dp
    val badgeCornerRadius = 20.dp
    val checkboxCornerRadius = 4.dp
    
    val shadowElevation = 4.dp
    val dividerHeight = 1.dp

    // endregion
}
