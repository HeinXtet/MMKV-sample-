package com.deevd.securestorage

import android.app.Application
import android.util.Log
import com.tencent.mmkv.MMKV
import java.io.File
import java.nio.charset.Charset
import android.R.attr.data
import com.deevd.securestorage.manager.SecureStore
import com.deevd.securestorage.model.UserItem
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


/**
 * Created by Hein Htet on 2019-11-03.
 */
class SecureApp : Application(){
    override fun onCreate() {
        super.onCreate()
        SecureStore.init(this)
    }
}