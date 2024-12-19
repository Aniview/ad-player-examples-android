# Creating a Placement

`AdPlayerPlacementView` can be created and added to the screen after library was initialized:
```kotlin
val view = AdPlayerPlacementView(it)
view.attachPlayerTag("YOUR TAG ID")

parent.addView(view) // do something with the view
```

Or you can also do the same from the layout xml file:
```xml
<com.adservrs.adplayer.placements.AdPlayerPlacementView
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:player_tag="YOUR TAG ID"
    />
```
