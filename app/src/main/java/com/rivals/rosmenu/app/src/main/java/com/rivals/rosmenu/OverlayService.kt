package com.rivals.rosmenu

import android.app.Service
import android.content.Intent
import android.os.IBinder

class OverlayService : Service() {
    private lateinit var cheatMenu: CheatMenu

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        cheatMenu = CheatMenu(this)
        cheatMenu.show()
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        cheatMenu.dismiss()
    }

    override fun onBind(intent: Intent?): IBinder? = null
}
