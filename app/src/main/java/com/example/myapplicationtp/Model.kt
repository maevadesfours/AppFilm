package com.example.myapplicationtp

data class ListeFilms(
    val page: Int,
    val total_pages: Int,
    val total_results: Int,
    val results: List<UnFilm>)


data class UnFilm(
    val adult: Boolean = false,
    val credits: Credits?,
    val budget: Int = 0,
    val homepage: String = "",
    val id: Int = 0,
    val imdb_id: String = "",
    val origin_country: List<String> = listOf(),
    val original_language: String = "",
    val original_title: String = "",
    val overview: String = "",
    val popularity: Double = 0.0,
    val poster_path: String?,

    val release_date: String = "",
    val revenue: Int = 0,
    val runtime: Int = 0,

    val status: String = "",
    val tagline: String = "",
    val title: String = "",
    val video: Boolean = false,
    val vote_average: Double = 0.0,
    val vote_count: Int = 0,
    val genres: List<Genre>?,
)


data class ListeActeurs(
    val page: Int,
    val results: List<UnActeur>,
    val total_pages: Int,
    val total_results: Int
)

data class UnActeur(
    val adult: Boolean,
    val biography: String  = "",
    val birthday: String?,
    //val deathday: Any,
    val gender: Int,
    //val homepage: Any,
    val id: Int,
    //val imdb_id: String,
    //val known_for_department: String,
    val name: String,
    val place_of_birth: String?,
    val popularity: Double,
    val profile_path: String?,
)


data class ListeSeries(
    val page: Int,
    val results: List<UneSerie>,
    val total_pages: Int,
    val total_results: Int
)

data class UneSerie(
    val adult: Boolean,
    //val backdrop_path: String,
    val first_air_date: String,
    val genres: List<Genre>?,
    //val homepage: String,
    val id: Int,
    val credits: Credits?,
    val origin_country: List<String>?,
    val name: String,
    val overview: String,
    val poster_path: String?,

    )



data class BelongsToCollection(
    val backdrop_path: String,
    val id: Int,
    val name: String,
    val poster_path: String
)

data class Credits(
    val cast: List<Cast>?,
    val crew: List<Crew>
)

data class Genre(
    val id: Int,
    val name: String
)

data class ProductionCompany(
    val id: Int,
    val logo_path: Any,
    val name: String,
    val origin_country: String
)

data class ProductionCountry(
    val iso_3166_1: String,
    val name: String
)

data class SpokenLanguage(
    val english_name: String,
    val iso_639_1: String,
    val name: String
)

data class Cast(
    val adult: Boolean,
    val cast_id: Int?,
    val character: String,
    val credit_id: String,
    val gender: Int,
    val id: Int,
    val known_for_department: String,
    val name: String,
    val order: Int,
    val original_name: String,
    val popularity: Double,
    val profile_path: String?
)

data class Crew(
    val adult: Boolean,
    val credit_id: String,
    val department: String,
    val gender: Int,
    val id: Int,
    val job: String,
    val known_for_department: String,
    val name: String,
    val original_name: String,
    val popularity: Double,
    val profile_path: String?
)

data class CreditsActors(
    val cast: List<CastActors>,
    val crew: List<CrewActors>
)

data class CastActors(
    val adult: Boolean,
    val backdrop_path: String,
    val character: String,
    val credit_id: String,
    val genre_ids: List<Int>,
    val id: Int,
    val order: Int,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
)

data class CrewActors(
    val adult: Boolean,
    val backdrop_path: String,
    val credit_id: String,
    val department: String,
    val genre_ids: List<Int>,
    val id: Int,
    val job: String,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val video: Boolean,
    val vote_average: Double,
    val vote_count: Int
)

data class CreatedBy(
    val credit_id: String,
    val gender: Int,
    val id: Int,
    val name: String,
    val original_name: String,
    val profile_path: Any
)

data class LastEpisodeToAir(
    val air_date: String,
    val episode_number: Int,
    val episode_type: String,
    val id: Int,
    val name: String,
    val overview: String,
    val production_code: String,
    val runtime: Int,
    val season_number: Int,
    val show_id: Int,
    val still_path: Any,
    val vote_average: Float,
    val vote_count: Int
)

data class Network(
    val id: Int,
    val logo_path: String,
    val name: String,
    val origin_country: String
)

data class Season(
    val air_date: String,
    val episode_count: Int,
    val id: Int,
    val name: String,
    val overview: String,
    val poster_path: String,
    val season_number: Int,
    val vote_average: Float
)

