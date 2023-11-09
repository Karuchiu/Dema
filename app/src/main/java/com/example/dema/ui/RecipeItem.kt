package com.example.dema.ui

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.dema.models.local.Dema

@Composable
fun RecipeItem(dema: Dema) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        // Image
        Image(
            painter = painterResource(id = dema.imageRes),
            contentDescription = null, // TODO: Provide a meaningful description
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()
                .clip(shape = MaterialTheme.shapes.medium),
            contentScale = ContentScale.Crop
        )

        // Spacer
        Spacer(modifier = Modifier.height(5.dp))

        // Recipe Name
        Text(
            text = dema.name,
            modifier = Modifier
                .padding(5.dp),
            style = MaterialTheme.typography.labelMedium
        )
    }
}
