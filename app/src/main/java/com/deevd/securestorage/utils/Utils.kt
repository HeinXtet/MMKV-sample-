package com.deevd.securestorage.utils

import android.content.Context
import android.util.Log
import java.io.IOException
import java.nio.charset.Charset

/**
 * Created by Hein Htet on 2019-11-03.
 */
object Utils {

    fun getAssetJsonData(context: Context): String? {
        val json: String
        try {
            val `is` = context.getAssets().open("test.json")
            val size = `is`.available()
            val buffer = ByteArray(size)
            `is`.read(buffer)
            `is`.close()
            json = String(buffer, Charset.forName("UTF-8"))
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }

        Log.e("data", json)
        return json

    }
}