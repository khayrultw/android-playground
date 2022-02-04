package com.khayrul.playground.ui.presentations

import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import com.facebook.FacebookSdk
import com.facebook.LoggingBehavior
import com.facebook.appevents.AppEventsLogger
import com.khayrul.playground.R


class MainActivity : AppCompatActivity() {
    private lateinit var logger:AppEventsLogger
    override fun onCreate(savedInstanceState: Bundle?) {
        logger = AppEventsLogger.newLogger(this)
        FacebookSdk.setIsDebugEnabled(true);
        FacebookSdk.addLoggingBehavior(LoggingBehavior.APP_EVENTS);
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun logSentFriendRequestEvent() {
        logger.logEvent("Custom Log")
    }

    fun onLog(view: View) {
        logSentFriendRequestEvent()
    }
}