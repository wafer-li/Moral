package com.wafer.moral.application

import android.app.Application
import com.wafer.moral.network.ApiManager

/**
 * The MoralApplication class
 * Please put more info here.
 * @author wafer
 * @since 17/4/15 19:32
 */

class MoralApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        ApiManager.init(applicationContext)
    }
}
