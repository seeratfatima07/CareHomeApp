package com.example.carehomeapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.carehomeapp.ui.theme.AppTheme
import com.example.carehomeapp.ui.theme.inter
import androidx.compose.material3.Button
import androidx.compose.runtime.*
import androidx.compose.runtime.remember
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.scale

/**
 * Data class representing a single review item.
 *
 * @param reviewerName The name of the reviewer
 * @param avatarResId Resource ID for the reviewer's avatar image
 * @param rating The star rating given (1-5)
 * @param timeAgo How long ago the review was posted
 * @param reviewText The review content text
 */
data class ReviewItem(
    val reviewerName: String,
    val avatarResId: Int,
    val rating: Int,
    val timeAgo: String,
    val reviewText: String
)

/**
 * Reviews and Ratings screen displaying overall rating and individual reviews.
 *
 * This screen shows:
 * - A header with back navigation and title
 * - Overall rating summary card
 * - List of individual review cards
 *
 * @param onBackClick Callback invoked when back button is clicked
 * @param modifier Optional modifier for the root composable
 */
@Composable
fun ReviewsRatingsScreen(
    onBackClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    val reviews = listOf(
        ReviewItem(
            reviewerName = stringResource(R.string.reviewer_michael_smith),
            avatarResId = R.drawable.avatar_michael,
            rating = 5,
            timeAgo = stringResource(R.string.time_one_day_ago),
            reviewText = stringResource(R.string.review_michael)
        ),
        ReviewItem(
            reviewerName = stringResource(R.string.reviewer_sara_ahmed),
            avatarResId = R.drawable.avatar_sara,
            rating = 5,
            timeAgo = stringResource(R.string.time_three_days_ago),
            reviewText = stringResource(R.string.review_sara)
        ),
        ReviewItem(
            reviewerName = stringResource(R.string.reviewer_john_ellis),
            avatarResId = R.drawable.avatar_john,
            rating = 5,
            timeAgo = stringResource(R.string.time_five_days_ago),
            reviewText = stringResource(R.string.review_john)
        )
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(ReviewsColors.backgroundColor)
            .verticalScroll(rememberScrollState())
    ) {
        // region Header Section
        HeaderSection(onBackClick = onBackClick)
        // endregion

        Spacer(modifier = Modifier.height(20.dp))

        // region Content Section
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            // Overall Rating Card
            OverallRatingCard(
                rating = "4.6",
                reviewCount = stringResource(R.string.based_on_reviews, 124)
            )

            // Review Cards
            reviews.forEach { review ->
                ReviewCard(review = review)
            }
        }
        // endregion

        Spacer(modifier = Modifier.height(47.dp))
    }
}

/**
 * Header section with gradient background, back button and title.
 *
 * @param onBackClick Callback for back button click
 */
@Composable
private fun HeaderSection(
    onBackClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFE8F4F6),
                        Color(0xFFF9FAFB)
                    )
                )
            )
            .padding(horizontal = 25.dp, vertical = 29.dp)
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

        // Title
        Text(
            text = stringResource(R.string.title_reviews_ratings),
            style = TextStyle(
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = inter,
                color = ReviewsColors.primaryTeal
            ),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 20.dp)
        )
    }
}

/**
 * Card displaying the overall rating summary.
 *
 * @param rating The overall rating value as string
 * @param reviewCount Text showing the number of reviews
 */
@Composable
private fun OverallRatingCard(
    rating: String,
    reviewCount: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(
                elevation = 4.dp,
                shape = RoundedCornerShape(20.dp),
                ambientColor = Color(0x40000000)
            ),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Rating Number
            Text(
                text = rating,
                style = TextStyle(
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = inter,
                    color = ReviewsColors.primaryTeal
                )
            )

            Spacer(modifier = Modifier.height(4.dp))

            // Star Rating
            Image(
                painter = painterResource(R.drawable.ic_star_rating),
                contentDescription = stringResource(R.string.content_desc_rating_stars),
                modifier = Modifier.height(16.dp),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Review Count
            Text(
                text = reviewCount,
                style = TextStyle(
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = inter,
                    color = ReviewsColors.secondaryTeal
                )
            )
        }
    }
}

/**
 * Individual review card displaying reviewer info and review content.
 *
 * @param review The review data to display
 */
@Composable
private fun ReviewCard(
    review: ReviewItem
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(
                elevation = 4.dp,
                shape = RoundedCornerShape(20.dp),
                ambientColor = Color(0x40000000)
            ),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
        ) {
            // Reviewer Info Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Avatar
                    Image(
                        painter = painterResource(review.avatarResId),
                        contentDescription = stringResource(R.string.content_desc_avatar, review.reviewerName),
                        modifier = Modifier
                            .size(43.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop
                    )

                    Spacer(modifier = Modifier.width(12.dp))

                    // Name and Stars
                    Column {
                        Text(
                            text = review.reviewerName,
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontWeight = FontWeight.SemiBold,
                                fontFamily = inter,
                                color = ReviewsColors.primaryTeal
                            )
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        // Star Row
                        StarRatingRow(rating = review.rating)
                    }
                }

                // Time Ago
                Text(
                    text = review.timeAgo,
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = inter,
                        color = ReviewsColors.secondaryTeal
                    )
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Review Text
            Text(
                text = review.reviewText,
                style = TextStyle(
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Medium,
                    fontFamily = inter,
                    color = Color.Black
                )
            )
        }
    }
}

/**
 * Row of star icons representing the rating.
 *
 * @param rating Number of filled stars (1-5)
 */
@Composable
private fun StarRatingRow(
    rating: Int
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        repeat(rating) {
            Image(
                painter = painterResource(R.drawable.ic_star_filled),
                contentDescription = null,
                modifier = Modifier.size(12.dp),
                contentScale = ContentScale.Fit
            )
        }
    }
}

/**
 * Color constants used in the Reviews screen.
 */
private object ReviewsColors {
    val backgroundColor = Color(0xFFF9FAFB)
    val primaryTeal = Color(0xFF2F6F7E)
    val secondaryTeal = Color(0xFF6497A3)
}

@Preview(showBackground = true)
@Composable
fun ReviewsRatingsScreenPreview() {
    AppTheme {
        ReviewsRatingsScreen()
    }
}
