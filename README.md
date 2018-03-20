# ce-dfp-sample-android

## Mediate CrystalExpress Ads through Dfp

The full integration guide: https://intowow.gitbooks.io/crystalexpress-documentation-v3-x/content/mediation-guidelines/admob/android.html

The CrystalExpress Dfp Custom Event allows Dfp publishers to add CrystalExpress as a Custom Ad Network within the Dfp platform.

CrystalExpress provides four ad formats for Dfp mediation. The relationship between Dfp ad unit and ad format in CrystalExpress is as following:

| Dfp ad unit | AD format from CrystalExpress |
| --- | --- |
| Banner | Card AD |
| Interstitial | Splash AD |

Before adding CrystalExpress as Custom network, you have to integrate Dfp SDK by following the instructions on the [Dfp website](https://developers.google.com/mobile-ads-sdk/docs/dfp/android/quick-start).


** NOTICE: This porject does not contain CrystalExpress SDK. Please contact your Intowow account manager. We will provide the appropriate version of SDK and Crystal ID to fit your needs.**

The custom event is under folder 'app/src/main/java/com/intowow/dfpdemo/customevent/'


## CHANGELOG

#### Version 1 (2018-03-15)

#### Features
* Implement Dfp Custom Events for CE Card & CE Interstitial.