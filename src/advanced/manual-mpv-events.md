# Manual MPV Events

`Available since 1.10.0`

Automatic MPV (Monetized Page View) events can be disabled in case they don't fit requirements:

```kotlin
AdPlayer.initializePublisher("publisherId") {
    addTag("tagId") {
        disableMpvEvents = true
    }
}
```

In this case they can still be triggered manually thought the `AdPlayerTag` object:

```kotlin
val tag: AdPlayerTag = TODO()

// trigger instant MPV event
tag.triggerMpvEvent(delayed = false)

// trigger delayed MPV event
tag.triggerMpvEvent(delayed = true)
```
