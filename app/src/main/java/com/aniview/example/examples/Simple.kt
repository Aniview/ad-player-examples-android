package com.aniview.example.examples

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.adservrs.adplayer.placements.AdPlayerPlacementView
import com.aniview.example.BuildConfig

@Composable
fun SimpleExample(modifier: Modifier = Modifier) {
    AndroidView(
        factory = {
            val view = AdPlayerPlacementView(it)
            view.attachPlayerTag(BuildConfig.AV_TAG_ID)
            view
        },
        modifier = modifier.fillMaxWidth()
    )
}
