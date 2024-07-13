package com.app.learn.retrofit


import com.google.gson.annotations.SerializedName

data class ResponseMoviesList(
    @SerializedName("data")
    val `data`: List<Data?>?,
    @SerializedName("metadata")
    val metadata: Metadata?
) {
    data class Data(
        @SerializedName("genres")
        val genres: List<String?>?,
        @SerializedName("id")
        val id: Int?, // 1
        @SerializedName("images")
        val images: List<String?>?,
        @SerializedName("poster")
        val poster: String?, // http://moviesapi.ir/images/tt0111161_poster.jpg
        @SerializedName("title")
        val title: String? // The Shawshank Redemption
    )

    data class Metadata(
        @SerializedName("current_page")
        val currentPage: Int?, // 1
        @SerializedName("page_count")
        val pageCount: Int?, // 25
        @SerializedName("per_page")
        val perPage: Int?, // 2
        @SerializedName("total_count")
        val totalCount: Int? // 250
    )
}