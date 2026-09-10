package com.heritage.india.auto

import android.content.Intent
import androidx.car.app.Screen
import androidx.car.app.Session
import com.heritage.india.auto.screen.CarHeritageMapScreen

class HeritageCarSession : Session() {
    override fun onCreateScreen(intent: Intent): Screen {
        return CarHeritageMapScreen(carContext)
    }
}
