package com.sarrawi.myimagesni

import com.google.gson.annotations.SerializedName

data class ImgsRespone(
    @SerializedName("ImgsModel")
    val results: List<ImgsModel>,
    @SerializedName("current_page")
    val currentPage: Int,
    @SerializedName("total_pages")
    val totalPages: Int
)

//
//data class ImgsRespone(@SerializedName("ImgsModel")
//                        val results:List<ImgsModel>)
