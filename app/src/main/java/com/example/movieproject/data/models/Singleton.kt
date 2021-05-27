package com.example.movieproject.data.models

import com.example.movieproject.domain.model.Movie
import com.google.gson.annotations.SerializedName

class Singleton(
    @SerializedName("username")
    var username: String?,
    @SerializedName("session_id")
    var sessionId: String?,
    @SerializedName("account_id")
    var accountId: Int?
) {
    @SerializedName("moviePremier")
    var moviePremier: Movie = Movie(
        454626,
        214.451,
        3013,
        false,
        "/aQvJ5WPzZgYVDrxLX4R6cLJCEaQ.jpg",
        false,
        "stmYfCUGd8Iy6kAMBr6AmWqx8Bq.jpg",
        "en",
        "Sonic the Hedgehog",
        "Sonic the Hedgehog"
        ,
        7.6,
        "Based on the global blockbuster videogame franchise from Sega, Sonic the Hedgehog tells the story of the world’s speediest hedgehog as he embraces his new home on Earth. In this live-action adventure comedy, Sonic and his new best friend team up to defend the planet from the evil genius Dr. Robotnik and his plans for world domination.",
        "2020-02-12"
    )

    companion object Factory {
        @Volatile
        private var INSTANCE: Singleton? = null

        @Synchronized
        fun create(username: String?, session_id: String?, account_id: Int?):
                Singleton =
            INSTANCE ?: Singleton(username, session_id, account_id).also { INSTANCE = it }

        fun getSession(): String? {
            return INSTANCE!!.sessionId
        }

        fun getAccountId(): Int? {
            return INSTANCE!!.accountId
        }

        fun getUserName(): String? {
            return INSTANCE!!.username
        }

        fun getMovie(): Movie? {
            return INSTANCE!!.moviePremier
        }
    }
}
