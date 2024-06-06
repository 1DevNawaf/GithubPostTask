package com.example.postapptask.common.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.postapptask.R

@Composable
fun GithubPostAppBar(title: String,subtitle: String,color: Color) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(130.dp)
            .background(color)
            .shadow(4.dp)
            .padding(top = 40.dp, bottom = 16.dp, start = 16.dp, end = 16.dp)
    ) {
        Column {
            Text(text = title, style = TextStyle(fontSize = 25.sp, color = Color.White))
            Row(Modifier.padding(top = 16.dp)) {
                Text(text = subtitle, style = TextStyle(fontSize = 16.sp, color = Color.White))
                Spacer(modifier = Modifier.width(8.dp))
                Icon(
                    painter = painterResource(id = R.drawable.code), // Replace with your actual icon resource
                    contentDescription = "Open URL",
                    tint = Color.White,
                    modifier = Modifier.size(25.dp)
                )
            }
        }
    }
}
