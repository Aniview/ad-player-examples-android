# States and Events

`AdPlayerTag` provides API to observe its state, emitted events and more.


## Player State

To be notified about changes in the state of the player, observe it in the following way:

```kotlin
tag.playingState.collect {
    when (it) {
        is AdPlayerPlayingState.Initial -> {}
        is AdPlayerPlayingState.Playing -> {
            if (it.isAd) {
                // the player is playing an ad
            } else {
                // the player is playing content
            }
        }
        is AdPlayerPlayingState.NotPlaying -> {}
        is AdPlayerPlayingState.Display -> {}
    }
}
```


## Player Events

To be notified about one-off events of the player, observe it in the following way:

```kotlin
tag.eventsFlow.collect {
    when (it) { 
        // handle events
    }
}
```


## Display modes

`AdPlayerTag.playingState.value.displayMode` can be used to detect the displaying mode of the player. Currently these modes are supported:
- `Not Displayed` - the player is not being displayed on the screen.
- `Inread` - the player is being displayed in a `AdPlayerPlacementView` inside the application’s UI. This is the default display mode.
- `Full Screen` - the player is taking up the entire screen.
- `Floating` - the player is occupying a part of the screen above the content.

To move between Inread and Full Screen display modes, use the following methods:
- `AdPlayerTag.toggleFullScreen()`
- `AdPlayerTag.enterFullScreen()`
- `AdPlayerTag.exitFullScreen()`

The transition to and from the `Floating` display mode is performed automatically.
