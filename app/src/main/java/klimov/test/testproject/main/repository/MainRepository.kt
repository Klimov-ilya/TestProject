package klimov.test.testproject.main.repository

import klimov.test.testproject.common.network.Api

object MainRepository {

    suspend fun requestToGetCharacterList() = Api.mainApi.getCharacterList()

}