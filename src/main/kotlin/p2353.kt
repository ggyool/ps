package p2353

import java.util.TreeSet

class FoodRatings(foods: Array<String>, cuisines: Array<String>, ratings: IntArray) {

    val cuisineMap = HashMap<String, String>()
    val ratingMap = HashMap<String, Int>()
    val treeMap = HashMap<String, TreeSet<FoodRating>>()

    init {
        for (i in foods.indices) {
            val food = foods[i]
            val cuisine = cuisines[i]
            val rating = ratings[i]

            cuisineMap[food] = cuisine
            ratingMap[food] = rating

            if (treeMap.contains(cuisine)) {
                treeMap[cuisine]!!.add(FoodRating(food, rating))
            } else {
                val tree = TreeSet<FoodRating>()
                tree.add(FoodRating(food, rating))
                treeMap[cuisine] = tree
            }
        }
    }

    fun changeRating(food: String, newRating: Int) {
        val cuisine = cuisineMap[food]
        val tree = treeMap[cuisine]!!
        tree.remove(FoodRating(food, ratingMap[food]!!))
        tree.add(FoodRating(food, newRating))
        ratingMap[food] = newRating
    }

    fun highestRated(cuisine: String): String {
        val tree = treeMap[cuisine]!!
        return tree.first().name
    }

    data class FoodRating(
        val name: String,
        val rating: Int
    ): Comparable<FoodRating> {
        override fun compareTo(other: FoodRating): Int {
            if (other.rating == rating) {
                return name.compareTo(other.name)
            }
            return other.rating - rating
        }
    }
}
