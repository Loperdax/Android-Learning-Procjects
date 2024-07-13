package com.app.learn.retrofit.responses


import com.google.gson.annotations.SerializedName

data class ResponseMoviesByGenre(
    @SerializedName("data")
    val `data`: List<Data?>?,
    @SerializedName("metadata")
    val metadata: Metadata?
) {
    data class Data(
        @SerializedName("country")
        val country: String?, // USA, Germany
        @SerializedName("genres")
        val genres: List<String?>?,
        @SerializedName("id")
        val id: Int?, // 25
        @SerializedName("images")
        val images: List<String?>?,
        @SerializedName("imdb_rating")
        val imdbRating: String?, // 8.6
        @SerializedName("poster")
        val poster: String?, // https://moviesapi.ir/images/tt0114814_poster.jpg
        @SerializedName("title")
        val title: String?, // The Usual Suspects
        @SerializedName("year")
        val year: String? // 1995
    )

    data class Metadata(
        @SerializedName("current_page")
        val currentPage: String?, // 2
        @SerializedName("page_count")
        val pageCount: Int?, // 6
        @SerializedName("per_page")
        val perPage: Int?, // 10
        @SerializedName("total_count")
        val totalCount: Int? // 59
    )
}