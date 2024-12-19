# Playback Controls

The `AdPlayerTag` allows you to control the player programmatically.


## Playback

- `AdPlayerTag.pause()` - pauses the player
- `AdPlayerTag.resume()` - resumes the player
- `AdPlayerTag.skipAd()` - skips an ad if one is playing and skippable
- `AdPlayerTag.playingState.value.isPlaying` - detects whether or not the player is playing


## Playlist

When using playlist content from our CMS, use the following to control which content is being played:
- `AdPlayerTag.nextContent()`
- `AdPlayerTag.previousContent()`
- `AdPlayerTag.setContentByIndex(index: Int)`


### Overriding in-stream content during initialization

In-stream content can be overriden during initialization with custom content:

```kotlin
AdPlayer.initializePublisher("publisherId") {
    addTag("tagId") {
        instreamContentOverride = InstreamContent(
            cmsType = "video",
            cmsId = "cmsId",
        )
    }
}
```


### Changing in-stream content on-demand

In-stream content can be replaced with some custom content:

```kotlin
val tag: AdPlayerTag = TODO()
val configItem: JSONObject = TODO()

tag.preloadVideoAsync()
tag.updateContentList(JSONArray().also { it.put(configItem) })
```

Alternatively items in the content playlist can be inserted or removed:

```kotlin
val tag: AdPlayerTag = TODO()
val configItem: JSONObject = TODO()

tag.preloadVideoAsync()
tag.addContentAt(5, configItem)
tag.removeContentAt(2)
```

Example of the config item:

```json
{
  "url": "https://sample-videos.com/video321/mp4/720/big_buck_bunny_720p_1mb.mp4"
}
```
