# About AdPlayerPlacementView

This section provides description of the other APIs available on the `AdPlayerPlacementView`.


## Basic Properties

- `playerTagId` - the ID of the `AdPlayerTag` attached to this placement.
- `label` - a convenience field to ease the identification of `AdPlayerPlacementView` in log records.


## Display Properties

- `priority` - in case more than one placement is visible on the screen, a priority can be set to decide which one should play. This value is configurable between 1 and 999. In case one or more of the placements are partially visible, the playing placement will be selected based on the highest value of priority times visible percent. In any case, user interactions with the player and API calls will override the priority.
- `animateAppearance` - defines weather the appearance of new placements on the screen should be animated. Is false by default for instream tags and true for outstream tags.
- `appearanceAnimationDuration` - the duration of the appearance animation in milliseconds if animateAppearance is set to true.
- `appearOnPlay` - when set to false, the placement will appear on the screen immediately when the attached tag is available. Otherwise, the placement will appear on the screen only when the tag starts to play video. Is false by default for instream tags and true for outstream tags.
- `allowFloatingAbove` - in case the player in this `AdPlayerPlacementView` is defined as "Floating", this property will determine whether or not it can be floating above this `AdPlayerPlacementView` (when this placement is being scrolled down) in addition to being floating below this `AdPlayerPlacementView` (when this placement is being scrolled up).


## Controls

- `close()` - prevents the player from appearing in this placement again unless the screen is recreated.
