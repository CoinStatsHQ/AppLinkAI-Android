package app.link.demo

import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONObject
import app.link.AppLink

/**
 * Minimal demo app that initializes the AppLinkAI SDK and triggers a sample verification call.
 */
class MainActivity : AppCompatActivity() {

    private lateinit var resultText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultText = findViewById(R.id.txtResult)
        val callButton: Button = findViewById(R.id.btnCall)

        // Initialize the library with your API key
        AppLink.initialize(
            activity = this,
            apiKey = "YOUR_API_KEY",
            isTestMode = true,
            deepLinkHandler = { paramsJson ->
                // Handle the deep link parameters
                onDeepLink(paramsJson)
            },
            errorHandler = { errorMessage ->
                // Handle any errors
                onError(errorMessage)
            }
        )

        callButton.setOnClickListener {
            // For demo purposes, simulate handling a deep link
            val sampleUrl = "https://example.com/path?utm_source=demo"
            val handled = AppLink.handleDeepLink(sampleUrl)
            if (!handled) {
                resultText.text = "Failed to handle sample link"
            }
        }
    }

    private fun onDeepLink(params: JSONObject) {
        resultText.text = buildString {
            appendLine("Deep Link Verified!")
            appendLine("Device: ${Build.MODEL}")
            appendLine("Params:")
            append(params.toString(2))
        }
    }

    private fun onError(message: String) {
        resultText.text = "Error: $message"
    }
}


