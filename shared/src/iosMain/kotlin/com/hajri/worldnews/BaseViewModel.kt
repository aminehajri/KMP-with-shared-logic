package com.hajri.worldnews

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

actual open class BaseViewModel {

    actual val scope: CoroutineScope = CoroutineScope(Dispatchers.IO)

}