package com.example.jetpackcomposeexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposeexample.ui.theme.JetpackComposeExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstApp()
        }
    }
}

@Composable
fun FirstApp() {
    Surface(
        modifier = Modifier.height(150.dp).width(250.dp).padding(20.dp),
        shape = CutCornerShape(8.dp),
        color = Color.Gray,
        border = BorderStroke(2.dp, Color.Green),
        shadowElevation = 20.dp
        ) {
        Text(text = "Mwakanemela Kayange", fontSize = 20.sp, modifier = Modifier.padding(8.dp))
    }
}


@Preview(showBackground = true, name = "Mwaka The Developer")
@Composable
fun AppPreview() {
    FirstApp()
}