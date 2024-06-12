# AdPlayer Example

This project contains a minimal example application to start displaying Ads with Aniview's AdPlayer library.


## How to run this example
Running this example requires `publisher` and `tag` ids.
They can be configures in the root `local.properties` file like this:

```properties
sdk.dir=...

av_pub_id={published id goes here}
av_tag_id={tag id goes here}
```

After this project can simply be opened in the Android Studio and built.


## How to configure fresh project
Here are steps to configure a fresh project:

1. Add Maven repository in the `settings.gradle.kts` file:
```kts
dependencyResolutionManagement {
    repositories {
        maven("https://us-central1-maven.pkg.dev/mobile-sdk-fd2e4/adservr-maven")
    }
}
```

2. Add Maven dependencies in the app's `build.gradle.kts` file:
```kts
dependencies {
    implementation("com.adservrs:adplayer:1.8.0")
}
```

3. Initialize AdPlayer library in the `Application` class:
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

4. Add `AdPlayerPlacementView` in the code:
```kotlin
val view = AdPlayerPlacementView(it)
view.attachPlayerTag("YOUR TAG ID")

parent.addView(view) // do something with the view
```

5. Or add `AdPlayerPlacementView` from the xml file:
```xml
<com.adservrs.adplayer.placements.AdPlayerPlacementView
        xmlns:app="http://schemas.android.com/apk/res-auto"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:player_tag="YOUR TAG ID"
        />
```


## Floating views
Floating views can be displayed when ad placement goes out of the visible screen area.

To enable such behaviour parent *scope* view (preferably it should be `FrameLayout`) must be provided:
```kotlin
val view: AdPlayerPlacementView
val scope: FrameLayout
view.setFloatingScope(scope)
```

Or alternatively *scope* view ID can be provided in xml file:
```xml
<com.adservrs.adplayer.placements.AdPlayerPlacementView
    xmlns:app="http://schemas.android.com/apk/res-auto"
    ...
    app:floating_scope="@id/ad_placement_scope"
    />
```
