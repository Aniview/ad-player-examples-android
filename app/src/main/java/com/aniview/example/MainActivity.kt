package com.aniview.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.aniview.example.examples.SimpleExample
import com.aniview.example.examples.UpdateContentListExample

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val colorScheme = when (isSystemInDarkTheme()) {
                true -> darkColorScheme()
                else -> lightColorScheme()
            }
            MaterialTheme(colorScheme = colorScheme) {
                Content()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Content() {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "AdPlayer Example") })
        },
        content = {
            Body(Modifier.padding(it))
        },
    )
}

@Composable
fun Body(modifier: Modifier = Modifier) {
    val screen = remember { mutableStateOf<(@Composable (Modifier) -> Unit)?>(null) }

    val screenValue = screen.value
    if (screenValue != null) {
        screenValue(modifier)
        return
    }

    Column(modifier.fillMaxSize()) {
        Button(onClick = { screen.value = { SimpleExample(it) } }) {
            Text("Simple")
        }
        Button(onClick = { screen.value = { UpdateContentListExample(it) } }) {
            Text("UpdateContentList")
        }
    }
}
