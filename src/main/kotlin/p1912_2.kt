package p1912_2

import java.util.TreeSet

class MovieRentingSystem(n: Int, entries: Array<IntArray>) {

    val priceInfo = mutableMapOf<Pair<Int, Int>, Int>()

    val unrentedMovies = mutableMapOf<Int, TreeSet<Movie>>()
    val rentedMovies = TreeSet<Movie>()

    init {
        entries.forEach { (shopId, movieId, price) ->
            val movie = Movie(shopId, movieId, price)
            priceInfo[Pair(shopId, movieId)] = price
            val tree = unrentedMovies.computeIfAbsent(movieId) {
                TreeSet()
            }
            tree.add(movie)
        }
    }

    fun search(movie: Int): List<Int> {
        val tree = unrentedMovies[movie] ?: return emptyList()
        return tree.take(5).map { it.shopId }
    }

    fun rent(shop: Int, movie: Int) {
        val price = priceInfo[Pair(shop, movie)]!!
        val movieObj = Movie(shop, movie, price)
        unrentedMovies[movie]!!.remove(movieObj)
        rentedMovies.add(movieObj)
    }

    fun drop(shop: Int, movie: Int) {
        val price = priceInfo[Pair(shop, movie)]!!
        val movieObj = Movie(shop, movie, price)
        rentedMovies.remove(movieObj)
        unrentedMovies[movie]!!.add(movieObj)
    }

    fun report(): List<List<Int>> {
        return rentedMovies.take(5).map {
            listOf(it.shopId, it.movieId)
        }
    }

    data class Movie(val shopId: Int, val movieId: Int, val price: Int) : Comparable<Movie> {
        override fun compareTo(other: Movie): Int {
            if (price == other.price) {
                if (shopId == other.shopId) {
                    return movieId - other.movieId
                }
                return shopId - other.shopId
            }
            return price - other.price
        }
    }
}
