# Initializing Library

Before any placement can be added to the screen library must be initialized first:
```kotlin
import com.adservrs.adplayer.AdPlayer.initializeAdPlayer
import com.adservrs.adplayer.AdPlayer.initializePublisher

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        initializeAdPlayer()
        initializePublisher("YOUR PUBLISHED ID") {
            addTag("YOUR TAG ID")
        }
    }
}
```
