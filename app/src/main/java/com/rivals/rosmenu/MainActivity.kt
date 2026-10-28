package com.rivals.rosmenu

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.graphics.Color

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(Color.parseColor("#0D0D0D"))
            setPadding(40, 80, 40, 40)
        }
        layout.addView(TextView(this).apply {
            text = "AXIOM — ROS LEGACY"
            setTextColor(Color.parseColor("#FF0000"))
            textSize = 20f
            gravity = android.view.Gravity.CENTER
        })
        val btn = Button(this).apply {
            text = "START AXIOM"
            setBackgroundColor(Color.parseColor("#FF0000"))
            setTextColor(Color.WHITE)
            textSize = 16f
        }
        btn.setOnClickListener {
            if (!Settings.canDrawOverlays(this)) {
                startActivity(Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:$packageName")))
            } else {
                startService(Intent(this, OverlayService::class.java))
                finish()
            }
        }
        layout.addView(btn)
        setContentView(layout)
    }
}
