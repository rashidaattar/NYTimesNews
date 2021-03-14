package com.demo.nytimesnews.base.utils;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

/**
 * Created by Rashida on 4/8/19.
 */
public class ResponseHelper {

    public static final int NO_NETWORK = 0;
    public static final int TIME_OUT = 1;
    public static final int UNKNOWN_HOST = 2;
    public static final int OTHER = 3;


    /**
     * to get the type of throwable (network, time_out, ..)
     *
     * @param throwable
     * @return the throwable type
     */
    public static int getErrorState(Throwable throwable) {
        if (throwable instanceof SocketTimeoutException) {
            return TIME_OUT;
        } else if (throwable instanceof UnknownHostException) {
            return UNKNOWN_HOST;
        }
        if (throwable instanceof IOException) {
            return NO_NETWORK;
        } else {
            return OTHER;
        }
    }
}
