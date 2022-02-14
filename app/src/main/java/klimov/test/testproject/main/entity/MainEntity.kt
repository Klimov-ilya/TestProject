package klimov.test.testproject.main.entity

data class DocsCharacterList(val docs: List<CharacterItem>)

data class CharacterItem(
    val height: String?,
    val race: String?,
    val gender: String?,
    val birth: String?,
    val spouse: String?,
    val death: String?,
    val realm: String?,
    val hair: String?,
    val name: String?,
    val wikiUrl: String?
)