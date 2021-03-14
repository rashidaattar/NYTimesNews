package com.demo.nytimesnews.base.utils

import java.io.IOException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * Created by Rashida on 4/8/19.
 */
object ResponseHelper {
    const val NO_NETWORK = 0
    const val TIME_OUT = 1
    const val UNKNOWN_HOST = 2
    const val OTHER = 3

    /**
     * to get the type of throwable (network, time_out, ..)
     *
     * @param throwable
     * @return the throwable type
     */
    @JvmStatic
    fun getErrorState(throwable: Throwable?): Int {
        when(throwable){
            is SocketTimeoutException -> return TIME_OUT
            is UnknownHostException -> return UNKNOWN_HOST
            is IOException -> return NO_NETWORK
            else -> return OTHER
        }
    }
}