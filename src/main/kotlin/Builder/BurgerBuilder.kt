package Builder

class Burger private constructor(
    val bread: String? = "Flat bread",
    val condiments: String?,
    val meat: String?,
    val fish: String?) {
    data class Builder(
        var bread: String? = null,
        var condiments: String? = null,
        var meat: String? = null,
        var fish: String? = null
    ) {

        fun bread(bread: String) = apply { this.bread = bread }
        fun condiments(condiments: String) = apply { this.condiments = condiments }
        fun meat(meat: String) = apply { this.meat = meat }
        fun fish(fish: String) = apply { this.fish = fish }
        fun build() = Burger(bread, condiments, meat, fish)
        fun randomBuild() = bread(bread ?: "dry")
            .condiments(condiments ?: "pepper")
            .meat(meat ?: "beef")
            .fish(fish ?: "Tilapia")
            .build()
    }
}

fun main() {
    val foodOrder = Burger.Builder()
        .bread("white bread")
        .meat("bacon")
        .condiments("olive oil")
        .build()
}