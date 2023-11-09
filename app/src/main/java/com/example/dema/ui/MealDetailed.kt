package com.example.dema.ui

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dema.R

@Composable
fun MealActivity() {
    var expandedHeight by remember { mutableStateOf(280.dp) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Gray)
    ) {
        // Collapsing Toolbar
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Gray)
        ) {
            Image(
                painter = painterResource(id = R.drawable.dema_1),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(expandedHeight)
                    .clip(shape = RoundedCornerShape(0.dp, 0.dp, 16.dp, 16.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(45.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Category: Pizza",
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                )
                Text(
                    text = "Area: Palestine",
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Instructions:",
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                fontSize = 15.sp
            )
        }

        // Floating Action Button
        FloatingActionButton(
            onClick = { /* Handle FAB click */ },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp),
            containerColor = Color.Red
        ) {
            Icon(imageVector = Icons.Default.Favorite, contentDescription = null, tint = Color.White)
        }

        // Progress Indicator
        LinearProgressIndicator(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        )
    }
}
