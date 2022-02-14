package klimov.test.testproject.main.api

import klimov.test.testproject.main.entity.DocsCharacterList
import retrofit2.http.GET

interface MainApi {
    @GET("character")
    suspend fun getCharacterList(): DocsCharacterList
}