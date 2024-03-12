package com.aniview.example.examples

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.adservrs.adplayer.AdPlayer
import com.adservrs.adplayer.placements.AdPlayerPlacementView
import com.aniview.example.BuildConfig
import org.json.JSONArray
import org.json.JSONObject

@Composable
fun UpdateContentListExample(modifier: Modifier = Modifier) {
    val ready = remember { mutableStateOf(false) }

    LaunchedEffect("tag") {
        val tag = AdPlayer.getTagWhenReady(BuildConfig.AV_TAG_ID).getSuccessOrNull()
        if (tag != null) {
            val configItem = JSONObject()
            configItem.put(
                "url",
                "https://sample-videos.com/video321/mp4/720/big_buck_bunny_720p_1mb.mp4",
            )

            val config = JSONArray()
            config.put(configItem)

            tag.preloadVideoAsync()
            tag.updateContentList(config)
        }
        ready.value = true
    }

    Column(modifier) {
        Text("This will work only for in-stream ads")

        if (ready.value) {
            AndroidView(
                factory = {
                    val view = AdPlayerPlacementView(it)
                    view.attachPlayerTag(BuildConfig.AV_TAG_ID)
                    view
                },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
