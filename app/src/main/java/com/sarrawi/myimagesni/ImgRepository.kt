package com.sarrawi.myimagesni

import android.app.Application
import retrofit2.Call

import retrofit2.Response


class ImgRepository(val apiService: ApiService,app:Application) {


    suspend fun getsnippets_Repoa() = apiService.getsnippets()

    suspend fun getsnippets_Repo(): Response<ImgsRespone2> {
        // استخدم نموذج البيانات لتعريف نوع الاستجابة المتوقع
        return apiService.getsnippets()
    }

    fun getSnippets(): Call<ImgsRespone2> {
        return apiService.getSnipp()
    }







}

