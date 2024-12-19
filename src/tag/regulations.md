# Regulations

AdPlayer library support GPP and GDPR regulatory policies.


### General Data Protection Regulation (GDPR)

Library will track GDPR related values mentioned in [GDPR Transparency and Consent Framework](https://github.com/InteractiveAdvertisingBureau/GDPR-Transparency-and-Consent-Framework/blob/master/TCFv2/IAB%20Tech%20Lab%20-%20CMP%20API%20v2.md#in-app-details).

Following values will be taken from the `SharedPreferences` automatically:
```
IABTCF_gdprApplies
IABTCF_TCString
```

This code can be used in case application wants to override default behaviour:
```kotlin
AdPlayer.setGdprRequired(true)
AdPlayer.setGdprConsentString("...")
```



### Global Privacy Platform (GPP)

Library will track GPP related values mentioned in [Global Privacy Platform](https://github.com/InteractiveAdvertisingBureau/Global-Privacy-Platform/blob/main/Core/CMP%20API%20Specification.md#in-app-details).

Following values will be taken from the `SharedPreferences` automatically:
```
IABGPP_HDR_GppString
IABGPP_GppSID
```

At this moment GPP cannot be configured through the `AdPlayerTag` object.
