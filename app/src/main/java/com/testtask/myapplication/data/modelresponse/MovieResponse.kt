package com.testtask.myapplication.data.modelresponse

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("byline")
    val byLine: String,
    @SerializedName("critics_pick")
    val criticsPick: Int,
    @SerializedName("date_updated")
    val dateUpdated: String,
    @SerializedName("display_title")
    val display_title: String,
    @SerializedName("headline")
    val headLine: String,
    @SerializedName("link")
    val link: Link,
    @SerializedName("mpaa_rating")
    val mpaaRating: String,
    @SerializedName("multimedia")
    val multimedia: Multimedia,
    @SerializedName("opening_date")
    val openingDate: String,
    @SerializedName("publication_date")
    val publication_date: String,
    @SerializedName("summary_short")
    val summaryShort: String
)