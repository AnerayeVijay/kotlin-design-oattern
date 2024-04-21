import org.junit.Test
import visitor.*

class ValidatorTest {
    @Test
    fun `test article validator`() {
        val article = Article(1, "First Article")
        val repository = ArticleRepository(mapOf(1 to article))
        val validatorList = arrayOf(DuplicateArticleValidator(article, repository),ArticleMetaDataValidator(article))
        val validator = ArticleValidatorImp()
        validatorList.map {
            it.validate(validator)
        }

    }
}