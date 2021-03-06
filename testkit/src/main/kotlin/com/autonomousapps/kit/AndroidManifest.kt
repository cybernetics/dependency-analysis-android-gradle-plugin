package com.autonomousapps.kit

class AndroidManifest(val content: String) {

  override fun toString(): String = content

  companion object {
    @JvmStatic fun app(application: String?): AndroidManifest {
      return AndroidManifest(
        """
        <?xml version="1.0" encoding="utf-8"?>
        <manifest xmlns:android="http://schemas.android.com/apk/res/android"
          package="com.example">
        
        <application
          android:allowBackup="true"
          android:label="Test app"
          android:theme="@style/AppTheme"
          ${application.let { "android:name=\"$it\"" }}
          >
          <activity
            android:name=".MainActivity"
            android:label="MainActivity"
            android:theme="@style/AppTheme.NoActionBar">
              <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.LAUNCHER" />
              </intent-filter>
            </activity>
          </application>
        </manifest>
      """.trimIndent()
      )
    }

    val DEFAULT_APP = app(null)

    @JvmStatic
    fun defaultLib(packageName: String) = AndroidManifest(
      """
        <?xml version="1.0" encoding="utf-8"?>
        <manifest xmlns:android="http://schemas.android.com/apk/res/android"
          package="$packageName"/>
      """.trimIndent()
    )
  }
}