package com.onionsquare.bitpanda_api_wrapper.repository

import retrofit2.Response
import com.onionsquare.exhange_common.entities.Result

abstract class BaseRepository {

    protected suspend fun <T : Any> apiCall(call: suspend () -> Response<T>): Result<T> {
        val response: Response<T>
        try {
            response = call.invoke()
        } catch (t: Throwable) {
            return Result.Error(java.lang.Exception(t))
        }

        if (!response.isSuccessful) {
            return Result.Error(java.lang.Exception(Throwable("Unknow error")))
        }
        return Result.Success(response.body()!!)
    }
}

