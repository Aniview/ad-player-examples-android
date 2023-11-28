package com.aniview.example

import android.app.Application
import com.adservrs.adplayer.AdPlayer.initializeAdPlayer
import com.adservrs.adplayer.AdPlayer.initializePublisher

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        initializeAdPlayer()
        initializePublisher(BuildConfig.AV_PUB_ID) {
            addTag(BuildConfig.AV_TAG_ID)
        }
    }
}
