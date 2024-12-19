# Create AdPlayerTag
`AdPlayerTag` provides ability to control the player. It can be received in any of the ways below.

- as a callback during initialization:
```kotlin
AdPlayer.initializePublisher("publisherId") { TODO() }
    .onTagReady { tag: AdPlayerTag ->
        // tag instance available here
    }
    .onError { error: AdPlayerError ->
        // tag initialization failed
    }
```

- registering a callback anywhere:
```kotlin
AdPlayer.getTagWhenReady("tagId", object  : AdPlayerTagInitCallback {
    override fun onTagReady(tag: AdPlayerTag) {
        // tag instance available here
    }

    override fun onError(error: AdPlayerError, tagId: String?) {
        // tag initialization failed
    }
}
```

- using suspend functions:
```kotlin
when (val result = AdPlayer.getTagWhenReady("tagId")) {
    is AvResult.Success -> {
        // tag instance available here
        val tag = result.value
    }
    is AvResult.Failure -> {
        // tag initialization failed
        val error = result.value
    }
}
```

- non-blocking peeking functions:
```kotlin
val tag = AdPlayer.getTagNowOrNull("tagId")
if (tag != null) {
    // tag instance available here
}
```
