package com.murielsilveira.digits

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.io.IOException
import android.util.Log
import com.google.android.things.contrib.driver.ssd1306.Ssd1306
import com.google.android.things.pio.PeripheralManager

private val TAG = MainActivity::class.java.simpleName
private val I2C_BUS = "BUS NAME"

class MainActivity : AppCompatActivity() {
    private lateinit var mScreen: Ssd1306

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val manager = PeripheralManager.getInstance()
        Log.e(TAG, "Available GPIO " + manager.getGpioList())
//        setupOledDisplay()
    }

    override fun onDestroy() {
        super.onDestroy()
//        destroyOledDisplay()
    }

    private fun setupOledDisplay() {
        try {
            mScreen = Ssd1306(I2C_BUS)
        } catch (e: IOException) {
            Log.e(TAG, "Error while opening screen", e)
        }

        Log.d(TAG, "OLED screen activity created")
    }

    private fun destroyOledDisplay() {
        try {
            mScreen.close()
        } catch (e: IOException) {
            Log.e(TAG, "Error closing SSD1306", e)
        }
    }

}
