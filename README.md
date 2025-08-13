## AppLinkAI Android SDK

**Tag: 1.2.0**

Lightweight Android/Kotlin SDK to verify deep links and receive enriched parameters from the AppLinkAI platform. The SDK handles network calls, parsing, and provides a simple API to integrate into your app.

Note: Your app must request Internet access:
```xml
<uses-permission android:name="android.permission.INTERNET" />
```

### Installation

Replace `$tag` with the current version number.
Add the dependency to your Android project:

Gradle (Kotlin DSL):
```kotlin
dependencies {
    implementation("applink.ai:AppLinkAI-Android:$tag")
}
```

Gradle (Groovy):
```groovy
dependencies {
    implementation 'applink.ai:AppLinkAI-Android:$tag'
}
```

Maven:
```xml
<dependency>
  <groupId>applink.ai</groupId>
  <artifactId>AppLinkAI-Android</artifactId>
  <version>$tag</version>
  <type>aar</type>
</dependency>
```

### Minimal Usage

Kotlin example (e.g., in your main `Activity`):
```kotlin
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AppLink.initialize(
            activity = this,
            apiKey = "YOUR_API_KEY",
            isTestMode = false,
            deepLinkHandler = { paramsJson ->
                // Handle the deep link parameters
                Log.d("AppLinkAI", paramsJson.toString())
            },
            errorHandler = { errorMessage ->
                // Handle any errors
                Log.e("AppLinkAI", errorMessage)
            }
        )
    }
}
```

The library generates a `JSONObject` with these parameters:
```
"+sourceUrlKey", "+sourceUrlPathKey", "+IsFirstSessionKey"
```

### Key Class

- `AppLink`: Primary entry point.
  - `initialize(activity, apiKey, isTestMode, deepLinkHandler, errorHandler)`: Initializes the SDK and performs a verification call.
  - `handleDeepLink(url: String)`: Optionally handle a deep link URL manually;.

### License

This project is released under the MIT License. See `LICENSE` for details.


