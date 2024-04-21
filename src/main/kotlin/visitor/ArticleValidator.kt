package visitor

interface ArticleValidator {
    fun validate (validator: Validator)
}

class DuplicateArticleValidator(private val article: Article, private val repository: ArticleRepository ): ArticleValidator {

    fun isDuplicate(): Boolean {
        return repository.store.keys.contains(article.articleID)
    }
    override fun validate(validator: Validator) {
        validator.visit(this)
    }

}

class ArticleMetaDataValidator(private val article: Article): ArticleValidator {

    fun isArticleMetaDateValid(): Boolean = true

    override fun validate(validator: Validator) {
        validator.visit(this)
    }

}

class ArticleRepository(val store:Map<Int, Article> = emptyMap())

data class Article(val articleID: Int, val title: String)



interface Validator {
    fun visit(duplicateArticleValidator: DuplicateArticleValidator)
    fun visit(articleMetadataValidator: ArticleMetaDataValidator)
}

class ArticleValidatorImp: Validator {
    override fun visit(duplicateArticleValidator: DuplicateArticleValidator) {
        duplicateArticleValidator.isDuplicate()
    }

    override fun visit(articleMetadataValidator: ArticleMetaDataValidator) {
        articleMetadataValidator.isArticleMetaDateValid()
    }

}