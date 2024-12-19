# AdPlayerTag Configuration

While most of the configurations are available on the dashboard, the `AdPlayerTag` provides some configurations to the player that can be changed in code. The configurations should be provided as part of the initialization process.

```kotlin
AdPlayer.initializePublisher("publisherId") {
    addTag("tagId") {
        // tag configuration happens here
        label = "tag_label"
        backgroundColor = Color.BLACK
        macros = mutableListOf(
            AdPlayerMacro.CmsId("cmsId"),
            AdPlayerMacro.PlaylistId("playlistId"),
            AdPlayerMacro.Custom("customKey", "customValue"),
        )
    }
}
```
