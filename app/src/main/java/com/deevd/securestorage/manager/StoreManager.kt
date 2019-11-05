package com.deevd.securestorage.manager

import com.deevd.securestorage.model.UserItem

/**
 * Created by Hein Htet on 2019-11-03.
 */
interface StoreManager {
    fun getUser() : UserItem?
    fun<T> saveUser(value : T)
}

