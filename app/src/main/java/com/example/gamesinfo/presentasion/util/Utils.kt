package com.example.gamesinfo.presentasion.util

import android.content.Context
import com.example.gamesinfo.presentasion.model.NewGame
import com.example.gamesinfo.presentasion.model.PopGame
import com.google.gson.JsonArray
import com.google.gson.JsonParser


fun Context.readJson(fileName: String): String {
    return assets.open(fileName).bufferedReader().use { it.readText() }
}

fun convertStringToPop(jsonString: String): List<PopGame> {
    val jsonArray: JsonArray = JsonParser().parse(jsonString).asJsonArray
    val popGame: MutableList<PopGame> = mutableListOf()
    jsonArray.forEach {
        val overview: String = it.asJsonObject["overview"].asString
        val originalLanguage: String = it.asJsonObject["original_language"].asString
        val originalTitle: String = it.asJsonObject["original_title"].asString
        val video: Boolean = it.asJsonObject["video"].asBoolean
        val title: String = it.asJsonObject["title"].asString
        val genreIds: MutableList<Int> = mutableListOf()
        it.asJsonObject.get("genre_ids").asJsonArray.forEach { genreId ->
            genreIds.add(genreId.asInt)
        }
        val posterPath: String = it.asJsonObject["poster_path"].asString
        val backdropPath: String = it.asJsonObject["backdrop_path"].asString
        val releaseDate = it.asJsonObject["release_date"].asString
        val popularity: Double = it.asJsonObject["popularity"].asDouble
        val voteAverage: Double = it.asJsonObject["vote_average"].asDouble
        val id: Int = it.asJsonObject["id"].asInt
        val adult: Boolean = it.asJsonObject["adult"].asBoolean
        val voteCount: Int = it.asJsonObject["vote_count"].asInt
        popGame.add(
            PopGame(
                overview = overview,
                originalLanguage = originalLanguage,
                originalTitle = originalTitle,
                video = video,
                title = title,
                genreIds = genreIds,
                posterPath = posterPath,
                backdropPath = backdropPath,
                releaseDate = releaseDate,
                popularity = popularity,
                voteAverage = voteAverage,
                id = id,
                adult = adult,
                voteCount = voteCount
            )
        )
    }
    return popGame
}

fun convertStringToNew(jsonString: String): List<NewGame> {
    val jsonArray: JsonArray = JsonParser().parse(jsonString).asJsonArray
    val newGame: MutableList<NewGame> = mutableListOf()
    jsonArray.forEach {
        val overview: String = it.asJsonObject["overview"].asString
        val originalLanguage: String = it.asJsonObject["original_language"].asString
        val originalTitle: String = it.asJsonObject["original_title"].asString
        val video: Boolean = it.asJsonObject["video"].asBoolean
        val title: String = it.asJsonObject["title"].asString
        val genreIds: MutableList<Int> = mutableListOf()
        it.asJsonObject.get("genre_ids").asJsonArray.forEach { genreId ->
            genreIds.add(genreId.asInt)
        }
        val posterPath: String = it.asJsonObject["poster_path"].asString
        val backdropPath: String = it.asJsonObject["backdrop_path"].asString
        val releaseDate = it.asJsonObject["release_date"].asString
        val popularity: Double = it.asJsonObject["popularity"].asDouble
        val voteAverage: Double = it.asJsonObject["vote_average"].asDouble
        val id: Int = it.asJsonObject["id"].asInt
        val adult: Boolean = it.asJsonObject["adult"].asBoolean
        val voteCount: Int = it.asJsonObject["vote_count"].asInt
        newGame.add(
            NewGame(
                overview = overview,
                originalLanguage = originalLanguage,
                originalTitle = originalTitle,
                video = video,
                title = title,
                genreIds = genreIds,
                posterPath = posterPath,
                backdropPath = backdropPath,
                releaseDate = releaseDate,
                popularity = popularity,
                voteAverage = voteAverage,
                id = id,
                adult = adult,
                voteCount = voteCount
            )
        )
    }
    return newGame
}
