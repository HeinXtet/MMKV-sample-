package com.deevd.securestorage.manager

import android.content.Context
import android.os.Environment
import android.util.Log
import com.deevd.securestorage.model.UserItem
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.tencent.mmkv.BuildConfig
import com.tencent.mmkv.MMKV
import com.tencent.mmkv.MMKVLogLevel
import java.io.File

/**
 * Created by Hein Htet on 2019-11-03.
 */

class SecureStore :StoreManager {
    companion object {
        private val STORE_USER = "app.User"
        private val TAG = SecureStore::class.java.simpleName
        private val cryptKey = "123456" // set up key from  api or C++
        private lateinit var kv: MMKV
        fun init(context: Context) {
            val file = File(
                context.getExternalFilesDir(
                    Environment.DIRECTORY_DOWNLOADS
                ), "SecureStorage"
            )
            if (!file.mkdirs()) {
                Log.e(TAG, "Directory not created")
            }
            val rootDir = MMKV.initialize(context) // create file
            Log.d(TAG, "root path $rootDir")
            kv = MMKV.mmkvWithID(context.packageName, MMKV.SINGLE_PROCESS_MODE, cryptKey)
            if(BuildConfig.DEBUG){
                MMKV.setLogLevel(MMKVLogLevel.LevelDebug)
            }else{
                MMKV.setLogLevel(MMKVLogLevel.LevelNone)
            }
        }
    }

    private inline fun <reified T> get(key: String): T {
        val type = object : TypeToken<T>() {
        }.type
        return Gson().fromJson(kv.decodeString(key), type)
    }

    private fun <T> save(key: String, data: T) {
        kv.encode(key, data.toString())
    }

    override fun getUser(): UserItem? {
        return get(STORE_USER)
    }

    override fun <T> saveUser(value: T) {
        if (value !is String) {
            save(STORE_USER, Gson().toJson(value))
        }
        save(STORE_USER, value)
    }
}