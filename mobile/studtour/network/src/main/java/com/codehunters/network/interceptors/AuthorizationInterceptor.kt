package com.codehunters.network.interceptors

import okhttp3.Interceptor
import okhttp3.Response

class AuthorizationInterceptor(
    var authToken: String? = null
) : Interceptor {

    companion object {
        private const val AUTHORIZATION_HEADER = "Authorization"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val builder = request.newBuilder().apply {
            if (chain.request().headers[AUTHORIZATION_HEADER].isNullOrEmpty()) {
                authToken?.let { addHeader(AUTHORIZATION_HEADER, it) }
            }
        }
        return chain.proceed(builder.build())
    }
}