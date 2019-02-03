package com.nosmurf.android.storage

import android.content.Context
import com.nosmurf.common.client.data.datasource.local.LocalDataSource


class AndroidLocalDataSource(context: Context) : LocalDataSource {

    companion object {
        const val PREFERENCES_KEY = "preferences_key"
    }

    private val sharedPreferences = context.getSharedPreferences(PREFERENCES_KEY, Context.MODE_PRIVATE)

}