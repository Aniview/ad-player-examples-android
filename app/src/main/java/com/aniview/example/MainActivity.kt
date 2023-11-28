package com.aniview.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.adservrs.adplayer.placements.AdPlayerPlacementView

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
    AndroidView(
        factory = {
            val view = AdPlayerPlacementView(it)
            view.attachPlayerTag(BuildConfig.AV_TAG_ID)
            view
        },
        modifier = modifier.fillMaxWidth()
    )
}
