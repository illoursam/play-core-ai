package com.playcore.ai.node

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import android.os.PowerManager

class NodeEngineManager(private val context: Context) {

    private val powerManager = context.getSystemService(Context.POWER_SERVICE) as PowerManager

    /**
     * 1. Vérifie si l'appareil est branché (secteur ou USB)
     */
    fun isDevicePluggedIn(): Boolean {
        val intent: Intent? = context.registerReceiver(null, IntentFilter(Intent.ACTION_BATTERY_CHANGED))
        val status = intent?.getIntExtra(BatteryManager.EXTRA_STATUS, -1) ?: -1
        return status == BatteryManager.BATTERY_STATUS_CHARGING || status == BatteryManager.BATTERY_STATUS_FULL
    }

    /**
     * 2. Vérifie si l'appareil est en mode Doze (veille profonde d'Android)
     */
    fun isDeviceInDozeMode(): Boolean {
        return powerManager.isDeviceIdleMode
    }

    /**
     * 3. Condition critique : Autorise ou bloque l'exécution d'une micro-tâche Edge AI
     * Garantit zéro impact sur l'expérience utilisateur et la batterie.
     */
    fun canExecuteMicroTask(): Boolean {
        val plugged = isDevicePluggedIn()
        val doze = isDeviceInDozeMode()
        
        // Le nœud ne s'active que si les deux conditions de sécurité sont réunies
        return plugged && doze
    }
}
