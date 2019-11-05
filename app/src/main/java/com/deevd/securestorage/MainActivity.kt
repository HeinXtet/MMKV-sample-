package com.deevd.securestorage

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.deevd.securestorage.manager.SecureStore
import com.deevd.securestorage.utils.Utils


class MainActivity : AppCompatActivity() {
    private val secureStore  = SecureStore()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val data = Utils.getAssetJsonData(this)
        secureStore.saveUser(data)
        Log.d("User Item " , secureStore.getUser().toString())
    }
}
