# Display Modes


## Interstitial

An `AdPlayerTag` may be presented as interstitial. To do so, use the following API:
```kotlin
val tag: AdPlayerTag = TODO()
tag.asInterstitial()
    .withConfiguration {
        backgroundColor = Color.WHITE
        noAdTimeoutSec = 10
        dismissOnBack = true
    }
    .onDismissed {
        // do dismiss action
    }
    .launch()
```


## Floating

Choosing the **Floating** player mode in the dashboard, allows the player to stay present on the screen and keep playing even after its original position has been scrolled out of view by “floating” at a fixed position on the screen. The floating position can also be selected in the dashboard from a pre defined set of options.

In general, the floating behavior and configuration is controlled from the dashboard but in order to provide flexibility to the application developers, they are the ones who define the borders that will limit the floating behavior by providing a **Floating Scope**. Here's a visual illustration:

![image](https://github.com/Aniview/ad-player-examples-android/assets/1215187/027ff961-6be0-41c8-9ae2-4a7734f2c056)

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/main_layout"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <FrameLayout
        android:id="@+id/floating_scope"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="@color/aniview_gray">

        <androidx.core.widget.NestedScrollView
            android:id="@+id/screen_content"
            android:layout_width="match_parent"
            android:layout_height="wrap_content">

            <!--Screen content here-->

        </androidx.core.widget.NestedScrollView>

    </FrameLayout>

</androidx.constraintlayout.widget.ConstraintLayout>
```

The scope is a ViewGroup, preferably a FrameLayout, that should be provided by invoking:
```kotlin
val placement: AdPlayerPlacementView = TODO()
placement.setFloatingScope(scopeViewGroup):
```

Or alternatively scope view ID can be provided in xml file:
```xml
<com.adservrs.adplayer.placements.AdPlayerPlacementView
    xmlns:app="http://schemas.android.com/apk/res-auto"
    ...
    app:floating_scope="@id/ad_placement_scope"
    />
```


### Important remarks

- Floating behavior will not be available without providing a scope!
- Make sure the floating scope doesn’t extend beyond the limits of the visible area. A scope that extends beyond the limits of the visible area will cause the player to float off the screen and be cut off or even not visible at all.
